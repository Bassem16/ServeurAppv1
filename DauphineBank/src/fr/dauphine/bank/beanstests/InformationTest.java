package fr.dauphine.bank.beanstests;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.dauphine.bank.entities.Demande;
import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Information;
import fr.dauphine.bank.entities.Personne;

import java.util.Calendar;
import java.util.Date;

import javax.sql.rowset.spi.SyncFactory;


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
		
		Calendar cal = Calendar.getInstance();
		cal.set(1991, 02, 19);
		Date dateTest = cal.getTime();
		I.setDateInformation(dateTest);
		
		assertEquals(dateTest ,I.getDateInformation());
	}

	@Test
	public void testSetDateInformation() {
		Information I = new Information();	
		
		Calendar cal = Calendar.getInstance();
		cal.set(1991, 02, 19);
		Date dateTest = cal.getTime();
		I.setDateInformation(dateTest);
		
		assertEquals(dateTest ,I.getDateInformation());
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
		Information I =new Information();
		// Création Entreprise
		Entreprise E =new Entreprise();
		// Ajout Entreprise
		I.setEntreprise(E);
		
		assertEquals(E, I.getEntreprise());
	}

	@Test
	public void testSetEntreprise() {
		Information I =new Information();
		// Création Entreprise
		Entreprise E =new Entreprise();
		// Ajout Entreprise
		I.setEntreprise(E);
		
		assertEquals(E, I.getEntreprise());
	}

}
