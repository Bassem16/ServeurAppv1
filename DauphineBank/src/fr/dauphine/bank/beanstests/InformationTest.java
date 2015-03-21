package fr.dauphine.bank.beanstests;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Information;
import java.util.Calendar;
import java.util.Date;


public class InformationTest {

	@Test
	public void testInformation() {
		Information i = new Information();
		assertNotNull(i);
	}

	@Test
	public void testGetIdInformation() {
		Information i = new Information();	
		i.setIdInformation(0);
		assertEquals(0,i.getIdInformation());
	}

	@Test
	public void testSetIdInformation() {
		Information i = new Information();	
		i.setIdInformation(1);
		assertEquals(1,i.getIdInformation());
	}

	@Test
	public void testGetDateInformation() {
		Information i = new Information();	
		
		Calendar cal = Calendar.getInstance();
		cal.set(1991, 02, 19);
		Date dateTest = cal.getTime();
		i.setDateInformation(dateTest);
		
		assertEquals(dateTest ,i.getDateInformation());
	}

	@Test
	public void testSetDateInformation() {
		Information i = new Information();	
		
		Calendar cal = Calendar.getInstance();
		cal.set(1991, 02, 19);
		Date dateTest = cal.getTime();
		i.setDateInformation(dateTest);
		
		assertEquals(dateTest ,i.getDateInformation());
	}

	@Test
	public void testGetTypeInformation() {
		Information i = new Information();	
		i.setTypeInformation("TEST");
		assertEquals("TEST",i.getTypeInformation());
	}

	@Test
	public void testSetTypeInformation() {
		Information i = new Information();	
		i.setTypeInformation("TEST");
		assertEquals("TEST",i.getTypeInformation());
	}

	@Test
	public void testGetEntreprise() {
		Information i =new Information();
		// Création Entreprise
		Entreprise E =new Entreprise();
		// Ajout Entreprise
		i.setEntreprise(E);
		
		assertEquals(E, i.getEntreprise());
	}

	@Test
	public void testSetEntreprise() {
		Information i =new Information();
		// Création Entreprise
		Entreprise e =new Entreprise();
		// Ajout Entreprise
		i.setEntreprise(e);
		
		assertEquals(e, i.getEntreprise());
	}

}
