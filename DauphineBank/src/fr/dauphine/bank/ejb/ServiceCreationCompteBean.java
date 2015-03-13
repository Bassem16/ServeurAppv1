package fr.dauphine.bank.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.TypePersonne;

@Stateless
public class ServiceCreationCompteBean implements ServiceCreationCompte {

	@PersistenceUnit
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("DauphineBank");

	public void CreationComptes(Personne personne) {
		try {

			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("DauphineBank");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = null;
			et = em.getTransaction();
			et.begin();
			personne.setTypePersonne(em.find(TypePersonne.class, 1));
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
