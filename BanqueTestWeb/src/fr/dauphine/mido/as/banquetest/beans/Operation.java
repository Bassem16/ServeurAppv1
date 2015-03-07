package fr.dauphine.mido.as.banquetest.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name = "OPERATIONS")
public class Operation implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "IDOPERATION", unique = true, nullable = false)
	private int idOperation;
	@Column(name = "NOCOMPTE", nullable = false, length = 4)
	private String noCompte;
	@Column(name = "DATE")
	private String dateOperation;
	@Column(name = "HEURE")
	private String heureOperation;
	@Column(name = "OP")
	private char operation;
	@Column(name = "VALEUR", nullable = false, precision = 10, scale = 2)
	private float valeur;

	public Operation() {
		// TODO Auto-generatedconstructorstub
	}

	public int getIdOperation() {
		return this.idOperation;
	}

	public void setIdOperation(int idOperation) {
		this.idOperation = idOperation;
	}

	public String getNoCompte() {
		return this.noCompte;
	}

	public void setNoCompte(String noCompte) {
		this.noCompte = noCompte;
	}

	public String getDateOperation() {
		return this.dateOperation;
	}

	public void setDateOperation(String dateOperation) {
		this.dateOperation = dateOperation;
	}

	public String getHeureOperation() {
		return this.heureOperation;
	}

	public void setHeureOperation(String heureOperation) {
		this.heureOperation = heureOperation;
	}

	public char getOperation() {
		return this.operation;
	}

	public void setOperation(char operation) {
		this.operation = operation;
	}

	public float getValeur() {
		return this.valeur;
	}

	public void setValeur(float valeur) {
		this.valeur = valeur;
	}

}
