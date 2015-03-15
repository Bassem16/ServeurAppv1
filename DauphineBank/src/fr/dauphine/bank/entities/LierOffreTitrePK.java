package fr.dauphine.bank.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LierOffreTitre database table.
 * 
 */
@Embeddable
public class LierOffreTitrePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idOffre;

	@Column(insertable=false, updatable=false)
	private int idTitre;

	public LierOffreTitrePK() {
	}
	public int getIdOffre() {
		return this.idOffre;
	}
	public void setIdOffre(int idOffre) {
		this.idOffre = idOffre;
	}
	public int getIdTitre() {
		return this.idTitre;
	}
	public void setIdTitre(int idTitre) {
		this.idTitre = idTitre;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LierOffreTitrePK)) {
			return false;
		}
		LierOffreTitrePK castOther = (LierOffreTitrePK)other;
		return 
			(this.idOffre == castOther.idOffre)
			&& (this.idTitre == castOther.idTitre);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idOffre;
		hash = hash * prime + this.idTitre;
		
		return hash;
	}
}