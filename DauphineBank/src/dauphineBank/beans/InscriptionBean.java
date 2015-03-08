package dauphineBank.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dauphineBank.ejb.ServiceCreationCompte;

@ManagedBean
@SessionScoped
public class InscriptionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private final static String _SQL_INSERT_PERSONNE = "INSERT INTO BDD_BANQUE.PERSONNE (idPersonne, NOM, PRENOM,EMAIL) VALUES(?,?,?,?)";
	private Personne personne = null;

	@EJB
	ServiceCreationCompte serviceCreationCompte;

	public InscriptionBean() {
		this.personne = new Personne();
	}

	public String getResponse() {
		String retour = null;
		personne.setDemandes(new ArrayList<Demande>());
		personne.setEntreprises(new ArrayList<Entreprise>());
		personne.setTitres(new ArrayList<Titre>());
		personne.setOffres(new ArrayList<Offre>());
		serviceCreationCompte.CreationComptes(this.personne);
		retour = "Une demande d'inscription a été envoyé";
		return retour;
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
