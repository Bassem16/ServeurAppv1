package fr.dauphine.bank.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import fr.dauphine.bank.entities.Demande;
import fr.dauphine.bank.entities.DemandeHistorique;
import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.web.ConnexionDataBase;

@Stateless
public class ServiceAdministrateurBean implements ServiceAdministrateur {

	@PersistenceUnit
	private EntityManagerFactory emf = ConnexionDataBase.getConnexion();


	@SuppressWarnings("unchecked")
	@Override
	public List<Demande> listeDemandes() {

		List<Demande> demandes = null;
		try {
			EntityManager em = emf.createEntityManager();
			Query query = em.createQuery("SELECT d FROM Demande d");
			demandes = (ArrayList<Demande>) query.getResultList();
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		}
		return demandes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DemandeHistorique> listeDemandesHistorique() {

		List<DemandeHistorique> demandesH = null;
		try {
			EntityManager em = emf.createEntityManager();
			Query query = em.createQuery("SELECT d FROM DemandeHistorique d");
			demandesH = (ArrayList<DemandeHistorique>) query.getResultList();
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		}
		return demandesH;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entreprise> listeEntreprise() {

		List<Entreprise> entreprises = null;
		try {
			EntityManager em = emf.createEntityManager();
			Query query = em.createQuery("SELECT en FROM Entreprise en");
			entreprises = (ArrayList<Entreprise>) query.getResultList();
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		}
		return entreprises;
	}

	@Override
	public void valideDemandePersonne(Demande demande) {
		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = null;
			et = em.getTransaction();
			et.begin();
			em.merge(demande);
			em.merge(demande.getPersonne());
			et.commit();
			System.out.println("Modification en base du compte "
					+ demande.getIdDemande());
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		}
	}

	@Override
	public void supprimerDemande(Demande demande) {

		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = null;
			et = em.getTransaction();
			et.begin();
			Query query = em
					.createQuery("DELETE FROM Demande l WHERE l.idDemande LIKE:idd");
			query.setParameter("idd", demande.getIdDemande());
			query.executeUpdate();
			et.commit();
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		}
	}

	@Override
	public List<Personne> listeMembresSociete() {

		return new ArrayList<Personne>();
	}

}
