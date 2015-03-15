package fr.dauphine.bank.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the Entreprise database table.
 * 
 */
@Entity
@NamedQuery(name="Entreprise.findAll", query="SELECT e FROM Entreprise e")
public class Entreprise implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEntreprise;

	private int nombreTitreTotal;

	private String nomEntreprise;

	private String secteurEntreprise;

	//bi-directional many-to-one association to Information
	@OneToMany(mappedBy="entreprise", fetch=FetchType.EAGER)
	private Set<Information> informations;

	//bi-directional many-to-one association to Offre
	@OneToMany(mappedBy="entreprise", fetch=FetchType.EAGER)
	private Set<Offre> offres;

	//bi-directional many-to-one association to OffreHistorique
	@OneToMany(mappedBy="entreprise", fetch=FetchType.EAGER)
	private Set<OffreHistorique> offreHistoriques;

	//bi-directional many-to-one association to Personne
	@OneToMany(mappedBy="entreprise", fetch=FetchType.EAGER)
	private Set<Personne> personnes;

	//bi-directional many-to-one association to Titre
	@OneToMany(mappedBy="entreprise", fetch=FetchType.EAGER)
	private Set<Titre> titres;

	public Entreprise() {
	}

	public int getIdEntreprise() {
		return this.idEntreprise;
	}

	public void setIdEntreprise(int idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	public int getNombreTitreTotal() {
		return this.nombreTitreTotal;
	}

	public void setNombreTitreTotal(int nombreTitreTotal) {
		this.nombreTitreTotal = nombreTitreTotal;
	}

	public String getNomEntreprise() {
		return this.nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public String getSecteurEntreprise() {
		return this.secteurEntreprise;
	}

	public void setSecteurEntreprise(String secteurEntreprise) {
		this.secteurEntreprise = secteurEntreprise;
	}

	public Set<Information> getInformations() {
		return this.informations;
	}

	public void setInformations(Set<Information> informations) {
		this.informations = informations;
	}

	public Information addInformation(Information information) {
		getInformations().add(information);
		information.setEntreprise(this);

		return information;
	}

	public Information removeInformation(Information information) {
		getInformations().remove(information);
		information.setEntreprise(null);

		return information;
	}

	public Set<Offre> getOffres() {
		return this.offres;
	}

	public void setOffres(Set<Offre> offres) {
		this.offres = offres;
	}

	public Offre addOffre(Offre offre) {
		getOffres().add(offre);
		offre.setEntreprise(this);

		return offre;
	}

	public Offre removeOffre(Offre offre) {
		getOffres().remove(offre);
		offre.setEntreprise(null);

		return offre;
	}

	public Set<OffreHistorique> getOffreHistoriques() {
		return this.offreHistoriques;
	}

	public void setOffreHistoriques(Set<OffreHistorique> offreHistoriques) {
		this.offreHistoriques = offreHistoriques;
	}

	public OffreHistorique addOffreHistorique(OffreHistorique offreHistorique) {
		getOffreHistoriques().add(offreHistorique);
		offreHistorique.setEntreprise(this);

		return offreHistorique;
	}

	public OffreHistorique removeOffreHistorique(OffreHistorique offreHistorique) {
		getOffreHistoriques().remove(offreHistorique);
		offreHistorique.setEntreprise(null);

		return offreHistorique;
	}

	public Set<Personne> getPersonnes() {
		return this.personnes;
	}

	public void setPersonnes(Set<Personne> personnes) {
		this.personnes = personnes;
	}

	public Personne addPersonne(Personne personne) {
		getPersonnes().add(personne);
		personne.setEntreprise(this);

		return personne;
	}

	public Personne removePersonne(Personne personne) {
		getPersonnes().remove(personne);
		personne.setEntreprise(null);

		return personne;
	}

	public Set<Titre> getTitres() {
		return this.titres;
	}

	public void setTitres(Set<Titre> titres) {
		this.titres = titres;
	}

	public Titre addTitre(Titre titre) {
		getTitres().add(titre);
		titre.setEntreprise(this);

		return titre;
	}

	public Titre removeTitre(Titre titre) {
		getTitres().remove(titre);
		titre.setEntreprise(null);

		return titre;
	}

}