package fr.dauphine.bank.beanstests;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.Personne;

public class PersonneTest {

	@Test
	public void testPersonne() {
		Personne P = new Personne();
		assertNotNull(P);
	}

	@Test
	public void testGetIdPersonne() {
		Personne P = new Personne();	
		P.setIdPersonne(0);
		assertEquals(0,P.getIdPersonne());
	}

	@Test
	public void testSetIdPersonne() {
		Personne P = new Personne();	
		P.setIdPersonne(0);
		assertEquals(0,P.getIdPersonne());
	}

	@Test
	public void testGetEmail() {
		Personne P = new Personne();	
		P.setEmail("test@test.com");
		assertEquals("test@test.com",P.getEmail());
	}

	@Test
	public void testSetEmail() {
		Personne P = new Personne();	
		P.setEmail("test@test.com");
		assertEquals("test@test.com",P.getEmail());
	}

	@Test
	public void testGetLogin() {
		Personne P = new Personne();	
		P.setLogin("test");
		assertEquals("test",P.getLogin());
	}

	@Test
	public void testSetLogin() {
		Personne P = new Personne();	
		P.setLogin("test");
		assertEquals("tes",P.getLogin());
	}

	@Test
	public void testGetMotDePasse() {
		Personne P = new Personne();	
		P.setMotDePasse("testtest");
		assertEquals("testtest",P.getMotDePasse());
	}

	@Test
	public void testSetMotDePasse() {
		Personne P = new Personne();	
		P.setMotDePasse("testtest");
		assertEquals("testtest",P.getMotDePasse());
	}

	@Test
	public void testGetNomPersonne() {
		Personne P = new Personne();	
		P.setNomPersonne("testtest");
		assertEquals("testtest",P.getNomPersonne());
	}

	@Test
	public void testSetNomPersonne() {
		Personne P = new Personne();	
		P.setNomPersonne("testtest");
		assertEquals("testtest",P.getNomPersonne());
	}

	@Test
	public void testGetPrenomPersonne() {
		Personne P = new Personne();	
		P.setPrenomPersonne("testtest");
		assertEquals("testtest",P.getPrenomPersonne());
	}

	@Test
	public void testSetPrenomPersonne() {
		Personne P = new Personne();	
		P.setPrenomPersonne("testtest");
		assertEquals("testtest",P.getPrenomPersonne());
	}

	@Test
	public void testGetEntreprises() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEntreprises() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDemandes() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDemandes() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddDemande() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveDemande() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTitres() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTitres() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOffres() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetOffres() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddOffre() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveOffre() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTypePersonne() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTypePersonne() {
		fail("Not yet implemented");
	}

}
