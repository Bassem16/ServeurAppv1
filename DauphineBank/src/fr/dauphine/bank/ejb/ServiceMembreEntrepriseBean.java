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

import fr.dauphine.bank.entities.Information;
import fr.dauphine.bank.web.ConnexionDataBase;

@Stateless
public class ServiceMembreEntrepriseBean implements ServiceMembreEntreprise {

	private static final Logger LOG = Logger
			.getLogger(ServiceMembreEntrepriseBean.class.getName());
	
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
			LOG.logf(Level.ERROR,
					"ServiceMembreEntrepriseBean : Fonction listeInformations : "
							+ e.getClass() + " Cause : " + e.getCause(),e);
		}
		return informations;
	}

}
