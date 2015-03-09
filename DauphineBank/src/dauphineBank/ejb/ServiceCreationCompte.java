package dauphineBank.ejb;

import java.util.ArrayList;

import javax.ejb.Remote;

import dauphineBank.beans.Personne;

@Remote
public interface ServiceCreationCompte {
	public void CreationComptes(Personne personne);
	public ArrayList<Personne> trouverCompteEmail(String email);
	public ArrayList<Personne> trouverCompteLogin(String login);
}
