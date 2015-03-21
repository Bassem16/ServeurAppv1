package fr.dauphine.bank.beanstests;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.Personne;

public class OffreTest {

	@Test
	public void testOffre() {
		Offre o = new Offre();
		assertNotNull(o);
	}

	@Test
	public void testGetIdOffre() {
		Offre o = new Offre();	
		o.setIdOffre(0);
		assertEquals(0,o.getIdOffre());
	}

	@Test
	public void testSetIdOffre() {
		Offre o = new Offre();	
		o.setIdOffre(1);
		assertEquals(1,o.getIdOffre());
	}

	@Test
	public void testGetPrixOffre() {
		Offre o = new Offre();	
		o.setPrixOffre(0);
		assertEquals(0, o.getPrixOffre(), 0);
	}

	@Test
	public void testSetPrixOffre() {
		Offre o = new Offre();	
		o.setPrixOffre(1);
		assertEquals(1,o.getPrixOffre(), 0);
	}

	@Test
	public void testGetQuantiteOffre() {
		Offre o = new Offre();	
		o.setQuantiteOffre(0);
		assertEquals(0, o.getQuantiteOffre(), 0);
	}

	@Test
	public void testSetQuantiteOffre() {
		Offre o = new Offre();	
		o.setQuantiteOffre(0);
		assertEquals(0, o.getQuantiteOffre(), 0);
	}

	@Test
	public void testGetTypeOffre() {
		Offre o = new Offre();	
		o.setTypeOffre("TEST");
		assertEquals("TEST",o.getTypeOffre());
	}

	@Test
	public void testSetTypeOffre() {
		Offre o = new Offre();	
		o.setTypeOffre("TEST");
		assertEquals("TEST",o.getTypeOffre());
	}

	@Test
	public void testGetEntreprise() {
		Offre o = new Offre();
		// Création Entreprise
		Entreprise e =new Entreprise();
		// Ajout Entreprise
		o.setEntreprise(e);
		
		assertEquals(e, o.getEntreprise());
	}

	@Test
	public void testSetEntreprise() {
		Offre o = new Offre();
		// Création Entreprise
		Entreprise e =new Entreprise();
		// Ajout Entreprise
		o.setEntreprise(e);
		
		assertEquals(e, o.getEntreprise());
	}

	@Test
	public void testGetPersonneEmetteur() {
		Offre o = new Offre();
		// Création Personnne
		Personne p=new Personne();

		// Ajout Personne
		 o.setPersonneEmetteur(p);
		 assertEquals(p, o.getPersonneEmetteur());
	}

	@Test
	public void testSetPersonneEmetteur() {
		Offre o = new Offre();
		// Création Personnne
		Personne p=new Personne();

		// Ajout Personne
		 o.setPersonneEmetteur(p);
		 assertEquals(p, o.getPersonneEmetteur());
	}
		 
	@Test
	public void testGetPersonneReceveur() {
		Offre o = new Offre();
		// Création Personnne
		Personne p=new Personne();

		// Ajout Personne
		 o.setPersonneReceveur(p);
		 assertEquals(p, o.getPersonneReceveur());
	}

	@Test
	public void testSetPersonneReceveur() {
		Offre o = new Offre();
		// Création Personnne
		Personne p=new Personne();

		// Ajout Personne
		 o.setPersonneReceveur(p);
		 assertEquals(p, o.getPersonneReceveur());		 
	}

}
