package fr.dauphine.bank.entities;

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

	private String nomTitre;

	private String typeTitre;

	//bi-directional many-to-one association to Entreprise
	@ManyToOne
	@JoinColumn(name="idEntreprise")
	private Entreprise entreprise;

	//bi-directional many-to-many association to Offre
	@ManyToMany
	@JoinTable(
		name="LierOffreTitre"
		, joinColumns={
			@JoinColumn(name="idTitre")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idOffre")
			}
		)
	private List<Offre> offres;

	//bi-directional many-to-one association to Personne
	@ManyToOne
	@JoinColumn(name="idPersonne")
	private Personne personne;

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

	public String getNomTitre() {
		return this.nomTitre;
	}

	public void setNomTitre(String nomTitre) {
		this.nomTitre = nomTitre;
	}

	public String getTypeTitre() {
		return this.typeTitre;
	}

	public void setTypeTitre(String typeTitre) {
		this.typeTitre = typeTitre;
	}

	public Entreprise getEntreprise() {
		return this.entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public List<Offre> getOffres() {
		return this.offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}

	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

}