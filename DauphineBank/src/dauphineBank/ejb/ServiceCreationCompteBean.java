package dauphineBank.ejb;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import dauphineBank.beans.Personne;
import dauphineBank.beans.TypePersonne;

@Stateless
public class ServiceCreationCompteBean implements ServiceCreationCompte {

	@PersistenceUnit
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("DauphineBank");

	@SuppressWarnings("unchecked")
	public ArrayList<Personne> trouverCompteEmail(String email) {
		ArrayList<Personne> Comptes = null;
		try {

			EntityManager em = emf.createEntityManager();
			EntityTransaction et = null;
			et = em.getTransaction();
			et.begin();
			// em.find(Personne.class, 5);
			Query q = em
					.createQuery("SELECT p FROM Personne p WHERE p.email LIKE:email");
			q.setParameter("email", email);
			Comptes = (ArrayList<Personne>) q.getResultList();
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
			EntityTransaction et = null;
			et = em.getTransaction();
			et.begin();
			Query q = em
					.createQuery("SELECT p FROM Personne p WHERE p.login LIKE:loginTest");
			q.setParameter("loginTest", login);
			Comptes = (ArrayList<Personne>) q.getResultList();
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		} finally {
		}
		return Comptes;
	}

	public void CreationComptes(Personne personne) {
		try {

			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("DauphineBank");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = null;
			et = em.getTransaction();
			et.begin();
			personne.setTypePersonne(em.find(TypePersonne.class, 0));
			personne.getTypePersonne().getPersonnes().add(personne);
			em.persist(personne);
			et.commit();
			System.out.println("Ecriture en base du compte "
					+ personne.getEmail());
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		} finally {
		}
	}
}
