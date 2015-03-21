package fr.dauphine.bank.ejb;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import fr.dauphine.bank.entities.DemandeHistorique;
import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.Information;
import fr.dauphine.bank.entities.OffreHistorique;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;
import fr.dauphine.bank.web.ConnexionDataBase;
import fr.dauphine.bank.entities.TypePersonne;

@Stateless
public class ServiceSauvegardeBean implements ServiceSauvegarde {

	@PersistenceUnit
	private EntityManagerFactory emf = ConnexionDataBase.getConnexion();

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
		}

	}

	@Override
	public void sauvegardeCompteEntreprise(Personne personne) {
		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = null;
			et = em.getTransaction();
			et.begin();
			personne.setTypePersonne(em.find(TypePersonne.class, 2));
			em.merge(personne);
			et.commit();
			System.out.println("Sauvegarde en base du compte "
					+ personne.getEntreprise().getNomEntreprise());
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		}
	}

	@Override
	public void sauvegardeOffreHistorique(OffreHistorique offreHistorique) {
		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = null;
			et = em.getTransaction();
			et.begin();
			em.merge(offreHistorique);
			et.commit();
			System.out.println("Sauvegarde en base de l'offre (historique) "
					+ offreHistorique.getIdOffreHistorique());
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		}
	}

	@Override
	public void sauvgarderEntreprise(Entreprise entreprise) {
		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = null;
			et = em.getTransaction();
			et.begin();
			em.merge(entreprise);
			et.commit();
			System.out.println("Sauvegarde en base de l'entreprise "
					+ entreprise.getIdEntreprise());
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
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
		}
	}

	@Override
	public void sauvgarderInformation(Information information) {
		try {

			EntityManager em = emf.createEntityManager();
			EntityTransaction et = null;
			et = em.getTransaction();
			et.begin();
			information
					.setDateInformation(new Date(System.currentTimeMillis()));
			em.merge(information);
			et.commit();
			System.out.println("Mise à jour du titre:" + "  / "
					+ information.getIdInformation());
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		}
	}

	@Override
	public void sauvgarderDemandeHistorique(DemandeHistorique demandeHistorique) {
		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = null;
			et = em.getTransaction();
			et.begin();
			em.persist(demandeHistorique);
			et.commit();
			System.out.println("Sauvegarde en base de l'offre (historique) "
					+ demandeHistorique.getIdDemandeHistorique());
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		}
	}

	@Override
	public void sauvgarderOffre(Offre offre) {
		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = null;
			et = em.getTransaction();
			et.begin();
			em.merge(offre);
			et.commit();
			System.out.println("Sauvegarde en base de l'offre "
					+ offre.getIdOffre());
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		}
	}

}
