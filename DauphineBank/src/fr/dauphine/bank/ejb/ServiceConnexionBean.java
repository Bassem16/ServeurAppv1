package fr.dauphine.bank.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import fr.dauphine.bank.entities.Personne;

@Stateless
public class ServiceConnexionBean implements ServiceConnexion {

	@PersistenceUnit
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("DauphineBank");

	@Override
	public Personne verificationPersonne(String login, String motDePasse) {
		Personne personne = null;
		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = null;
			et = em.getTransaction();
			et.begin();
			Query query = em
					.createQuery("SELECT p FROM Personne p WHERE p.login LIKE:loginTest  AND p.motDePasse LIKE:motDePasseTest");
			query.setParameter("loginTest", login);
			query.setParameter("motDePasseTest", motDePasse);
			try {
				personne = (Personne) query.getSingleResult();
			} catch (NoResultException nre) {

			}

			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		} finally {
		}

		return personne;
	}

}
