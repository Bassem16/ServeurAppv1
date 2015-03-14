package fr.dauphine.bank.beanstests;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.dauphine.bank.entities.Information;

public class InformationTest {

	@Test
	public void testInformation() {
		Information I = new Information();
		assertNotNull(I);
	}

	@Test
	public void testGetIdInformation() {
		Information I = new Information();	
		I.setIdInformation(0);
		assertEquals(0,I.getIdInformation());
	}

	@Test
	public void testSetIdInformation() {
		Information I = new Information();	
		I.setIdInformation(1);
		assertEquals(1,I.getIdInformation());
	}

	@Test
	public void testGetDateInformation() {
		Information I = new Information();	
		I.setDateInformation(0);
		assertEquals(0,I.getDateInformation());
	}

	@Test
	public void testSetDateInformation() {
		Information I = new Information();	
		I.setDateInformation(1);
		assertEquals(1,I.getDateInformation());
	}

	@Test
	public void testGetTypeInformation() {
		Information I = new Information();	
		I.setTypeInformation("TEST");
		assertEquals("TEST",I.getTypeInformation());
	}

	@Test
	public void testSetTypeInformation() {
		Information I = new Information();	
		I.setTypeInformation("TEST");
		assertEquals("TEST",I.getTypeInformation());
	}

	@Test
	public void testGetEntreprise() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEntreprise() {
		fail("Not yet implemented");
	}

}
