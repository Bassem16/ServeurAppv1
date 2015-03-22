package fr.dauphine.bank.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.web.ConnexionDataBase;

@Stateless
public class ServiceVerificationDataBean implements ServiceVerificationData {

	private static final Logger LOG = Logger
			.getLogger(ServiceVerificationDataBean.class.getName());
	
	@PersistenceUnit
	private static EntityManagerFactory emf = ConnexionDataBase.getConnexion();

	@SuppressWarnings("unchecked")
	@Override
	public List<Personne> trouverCompteEmail(String email) {
		List<Personne> comptes = null;
		try {

			EntityManager em = emf.createEntityManager();
			Query query = em
					.createQuery("SELECT p FROM Personne p WHERE p.email LIKE:email");
			query.setParameter("email", email);
			comptes = (ArrayList<Personne>) query.getResultList();
			em.close();
		} catch (Exception e) {
			LOG.logf(Level.ERROR,
					"ServiceVerificationDataBean : Fonction trouverCompteEmail : "
							+ e.getClass() + " Cause : " + e.getCause(),e);
		}
		return comptes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Personne> trouverCompteLogin(String login) {
		List<Personne> comptes = null;
		try {

			EntityManager em = emf.createEntityManager();
			Query query = em
					.createQuery("SELECT p FROM Personne p WHERE p.login LIKE:loginTest");
			query.setParameter("loginTest", login);
			comptes = (ArrayList<Personne>) query.getResultList();
			em.close();
		} catch (Exception e) {
			LOG.logf(Level.ERROR,
					"ServiceVerificationDataBean : Fonction trouverCompteLogin : "
							+ e.getClass() + " Cause : " + e.getCause(),e);
		}
		return comptes;
	}

	@Override
	public Entreprise verificationEntreprise(String nom) {
		Entreprise en = new Entreprise();
		try {
			EntityManager em = emf.createEntityManager();
			Query query = em
					.createQuery("SELECT e FROM Entreprise e WHERE e.nomEntreprise LIKE:nomE");
			query.setParameter("nomE", nom);
			en = (Entreprise) query.getSingleResult();
			em.close();
		} catch (Exception e) {
			LOG.logf(Level.ERROR,
					"ServiceVerificationDataBean : Fonction verificationEntreprise : "
							+ e.getClass() + " Cause : " + e.getCause(),e);
		}
		return en;

	}

}
