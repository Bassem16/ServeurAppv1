package fr.dauphine.mido.as.banquetest.ejb;

import javax.ejb.*;
import java.util.ArrayList;
import fr.dauphine.mido.as.banquetest.beans.Compte;
import fr.dauphine.mido.as.banquetest.beans.Operation;

@Remote
public interface ServicesCompte {
	public ArrayList<Operation> rechercheOperations(Compte compte);
}
