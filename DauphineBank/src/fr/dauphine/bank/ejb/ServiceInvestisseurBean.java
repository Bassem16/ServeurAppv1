package fr.dauphine.bank.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
//import javax.persistence.Query;

//import fr.dauphine.bank.entities.Offre;

@Stateless
public class ServiceInvestisseurBean implements ServiceInvestisseur {


	@PersistenceUnit
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("DauphineBank");
	
	
	/*public ArrayList<Offre> historiqueOffre(String login) {
		ArrayList<Offre> Offres = null;
		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = null;
			et = em.getTransaction();
			et.begin();
			Query query = em
					.createQuery("SELECT offres FROM Personne p WHERE p.login LIKE:loginTest");
			query.setParameter("loginTest", login);
			Offres = (ArrayList<Offre>) query.getSingleResult();
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		} finally {
		}
		return Offres;
	}*/
	

}
