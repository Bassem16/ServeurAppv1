package fr.dauphine.bank.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

/**
 * The persistent class for the OffreHistorique database table.
 * 
 */
@Entity
@NamedQuery(name = "OffreHistorique.findAll", query = "SELECT o FROM OffreHistorique o")
public class OffreHistorique implements Serializable, Comparable<OffreHistorique>{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOffreHistorique;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOffreHistorique;

	private double prixOffreHistorique;

	private int quantiteOffreHistorique;

	private String statut;

	private String typeOffreHistorique;

	// bi-directional many-to-one association to Entreprise
	@ManyToOne
	@JoinColumn(name = "idEntreprise")
	private Entreprise entreprise;

	// bi-directional many-to-one association to Personne
	@ManyToOne
	@JoinColumn(name = "idPersonneEmetteur")
	private Personne personneEmetteur;

	// bi-directional many-to-one association to Personne
	@ManyToOne
	@JoinColumn(name = "idPersonneReceveur")
	private Personne personneReceveur;

	// bi-directional many-to-many association to Titre
	@ManyToMany(cascade= {CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinTable(name = "LierOffreTitreHistorique", joinColumns = { @JoinColumn(name = "idOffreHistorique") }, inverseJoinColumns = { @JoinColumn(name = "idTitre") })
	private Set<Titre> titres;

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

	public void setPrixOffreHistorique(double prixOffreHistorique) {
		this.prixOffreHistorique = prixOffreHistorique;
	}

	public int getQuantiteOffreHistorique() {
		return this.quantiteOffreHistorique;
	}

	public void setQuantiteOffreHistorique(int quantiteOffreHistorique) {
		this.quantiteOffreHistorique = quantiteOffreHistorique;
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

	public Entreprise getEntreprise() {
		return this.entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public Personne getPersonneEmetteur() {
		return this.personneEmetteur;
	}

	public void setPersonneEmetteur(Personne PersonneEmetteur) {
		this.personneEmetteur = PersonneEmetteur;
	}

	public Personne getPersonneReceveur() {
		return this.personneReceveur;
	}

	public void setPersonneReceveur(Personne PersonneReceveur) {
		this.personneReceveur = PersonneReceveur;
	}

	public Set<Titre> getTitres() {
		return this.titres;
	}

	public void setTitres(Set<Titre> titres) {
		this.titres = titres;
	}

	public ArrayList<Titre> getTitresList() {

		return new ArrayList<Titre>(titres);
	}
	
	//Comparable code
	@Override
	public int compareTo(OffreHistorique o) {
		
		//Odre décroissant
		return o.getDateOffreHistorique().compareTo(this.getDateOffreHistorique());

	}

}