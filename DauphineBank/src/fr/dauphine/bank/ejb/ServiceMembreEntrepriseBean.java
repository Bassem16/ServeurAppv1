package fr.dauphine.bank.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import fr.dauphine.bank.entities.Information;
import fr.dauphine.bank.web.ConnexionDataBase;

@Stateless
public class ServiceMembreEntrepriseBean implements ServiceMembreEntreprise {

	@PersistenceUnit
	private EntityManagerFactory emf = ConnexionDataBase.getConnexion();

	@SuppressWarnings("unchecked")
	@Override
	public List<Information> listeInformations(int idEntreprise) {
		List<Information> informations = null;
		try {
			EntityManager em = emf.createEntityManager();
			Query query = em
					.createQuery("SELECT i FROM Information i WHERE i.entreprise.idEntreprise LIKE:id");
			query.setParameter("id", idEntreprise);
			informations = (ArrayList<Information>) query.getResultList();
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		}
		return informations;
	}

}
