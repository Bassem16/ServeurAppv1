package fr.dauphine.bank.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;
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
	private boolean entrepriseChek = false;
	private boolean typeCheck = false;
	private String entrepriseNom = null;
	private String typeNom = null;
	// private ArrayList<Offre> offresRecues = null;
	// private ArrayList<Offre> offresAcceptees= null;

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
		// offresRecues = serviceInvestisseur.recupererOffres(personne);

	}
	
	
	public ArrayList<Titre> rechercherTitre(){
		return serviceInvestisseur.recupererTitre(entrepriseChek, typeCheck, entrepriseNom, typeNom);
		
		
	}
	
	public ArrayList<Entreprise> listEntreprise(){
		return serviceInvestisseur.recupererEntrepriseListAll(entrepriseNom);
		
		
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

	
	//Ne plus toucher
	public void cloturerOffre(Offre offre) {
		//OffreHistorique offreH = offreAHistorique(offre, "Retirée");
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

	
	//Ne plus toucher
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
			//serviceSauvegarde.sauvegardeCompte(personneEmetteur);
			serviceInvestisseur.supprimerOffre(offre);
		}

		// serviceSauvegarde.sauvegardeTitre(titre);

	}

	
	//Ne plus toucher
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
		//serviceSauvegarde.sauvegardeCompte(personneEmetteur);
		serviceInvestisseur.supprimerOffre(offre);
	}

	
	public void accepterOffre(Offre offre) {
		passerOffreAHistorique_Offre(offre, "Acceptée");
		ArrayList<Titre> titres = offre.getTitresList(); // On recupere les
															// Titres echangés

		Personne p = offre.getPersonneEmetteur(); // On recupere la personne
													// recevant les titres

		p.getTitres().addAll(titres); // On lui donne les titres
		personne.getTitres().removeAll(titres); //On les supprimes de chez le
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

}
