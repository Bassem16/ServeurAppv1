package fr.dauphine.bank.ejb;

import javax.ejb.Remote;

import fr.dauphine.bank.entities.OffreHistorique;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;

@Remote
public interface ServiceSauvegarde {
	public void sauvegardeCompte(Personne personne);
	public void sauvegardeOffreHistorique(OffreHistorique offreHistorique);
	public void sauvegardeTitre(Titre titre);
}
