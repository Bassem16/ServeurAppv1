package fr.dauphine.bank.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Offre database table.
 * 
 */
@Entity
@NamedQuery(name="Offre.findAll", query="SELECT o FROM Offre o")
public class Offre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idOffre;

	private int prixOffre;

	private String quantiteOffre;

	private String statut;

	private String typeOffre;

	//bi-directional many-to-one association to Entreprise
	@ManyToOne
	@JoinColumn(name="idEntreprise")
	private Entreprise entreprise;

	//bi-directional many-to-one association to Personne
	@ManyToOne
	@JoinColumn(name="idPersonne")
	private Personne personne;

	//bi-directional many-to-many association to Titre
	@ManyToMany(mappedBy="offres",fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private List<Titre> titres;

	public Offre() {
	}

	public int getIdOffre() {
		return this.idOffre;
	}

	public void setIdOffre(int idOffre) {
		this.idOffre = idOffre;
	}

	public int getPrixOffre() {
		return this.prixOffre;
	}

	public void setPrixOffre(int prixOffre) {
		this.prixOffre = prixOffre;
	}

	public String getQuantiteOffre() {
		return this.quantiteOffre;
	}

	public void setQuantiteOffre(String quantiteOffre) {
		this.quantiteOffre = quantiteOffre;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getTypeOffre() {
		return this.typeOffre;
	}

	public void setTypeOffre(String typeOffre) {
		this.typeOffre = typeOffre;
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

	public List<Titre> getTitres() {
		return this.titres;
	}

	public void setTitres(List<Titre> titres) {
		this.titres = titres;
	}

}