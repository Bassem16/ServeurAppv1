package fr.dauphine.bank.beans;

import java.util.ArrayList;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.dauphine.bank.ejb.ServiceConnexion;
import fr.dauphine.bank.ejb.ServiceSauvegarde;
import fr.dauphine.bank.entities.Demande;
import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;
import fr.dauphine.bank.entities.TypePersonne;
import fr.dauphine.bank.web.Utile;

@ManagedBean
@SessionScoped
public class ConnexionBean {

	private Personne personne;

	@EJB
	ServiceConnexion serviceConnexion;
	
	@EJB
	ServiceSauvegarde serviceSauvegarde;
	


	public String doLogin(){
		Personne p=serviceConnexion.verificationPersonne(personne.getLogin(),personne.getMotDePasse());
		if(p!=null){
			HttpSession hs= Utile.getSession();
					personne=p;
					hs.setAttribute("personne", p);
					if (personne.getTypePersonne().getIdTypePersonne() == 1){
						return "/Investisseur/home.xhtml?faces-redirect=true";
					}
					else if (personne.getTypePersonne().getIdTypePersonne() == 3) {
						return "/Administrateur/homeAdministrateur.xhtml?faces-redirect=true";
					}
					else{
						return "Visiteur/login.xhtml";
					}
		} else{
			FacesMessage fm= new FacesMessage("Erreur d'identification", "!!!! ERROR MSG !!!!");

			fm.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, fm);
			return "Visiteur/login.xhtml";
		}
	}
	
	
	public ConnexionBean() {
		personne = new Personne();
	}

	

	public boolean isConnected() {
		HttpSession hs = Utile.getSession();
		if (hs.getAttribute("personne") == null) {
			return false;
		} else {
			return true;
		}

	}

	public String doLogout() {
//		serviceSauvegarde.sauvegardeCompte((Personne) Utile.getSession()
//				.getAttribute("personne"));
		HttpSession hs = Utile.getSession();
		hs.invalidate();
		return "/index.xhtml";

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

	

	public ArrayList<Titre> getTitresList() {
		return new ArrayList<Titre>(getPersonne().getTitres());
	}

	public ArrayList<Demande> getDemandesList() {
		return new ArrayList<Demande>(getPersonne().getDemandes());
	}

}
