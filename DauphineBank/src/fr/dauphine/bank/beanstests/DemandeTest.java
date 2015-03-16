package fr.dauphine.bank.beanstests;

// Rajout pour Test optimale 
import java.util.Calendar;
import java.util.Date;

import org.hamcrest.core.AllOf;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsInstanceOf;
import org.hamcrest.core.IsNot;
import org.junit.Assert;
// Fin Rajout




import static org.junit.Assert.*;

import org.junit.Test;

import fr.dauphine.bank.entities.Demande;
import fr.dauphine.bank.entities.Information;
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
	public void testGetDatedDemande() {
	Demande D = new Demande();	
	
	Calendar cal = Calendar.getInstance();
	cal.set(1991, 02, 19);
	Date dateTest = cal.getTime();
	D.setDateDemande(dateTest);
	
	assertEquals(dateTest ,D.getDateDemande());
	}
	
	@Test
	public void testSetDatedDemande() {
	Demande D = new Demande();	
	
	Calendar cal = Calendar.getInstance();
	cal.set(1991, 02, 19);
	Date dateTest = cal.getTime();
	D.setDateDemande(dateTest);
	
	assertEquals(dateTest ,D.getDateDemande());
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
		d.setStatutDemande("A traiter");
	    Assert.assertThat("A traiter", IsEqual.equalTo(d.getStatutDemande()));
	}

	@Test
	public void testSetStatutDemande() {
		Demande d=new Demande();
		d.setStatutDemande("A traiter");
	    Assert.assertThat("A traiter", IsEqual.equalTo(d.getStatutDemande()));
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
	
	@Test
	public void testDateIdDemande() {
		Demande d=new Demande();
		Date date = new Date();
		d.setDateDemande(date);
		assertEquals(date,d.getDateDemande());
	}

	@Test
	public void testDateDemande() {
		Demande d=new Demande();
		Date date = new Date();
		d.setDateDemande(date);
		assertEquals(date,d.getDateDemande());
	}

}
