package fr.dauphine.bank.ejb;

import java.util.List;
import javax.ejb.Remote;

import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Personne;


@Remote
public interface ServiceVerificationData {
	public List<Personne> trouverCompteEmail(String email);
	public List<Personne> trouverCompteLogin(String email);
	public Entreprise verificationEntreprise(String nom);
}
