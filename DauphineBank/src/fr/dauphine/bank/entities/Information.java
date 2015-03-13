package fr.dauphine.bank.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the Information database table.
 * 
 */
@Entity
@NamedQuery(name="Information.findAll", query="SELECT i FROM Information i")
public class Information implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idInformation;

	private Date dateInformation;

	private String texteInformation;

	private String typeInformation;

	//bi-directional many-to-one association to Entreprise
	@ManyToOne
	@JoinColumn(name="idEntreprise")
	private Entreprise entreprise;

	public Information() {
	}

	public int getIdInformation() {
		return this.idInformation;
	}

	public void setIdInformation(int idInformation) {
		this.idInformation = idInformation;
	}

	public Date getDateInformation() {
		return this.dateInformation;
	}

	public void setDateInformation(Date dateInformation) {
		this.dateInformation = dateInformation;
	}

	public String getTexteInformation() {
		return this.texteInformation;
	}

	public void setTexteInformation(String texteInformation) {
		this.texteInformation = texteInformation;
	}

	public String getTypeInformation() {
		return this.typeInformation;
	}

	public void setTypeInformation(String typeInformation) {
		this.typeInformation = typeInformation;
	}

	public Entreprise getEntreprise() {
		return this.entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

}