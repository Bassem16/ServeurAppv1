package fr.dauphine.bank.ejb;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import fr.dauphine.bank.entities.Offre;

@Stateless
public class ServiceInvestisseurBean implements ServiceInvestisseur {


	@PersistenceUnit
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("DauphineBank");
	
	@Override
	public ArrayList<Offre> historiqueOffre() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
