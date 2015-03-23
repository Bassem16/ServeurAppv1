package fr.dauphine.bank.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.dauphine.bank.ejb.ServiceInvestisseur;
import fr.dauphine.bank.ejb.ServiceSauvegarde;
import fr.dauphine.bank.entities.Demande;
import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Information;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.OffreHistorique;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;
import fr.dauphine.bank.entities.TypePersonne;
import fr.dauphine.bank.web.Utile;

@ManagedBean
@SessionScoped
// ATTENTION Cette classe ne doit etre appelé que lorsqu'un utilisateur
// Investisseur est connecté
public class GestionInvestisseurBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String ACTION = "Action";
	private static final String REFUSEE = "Refusée";
	private static final String ACCEPTEE = "Acceptée";

	private Personne personne = null;
	private Personne personneVisite = null;

	private boolean entrepriseChek = false;
	private boolean typeCheck = false;
	private boolean userCheck = false;

	private String entrepriseNom = null;
	private String typeNom = null;
	private String userNom = null;

	private String typeTitreTransaction = null;
	private String nomTitreTransaction = null;

	private int quantiteOffre = 0;
	private double prixOffre = 0;

	private boolean entrepriseCheckRecherche = false;
	private boolean domaineChek = false;

	private String entrepriseCheckRechercheName = null;
	private String domaineChekName = null;

	private Entreprise ficheEntreprise = null;
	@EJB
	ServiceInvestisseur serviceInvestisseur;
	@EJB
	ServiceSauvegarde serviceSauvegarde;

	public GestionInvestisseurBean() {
	}

	@PostConstruct
	public void init() {
		HttpSession hs = Utile.getSession();
		personne = (Personne) hs.getAttribute("personne");
		setEntrepriseNom("Accenture");
		setTypeNom(ACTION);
		setTypeTitreTransaction(ACTION);

		setEntrepriseCheckRechercheName("");

	}

	public List<Titre> rechercherTitre() {
		List<Titre> listTitre = serviceInvestisseur.recupererTitre(
				entrepriseChek, typeCheck, userCheck, entrepriseNom, typeNom,
				userNom);
		List<Titre> listTitreRemoved = new ArrayList<Titre>();
		for (Titre t : listTitre) {
			if (!t.getPersonne().getLogin().equals(personne.getLogin())) {
				listTitreRemoved.add(t);
			}
		}

		return listTitreRemoved;

	}

	public List<Entreprise> listEntreprise() {
		List<Entreprise> listEntreprise = serviceInvestisseur
				.recupererEntrepriseListAll();
		Collections.sort(listEntreprise, Entreprise.alphabetique);

		return listEntreprise;

	}

	public List<Information> listInformation() {
		List<Information> listInformation = serviceInvestisseur
				.recupererInformationEntreprise(ficheEntreprise);

		return listInformation;

	}

	public List<Personne> listPersonne() {
		return serviceInvestisseur.recupererPersonneListAll();

	}

	public OffreHistorique offreAHistorique(Offre offre, String statut) {
		OffreHistorique offreH = new OffreHistorique();
		offreH.setDateOffreHistorique(offre.getDateOffre());
		offreH.setEntreprise(offre.getEntreprise());
		offreH.setPersonneEmetteur(offre.getPersonneEmetteur());
		offreH.setPersonneReceveur(offre.getPersonneReceveur());
		offreH.setPrixOffreHistorique(offre.getPrixOffre());
		offreH.setQuantiteOffreHistorique(offre.getQuantiteOffre());
		offreH.setStatut(statut);

		offreH.setTitres(offre.getTitres());
		offreH.setTypeOffreHistorique(offre.getTypeOffre());
		List<Titre> titres = offre.getTitresList();

		for (Titre t : titres) {
			t.getOffres().remove(offre);
			t.getOffreHistoriques().add(offreH);

			serviceSauvegarde.sauvegardeTitre(t);

		}

		return offreH;
	}

	// Ne plus toucher
	public void cloturerOffre(Offre offre) {
		passerOffreAHistoriqueOffre(offre, "Retirée");

		serviceInvestisseur.supprimerOffre(offre);

	}

	public void mettreSurMarcherTitre(Titre titre) {
		titre.setEtatTitre(1);
		serviceSauvegarde.sauvegardeTitre(titre);
	}

	public void retirerDuMarcherTitre(Titre titre) {
		titre.setEtatTitre(0);
		passerOffreAHistoriqueTitre(titre);
	}

	// Ne plus toucher
	public void passerOffreAHistoriqueTitre(Titre titre) {
		OffreHistorique offreH = new OffreHistorique();
		List<Offre> ao = titre.getOffresList();
		Set<Offre> t1 = titre.getOffres();
		for (int i = 0; i < ao.size(); i++) {
			Offre offre = ao.get(i);
			offreH = offreAHistorique(offre, REFUSEE);

			List<Titre> titres = offre.getTitresList();
			for (int j = 0; j < titres.size(); j++) {
				Titre t2 = titres.get(j);

				t2.getOffres().remove(offre);
				offreH.getTitres().add(t2);

			}

			serviceSauvegarde.sauvegardeOffreHistorique(offreH);

			t1.remove(offre);

			titre.getOffreHistoriques().add(offreH);

			Personne personneReceveur = offre.getPersonneReceveur();
			Personne personneEmetteur = offre.getPersonneEmetteur();

			personneReceveur.getOffresRecues().remove(offre);
			personneEmetteur.getOffresEmises().remove(offre);

			personneEmetteur.getOffreHistoriquesEmises().add(offreH);
			personneReceveur.getOffreHistoriquesRecues().add(offreH);

			serviceInvestisseur.supprimerOffre(offre);
		}

	}

	// Ne plus toucher
	public void passerOffreAHistoriqueOffre(Offre offre, String statut) {
		OffreHistorique offreH = new OffreHistorique();

		offreH.setDateOffreHistorique(offre.getDateOffre());
		offreH.setEntreprise(offre.getEntreprise());
		offreH.setPersonneEmetteur(offre.getPersonneEmetteur());
		offreH.setPersonneReceveur(offre.getPersonneReceveur());
		offreH.setPrixOffreHistorique(offre.getPrixOffre());
		offreH.setQuantiteOffreHistorique(offre.getQuantiteOffre());
		offreH.setStatut(statut);
		offreH.setTitres(new HashSet<Titre>());
		offreH.setTypeOffreHistorique(offre.getTypeOffre());

		List<Titre> titres = offre.getTitresList();
		for (int j = 0; j < titres.size(); j++) {
			Titre t = titres.get(j);
			t.getOffres().remove(offre);

			t.getOffreHistoriques().add(offreH);
			offreH.getTitres().add(t);

		}

		serviceSauvegarde.sauvegardeOffreHistorique(offreH);

		Personne personneReceveur = offre.getPersonneReceveur();
		Personne personneEmetteur = offre.getPersonneEmetteur();

		personneReceveur.getOffresRecues().remove(offre);
		personneEmetteur.getOffresEmises().remove(offre);

		personneEmetteur.getOffreHistoriquesEmises().add(offreH);
		personneReceveur.getOffreHistoriquesRecues().add(offreH);

		serviceInvestisseur.supprimerOffre(offre);
	}

	public void accepterOffre(Offre offre) {
		passerOffreAHistoriqueOffre(offre, ACCEPTEE);
		List<Titre> titres = offre.getTitresList(); // On recupere les
													// titres

		List<Offre> listOffresSupprimeesTemp = new ArrayList<Offre>();
		// On met à jours les titres (suppression de toutes les offres)
		for (Titre t : titres) {
			for (Offre o : t.getOffresList()) {

				t.getOffres().remove(o);

				o.getPersonneEmetteur().getOffresEmises().remove(o);
				o.getPersonneReceveur().getOffresRecues().remove(o);

				if (!listOffresSupprimeesTemp.contains(o)) {
					passerOffreAHistoriqueOffre(o, REFUSEE);
					listOffresSupprimeesTemp.add(o);
				}

			}
		}
		// Titres echangés
		// On annule les offres des titres concerné
		Personne p = offre.getPersonneEmetteur(); // On recupere la personne
													// recevant les titres

		p.getTitres().addAll(titres); // On lui donne les titres
		personne.getTitres().removeAll(titres); // On les supprimes de chez le
		// donneur

		for (Titre t : titres) {
			serviceInvestisseur.miseAJourTitre(t);
			t.setPersonne(p);
			t.setEtatTitre(0);
			serviceSauvegarde.sauvegardeTitre(t);
		}

		// Mettre à jour les soldes des comptes émetteurs et receveurs
		Personne personneEmetteur = offre.getPersonneEmetteur();
		Personne personneReceveur = offre.getPersonneReceveur();

		personneEmetteur.setSoldePersonne(personneEmetteur.getSoldePersonne()
				- offre.getPrixOffre());
		personneReceveur.setSoldePersonne(personneReceveur.getSoldePersonne()
				+ offre.getPrixOffre());

		serviceSauvegarde.sauvegardeCompte(personneEmetteur);
		serviceSauvegarde.sauvegardeCompte(personneReceveur);
	}

	public List<String> personneVisiteListNomTitreSelect() {
		List<String> nomTitres = new ArrayList<String>();
		for (Titre t : personneVisite.getTitresList()) {

			if (!nomTitres.contains(t.getNomTitre())
					&& t.getTypeTitre().equals(typeTitreTransaction)
					&& t.estVente()) {
				nomTitres.add(t.getNomTitre());

			}
		}

		return nomTitres;
	}

	public List<Titre> personneVisiteTitrePourOffre() {
		List<Titre> titres = new ArrayList<Titre>();
		for (Titre t : personneVisiteListTitre()) {
			if (t.getNomTitre().equals(nomTitreTransaction)
					&& t.getTypeTitre().equals(typeTitreTransaction)) {
				titres.add(t);

			}
		}
		return titres;
	}

	public List<Integer> personneVisiteTitrePourOffreNombre() {
		List<Integer> nomb = new ArrayList<Integer>();
		int i = 0;
		for (Titre t : personneVisite.getTitresList()) {
			if (t.getNomTitre().equals(nomTitreTransaction)
					&& t.getTypeTitre().equals(typeTitreTransaction)
					&& t.estVente()) {
				nomb.add(i + 1);
				i++;
			}
		}
		return nomb;
	}

	@SuppressWarnings("unchecked")
	public String faireOffre() {
		List<Titre> titresOffre = personneVisiteTitrePourOffre();
		Collections.sort(titresOffre, Titre.nbrOffre);
		Offre offre = new Offre();
		offre.setDateOffre(new Date(System.currentTimeMillis()));
		offre.setEntreprise(titresOffre.get(0).getEntreprise());
		offre.setPersonneEmetteur(personne);
		offre.setPersonneReceveur(personneVisite);
		offre.setPrixOffre(prixOffre);
		offre.setQuantiteOffre(quantiteOffre);
		offre.setStatut("En cours");
		offre.setTitres(new HashSet<Titre>());
		offre.setTypeOffre("Achat");

		for (int i = 0; i < quantiteOffre; i++) {
			Titre t = titresOffre.get(i);
			t.getOffres().add(offre);
			offre.getTitres().add(t);

		}

		serviceSauvegarde.sauvgarderOffre(offre);
		personne.getOffresEmises().add(offre);

		return "home.xhtml";

	}

	public List<Entreprise> listEntrepriseFiltre() {
		List<Entreprise> listEntrepriseFiltre = new ArrayList<Entreprise>();
		List<Entreprise> listEntreprise = listEntreprise();

		for (Entreprise e : listEntreprise) {
			if (!entrepriseCheckRecherche && !domaineChek) {
				listEntrepriseFiltre.add(e);

			} else if (entrepriseCheckRecherche && !domaineChek) {
				if (e.getNomEntreprise().toLowerCase()
						.indexOf(entrepriseCheckRechercheName.toLowerCase()) > -1
						|| entrepriseCheckRechercheName.toLowerCase().indexOf(
								e.getNomEntreprise().toLowerCase()) > -1
						|| entrepriseCheckRechercheName.equalsIgnoreCase(e
								.getNomEntreprise())) {
					listEntrepriseFiltre.add(e);

				}

			} else if (!entrepriseCheckRecherche && domaineChek) {
				if (e.getSecteurEntreprise().toLowerCase()
						.indexOf(domaineChekName.toLowerCase()) > -1
						|| domaineChekName.toLowerCase().indexOf(
								e.getSecteurEntreprise().toLowerCase()) > -1) {
					listEntrepriseFiltre.add(e);
				}
			} else {
				if ((e.getSecteurEntreprise().toLowerCase()
						.indexOf(domaineChekName.toLowerCase()) > -1 || domaineChekName
						.toLowerCase().indexOf(
								e.getSecteurEntreprise().toLowerCase()) > -1)
						&& (e.getNomEntreprise()
								.toLowerCase()
								.indexOf(
										entrepriseCheckRechercheName
												.toLowerCase()) > -1 || entrepriseCheckRechercheName
								.toLowerCase().indexOf(
										e.getNomEntreprise().toLowerCase()) > -1)) {
					listEntrepriseFiltre.add(e);
				}

			}

		}

		Collections.sort(listEntrepriseFiltre, Entreprise.alphabetique);
		return listEntrepriseFiltre;

	}

	public void addMessage() {
		String summary = entrepriseChek ? "Filtre enclenché" : "Filtre retiré";
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(summary));
	}

	public String visiterPersonne(Personne p) {
		personneVisite = p;

		return "offer.xhtml";

	}

	public String visiterEntreprise(Entreprise e) {
		ficheEntreprise = e;
		return "company.xhtml";

	}

	public void refuserOffre(Offre offre) {
		passerOffreAHistoriqueOffre(offre, REFUSEE);
	}

	public boolean estVente(Titre titre) {
		return titre.estVente();

	}

	public boolean soldeSuffisant(Offre offre) {
		boolean verif = true;
		if (offre.getPersonneEmetteur().getSoldePersonne() >= offre
				.getPrixOffre())
			verif = false;

		return verif;

	}

	public double getSoldePersonne() {
		return getPersonne().getSoldePersonne();
	}

	public void rechercherTitre(String nomTitre) {

	}

	public Personne getPersonne() {
		return this.personne;
	}

	public int getIdPersonne() {
		return getPersonne().getIdPersonne();
	}

	public void setIdPersonne(int idPersonne) {
		getPersonne().setIdPersonne(idPersonne);
	}

	public String getEmail() {
		return getPersonne().getEmail();
	}

	public void setEmail(String email) {
		getPersonne().setEmail(email);

	}

	public String getLogin() {
		return getPersonne().getLogin();
	}

	public void setLogin(String login) {
		getPersonne().setLogin(login);
	}

	public String getMotDePasse() {
		return getPersonne().getMotDePasse();
	}

	public void setMotDePasse(String motDePasse) {
		getPersonne().setMotDePasse(motDePasse);

	}

	public String getNomPersonne() {
		return getPersonne().getNomPersonne();
	}

	public void setNomPersonne(String nomPersonne) {
		getPersonne().setNomPersonne(nomPersonne);

	}

	public String getPrenomPersonne() {
		return getPersonne().getPrenomPersonne();
	}

	public void setPrenomPersonne(String prenomPersonne) {
		getPersonne().setPrenomPersonne(prenomPersonne);

	}

	public Entreprise getEntreprises() {
		return getPersonne().getEntreprise();
	}

	public void setEntreprise(Entreprise entreprise) {
		getPersonne().setEntreprise(entreprise);

	}

	public Set<Demande> getDemandes() {
		return getPersonne().getDemandes();
	}

	public void setDemandes(Set<Demande> demandes) {
		getPersonne().setDemandes(demandes);

	}

	public Demande addDemande(Demande demande) {
		getDemandes().add(demande);
		demande.setPersonne(getPersonne());
		return demande;
	}

	public Demande removeDemande(Demande demande) {
		getDemandes().remove(demande);
		demande.setPersonne(null);
		return demande;
	}

	public Set<Titre> getTitres() {
		return getPersonne().getTitres();
	}

	public void setTitres(Set<Titre> titres) {
		getPersonne().setTitres(titres);

	}

	public Set<Offre> getOffresEmises() {
		return getPersonne().getOffresEmises();
	}

	public Set<Offre> getOffresRecues() {
		return getPersonne().getOffresRecues();
	}

	public List<Offre> getOffresEmisesList() {
		List<Offre> listeOffresEmises = new ArrayList<Offre>();
		listeOffresEmises.addAll(getPersonne().getOffresEmises());
		Collections.sort(listeOffresEmises, Offre.date);
		Collections.reverse(listeOffresEmises);
		return listeOffresEmises;
	}

	public List<Offre> getOffresRecuesList() {
		List<Offre> listeOffresRecues = new ArrayList<Offre>();
		listeOffresRecues.addAll(getPersonne().getOffresRecues());
		Collections.sort(listeOffresRecues, Offre.prix);
		Collections.reverse(listeOffresRecues);
		return listeOffresRecues;
	}

	public void setOffresEmises(Set<Offre> offres) {
		getPersonne().setOffresEmises(offres);

	}

	public void setOffresRecues(Set<Offre> offres) {
		getPersonne().setOffresRecues(offres);

	}

	public Offre addOffreEmises(Offre offre) {
		getPersonne().getOffresEmises().add(offre);
		offre.setPersonneEmetteur(getPersonne());

		return offre;
	}

	public Offre addOffreRecues(Offre offre) {
		getPersonne().getOffresRecues().add(offre);
		offre.setPersonneReceveur(getPersonne());

		return offre;
	}

	public Offre removeOffreEmise(Offre offre) {
		getPersonne().getOffresEmises().remove(offre);
		offre.setPersonneEmetteur(null);

		return offre;
	}

	public Offre removeOffreRecue(Offre offre) {
		getPersonne().getOffresRecues().remove(offre);
		offre.setPersonneReceveur(null);

		return offre;
	}

	public TypePersonne getTypePersonne() {
		return getPersonne().getTypePersonne();
	}

	public void setTypePersonne(TypePersonne typePersonne) {
		getPersonne().setTypePersonne(typePersonne);
	}

	public List<Offre> getOffresList() {
		return new ArrayList<Offre>(getPersonne().getOffresRecues());
	}

	public List<Titre> getTitresList() {
		List<Titre> listTitre = new ArrayList<Titre>(getPersonne().getTitres());
		Collections.sort(listTitre, Titre.alphabetique);
		return listTitre;
	}

	public List<Demande> getDemandesList() {
		return new ArrayList<Demande>(getPersonne().getDemandes());
	}

	public List<OffreHistorique> getOffreHistoriquesEmisesList() {

		List<OffreHistorique> listeOffresHistoriquesEmises = new ArrayList<OffreHistorique>();
		listeOffresHistoriquesEmises.addAll(getPersonne()
				.getOffreHistoriquesEmises());
		Collections.sort(listeOffresHistoriquesEmises, OffreHistorique.date);
		Collections.reverse(listeOffresHistoriquesEmises);
		return listeOffresHistoriquesEmises;
	}

	public List<OffreHistorique> getOffreHistoriquesRecuesList() {

		List<OffreHistorique> listeOffresHistoriquesRecues = new ArrayList<OffreHistorique>();
		listeOffresHistoriquesRecues.addAll(getPersonne()
				.getOffreHistoriquesRecues());
		Collections.sort(listeOffresHistoriquesRecues, OffreHistorique.date);
		Collections.reverse(listeOffresHistoriquesRecues);
		return listeOffresHistoriquesRecues;
	}

	public boolean isEntrepriseChek() {
		return entrepriseChek;
	}

	public void setEntrepriseChek(boolean entrepriseChek) {
		this.entrepriseChek = entrepriseChek;
	}

	public boolean isTypeCheck() {
		return typeCheck;
	}

	public void setTypeCheck(boolean typeChek) {
		this.typeCheck = typeChek;
	}

	public String getEntrepriseNom() {
		return entrepriseNom;
	}

	public void setEntrepriseNom(String entrepriseNom) {
		this.entrepriseNom = entrepriseNom;
	}

	public String getTypeNom() {
		return typeNom;
	}

	public void setTypeNom(String typeNom) {
		this.typeNom = typeNom;
	}

	public String getUserNom() {
		return userNom;
	}

	public void setUserNom(String personneNom) {
		this.userNom = personneNom;
	}

	public boolean isUserCheck() {
		return userCheck;
	}

	public void setUserCheck(boolean userChek) {
		this.userCheck = userChek;
	}

	public Personne getPersonneVisite() {
		return personneVisite;
	}

	public void setPersonneVisite(Personne personneVisite) {
		this.personneVisite = personneVisite;
	}

	public String getTypeTitreTransaction() {
		return typeTitreTransaction;
	}

	public void setTypeTitreTransaction(String typeTitreTransaction) {
		this.typeTitreTransaction = typeTitreTransaction;
	}

	public String getNomTitreTransaction() {
		return nomTitreTransaction;
	}

	public void setNomTitreTransaction(String titreNomTransaction) {
		this.nomTitreTransaction = titreNomTransaction;
	}

	public int getQuantiteOffre() {
		return quantiteOffre;
	}

	public void setQuantiteOffre(int quantiteOffre) {
		this.quantiteOffre = quantiteOffre;
	}

	public double getPrixOffre() {
		return prixOffre;
	}

	public void setPrixOffre(double prixOffre) {
		this.prixOffre = prixOffre;
	}

	public List<Titre> personneVisiteListTitre() {
		List<Titre> titres = new ArrayList<Titre>();
		for (Titre t : personneVisite.getTitresList()) {
			if (t.estVente() == true) {
				titres.add(t);
			}
		}
		return titres;
	}

	public List<String> personneVisiteListTypeTitre() {
		List<String> typeTitres = new ArrayList<String>();
		for (Titre t : personneVisite.getTitresList()) {
			if (!typeTitres.contains(t.getTypeTitre()) && t.estVente()) {
				typeTitres.add(t.getTypeTitre());
			}
		}

		return typeTitres;
	}

	public double getDentention() {

		double detention = 0;

		for (Titre t : personne.getTitresList()) {
			if (t.getEntreprise().getNomEntreprise()
					.equals(ficheEntreprise.getNomEntreprise())
					&& t.getTypeTitre().equals(ACTION)) {
				detention++;

			}

		}

		return (detention / ficheEntreprise.getNombreTitreTotal()) * 100;
	}

	public boolean isEntrepriseCheckRecherche() {
		return entrepriseCheckRecherche;
	}

	public void setEntrepriseCheckRecherche(boolean entrepriseCheckRecherche) {
		this.setEntrepriseCheckRechercheName("");
		this.entrepriseCheckRecherche = entrepriseCheckRecherche;
	}

	public boolean isDomaineChek() {
		return domaineChek;
	}

	public void setDomaineChek(boolean domaineChek) {
		this.setDomaineChekName("");
		this.domaineChek = domaineChek;
	}

	public String getEntrepriseCheckRechercheName() {
		return entrepriseCheckRechercheName;
	}

	public void setEntrepriseCheckRechercheName(
			String entrepriseCheckRechercheName) {
		this.entrepriseCheckRechercheName = entrepriseCheckRechercheName;
	}

	public String getDomaineChekName() {
		return domaineChekName;
	}

	public void setDomaineChekName(String domaineChekName) {
		this.domaineChekName = domaineChekName;
	}

	public Entreprise getFicheEntreprise() {
		return ficheEntreprise;
	}

	public void setFicheEntreprise(Entreprise ficheEntreprise) {
		this.ficheEntreprise = ficheEntreprise;
	}

	public void setPersonne(Personne p) {
		personne = p;
	}
}
