package fr.dauphine.bank.ejb;

import java.util.List;

import javax.ejb.Remote;

import fr.dauphine.bank.entities.Information;


@Remote
public interface ServiceMembreEntreprise {
	public List<Information> listeInformations(int idEntreprise);
}
