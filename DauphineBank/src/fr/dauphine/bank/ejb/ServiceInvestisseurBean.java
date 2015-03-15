package fr.dauphine.bank.ejb;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
//import javax.persistence.Query;

import javax.persistence.Query;

import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;

//import fr.dauphine.bank.entities.Offre;

@Stateless
public class ServiceInvestisseurBean implements ServiceInvestisseur {

	@PersistenceUnit
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("DauphineBank");

	public void supprimerOffre(Offre offre) {

		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = null;
			et = em.getTransaction();
			et.begin();
			// Offre o = em.getReference(Offre.class, offre.getIdOffre());
			// em.remove(em.contains(offre) ? offre : em.merge(offre));
			// em.remove(em.contains(o) ? o : em.merge(o));
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

	@Override
	public ArrayList<Offre> recupererOffres(Personne personne) {
		// ArrayList<Offre> offres = null;
		// try {
		// EntityManager em = emf.createEntityManager();
		// EntityTransaction et = null;
		// et = em.getTransaction();
		// et.begin();
		// Query query = em
		// .createQuery("SELECT Offre o FROM Personne p WHERE p.titres. LIKE:personneID");
		// query.setParameter("personneID", personne.getIdPersonne());
		//
		// try {
		// offres = (ArrayList<Offre>) query.getResultList();
		// } catch (NoResultException nre) {
		// offres = new ArrayList<Offre>();
		//
		// }
		//
		// em.close();
		// } catch (Exception e) {
		// System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		// } finally {
		// }

		return null;

	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Titre> recupererTitre(boolean entrepriseChek,
			boolean typeChek, String entrepriseNom, String nomType) {
		ArrayList<Titre> selectedTitre = new ArrayList<Titre>();
		if (entrepriseChek == true && typeChek == true) {
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
		} else if (entrepriseChek == false && typeChek == true) {
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

		} else if (entrepriseChek == true && typeChek == false) {
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

		} else {
			return selectedTitre;
		}
		return selectedTitre;

	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Entreprise> recupererEntrepriseListAll(String entrepriseNom) {
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

}
