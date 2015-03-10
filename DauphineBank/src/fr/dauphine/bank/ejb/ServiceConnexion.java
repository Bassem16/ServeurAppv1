package fr.dauphine.bank.ejb;

import javax.ejb.Remote;

import fr.dauphine.bank.entities.Personne;

@Remote
public interface ServiceConnexion {
	public Personne verificationPersonne(String login, String motDePasse);

}
