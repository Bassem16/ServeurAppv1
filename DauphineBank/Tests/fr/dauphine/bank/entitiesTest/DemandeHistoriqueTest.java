package fr.dauphine.bank.entitiesTest;

import static org.junit.Assert.*;

import java.util.Date;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import fr.dauphine.bank.entities.DemandeHistorique;
import fr.dauphine.bank.entities.Personne;

public class DemandeHistoriqueTest {

	public static final String TEST = "TEST";
	public static final String A_TRAITER = "A traiter";
	@Test
	public void testDemandeHistorique() {
		DemandeHistorique d =new DemandeHistorique();
		assertNotNull("L'istance est créé", d);
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
		DemandeHistorique d = new DemandeHistorique();	
		
		
		Date dateTest = new Date(System.currentTimeMillis());
		d.setDateDemandeHistorique(dateTest);
		
		assertEquals(dateTest ,d.getDateDemandeHistorique());
	}

	@Test
	public void testSetDateDemandeHistorique() {
		DemandeHistorique d = new DemandeHistorique();	
		
		
		Date dateTest = new Date(System.currentTimeMillis());
		d.setDateDemandeHistorique(dateTest);
		
		assertEquals(dateTest ,d.getDateDemandeHistorique());
	}

	@Test
	public void testGetDescriptifDemandeHistorique() {
		DemandeHistorique d=new DemandeHistorique();
		d.setDescriptifDemandeHistorique(TEST);
		assertEquals(TEST, d.getDescriptifDemandeHistorique());
	}

	@Test
	public void testSetDescriptifDemandeHistorique() {
		DemandeHistorique d=new DemandeHistorique();
		d.setDescriptifDemandeHistorique(TEST);
		assertEquals(TEST, d.getDescriptifDemandeHistorique());
	}

	@Test
	public void testGetStatutDemandeHistorique() {
		DemandeHistorique d=new DemandeHistorique();
		d.setStatutDemandeHistorique(A_TRAITER);
	    Assert.assertThat(A_TRAITER, IsEqual.equalTo(d.getStatutDemandeHistorique()));
	}

	@Test
	public void testSetStatutDemandeHistorique() {
		DemandeHistorique d=new DemandeHistorique();
		d.setStatutDemandeHistorique(A_TRAITER);
	    Assert.assertThat(A_TRAITER, IsEqual.equalTo(d.getStatutDemandeHistorique()));
	}

	@Test
	public void testGetPersonne() {
		DemandeHistorique d=new DemandeHistorique();
		// Création Personnne
		Personne p=new Personne();
		// Ajout Personne
		d.setPersonne(p);
		
		assertEquals(p, d.getPersonne());
	}

	@Test
	public void testSetPersonne() {
		DemandeHistorique d=new DemandeHistorique();
		// Création Personnne
		Personne p=new Personne();
		// Ajout Personne
		d.setPersonne(p);
		
		assertEquals(p, d.getPersonne());
	}

}
