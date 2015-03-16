package fr.dauphine.bank.ejb;

//import java.util.ArrayList;

import java.util.ArrayList;

import javax.ejb.Remote;

import fr.dauphine.bank.entities.Demande;
import fr.dauphine.bank.entities.DemandeHistorique;
import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Personne;

//import fr.dauphine.bank.entities.Offre;

@Remote
public interface ServiceAdministrateur {
	public ArrayList<Demande> listeDemandes();
	public ArrayList<DemandeHistorique> listeDemandesHistorique();
	public void valideDemandePersonne(Demande demande);
	public void supprimerDemande(Demande demande);
	public ArrayList<Entreprise> listeEntreprise();
	public ArrayList<Personne>listeMembresSociete();
	
}
