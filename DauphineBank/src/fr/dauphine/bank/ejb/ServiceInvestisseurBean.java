package fr.dauphine.bank.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
//import javax.persistence.Query;


import fr.dauphine.bank.entities.Offre;
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
			// Query query = em
			// .createQuery("DELETE FROM LierOffreTitre l WHERE l.getIdOffre() LIKE:email");
			// query.setParameter("email", offre.getIdOffre());
			// query.executeUpdate();
			Offre o=em.getReference(Offre.class, offre.getIdOffre());
			em.remove(o);
			//em.refresh(o);
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
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		} finally {
		}

	}

	

}
