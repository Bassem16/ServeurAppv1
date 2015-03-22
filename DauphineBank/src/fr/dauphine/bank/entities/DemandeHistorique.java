package fr.dauphine.bank.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the DemandeHistorique database table.
 * 
 */
@Entity
@NamedQuery(name="DemandeHistorique.findAll", query="SELECT d FROM DemandeHistorique d")
public class DemandeHistorique implements Serializable {

	private static final long serialVersionUID = -1107502229132899926L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDemandeHistorique;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDemandeHistorique;

	private String descriptifDemandeHistorique;

	private String statutDemandeHistorique;

	//bi-directional many-to-one association to Personne
	@ManyToOne
	@JoinColumn(name="idPersonne")
	private Personne personne;

	public DemandeHistorique() {
	}

	public int getIdDemandeHistorique() {
		return this.idDemandeHistorique;
	}

	public void setIdDemandeHistorique(int idDemandeHistorique) {
		this.idDemandeHistorique = idDemandeHistorique;
	}

	public Date getDateDemandeHistorique() {
		return this.dateDemandeHistorique;
	}

	public void setDateDemandeHistorique(Date dateDemandeHistorique) {
		this.dateDemandeHistorique = dateDemandeHistorique;
	}

	public String getDescriptifDemandeHistorique() {
		return this.descriptifDemandeHistorique;
	}

	public void setDescriptifDemandeHistorique(String descriptifDemandeHistorique) {
		this.descriptifDemandeHistorique = descriptifDemandeHistorique;
	}

	public String getStatutDemandeHistorique() {
		return this.statutDemandeHistorique;
	}

	public void setStatutDemandeHistorique(String statutDemandeHistorique) {
		this.statutDemandeHistorique = statutDemandeHistorique;
	}

	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

}