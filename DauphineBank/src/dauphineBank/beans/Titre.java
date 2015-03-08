package dauphineBank.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Titre database table.
 * 
 */
@Entity
@NamedQuery(name="Titre.findAll", query="SELECT t FROM Titre t")
public class Titre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTitre;

	private int nombreTitre;

	private int nomTitre;

	private int typeTitre;

	//bi-directional many-to-many association to Personne
	@ManyToMany
	@JoinTable(
		name="Echanger"
		, joinColumns={
			@JoinColumn(name="idTitre")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idPersonne")
			}
		)
	private List<Personne> personnes;

	//bi-directional many-to-one association to Entreprise
	@ManyToOne
	@JoinColumn(name="idEntreprise")
	private Entreprise entreprise;

	public Titre() {
	}

	public int getIdTitre() {
		return this.idTitre;
	}

	public void setIdTitre(int idTitre) {
		this.idTitre = idTitre;
	}

	public int getNombreTitre() {
		return this.nombreTitre;
	}

	public void setNombreTitre(int nombreTitre) {
		this.nombreTitre = nombreTitre;
	}

	public int getNomTitre() {
		return this.nomTitre;
	}

	public void setNomTitre(int nomTitre) {
		this.nomTitre = nomTitre;
	}

	public int getTypeTitre() {
		return this.typeTitre;
	}

	public void setTypeTitre(int typeTitre) {
		this.typeTitre = typeTitre;
	}

	public List<Personne> getPersonnes() {
		return this.personnes;
	}

	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}

	public Entreprise getEntreprise() {
		return this.entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

}