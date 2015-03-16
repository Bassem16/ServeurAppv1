package fr.dauphine.bank.beanstests;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import fr.dauphine.bank.entities.Demande;
import fr.dauphine.bank.entities.DemandeHistorique;
import fr.dauphine.bank.entities.Personne;

public class DemandeHistoriqueTest {

	@Test
	public void testDemandeHistorique() {
		DemandeHistorique d=new DemandeHistorique();
		assertNotNull(d);
	}

	@Test
	public void testGetIdDemandeHistorique() {
		DemandeHistorique d=new DemandeHistorique();
		d.setIdDemandeHistorique(1);
		assertEquals(1,d.getIdDemandeHistorique());
	}

	@Test
	public void testSetIdDemandeHistorique() {
		DemandeHistorique d=new DemandeHistorique();
		d.setIdDemandeHistorique(1);
		assertEquals(1,d.getIdDemandeHistorique());
	}

	@Test
	public void testGetDateDemandeHistorique() {
		DemandeHistorique D = new DemandeHistorique();	
		
		Calendar cal = Calendar.getInstance();
		cal.set(1991, 02, 19);
		Date dateTest = cal.getTime();
		D.setDateDemandeHistorique(dateTest);
		
		assertEquals(dateTest ,D.getDateDemandeHistorique());
	}

	@Test
	public void testSetDateDemandeHistorique() {
		DemandeHistorique D = new DemandeHistorique();	
		
		Calendar cal = Calendar.getInstance();
		cal.set(1991, 02, 19);
		Date dateTest = cal.getTime();
		D.setDateDemandeHistorique(dateTest);
		
		assertEquals(dateTest ,D.getDateDemandeHistorique());
	}

	@Test
	public void testGetDescriptifDemandeHistorique() {
		DemandeHistorique d=new DemandeHistorique();
		d.setDescriptifDemandeHistorique("TEST");
		assertEquals("TEST", d.getDescriptifDemandeHistorique());
	}

	@Test
	public void testSetDescriptifDemandeHistorique() {
		DemandeHistorique d=new DemandeHistorique();
		d.setDescriptifDemandeHistorique("TEST");
		assertEquals("TEST", d.getDescriptifDemandeHistorique());
	}

	@Test
	public void testGetStatutDemandeHistorique() {
		DemandeHistorique d=new DemandeHistorique();
		d.setStatutDemandeHistorique("A traiter");
	    Assert.assertThat("A traiter", IsEqual.equalTo(d.getStatutDemandeHistorique()));
	}

	@Test
	public void testSetStatutDemandeHistorique() {
		DemandeHistorique d=new DemandeHistorique();
		d.setStatutDemandeHistorique("A traiter");
	    Assert.assertThat("A traiter", IsEqual.equalTo(d.getStatutDemandeHistorique()));
	}

	@Test
	public void testGetPersonne() {
		DemandeHistorique d=new DemandeHistorique();
		// Création Personnne
		Personne P=new Personne();
		// Ajout Personne
		d.setPersonne(P);
		
		assertEquals(P, d.getPersonne());
	}

	@Test
	public void testSetPersonne() {
		DemandeHistorique d=new DemandeHistorique();
		// Création Personnne
		Personne P=new Personne();
		// Ajout Personne
		d.setPersonne(P);
		
		assertEquals(P, d.getPersonne());
	}

}
