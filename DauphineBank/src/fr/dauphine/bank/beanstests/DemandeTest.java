package fr.dauphine.bank.beanstests;

// Rajout pour Test optimale 
import org.hamcrest.core.AllOf;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsInstanceOf;
import org.hamcrest.core.IsNot;
import org.junit.Assert;
// Fin Rajout


import static org.junit.Assert.*;

import org.junit.Test;

import fr.dauphine.bank.entities.Demande;
import fr.dauphine.bank.entities.Personne;

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
		Demande d=new Demande();
		d.setDescriptifDemande("TEST");
		assertEquals("TEST", d.getDescriptifDemande());
	}

	@Test
	public void testSetDescriptifDemande() {
		Demande d=new Demande();
		d.setDescriptifDemande("TEST");
		assertEquals("TEST", d.getDescriptifDemande());
	}

	@Test
	public void testGetStatutDemande() {
		Demande d=new Demande();
		d.setStatutDemande(1);
		assertEquals(1, d.getStatutDemande());
	}

	@Test
	public void testSetStatutDemande() {
		Demande d=new Demande();
		d.setStatutDemande(2);
	    Assert.assertThat(2, IsEqual.equalTo(d.getStatutDemande()));
	}

	@Test
	public void testGetPersonne() {
		Demande d=new Demande();
		// Création Personnne
		Personne P=new Personne();
		// Ajout Personne
		d.setPersonne(P);
		
		assertEquals(P, d.getPersonne());
	}

	@Test
	public void testSetPersonne() {
		Demande d=new Demande();
		// Création Personnne
		Personne P=new Personne();
		// Ajout Personne
		d.setPersonne(P);
		
		assertEquals(P, d.getPersonne());
	}

}
