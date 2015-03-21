package fr.dauphine.bank.beanstests;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.dauphine.bank.entities.LierOffreTitrePK;

public class LierOffreTitrePKTest {

	@Test
	public void testHashCode() {
		LierOffreTitrePK l = new LierOffreTitrePK();
		l.setIdOffre(1);
		l.setIdTitre(1);
		
		assertEquals(16369, l.hashCode());
	}

	@Test
	public void testLierOffreTitrePK() {
		LierOffreTitrePK l = new LierOffreTitrePK();
		assertNotNull(l);
	}

	@Test
	public void testGetIdOffre() {
		LierOffreTitrePK l = new LierOffreTitrePK();
		l.setIdOffre(1);
		
		assertEquals(1, l.getIdOffre());
	}

	@Test
	public void testSetIdOffre() {
		LierOffreTitrePK l = new LierOffreTitrePK();
		l.setIdOffre(1);
		
		assertEquals(1, l.getIdOffre());
	}

	@Test
	public void testGetIdTitre() {
		LierOffreTitrePK l = new LierOffreTitrePK();
		l.setIdTitre(1);
		
		assertEquals(1, l.getIdTitre());
	}

	@Test
	public void testSetIdTitre() {
		LierOffreTitrePK l = new LierOffreTitrePK();
		l.setIdTitre(1);
		
		assertEquals(1, l.getIdTitre());
	}

	@Test
	public void testEqualsObject() {
		LierOffreTitrePK l = new LierOffreTitrePK();
		LierOffreTitrePK l2 = new LierOffreTitrePK();
		
		assertEquals(true, l.equals(l2));
	}

}
