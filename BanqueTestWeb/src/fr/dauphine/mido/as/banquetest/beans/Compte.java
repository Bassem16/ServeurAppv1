package fr.dauphine.mido.as.banquetest.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the COMPTES database table.
 * 
 */
@Entity
@Table(name = "COMPTES")
@NamedQuery(name = "Compte.findAll", query = "SELECT c FROM Compte c")
public class Compte implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String _COMPTE_COURANT = "_COMPTE_COURANT";
	public static final String _LISTE_OPERATIONS = "_LISTE_OPERATIONS";
	@Id
	@Column(name = "NOCOMPTE")
	private String nocompte;

	@Column(name = "NOM")
	private String nom;

	@Column(name = "PRENOM")
	private String prenom;

	@Column(name = "SOLDE")
	private BigDecimal solde;

	public Compte() {
	}

	public String getNocompte() {
		return this.nocompte;
	}

	public void setNocompte(String nocompte) {
		this.nocompte = nocompte;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public BigDecimal getSolde() {
		return this.solde;
	}

	public void setSolde(BigDecimal solde) {
		this.solde = solde;
	}

}