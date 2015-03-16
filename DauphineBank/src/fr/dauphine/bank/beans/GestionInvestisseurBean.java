package fr.dauphine.bank.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import fr.dauphine.bank.ejb.ServiceInvestisseur;
import fr.dauphine.bank.ejb.ServiceSauvegarde;
import fr.dauphine.bank.entities.Demande;
import fr.dauphine.bank.entities.Entreprise;
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
		setTypeNom("Action");
		setTypeTitreTransaction("Action");

	}

	public ArrayList<Titre> rechercherTitre() {
		return serviceInvestisseur.recupererTitre(entrepriseChek, typeCheck,
				userCheck, entrepriseNom, typeNom, userNom);

	}

	public ArrayList<Entreprise> listEntreprise() {
		return serviceInvestisseur.recupererEntrepriseListAll();

	}

	public ArrayList<Personne> listPersonne() {
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
		ArrayList<Titre> titres = offre.getTitresList();

		boolean a = true;
		for (Titre t : titres) {
			t.getOffres().remove(offre);
			t.getOffreHistoriques().add(offreH);

			if (a == true) {// pour eviter la redondonce des données
				serviceSauvegarde.sauvegardeTitre(t);
				a = false;
			}
		}
		// serviceSauvegarde.sauvegardeOffreHistorique(offreH);

		return offreH;
	}

	// Ne plus toucher
	public void cloturerOffre(Offre offre) {
		// OffreHistorique offreH = offreAHistorique(offre, "Retirée");
		passerOffreAHistorique_Offre(offre, "Retirée");

		// serviceSauvegarde.sauvegardeCompte(p);
		// serviceSauvegarde.sauvegardeCompte(personne);
		serviceInvestisseur.supprimerOffre(offre);

	}

	public void mettreSurMarcherTitre(Titre titre) {
		titre.setEtatTitre(1);
		serviceSauvegarde.sauvegardeTitre(titre);
	}

	public void retirerDuMarcherTitre(Titre titre) {
		titre.setEtatTitre(0);
		passerOffreAHistorique_Titre(titre);
	}

	// Ne plus toucher
	public void passerOffreAHistorique_Titre(Titre titre) {
		OffreHistorique offreH = new OffreHistorique();
		ArrayList<Offre> AO = titre.getOffresList();
		Set<Offre> T = titre.getOffres();
		for (int i = 0; i < AO.size(); i++) {
			Offre offre = AO.get(i);
			offreH = offreAHistorique(offre, "Refusée");

			System.out.println("TAILLE  : " + titre.getOffres().size());

			ArrayList<Titre> titres = offre.getTitresList();
			for (int j = 0; j < titres.size(); j++) {
				titres.get(j).getOffres().remove(offre);
			}

			T.remove(offre);

			titre.getOffreHistoriques().add(offreH);

			Personne personneReceveur = offre.getPersonneReceveur();
			Personne personneEmetteur = offre.getPersonneEmetteur();

			personneReceveur.getOffresRecues().remove(offre);
			personneEmetteur.getOffresEmises().remove(offre);

			personneEmetteur.getOffreHistoriquesEmises().add(offreH);
			personneReceveur.getOffreHistoriquesRecues().add(offreH);

			serviceSauvegarde.sauvegardeCompte(personneReceveur);
			// serviceSauvegarde.sauvegardeCompte(personneEmetteur);
			serviceInvestisseur.supprimerOffre(offre);
		}

		// serviceSauvegarde.sauvegardeTitre(titre);

	}

	// Ne plus toucher
	public void passerOffreAHistorique_Offre(Offre offre, String statut) {
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

		// System.out.println("TAILLE  : " + titre.getOffres().size());

		ArrayList<Titre> titres = offre.getTitresList();
		for (int j = 0; j < titres.size(); j++) {
			titres.get(j).getOffres().remove(offre);
			titres.get(j).getOffreHistoriques().add(offreH);

		}
		// serviceSauvegarde.sauvegardeOffreHistorique(offreH);
		Personne personneReceveur = offre.getPersonneReceveur();
		Personne personneEmetteur = offre.getPersonneEmetteur();

		personneReceveur.getOffresRecues().remove(offre);
		personneEmetteur.getOffresEmises().remove(offre);

		personneEmetteur.getOffreHistoriquesEmises().add(offreH);
		personneReceveur.getOffreHistoriquesRecues().add(offreH);

		serviceSauvegarde.sauvegardeCompte(personneReceveur);
		// serviceSauvegarde.sauvegardeCompte(personneEmetteur);
		serviceInvestisseur.supprimerOffre(offre);
	}

	public void accepterOffre(Offre offre) {
		passerOffreAHistorique_Offre(offre, "Acceptée");
		ArrayList<Titre> titres = offre.getTitresList(); // On recupere les
															// Titres echangés

		Personne p = offre.getPersonneEmetteur(); // On recupere la personne
													// recevant les titres

		p.getTitres().addAll(titres); // On lui donne les titres
		personne.getTitres().removeAll(titres); // On les supprimes de chez le
		// donneur

		// serviceSauvegarde.sauvegardeCompte(p);
		// serviceSauvegarde.sauvegardeCompte(personne);

		for (Titre t : titres) {
			serviceInvestisseur.miseAJourTitre(t);
			t.setPersonne(p);
			t.setEtatTitre(0);
			serviceSauvegarde.sauvegardeTitre(t);
		}

	}

	public String visiterPersonne(Personne p) {
		personneVisite = p;

		return "offer.xhtml";

	}

	public void refuserOffre(Offre offre) {
		passerOffreAHistorique_Offre(offre, "Refusé");
	}

	public boolean estVente(Titre titre) {
		return titre.estVente();

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
		;
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
		;
	}

	public String getNomPersonne() {
		return getPersonne().getNomPersonne();
	}

	public void setNomPersonne(String nomPersonne) {
		getPersonne().setNomPersonne(nomPersonne);
		;
	}

	public String getPrenomPersonne() {
		return getPersonne().getPrenomPersonne();
	}

	public void setPrenomPersonne(String prenomPersonne) {
		getPersonne().setPrenomPersonne(prenomPersonne);
		;
	}

	public Entreprise getEntreprises() {
		return getPersonne().getEntreprise();
	}

	public void setEntreprise(Entreprise entreprise) {
		getPersonne().setEntreprise(entreprise);
		;
	}

	public Set<Demande> getDemandes() {
		return getPersonne().getDemandes();
	}

	public void setDemandes(Set<Demande> demandes) {
		getPersonne().setDemandes(demandes);
		;
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
		;
	}

	public Set<Offre> getOffresEmises() {
		return getPersonne().getOffresEmises();
	}

	public Set<Offre> getOffresRecues() {
		return getPersonne().getOffresRecues();
	}

	public ArrayList<Offre> getOffresEmisesList() {
		return new ArrayList<Offre>(getPersonne().getOffresEmises());
	}

	public ArrayList<Offre> getOffresRecuesList() {
		return new ArrayList<Offre>(getPersonne().getOffresRecues());
	}

	public void setOffresEmises(Set<Offre> offres) {
		getPersonne().setOffresEmises(offres);
		;
	}

	public void setOffresRecues(Set<Offre> offres) {
		getPersonne().setOffresRecues(offres);
		;
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

	public ArrayList<Offre> getOffresList() {
		return new ArrayList<Offre>(getPersonne().getOffresRecues());
	}

	public ArrayList<Titre> getTitresList() {
		return new ArrayList<Titre>(getPersonne().getTitres());
	}

	public ArrayList<Demande> getDemandesList() {
		return new ArrayList<Demande>(getPersonne().getDemandes());
	}

	public ArrayList<OffreHistorique> getOffreHistoriquesEmisesList() {
		return new ArrayList<OffreHistorique>(getPersonne()
				.getOffreHistoriquesEmises());
	}

	public ArrayList<OffreHistorique> getOffreHistoriquesRecuesList() {
		return new ArrayList<OffreHistorique>(getPersonne()
				.getOffreHistoriquesRecues());
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

	public ArrayList<Titre> personneVisiteListTitre() {
		ArrayList<Titre> titres = new ArrayList<Titre>();
		for (Titre t : personneVisite.getTitresList()) {
			if (t.estVente() == true) {
				titres.add(t);
			}
		}
		return titres;
	}

	public ArrayList<String> personneVisiteListTypeTitre() {
		ArrayList<String> typeTitres = new ArrayList<String>();
		for (Titre t : personneVisite.getTitresList()) {
			if (!typeTitres.contains(t.getTypeTitre()) && t.estVente()) {
				typeTitres.add(t.getTypeTitre());
			}
		}

		return typeTitres;
	}

	public ArrayList<String> personneVisiteListNomTitreSelect() {
		ArrayList<String> nomTitres = new ArrayList<String>();
		for (Titre t : personneVisite.getTitresList()) {

			if (nomTitres.contains(t.getNomTitre()) == false
					&& t.getTypeTitre().equals(typeTitreTransaction) && t.estVente()) {
				nomTitres.add(t.getNomTitre());
				// System.out.println(t.getNomTitre());
			}
		}

		return nomTitres;
	}

	public ArrayList<Titre> personneVisiteTitrePourOffre() {
		ArrayList<Titre> titres = new ArrayList<Titre>();
		for (Titre t : personneVisiteListTitre()) {
			if (t.getNomTitre().equals(nomTitreTransaction)
					&& t.getTypeTitre().equals(typeTitreTransaction)) {
				titres.add(t);
				// System.out.println(t.getNomTitre()+ "/"+ nomTitreTransaction
				// +"  ----   "+ t.getTypeTitre()+"/"+typeTitreTransaction);
			}
		}
		return titres;
	}

	public ArrayList<Integer> personneVisiteTitrePourOffreNombre() {
		ArrayList<Integer> nomb = new ArrayList<Integer>();
		int i = 0;
		for (Titre t : personneVisite.getTitresList()) {
			if (t.getNomTitre().equals(nomTitreTransaction)
					&& t.getTypeTitre().equals(typeTitreTransaction) && t.estVente()) {
				nomb.add(i + 1);
				i++;
				// System.out.println(t.getNomTitre()+ "/"+ nomTitreTransaction
				// +"  ----   "+ t.getTypeTitre()+"/"+typeTitreTransaction);
			}
		}
		return nomb;
	}

	public String faireOffre(){
		ArrayList<Titre> titresOffre = personneVisiteTitrePourOffre();
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
		for(int i=0;i<quantiteOffre;i++){
			titresOffre.get(i).getOffres().add(offre);
			offre.getTitres().add(titresOffre.get(i));
			
		}
		
		
		personne.getOffresEmises().add(offre);
		personneVisite.getOffresRecues().add(offre);
		
		serviceSauvegarde.sauvegardeCompte(personne);
		//serviceSauvegarde.sauvegardeCompte(personneVisite);
		
		return "home.xhtml";
		
	}
}

