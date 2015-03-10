package fr.dauphine.bank.ejb;

import java.util.ArrayList;

import javax.ejb.Remote;

import fr.dauphine.bank.entities.Personne;

@Remote
public interface ServiceCreationCompte {
	public void CreationComptes(Personne personne);
	public ArrayList<Personne> trouverCompteEmail(String email);
	public ArrayList<Personne> trouverCompteLogin(String login);
}
