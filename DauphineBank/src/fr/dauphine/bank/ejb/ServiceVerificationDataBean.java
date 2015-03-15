package fr.dauphine.bank.ejb;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import fr.dauphine.bank.entities.Personne;

@Stateless
public class ServiceVerificationDataBean implements ServiceVerificationData {

	@PersistenceUnit
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("DauphineBank");

	@SuppressWarnings("unchecked")
	public ArrayList<Personne> trouverCompteEmail(String email) {
		ArrayList<Personne> Comptes = null;
		try {

			EntityManager em = emf.createEntityManager();

			Query query = em
					.createQuery("SELECT p FROM Personne p WHERE p.email LIKE:email");
			query.setParameter("email", email);
			Comptes = (ArrayList<Personne>) query.getResultList();
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		} finally {
		}
		return Comptes;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Personne> trouverCompteLogin(String login) {
		ArrayList<Personne> Comptes = null;
		try {

			EntityManager em = emf.createEntityManager();
			Query query = em
					.createQuery("SELECT p FROM Personne p WHERE p.login LIKE:loginTest");
			query.setParameter("loginTest", login);
			Comptes = (ArrayList<Personne>) query.getResultList();
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		} finally {
		}
		return Comptes;
	}

}
