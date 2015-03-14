package fr.dauphine.bank.ejb;

//import java.util.ArrayList;

import javax.ejb.Remote;

import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.Titre;

//import fr.dauphine.bank.entities.Offre;

@Remote
public interface ServiceInvestisseur {
	public void miseAJourTitre(Titre titre);
	public void supprimerOffre(Offre offre);
	

}
