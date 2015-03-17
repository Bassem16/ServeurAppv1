package fr.dauphine.bank.beanstests;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.dauphine.bank.entities.Information;
import fr.dauphine.bank.entities.LierOffreTitre;
import fr.dauphine.bank.entities.LierOffreTitrePK;

public class LierOffreTitreTest {

	@Test
	public void testLierOffreTitre() {
		LierOffreTitre I = new LierOffreTitre();
		assertNotNull(I);
	}

	@Test
	public void testGetId() {
		LierOffreTitre I = new LierOffreTitre();
		LierOffreTitrePK id = new LierOffreTitrePK();
		I.setId(id);
		
		assertEquals(id, I.getId());
	}

	@Test
	public void testSetId() {
		LierOffreTitre I = new LierOffreTitre();
		LierOffreTitrePK id = new LierOffreTitrePK();
		I.setId(id);
		
		assertEquals(id, I.getId());
	}

}
