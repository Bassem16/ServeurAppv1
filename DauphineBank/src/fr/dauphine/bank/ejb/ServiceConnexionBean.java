package fr.dauphine.bank.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.web.ConnexionDataBase;

@Stateless
public class ServiceConnexionBean implements ServiceConnexion {

	private static final Logger LOG = Logger
			.getLogger(ServiceConnexionBean.class.getName());
	
	
	@PersistenceUnit
	private static EntityManagerFactory emf = ConnexionDataBase.getConnexion();

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
			LOG.logf(Level.ERROR,
					"ServiceConnexionBean : Fonction verificationPersonne : "
							+ e.getClass() + " Cause : " + e.getCause(),e);
		} 
		return personne;
	}

}
