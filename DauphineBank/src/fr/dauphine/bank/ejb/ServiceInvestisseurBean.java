package fr.dauphine.bank.ejb;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
//import javax.persistence.Query;

import javax.persistence.Query;

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
			Query query = em
			.createQuery("DELETE FROM Offre o WHERE o.idOffre LIKE:offreid");
			 query.setParameter("offreid", offre.getIdOffre());
			 query.executeUpdate();
			
			//em.remove(o);
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
			em.refresh(titre);
			et.commit();
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		} finally {
		}

	}

	@Override
	public ArrayList<Offre> recupererOffres(Personne personne) {
//		ArrayList<Offre> offres = null;
//		try {
//			EntityManager em = emf.createEntityManager();
//			EntityTransaction et = null;
//			et = em.getTransaction();
//			et.begin();
//			Query query = em
//					.createQuery("SELECT Offre o FROM Personne p WHERE p.titres. LIKE:personneID");
//			query.setParameter("personneID", personne.getIdPersonne());
//
//			try {
//				offres = (ArrayList<Offre>) query.getResultList();
//			} catch (NoResultException nre) {
//				offres = new ArrayList<Offre>();
//
//			}
//
//			em.close();
//		} catch (Exception e) {
//			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
//		} finally {
//		}

		return null;

	}

}
