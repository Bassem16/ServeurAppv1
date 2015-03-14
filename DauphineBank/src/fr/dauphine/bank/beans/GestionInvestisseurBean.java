package fr.dauphine.bank.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
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
	private ArrayList<Offre> offresRecues = null;
	private ArrayList<Offre> offresAcceptees= null;

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
		// offresRecues = serviceInvestisseur.recupererOffres(personne);
		offresRecues = new ArrayList();

		for (Titre t : personne.getTitres()) {
			offresRecues.addAll(t.getOffres());
		}
		ArrayList<Offre> uniqueList = new ArrayList<Offre>(new HashSet<Offre>(
				offresRecues));
		offresRecues = uniqueList;
	}

	public void cloturerOffre(Offre offre) {
		personne.removeOffre(offre);

		serviceInvestisseur.supprimerOffre(offre);
		serviceSauvegarde.sauvegardeCompte(personne);

	}

	public void mettreSurMarcherTitre(Titre titre) {
		titre.setEtatTitre(1);
		serviceSauvegarde.sauvegardeTitre(titre);
	}

	public void retirerDuMarcherTitre(Titre titre) {
		titre.setEtatTitre(0);
		passerOffreAHistorique_Titre(titre);
	}

	public void passerOffreAHistorique_Titre(Titre titre) {
		OffreHistorique offreH = new OffreHistorique();
		ArrayList<Offre> AO = titre.getOffresList();
		Set<Offre> T = titre.getOffres();
		for (int i = 0; i < AO.size(); i++) {
			Offre offre = AO.get(i);
			offreH.setDateOffreHistorique(offre.getDateOffre());
			offreH.setEntreprise(offre.getEntreprise());
			offreH.setPersonne(offre.getPersonne());
			offreH.setPrixOffreHistorique(offre.getPrixOffre());
			offreH.setQuantiteOffreHistorique(offre.getQuantiteOffre());
			offreH.setStatut("Refusée");
			offreH.setTitres(offre.getTitres());
			offreH.setTypeOffreHistorique(offre.getTypeOffre());

			System.out.println("TAILLE  : " + titre.getOffres().size());

			ArrayList<Titre> titres = offre.getTitresList();
			for (int j = 0; j < titres.size(); j++) {
				titres.get(j).getOffres().remove(offre);
			}

			T.remove(offre);

			titre.getOffreHistoriques().add(offreH);

			Personne p = offre.getPersonne();
			p.getOffres().remove(offre);
			serviceInvestisseur.supprimerOffre(offre);
			serviceSauvegarde.sauvegardeCompte(p);

		}
		serviceSauvegarde.sauvegardeTitre(titre);

	}

	public void passerOffreAHistorique_Offre(Offre offre, String statut) {
		OffreHistorique offreH = new OffreHistorique();

		offreH.setDateOffreHistorique(offre.getDateOffre());
		offreH.setEntreprise(offre.getEntreprise());
		offreH.setPersonne(offre.getPersonne());
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
		serviceSauvegarde.sauvegardeOffreHistorique(offreH);
		Personne p = offre.getPersonne();
		p.getOffres().remove(offre);
		offresRecues.remove(offre);
		serviceInvestisseur.supprimerOffre(offre);
		serviceSauvegarde.sauvegardeCompte(p);
		
		

		// serviceSauvegarde.sauvegardeTitre(titres.get(0));

	}

	public void accepterOffre(Offre offre) {
		passerOffreAHistorique_Offre(offre, "Acceptée");
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

	public Set<Offre> getOffres() {
		return getPersonne().getOffres();
	}

	public void setOffres(Set<Offre> offres) {
		getPersonne().setOffres(offres);
		;
	}

	public Offre addOffre(Offre offre) {
		getOffres().add(offre);
		offre.setPersonne(getPersonne());

		return offre;
	}

	public Offre removeOffre(Offre offre) {
		getOffres().remove(offre);
		offre.setPersonne(null);

		return offre;
	}

	public TypePersonne getTypePersonne() {
		return getPersonne().getTypePersonne();
	}

	public void setTypePersonne(TypePersonne typePersonne) {
		getPersonne().setTypePersonne(typePersonne);
	}

	public ArrayList<Offre> getOffresList() {
		return new ArrayList<Offre>(getPersonne().getOffres());
	}

	public ArrayList<Titre> getTitresList() {
		return new ArrayList<Titre>(getPersonne().getTitres());
	}

	public ArrayList<Demande> getDemandesList() {
		return new ArrayList<Demande>(getPersonne().getDemandes());
	}

	public ArrayList<OffreHistorique> getOffreHistoriquesList() {
		return new ArrayList<OffreHistorique>(getPersonne()
				.getOffreHistoriques());
	}

	public ArrayList<Offre> getOffresRecues() {
		return offresRecues;
	}
}
