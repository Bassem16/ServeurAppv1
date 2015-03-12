package fr.dauphine.bank.ejb;

//import java.util.ArrayList;

import java.util.ArrayList;

import javax.ejb.Remote;

import fr.dauphine.bank.entities.Demande;

//import fr.dauphine.bank.entities.Offre;

@Remote
public interface ServiceAdministrateur {
	public ArrayList<Demande> listeDemandes(String login);
}
