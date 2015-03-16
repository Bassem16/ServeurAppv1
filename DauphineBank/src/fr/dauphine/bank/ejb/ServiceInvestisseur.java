package fr.dauphine.bank.ejb;

//import java.util.ArrayList;

import java.util.ArrayList;

import javax.ejb.Remote;

import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;

//import fr.dauphine.bank.entities.Offre;

@Remote
public interface ServiceInvestisseur {
	public void miseAJourTitre(Titre titre);
	public void supprimerOffre(Offre offre);
	public ArrayList<Offre> recupererOffres(Personne personne);
	public ArrayList<Titre> recupererTitre(boolean entrepriseChek, boolean typeChek,boolean userCheck, String entrepriseNom, String typeNom, String userNom);
	public ArrayList<Entreprise> recupererEntrepriseListAll();
	public ArrayList<Personne> recupererPersonneListAll();
	

}
