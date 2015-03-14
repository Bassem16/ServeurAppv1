package fr.dauphine.bank.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import fr.dauphine.bank.entities.OffreHistorique;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;

@Stateless
public class ServiceSauvegardeBean implements ServiceSauvegarde {

	@PersistenceUnit
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("DauphineBank");

	@Override
	public void sauvegardeCompte(Personne personne) {
		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = null;
			et = em.getTransaction();
			et.begin();
			em.merge(personne);
			et.commit();
			System.out.println("Sauvegarde en base du compte "
					+ personne.getEmail());
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		} finally {
		}

	}

	@Override
	public void sauvegardeOffreHistorique(OffreHistorique offreHistorique) {
		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = null;
			et = em.getTransaction();
			et.begin();
			em.persist(offreHistorique);
			et.commit();
			System.out.println("Sauvegarde en base de l'offre (historique) "
					+ offreHistorique.getIdOffreHistorique());
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		} finally {
		}

	}

	@Override
	public void sauvegardeTitre(Titre titre) {
		try {

			EntityManager em = emf.createEntityManager();
			EntityTransaction et = null;
			et = em.getTransaction();
			et.begin();
			Titre t = em.getReference(Titre.class, titre.getIdTitre());
			em.merge(titre);
			et.commit();
			System.out.println("Mise à jour du titre:" + t.getEtatTitre()
					+ "  / " + titre.getIdTitre());
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		} finally {
		}

	}

}
