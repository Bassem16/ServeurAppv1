package fr.dauphine.bank.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Information;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;
import fr.dauphine.bank.web.ConnexionDataBase;

@Stateless
public class ServiceInvestisseurBean implements ServiceInvestisseur {

	private static final Logger LOG = Logger
			.getLogger(ServiceInvestisseurBean.class.getName());

	@PersistenceUnit
	private static EntityManagerFactory emf = ConnexionDataBase.getConnexion();

	@Override
	public void supprimerOffre(Offre offre) {

		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = null;
			et = em.getTransaction();
			et.begin();
			Query query = em
					.createQuery("DELETE FROM LierOffreTitre lot WHERE lot.id.idOffre LIKE:personneID");
			query.setParameter("personneID", offre.getIdOffre());
			query.executeUpdate();
			query = em
					.createQuery("DELETE FROM Offre o WHERE o.idOffre LIKE:personneID");
			query.setParameter("personneID", offre.getIdOffre());
			query.executeUpdate();
			et.commit();
			em.close();
		} catch (Exception e) {
			LOG.logf(Level.ERROR,
					"ServiceInvestisseurBean : Fonction SupprimerOffre : "
							+ e.getClass() + " Cause : " + e.getCause(),e);
		}

	}

	@Override
	public void miseAJourTitre(Titre titre) {

		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = null;
			et = em.getTransaction();
			et.begin();
			em.refresh(em.contains(titre) ? titre : em.merge(titre));
			et.commit();
			em.close();
		} catch (Exception e) {

			LOG.logf(Level.ERROR,
					"ServiceInvestisseurBean : Fonction miseAJourTitre : "
							+ e.getClass() + " Cause : " + e.getCause(),e);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Titre> recupererTitre(boolean entrepriseChek, boolean typeChek,
			boolean userCheck, String entrepriseNom, String nomType,
			String userNom) {
		List<Titre> selectedTitre = new ArrayList<Titre>();
		if (entrepriseChek && typeChek && !userCheck) {
			try {
				EntityManager em = emf.createEntityManager();
				Query query = em
						.createQuery("SELECT t FROM Entreprise e, Titre t WHERE t.entreprise.nomEntreprise LIKE:test1 AND t.typeTitre LIKE:test2 AND t.etatTitre=1 GROUP BY t.idTitre");
				query.setParameter("test1", entrepriseNom);
				query.setParameter("test2", nomType);

				selectedTitre = (ArrayList<Titre>) query.getResultList();
				em.close();
				return selectedTitre;

			} catch (Exception e) {
				LOG.logf(Level.ERROR,
						"ServiceInvestisseurBean : Fonction recupererTitre : Premier IF "
								+ e.getClass() + " Cause : " + e.getCause(),e);
			}
		} else if (!entrepriseChek && typeChek && !userCheck) {
			try {
				EntityManager em = emf.createEntityManager();
				Query query = em
						.createQuery("SELECT t FROM Titre t WHERE t.typeTitre LIKE:test AND t.etatTitre=1");

				query.setParameter("test", nomType);

				selectedTitre = (ArrayList<Titre>) query.getResultList();
				em.close();
				return selectedTitre;

			} catch (Exception e) {
				LOG.logf(Level.ERROR,
						"ServiceInvestisseurBean : Fonction recupererTitre : Second IF "
								+ e.getClass() + " Cause : " + e.getCause(),e);
			}

		} else if (entrepriseChek && !typeChek && !userCheck) {
			try {
				EntityManager em = emf.createEntityManager();
				Query query = em
						.createQuery("SELECT t FROM Titre t, Entreprise e WHERE t.entreprise.nomEntreprise LIKE:test AND t.etatTitre=1 GROUP BY t.idTitre");
				query.setParameter("test", entrepriseNom);

				selectedTitre = (ArrayList<Titre>) query.getResultList();
				em.close();
				return selectedTitre;

			} catch (Exception e) {
				LOG.logf(Level.ERROR,
						"ServiceInvestisseurBean : Fonction recupererTitre : Troisiene IF "
								+ e.getClass() + " Cause : " + e.getCause(),e);
			}

		} else if (entrepriseChek && typeChek && userCheck) {
			try {
				EntityManager em = emf.createEntityManager();
				Query query = em
						.createQuery("SELECT t FROM Titre t WHERE t.entreprise.nomEntreprise LIKE:test1 AND t.typeTitre LIKE:test2 AND t.etatTitre=1 AND t.personne.login LIKE:test3 GROUP BY t.idTitre");
				query.setParameter("test1", entrepriseNom);
				query.setParameter("test2", nomType);
				query.setParameter("test3", userNom);

				selectedTitre = (ArrayList<Titre>) query.getResultList();
				em.close();
				return selectedTitre;

			} catch (Exception e) {
				LOG.logf(Level.ERROR,
						"ServiceInvestisseurBean : Fonction recupererTitre : Quatrieme IF "
								+ e.getClass() + " Cause : " + e.getCause(),e);
			}
		} else if (!entrepriseChek && typeChek && userCheck) {
			try {
				EntityManager em = emf.createEntityManager();
				Query query = em
						.createQuery("SELECT t FROM Titre t WHERE t.typeTitre LIKE:test AND t.etatTitre=1 AND t.personne.login LIKE:test3");

				query.setParameter("test", nomType);
				query.setParameter("test3", userNom);

				selectedTitre = (ArrayList<Titre>) query.getResultList();
				em.close();
				return selectedTitre;

			} catch (Exception e) {
				LOG.logf(Level.ERROR,
						"ServiceInvestisseurBean : Fonction recupererTitre : Cinquieme IF "
								+ e.getClass() + " Cause : " + e.getCause(),e);
			}

		} else if (entrepriseChek && !typeChek && userCheck) {
			try {
				EntityManager em = emf.createEntityManager();
				Query query = em
						.createQuery("SELECT t FROM Titre t, Entreprise e WHERE t.entreprise.nomEntreprise LIKE:test AND t.etatTitre=1 AND t.personne.login LIKE:test3 GROUP BY t.idTitre");
				query.setParameter("test", entrepriseNom);
				query.setParameter("test3", userNom);

				selectedTitre = (ArrayList<Titre>) query.getResultList();
				em.close();
				return selectedTitre;

			} catch (Exception e) {
				LOG.logf(Level.ERROR,
						"ServiceInvestisseurBean : Fonction recupererTitre : Sixieme IF "
								+ e.getClass() + " Cause : " + e.getCause(),e);
			}

		} else if (!entrepriseChek && !typeChek && userCheck) {
			try {
				EntityManager em = emf.createEntityManager();
				Query query = em
						.createQuery("SELECT t FROM Titre t WHERE t.etatTitre=1 AND t.personne.login LIKE:test3 GROUP BY t.idTitre");
				query.setParameter("test3", userNom);

				selectedTitre = (ArrayList<Titre>) query.getResultList();
				em.close();
				return selectedTitre;

			} catch (Exception e) {
				LOG.logf(Level.ERROR,
						"ServiceInvestisseurBean : Fonction recupererTitre : Septieme IF "
								+ e.getClass() + " Cause : " + e.getCause(),e);
			}
		} else {
			return selectedTitre;
		}
		return selectedTitre;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entreprise> recupererEntrepriseListAll() {
		List<Entreprise> selectedEntreprise = new ArrayList<Entreprise>();

		try {
			EntityManager em = emf.createEntityManager();
			Query query = em.createQuery("SELECT e FROM Entreprise e");

			selectedEntreprise = (ArrayList<Entreprise>) query.getResultList();
			em.close();
			return selectedEntreprise;

		} catch (Exception e) {
			LOG.logf(Level.ERROR,
					"ServiceInvestisseurBean : Fonction recupererEntrepriseListAll : Type "
							+ e.getClass() + " Cause : " + e.getCause(),e);
		}
		return selectedEntreprise;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Personne> recupererPersonneListAll() {
		List<Personne> selectedPersonne = new ArrayList<Personne>();

		try {
			EntityManager em = emf.createEntityManager();
			Query query = em
					.createQuery("SELECT p FROM Personne p WHERE p.typePersonne=1");
			selectedPersonne = (ArrayList<Personne>) query.getResultList();
			em.close();
			return selectedPersonne;

		} catch (Exception e) {
			LOG.logf(Level.ERROR,
					"ServiceInvestisseurBean : Fonction recupererEntrepriseListAll : Type "
							+ e.getClass() + " Cause : " + e.getCause(),e);
		}
		return selectedPersonne;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Information> recupererInformationEntreprise(
			Entreprise entreprise) {

		List<Information> selectedInformation = new ArrayList<Information>();

		try {
			EntityManager em = emf.createEntityManager();
			Query query = em
					.createQuery("SELECT i FROM Information i WHERE i.entreprise.nomEntreprise LIKE:entrepriseId");
			query.setParameter("entrepriseId", entreprise.getNomEntreprise());
			selectedInformation = (ArrayList<Information>) query
					.getResultList();
			em.close();
			return selectedInformation;

		} catch (Exception e) {
			LOG.logf(Level.ERROR,
					"ServiceInvestisseurBean : Fonction recupererInformationEntreprise : Type "
							+ e.getClass() + " Cause : " + e.getCause(),e);
		}
		return selectedInformation;
	}

}
