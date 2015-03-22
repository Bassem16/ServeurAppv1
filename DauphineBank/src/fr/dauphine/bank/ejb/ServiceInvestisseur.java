package fr.dauphine.bank.ejb;

import java.util.List;

import javax.ejb.Remote;

import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Information;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;



@Remote
public interface ServiceInvestisseur {
	public void miseAJourTitre(Titre titre);
	public void supprimerOffre(Offre offre);
	public List<Titre> recupererTitre(boolean entrepriseChek, boolean typeChek,boolean userCheck, String entrepriseNom, String typeNom, String userNom);
	public List<Entreprise> recupererEntrepriseListAll();
	public List<Personne> recupererPersonneListAll();	
	public List<Information> recupererInformationEntreprise(Entreprise entreprise);

}
