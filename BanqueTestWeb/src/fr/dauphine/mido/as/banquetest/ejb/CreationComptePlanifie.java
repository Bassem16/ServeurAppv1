package fr.dauphine.mido.as.banquetest.ejb;

import javax.ejb.*;
import fr.dauphine.mido.as.banquetest.beans.Compte;

@Remote
public interface CreationComptePlanifie {
	public void creationCompte(Compte compte);
}