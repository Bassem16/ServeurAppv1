package fr.dauphine.bank.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the OffreHistorique database table.
 * 
 */
@Entity
@NamedQuery(name="OffreHistorique.findAll", query="SELECT o FROM OffreHistorique o")
public class OffreHistorique implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idOffreHistorique;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOffreHistorique;

	private double prixOffreHistorique;

	private int quantiteOffreHistorique;

	private String statut;

	private String typeOffreHistorique;

	//bi-directional many-to-many association to Titre
	@ManyToMany(mappedBy="offreHistoriques")
	private Set<Titre> titres;

	//bi-directional many-to-one association to Entreprise
	@ManyToOne
	@JoinColumn(name="idEntreprise")
	private Entreprise entreprise;

	//bi-directional many-to-one association to Personne
	@ManyToOne
	@JoinColumn(name="idPersonne")
	private Personne personne;

	public OffreHistorique() {
	}

	public int getIdOffreHistorique() {
		return this.idOffreHistorique;
	}

	public void setIdOffreHistorique(int idOffreHistorique) {
		this.idOffreHistorique = idOffreHistorique;
	}

	public Date getDateOffreHistorique() {
		return this.dateOffreHistorique;
	}

	public void setDateOffreHistorique(Date dateOffreHistorique) {
		this.dateOffreHistorique = dateOffreHistorique;
	}

	public double getPrixOffreHistorique() {
		return this.prixOffreHistorique;
	}

	public void setPrixOffreHistorique(double d) {
		this.prixOffreHistorique = d;
	}

	public int getQuantiteOffreHistorique() {
		return this.quantiteOffreHistorique;
	}

	public void setQuantiteOffreHistorique(int i) {
		this.quantiteOffreHistorique = i;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getTypeOffreHistorique() {
		return this.typeOffreHistorique;
	}

	public void setTypeOffreHistorique(String typeOffreHistorique) {
		this.typeOffreHistorique = typeOffreHistorique;
	}

	public Set<Titre> getTitres() {
		return this.titres;
	}

	public void setTitres(Set<Titre> titres) {
		this.titres = titres;
	}

	public Entreprise getEntreprise() {
		return this.entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

}