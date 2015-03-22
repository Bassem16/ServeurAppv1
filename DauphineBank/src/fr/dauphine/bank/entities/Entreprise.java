package fr.dauphine.bank.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Comparator;
import java.util.Set;

/**
 * The persistent class for the Entreprise database table.
 * 
 */
@Entity
@NamedQuery(name = "Entreprise.findAll", query = "SELECT e FROM Entreprise e")
public class Entreprise implements Serializable {

	private static final long serialVersionUID = -7298202568294585054L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEntreprise;

	private int nombreTitreTotal;

	private String nomEntreprise;

	private String secteurEntreprise;
	
	private String logo;

	// bi-directional many-to-one association to Information
	@OneToMany(mappedBy = "entreprise", fetch = FetchType.EAGER)
	private Set<Information> informations;

	// bi-directional many-to-one association to Offre
	@OneToMany(mappedBy = "entreprise", fetch = FetchType.EAGER)
	private Set<Offre> offres;

	// bi-directional many-to-one association to OffreHistorique
	@OneToMany(mappedBy = "entreprise", fetch = FetchType.EAGER)
	private Set<OffreHistorique> offreHistoriques;

	// bi-directional many-to-one association to Personne
	@OneToMany(mappedBy = "entreprise", fetch = FetchType.EAGER)
	private Set<Personne> personnes;

	// bi-directional many-to-one association to Titre
	@OneToMany(mappedBy = "entreprise", fetch = FetchType.EAGER)
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

	

	public Set<Offre> getOffres() {
		return this.offres;
	}

	public void setOffres(Set<Offre> offres) {
		this.offres = offres;
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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
	public static final Comparator<Entreprise> alphabetique = new Comparator<Entreprise>() {

		public int compare(Entreprise o1, Entreprise o2) {

					
			return o1.getNomEntreprise().toLowerCase().compareTo(o2.getNomEntreprise().toLowerCase());

		}

};

}