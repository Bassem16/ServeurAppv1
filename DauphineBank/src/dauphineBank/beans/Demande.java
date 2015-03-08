package dauphineBank.beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Demande database table.
 * 
 */
@Entity
@NamedQuery(name="Demande.findAll", query="SELECT d FROM Demande d")
public class Demande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idDemande;

	private int descriptifDemande;

	private int statutDemande;

	//bi-directional many-to-one association to Personne
	@ManyToOne
	@JoinColumn(name="idPersonne")
	private Personne personne;

	public Demande() {
	}

	public int getIdDemande() {
		return this.idDemande;
	}

	public void setIdDemande(int idDemande) {
		this.idDemande = idDemande;
	}

	public int getDescriptifDemande() {
		return this.descriptifDemande;
	}

	public void setDescriptifDemande(int descriptifDemande) {
		this.descriptifDemande = descriptifDemande;
	}

	public int getStatutDemande() {
		return this.statutDemande;
	}

	public void setStatutDemande(int statutDemande) {
		this.statutDemande = statutDemande;
	}

	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

}