package fr.dauphine.bank.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;
import java.util.Set;


/**
 * The persistent class for the TypePersonne database table.
 * 
 */
@Entity
@NamedQuery(name="TypePersonne.findAll", query="SELECT t FROM TypePersonne t")
public class TypePersonne implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTypePersonne;

	private String typePersonne;

	//bi-directional many-to-one association to Personne
	@OneToMany(mappedBy="typePersonne", fetch=FetchType.EAGER)
	private Set<Personne> personnes;

	public TypePersonne() {
	}

	public int getIdTypePersonne() {
		return this.idTypePersonne;
	}

	public void setIdTypePersonne(int idTypePersonne) {
		this.idTypePersonne = idTypePersonne;
	}

	public String getTypePersonne() {
		return this.typePersonne;
	}

	public void setTypePersonne(String typePersonne) {
		this.typePersonne = typePersonne;
	}

	public Set<Personne> getPersonnes() {
		return this.personnes;
	}

	public void setPersonnes(Set<Personne> personnes) {
		this.personnes = personnes;
	}

	public Personne addPersonne(Personne personne) {
		getPersonnes().add(personne);
		personne.setTypePersonne(this);

		return personne;
	}

	public Personne removePersonne(Personne personne) {
		getPersonnes().remove(personne);
		personne.setTypePersonne(null);

		return personne;
	}

}