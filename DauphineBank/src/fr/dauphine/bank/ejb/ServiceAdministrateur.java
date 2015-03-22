package fr.dauphine.bank.ejb;


import java.util.List;

import javax.ejb.Remote;

import fr.dauphine.bank.entities.Demande;
import fr.dauphine.bank.entities.DemandeHistorique;
import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Personne;



@Remote
public interface ServiceAdministrateur {
	public List<Demande> listeDemandes();
	public List<DemandeHistorique> listeDemandesHistorique();
	public void valideDemandePersonne(Demande demande);
	public void supprimerDemande(Demande demande);
	public List<Entreprise> listeEntreprise();
	public List<Personne>listeMembresSociete();
	
}
