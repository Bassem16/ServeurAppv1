package DauphineBank.beans.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dauphineBank.beans.Demande;

public class DemandeTest {

	@Test
	public void testDemande() {
		Demande d=new Demande();
		assertNotNull(d);
	}

	@Test
	public void testGetIdDemande() {
		Demande d=new Demande();
		d.setIdDemande(1);
		assertEquals(1,d.getIdDemande());
	}

	@Test
	public void testSetIdDemande() {
		Demande d=new Demande();
		d.setIdDemande(2);
		assertEquals(2,d.getIdDemande());
	}

	@Test
	public void testGetDescriptifDemande() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDescriptifDemande() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStatutDemande() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetStatutDemande() {
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
