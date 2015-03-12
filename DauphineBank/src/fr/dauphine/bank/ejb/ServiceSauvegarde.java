package fr.dauphine.bank.ejb;

import javax.ejb.Remote;

import fr.dauphine.bank.entities.Personne;

@Remote
public interface ServiceSauvegarde {
	public void sauvegardeCompte(Personne personne);
}
