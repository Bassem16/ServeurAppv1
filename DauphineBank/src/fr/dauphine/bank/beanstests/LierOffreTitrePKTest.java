package fr.dauphine.bank.beanstests;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.dauphine.bank.entities.LierOffreTitrePK;

public class LierOffreTitrePKTest {

	@Test
	public void testHashCode() {
		LierOffreTitrePK L = new LierOffreTitrePK();
		L.setIdOffre(1);
		L.setIdTitre(1);
		
		assertEquals(16369, L.hashCode());
	}

	@Test
	public void testLierOffreTitrePK() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIdOffre() {
		LierOffreTitrePK L = new LierOffreTitrePK();
		L.setIdOffre(1);
		
		assertEquals(1, L.getIdOffre());
	}

	@Test
	public void testSetIdOffre() {
		LierOffreTitrePK L = new LierOffreTitrePK();
		L.setIdOffre(1);
		
		assertEquals(1, L.getIdOffre());
	}

	@Test
	public void testGetIdTitre() {
		LierOffreTitrePK L = new LierOffreTitrePK();
		L.setIdTitre(1);
		
		assertEquals(1, L.getIdTitre());
	}

	@Test
	public void testSetIdTitre() {
		LierOffreTitrePK L = new LierOffreTitrePK();
		L.setIdTitre(1);
		
		assertEquals(1, L.getIdTitre());
	}

	@Test
	public void testEqualsObject() {
		LierOffreTitrePK L = new LierOffreTitrePK();
		LierOffreTitrePK L2 = new LierOffreTitrePK();
		
		assertEquals(true, L.equals(L2));
	}

}
