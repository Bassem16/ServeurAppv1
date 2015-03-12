

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.List;

/**
 * The persistent class for the Personne database table.
 * 
 */
@Entity
@NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p")
public class Personne implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersonne;
	@Pattern(regexp = "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)", message = "Merci de saisir une adresse mail valide")
	@NotNull(message = "Veuillez saisir un email")
	private String email;
	@NotNull(message = "Veuillez saisir un login")
	@Size(min = 6, message = "Le login doit contenir au moins 6 caractères")
	private String login;
	@NotNull(message = "Veuillez saisir un mot de passe")
	private String motDePasse;
	@NotNull(message = "Veuillez saisir un nom")
	private String nomPersonne;
	@NotNull(message = "Veuillez saisir un prenom")
	private String prenomPersonne;

	private int valide;

	// bi-directional many-to-one association to Demande
	@OneToMany(mappedBy = "personne", fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private List<Demande> demandes;

	// bi-directional many-to-one association to Offre
	@OneToMany(mappedBy = "personne", fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private List<Offre> offres;

	// bi-directional many-to-one association to Entreprise
	@ManyToOne
	@JoinColumn(name = "idEntreprise")
	private Entreprise entreprise;

	// bi-directional many-to-one association to TypePersonne
	@ManyToOne
	@JoinColumn(name = "idTypePersonne")
	private TypePersonne typePersonne;

	// bi-directional many-to-one association to Titre
	@OneToMany(mappedBy = "personne", fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private List<Titre> titres;

	public Personne() {
	}

	public int getIdPersonne() {
		return this.idPersonne;
	}

	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getNomPersonne() {
		return this.nomPersonne;
	}

	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}

	public String getPrenomPersonne() {
		return this.prenomPersonne;
	}

	public void setPrenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}

	public int getValide() {
		return this.valide;
	}

	public void setValide(int valide) {
		this.valide = valide;
	}

	public List<Demande> getDemandes() {
		return this.demandes;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}

	public Demande addDemande(Demande demande) {
		getDemandes().add(demande);
		demande.setPersonne(this);

		return demande;
	}

	public Demande removeDemande(Demande demande) {
		getDemandes().remove(demande);
		demande.setPersonne(null);

		return demande;
	}

	public List<Offre> getOffres() {
		return this.offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}

	public Offre addOffre(Offre offre) {
		getOffres().add(offre);
		offre.setPersonne(this);

		return offre;
	}

	public Offre removeOffre(Offre offre) {
		getOffres().remove(offre);
		offre.setPersonne(null);

		return offre;
	}

	public Entreprise getEntreprise() {
		return this.entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public TypePersonne getTypePersonne() {
		return this.typePersonne;
	}

	public void setTypePersonne(TypePersonne typePersonne) {
		this.typePersonne = typePersonne;
	}

	public List<Titre> getTitres() {
		return this.titres;
	}

	public void setTitres(List<Titre> titres) {
		this.titres = titres;
	}

	public Titre addTitre(Titre titre) {
		getTitres().add(titre);
		titre.setPersonne(this);

		return titre;
	}

	public Titre removeTitre(Titre titre) {
		getTitres().remove(titre);
		titre.setPersonne(null);

		return titre;
	}

}