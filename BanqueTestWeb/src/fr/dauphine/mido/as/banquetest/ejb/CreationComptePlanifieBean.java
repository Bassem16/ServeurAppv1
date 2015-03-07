package fr.dauphine.mido.as.banquetest.ejb;

import javax.annotation.Resource;
import javax.ejb.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import org.jboss.ejb3.annotation.Clustered;

import fr.dauphine.mido.as.banquetest.beans.Compte;

@Stateless
public class CreationComptePlanifieBean implements CreationComptePlanifie {
	private static ArrayList<Compte> listeComptesACreer = new ArrayList<Compte>();

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Schedule(hour = "12", minute = "15")
	public void executionCreationComptes() {
		try {

			Compte unCompte = null;
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("BanqueTestWeb");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = null;
			while (listeComptesACreer.size() > 0) {
				unCompte = (Compte) listeComptesACreer.get(0);
				listeComptesACreer.remove(0);
				et = em.getTransaction();
				et.begin();
				em.persist(unCompte);
				et.commit();
				System.out.println("Ecriture en base du compte "
						+ unCompte.getNocompte());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		} finally {
		}
	}

	@Override
	public void creationCompte(Compte compte) {
		listeComptesACreer.add(compte);
		System.out.println("Compte à créer (n° " + compte.getNocompte()
				+ ") ajouté à la liste à " + System.currentTimeMillis());

	}

}