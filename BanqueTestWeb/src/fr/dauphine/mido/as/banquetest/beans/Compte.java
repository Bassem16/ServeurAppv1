package fr.dauphine.mido.as.banquetest.beans;

import java.math.BigDecimal;

public class Compte {
	private String nocompte;
	private String nom;
	private String prenom;
	private BigDecimal solde;

	public Compte() {
		// TODO Auto-generatedconstructorstub
	}

	public String getNocompte() {
		return nocompte;
	}

	public void setNocompte(String nocompte) {
		this.nocompte = nocompte;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public BigDecimal getSolde() {
		return solde;
	}

	public void setSolde(BigDecimal solde) {
		this.solde = solde;
	}
}
