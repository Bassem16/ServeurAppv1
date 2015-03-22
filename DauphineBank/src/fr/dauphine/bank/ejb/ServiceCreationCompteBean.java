package fr.dauphine.bank.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.TypePersonne;
import fr.dauphine.bank.web.ConnexionDataBase;

@Stateless
public class ServiceCreationCompteBean implements ServiceCreationCompte {

	private static final Logger LOG = Logger
			.getLogger(ServiceCreationCompteBean.class.getName());
	
	@PersistenceUnit
	private static EntityManagerFactory emf = ConnexionDataBase.getConnexion();

	@Override
	public void CreationComptes(Personne personne) {
		try {

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
			LOG.logf(Level.ERROR,
					"ServiceCreationCompteBean : Fonction CreationComptes : "
							+ e.getClass() + " Cause : " + e.getCause(),e);
		}
	}
}
