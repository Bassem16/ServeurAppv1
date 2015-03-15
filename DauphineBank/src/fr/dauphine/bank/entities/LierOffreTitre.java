package fr.dauphine.bank.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LierOffreTitre database table.
 * 
 */
@Entity
@NamedQuery(name="LierOffreTitre.findAll", query="SELECT l FROM LierOffreTitre l")
public class LierOffreTitre implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LierOffreTitrePK id;

	public LierOffreTitre() {
	}

	public LierOffreTitrePK getId() {
		return this.id;
	}

	public void setId(LierOffreTitrePK id) {
		this.id = id;
	}

}