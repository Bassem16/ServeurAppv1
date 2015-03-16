package fr.dauphine.bank.ejb;

import java.util.ArrayList;

import javax.ejb.Remote;

import fr.dauphine.bank.entities.Information;


@Remote
public interface ServiceMembreEntreprise {
	public ArrayList<Information> listeInformations(int idEntreprise);
}
