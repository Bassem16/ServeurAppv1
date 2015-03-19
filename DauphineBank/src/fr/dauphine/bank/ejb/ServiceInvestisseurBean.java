package fr.dauphine.bank.ejb;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
//import javax.persistence.Query;

import javax.persistence.Query;

import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Information;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;
import fr.dauphine.bank.web.ConnexionDataBase;

@Stateless
public class ServiceInvestisseurBean implements ServiceInvestisseur {

	@PersistenceUnit
	private static EntityManagerFactory emf = ConnexionDataBase.getConnexion();

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
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		} finally {
		}

	}

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
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		} finally {
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Titre> recupererTitre(boolean entrepriseChek,
			boolean typeChek, boolean userCheck, String entrepriseNom,
			String nomType, String userNom) {
		ArrayList<Titre> selectedTitre = new ArrayList<Titre>();
		if (entrepriseChek == true && typeChek == true && userCheck == false) {
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
				System.out.println(e.getClass() + "  + " + e.getCause()
						+ "   + ");
			} finally {
			}
		} else if (entrepriseChek == false && typeChek == true
				&& userCheck == false) {
			try {
				EntityManager em = emf.createEntityManager();
				Query query = em
						.createQuery("SELECT t FROM Titre t WHERE t.typeTitre LIKE:test AND t.etatTitre=1");

				query.setParameter("test", nomType);

				selectedTitre = (ArrayList<Titre>) query.getResultList();
				em.close();
				return selectedTitre;

			} catch (Exception e) {
				System.out.println(e.getClass() + "  + " + e.getCause()
						+ "   + ");
			} finally {
			}

		} else if (entrepriseChek == true && typeChek == false
				&& userCheck == false) {
			try {
				EntityManager em = emf.createEntityManager();
				Query query = em
						.createQuery("SELECT t FROM Titre t, Entreprise e WHERE t.entreprise.nomEntreprise LIKE:test AND t.etatTitre=1 GROUP BY t.idTitre");
				query.setParameter("test", entrepriseNom);

				selectedTitre = (ArrayList<Titre>) query.getResultList();
				em.close();
				return selectedTitre;

			} catch (Exception e) {
				System.out.println(e.getClass() + "  + " + e.getCause()
						+ "   + ");
			} finally {
			}

		} else if (entrepriseChek == true && typeChek == true
				&& userCheck == true) {
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
				System.out.println(e.getClass() + "  + " + e.getCause()
						+ "   + ");
			} finally {
			}
		} else if (entrepriseChek == false && typeChek == true
				&& userCheck == true) {
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
				System.out.println(e.getClass() + "  + " + e.getCause()
						+ "   + ");
			} finally {
			}

		} else if (entrepriseChek == true && typeChek == false
				&& userCheck == true) {
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
				System.out.println(e.getClass() + "  + " + e.getCause()
						+ "   + ");
			} finally {
			}

		} else if (entrepriseChek == false && typeChek == false
				&& userCheck == true) {
			try {
				EntityManager em = emf.createEntityManager();
				Query query = em
						.createQuery("SELECT t FROM Titre t WHERE t.etatTitre=1 AND t.personne.login LIKE:test3 GROUP BY t.idTitre");
				query.setParameter("test3", userNom);

				selectedTitre = (ArrayList<Titre>) query.getResultList();
				em.close();
				return selectedTitre;

			} catch (Exception e) {
				System.out.println(e.getClass() + "  + " + e.getCause()
						+ "   + ");
			} finally {
			}
		} else {
			return selectedTitre;
		}
		return selectedTitre;

	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Entreprise> recupererEntrepriseListAll() {
		ArrayList<Entreprise> selectedEntreprise = new ArrayList<Entreprise>();

		try {
			EntityManager em = emf.createEntityManager();
			Query query = em.createQuery("SELECT e FROM Entreprise e");

			selectedEntreprise = (ArrayList<Entreprise>) query.getResultList();
			em.close();
			return selectedEntreprise;

		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		} finally {
		}
		return selectedEntreprise;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Personne> recupererPersonneListAll() {
		ArrayList<Personne> selectedPersonne = new ArrayList<Personne>();

		try {
			EntityManager em = emf.createEntityManager();
			Query query = em.createQuery("SELECT p FROM Personne p");

			selectedPersonne = (ArrayList<Personne>) query.getResultList();
			em.close();
			return selectedPersonne;

		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		} finally {
		}
		return selectedPersonne;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Information> recupererInformationEntreprise(
			Entreprise entreprise) {

		ArrayList<Information> selectedInformation = new ArrayList<Information>();

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
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		} finally {
		}
		return selectedInformation;
	}

}
