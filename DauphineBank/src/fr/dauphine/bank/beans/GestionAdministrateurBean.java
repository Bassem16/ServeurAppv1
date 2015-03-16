package fr.dauphine.bank.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import fr.dauphine.bank.ejb.ServiceAdministrateur;
import fr.dauphine.bank.ejb.ServiceSauvegarde;
import fr.dauphine.bank.ejb.ServiceVerificationData;
import fr.dauphine.bank.entities.Demande;
import fr.dauphine.bank.entities.DemandeHistorique;
import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.OffreHistorique;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;
import fr.dauphine.bank.entities.TypePersonne;
import fr.dauphine.bank.web.Utile;

@ManagedBean
@SessionScoped
//ATTENTION Cette classe ne doit etre appelé que lorsqu'un utilisateur
//Administrateur est connecté
public class GestionAdministrateurBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Personne personne = null;
	private Personne personneEntreprise = null;
	private Entreprise entreprise = null;

	@EJB
	ServiceAdministrateur serviceAdministrateur;
	@EJB
	ServiceVerificationData serviceVerificationData;
	@EJB
	ServiceSauvegarde serviceSauvegarde;

	public GestionAdministrateurBean(){
		HttpSession hs = Utile.getSession();
		personne = (Personne) hs.getAttribute("personne"); 
		if (entreprise == null)
			entreprise = new Entreprise();
		else
			entreprise = (Entreprise) hs.getAttribute("entreprise");
		this.personne = new Personne();
		
		this.personneEntreprise = new Personne();
		this.personneEntreprise.setValide(1);
		this.personneEntreprise.setEntreprise(null);
		this.personneEntreprise.setTypePersonne(null);
		this.personneEntreprise.setTitres(new HashSet<Titre>());
		this.personneEntreprise.setOffresEmises(new HashSet<Offre>());
		this.personneEntreprise.setOffresRecues(new HashSet<Offre>());
		this.personneEntreprise.setOffreHistoriquesEmises(new HashSet<OffreHistorique>());
		this.personneEntreprise.setOffreHistoriquesRecues(new HashSet<OffreHistorique>());
		this.personneEntreprise.setDemandeHistoriques(new HashSet<DemandeHistorique>());
		
	}

	public List<Demande> getDemandes() {
		return serviceAdministrateur.listeDemandes();
	}
	
	public List<Entreprise> getEntreprises() {
		return serviceAdministrateur.listeEntreprise();
	}
	
	public List<Personne> getMembresSociete() {
		return serviceAdministrateur.listeMembresSociete();
	}
	
	
	public List<DemandeHistorique> getDemandesHistorique() {
		return serviceAdministrateur.listeDemandesHistorique();
	}
	
	public void passerOffreADemande(Demande demande) {
		DemandeHistorique demandeH = new DemandeHistorique();
		demandeH.setDateDemandeHistorique(demande.getDateDemande());
		demandeH.setDescriptifDemandeHistorique(demande.getDescriptifDemande());
		demandeH.setStatutDemandeHistorique(demande.getStatutDemande());
		demandeH.setPersonne(demande.getPersonne());
		serviceAdministrateur.supprimerDemande(demande);
		serviceSauvegarde.sauvgarderDemandeHistorique(demandeH);


	}
	
	public void validerDemandePersonne(Demande demande) {
		demande.setStatutDemande("Traitée");
		demande.getPersonne().setValide(1);
		passerOffreADemande(demande);
	}
	
	public void supprimerDemandePersonne(Demande demande) {
		demande.setStatutDemande("Refusée");
		passerOffreADemande(demande);
	}
	
	public void ajouterEntreprise() {
		serviceSauvegarde.sauvgarderEntreprise(entreprise);
	}
	
	public void ajouterMembreEntreprise() {
		Entreprise e=serviceVerificationData.verificationEntreprise(entreprise.getNomEntreprise());
		personneEntreprise.setEntreprise(e);
		serviceSauvegarde.sauvegardeCompteEntreprise(this.personneEntreprise);
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
	
	public void setEntreprise(Entreprise entreprise) {
		getPersonne().setEntreprise(entreprise);
		;
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


	
	public Entreprise getEntreprise() {
		return this.entreprise;
	}
	
	public String getNomEntreprise() {
		return getEntreprise().getNomEntreprise();
	}
	
	public void setNomEntreprise(String nomEntreprise) {
		getEntreprise().setNomEntreprise(nomEntreprise);
	}
	
	public String getSecteurEntreprise() {
		return getEntreprise().getSecteurEntreprise();
	}
	
	public void setSecteurEntreprise(String secteurEntreprise) {
		getEntreprise().setSecteurEntreprise(secteurEntreprise);
	}
	
	public int getNombreTitreTotal() {
		return getEntreprise().getNombreTitreTotal();
	}
	
	public void setNombreTitreTotal(int nombreTitreTotal) {
		getEntreprise().setNombreTitreTotal(nombreTitreTotal);
	}
	
	
	public Personne getPersonneEntreprise() {
		return this.personneEntreprise;
	}

	public int getIdPersonneEntreprise() {
		return getPersonneEntreprise().getIdPersonne();
	}

	public void setIdPersonneEntreprise(int idPersonne) {
		getPersonne().setIdPersonne(idPersonne);
	}

	public String getEmailEntreprise() {
		return getPersonneEntreprise().getEmail();
	}

	public void setEmailEntreprise(String email) {
		getPersonneEntreprise().setEmail(email);
		;
	}

	public String getLoginEntreprise() {
		return getPersonneEntreprise().getLogin();
	}

	public void setLoginEntreprise(String login) {
		getPersonneEntreprise().setLogin(login);
	}

	public String getMotDePasseEntreprise() {
		return getPersonneEntreprise().getMotDePasse();
	}

	public void setMotDePasseEntreprise(String motDePasse) {
		getPersonneEntreprise().setMotDePasse(motDePasse);
		;
	}

	public String getNomPersonneEntreprise() {
		return getPersonne().getNomPersonne();
	}

	public void setNomPersonneEntreprise(String nomPersonne) {
		getPersonneEntreprise().setNomPersonne(nomPersonne);
	}

	public String getPrenomPersonneEntreprise() {
		return getPersonneEntreprise().getPrenomPersonne();
	}
	
	public void setPrenomPersonneEntreprise(String nomPersonne) {
		getPersonneEntreprise().setPrenomPersonne(nomPersonne);
	}
	
}
