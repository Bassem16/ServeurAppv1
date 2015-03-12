package fr.dauphine.bank.beans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;

import fr.dauphine.bank.ejb.ServiceAdministrateur;
import fr.dauphine.bank.ejb.ServiceInvestisseur;
import fr.dauphine.bank.entities.Demande;
import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;
import fr.dauphine.bank.entities.TypePersonne;
import fr.dauphine.bank.web.Utile;

@ManagedBean
@RequestScoped
// ATTENTION Cette classe ne doit etre appelé que lorsqu'un utilisateur Investisseur est connecté
public class GestionAdministrateurBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Personne personne = null;

	@EJB
	ServiceAdministrateur serviceAdministrateur;

	public GestionAdministrateurBean(){
		HttpSession hs = Utile.getSession();
		personne = (Personne) hs.getAttribute("personne");
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
		return serviceAdministrateur.listeDemandes(personne.getLogin());
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
