package fr.dauphine.bank.beanstests;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.dauphine.bank.entities.Information;
import fr.dauphine.bank.entities.Offre;

public class OffreTest {

	@Test
	public void testOffre() {
		Offre O = new Offre();
		assertNotNull(O);
	}

	@Test
	public void testGetIdOffre() {
		Offre O = new Offre();	
		O.setIdOffre(0);
		assertEquals(0,O.getIdOffre());
	}

	@Test
	public void testSetIdOffre() {
		Offre O = new Offre();	
		O.setIdOffre(1);
		assertEquals(1,O.getIdOffre());
	}

	@Test
	public void testGetPrixOffre() {
		Offre O = new Offre();	
		O.setPrixOffre(0);
		assertEquals(0,O.getPrixOffre());
	}

	@Test
	public void testSetPrixOffre() {
		Offre O = new Offre();	
		O.setPrixOffre(1);
		assertEquals(1,O.getPrixOffre());
	}

	@Test
	public void testGetQuantiteOffre() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetQuantiteOffre() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTypeOffre() {
		Offre O = new Offre();	
		O.setTypeOffre("TEST");
		assertEquals("TEST",O.getTypeOffre());
	}

	@Test
	public void testSetTypeOffre() {
		Offre O = new Offre();	
		O.setTypeOffre("TEST");
		assertEquals("TEST",O.getTypeOffre());
	}

	@Test
	public void testGetEntreprise() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEntreprise() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPersonne() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPersonne() {
		fail("Not yet implemented");
	}

}
