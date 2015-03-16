package fr.dauphine.bank.ejb;

import java.util.ArrayList;

import javax.ejb.Remote;

import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Personne;


@Remote
public interface ServiceVerificationData {
	public ArrayList<Personne> trouverCompteEmail(String email);
	public ArrayList<Personne> trouverCompteLogin(String email);
	public Entreprise verificationEntreprise(String nom, String secteur);
}
