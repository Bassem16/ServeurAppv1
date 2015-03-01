package fr.dauphine.mido.as.banquetest.beans;

public class Operation {
	private int idOperation;
	private String noCompte;
	private String dateOperation;
	private String heureOperation;
	private char operation;
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
