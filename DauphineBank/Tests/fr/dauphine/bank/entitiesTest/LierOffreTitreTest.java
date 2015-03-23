package fr.dauphine.bank.entitiesTest;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.dauphine.bank.entities.LierOffreTitre;
import fr.dauphine.bank.entities.LierOffreTitrePK;

public class LierOffreTitreTest {

	@Test
	public void testLierOffreTitre() {
		LierOffreTitre i = new LierOffreTitre();
		assertNotNull(i);
	}

	@Test
	public void testGetId() {
		LierOffreTitre i = new LierOffreTitre();
		LierOffreTitrePK id = new LierOffreTitrePK();
		i.setId(id);
		
		assertEquals(id, i.getId());
	}

	@Test
	public void testSetId() {
		LierOffreTitre i = new LierOffreTitre();
		LierOffreTitrePK id = new LierOffreTitrePK();
		i.setId(id);
		
		assertEquals(id, i.getId());
	}

}
