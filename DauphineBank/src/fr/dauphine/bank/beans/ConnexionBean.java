package fr.dauphine.bank.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.dauphine.bank.ejb.ServiceConnexion;
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
	
	public ConnexionBean() {
		personne=new Personne();	
	}
	
	public String doLogin(){
		Personne p=serviceConnexion.verificationPersonne(personne.getLogin(),personne.getMotDePasse());
		if(p!=null){
			HttpSession hs= Utile.getSession();
					personne=p;
					hs.setAttribute("Investisseur", p);
					return "/Investisseur/home.xhtml?faces-redirect=true";
		} else{
			FacesMessage fm= new FacesMessage("Erreur d'identification", "!!!! ERROR MSG !!!!");
			fm.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, fm);
			return "login.xhtml";
		}
	}

	
	public String doLogout(){
		HttpSession hs= Utile.getSession();
		hs.invalidate();
		return "/login.xhtml?faces-redirect=true";
		
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

	public List<Entreprise> getEntreprises() {
		return getPersonne().getEntreprises();
	}

	public void setEntreprises(List<Entreprise> entreprises) {
		getPersonne().setEntreprises(entreprises);
		;
	}

	public List<Demande> getDemandes() {
		return getPersonne().getDemandes();
	}

	public void setDemandes(List<Demande> demandes) {
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

	public List<Titre> getTitres() {
		return getPersonne().getTitres();
	}

	public void setTitres(List<Titre> titres) {
		getPersonne().setTitres(titres);
		;
	}

	public List<Offre> getOffres() {
		return getPersonne().getOffres();
	}

	public void setOffres(List<Offre> offres) {
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

}
