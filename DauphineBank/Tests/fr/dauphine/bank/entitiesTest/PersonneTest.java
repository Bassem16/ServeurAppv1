package fr.dauphine.bank.entitiesTest;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import fr.dauphine.bank.entities.Demande;
import fr.dauphine.bank.entities.DemandeHistorique;
import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.OffreHistorique;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;
import fr.dauphine.bank.entities.TypePersonne;

public class PersonneTest {

	public static final String MAIL = "test@test.com";
	public static final String TEST = "TEST";

	@Test
	public void testPersonne() {
		Personne p = new Personne();
		assertNotNull(p);
	}

	@Test
	public void testGetIdPersonne() {
		Personne p = new Personne();
		p.setIdPersonne(1);
		assertEquals(1, p.getIdPersonne());
	}

	@Test
	public void testSetIdPersonne() {
		Personne p = new Personne();
		p.setIdPersonne(1);
		assertEquals("Ok", 1, p.getIdPersonne());
	}

	@Test
	public void testGeSettValide() {
		Personne p = new Personne();
		p.setValide(1);
		assertEquals(1, p.getValide());
	}

	@Test
	public void testGetEmail() {
		Personne p = new Personne();
		p.setEmail(MAIL);
		assertEquals(MAIL, p.getEmail());
	}

	@Test
	public void testSetEmail() {
		Personne p = new Personne();
		p.setEmail(MAIL);
		assertEquals(MAIL, p.getEmail());
	}

	@Test
	public void testGetLogin() {
		Personne p = new Personne();
		p.setLogin(TEST);
		assertEquals(TEST, p.getLogin());
	}

	@Test
	public void testSetLogin() {
		Personne p = new Personne();
		p.setLogin(TEST);
		assertEquals(TEST, p.getLogin());
	}

	@Test
	public void testGetMotDePasse() {
		Personne p = new Personne();
		p.setMotDePasse(TEST);
		assertEquals(TEST, p.getMotDePasse());
	}

	@Test
	public void testSetMotDePasse() {
		Personne p = new Personne();
		p.setMotDePasse(TEST);
		assertEquals(TEST, p.getMotDePasse());
	}

	@Test
	public void testGetNomPersonne() {
		Personne p = new Personne();
		p.setNomPersonne(TEST);
		assertEquals(TEST, p.getNomPersonne());
	}

	@Test
	public void testSetNomPersonne() {
		Personne p = new Personne();
		p.setNomPersonne(TEST);
		assertEquals(TEST, p.getNomPersonne());
	}

	@Test
	public void testGetPrenomPersonne() {
		Personne p = new Personne();
		p.setPrenomPersonne(TEST);
		assertEquals(TEST, p.getPrenomPersonne());
	}

	@Test
	public void testSetPrenomPersonne() {
		Personne p = new Personne();
		p.setPrenomPersonne(TEST);
		assertEquals(TEST, p.getPrenomPersonne());
	}

	@Test
	public void testGetEntreprise() {
		Personne p = new Personne();
		// Création Entreprise
		Entreprise e = new Entreprise();
		// Ajout Entreprise
		p.setEntreprise(e);

		assertEquals(e, p.getEntreprise());
	}

	@Test
	public void testSetEntreprise() {
		Personne p = new Personne();
		// Création Entreprise
		Entreprise e = new Entreprise();
		// Ajout Entreprise
		p.setEntreprise(e);

		assertEquals(e, p.getEntreprise());
	}

	@Test
	public void testGetDemandes() {
		Personne p = new Personne();
		Set<Demande> seteO = new TreeSet<Demande>();

		// Ajout Demande
		p.setDemandes(seteO);
		Set<Demande> sete1 = p.getDemandes();

		assertEquals(seteO, sete1);
	}

	@Test
	public void testSetDemandes() {
		Personne p = new Personne();
		Set<Demande> seteO = new TreeSet<Demande>();

		// Ajout Demande
		p.setDemandes(seteO);
		Set<Demande> sete1 = p.getDemandes();

		assertEquals(seteO, sete1);
	}

