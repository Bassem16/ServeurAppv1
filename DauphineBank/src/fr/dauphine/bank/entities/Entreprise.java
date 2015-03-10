package fr.dauphine.bank.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Entreprise database table.
 * 
 */
@Entity
@NamedQuery(name="Entreprise.findAll", query="SELECT e FROM Entreprise e")
public class Entreprise implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEntreprise;

	private int nombreTitreTotal;

	private String nomEntreprise;

	private String secteurEntreprise;

	//bi-directional many-to-many association to Personne
	@ManyToMany(mappedBy="entreprises")
	private List<Personne> personnes;

	//bi-directional many-to-one association to Information
	@OneToMany(mappedBy="entreprise")
	private List<Information> informations;

	//bi-directional many-to-one association to Offre
	@OneToMany(mappedBy="entreprise")
	private List<Offre> offres;

	//bi-directional many-to-one association to Titre
	@OneToMany(mappedBy="entreprise")
	private List<Titre> titres;

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

	public List<Personne> getPersonnes() {
		return this.personnes;
	}

	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}

	public List<Information> getInformations() {
		return this.informations;
	}

	public void setInformations(List<Information> informations) {
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

	public List<Offre> getOffres() {
		return this.offres;
	}

	public void setOffres(List<Offre> offres) {
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

	public List<Titre> getTitres() {
		return this.titres;
	}

	public void setTitres(List<Titre> titres) {
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