	@Test
	public void testGetDemandeHistoriques() {
		Personne p = new Personne();
		Set<DemandeHistorique> seteD = new HashSet<DemandeHistorique>();

		// Ajout Demande
		p.setDemandeHistoriques(seteD);

		assertSame(seteD, p.getDemandeHistoriques());
	}
	
	@Test
	public void testGetOffreHistoriquesEmises() {
		Personne p = new Personne();
		Set<OffreHistorique> seteO = new HashSet<OffreHistorique>();

		// Ajout Demande
		p.setOffreHistoriquesEmises(seteO);

		assertSame(seteO, p.getOffreHistoriquesEmises());
	}
	
	@Test
	public void testGetOffreHistoriquesRecues() {
		Personne p = new Personne();
		Set<OffreHistorique> seteO = new HashSet<OffreHistorique>();

		// Ajout Demande
		p.setOffreHistoriquesRecues(seteO);

		assertSame(seteO, p.getOffreHistoriquesRecues());
	}

	@Test
	public void testGetTitres() {
		Personne p = new Personne();
		Set<Titre> seteO = new TreeSet<Titre>();

		// Ajout Titre
		p.setTitres(seteO);
		Set<Titre> sete1 = p.getTitres();

		assertEquals(seteO, sete1);
	}

	@Test
	public void testSetTitres() {
		Personne p = new Personne();
		Set<Titre> seteO = new TreeSet<Titre>();

		// Ajout Titre
		p.setTitres(seteO);
		Set<Titre> sete1 = p.getTitres();

		assertEquals(seteO, sete1);
	}

	@Test
	public void testGetOffresEmises() {
		Personne p = new Personne();
		Set<Offre> seteO = new TreeSet<Offre>();

		// Ajout Offre
		p.setOffresEmises(seteO);
		Set<Offre> sete1 = p.getOffresEmises();

		assertEquals(seteO, sete1);
	}

	@Test
	public void testSetOffresEmises() {
		Personne p = new Personne();
		Set<Offre> seteO = new TreeSet<Offre>();

		// Ajout Offre
		p.setOffresEmises(seteO);
		Set<Offre> sete1 = p.getOffresEmises();

		assertEquals(seteO, sete1);
	}

	@Test
	public void testGetOffresRecues() {
		Personne p = new Personne();
		Set<Offre> seteO = new TreeSet<Offre>();

		// Ajout Offre
		p.setOffresRecues(seteO);
		Set<Offre> sete1 = p.getOffresRecues();

		assertEquals(seteO, sete1);
	}

	@Test
	public void testSetOffresRecues() {
		Personne p = new Personne();
		Set<Offre> seteO = new TreeSet<Offre>();

		// Ajout Offre
		p.setOffresRecues(seteO);
		Set<Offre> sete1 = p.getOffresRecues();

		assertEquals(seteO, sete1);
	}

	@Test
	public void testGetTypePersonne() {
		Personne p = new Personne();
		TypePersonne test = new TypePersonne();
		p.setTypePersonne(test);
		assertEquals(test, p.getTypePersonne());
	}

	@Test
	public void testSetTypePersonne() {
		Personne p = new Personne();
		TypePersonne test = new TypePersonne();
		p.setTypePersonne(test);
		assertEquals(test, p.getTypePersonne());
	}
	
	@Test
	public void testGetSetSoldePersonne() {
		Personne p = new Personne();
		p.setSoldePersonne(1526.54);
		assertEquals(1526.54, p.getSoldePersonne(),0.0001);
	}
	
	@Test
	public void testGetTitresList() {
		Personne p = new Personne();
		Set<Titre> seteT = new HashSet<Titre>();

		Titre t = new Titre();
		seteT.add(t);
		// Ajout Titre
		p.setTitres(seteT);
		

		assertEquals(t, p.getTitresList().get(0));
		
	}

}
