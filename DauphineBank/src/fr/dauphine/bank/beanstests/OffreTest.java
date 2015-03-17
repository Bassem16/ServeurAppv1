package fr.dauphine.bank.beanstests;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Information;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.Personne;

public class OffreTest {

	@Test
	public void testOffre() {
		Offre O = new Offre();
		assertNotNull(O);
	}

	@Test
	public void testGetIdOffre() {
		Offre O = new Offre();	
		O.setIdOffre(0);
		assertEquals(0,O.getIdOffre());
	}

	@Test
	public void testSetIdOffre() {
		Offre O = new Offre();	
		O.setIdOffre(1);
		assertEquals(1,O.getIdOffre());
	}

	@Test
	public void testGetPrixOffre() {
		Offre O = new Offre();	
		O.setPrixOffre(0);
		assertEquals(0, O.getPrixOffre(), 0);
	}

	@Test
	public void testSetPrixOffre() {
		Offre O = new Offre();	
		O.setPrixOffre(1);
		assertEquals(1,O.getPrixOffre(), 0);
	}

	@Test
	public void testGetQuantiteOffre() {
		Offre O = new Offre();	
		O.setQuantiteOffre(0);
		assertEquals(0, O.getQuantiteOffre(), 0);
	}

	@Test
	public void testSetQuantiteOffre() {
		Offre O = new Offre();	
		O.setQuantiteOffre(0);
		assertEquals(0, O.getQuantiteOffre(), 0);
	}

	@Test
	public void testGetTypeOffre() {
		Offre O = new Offre();	
		O.setTypeOffre("TEST");
		assertEquals("TEST",O.getTypeOffre());
	}

	@Test
	public void testSetTypeOffre() {
		Offre O = new Offre();	
		O.setTypeOffre("TEST");
		assertEquals("TEST",O.getTypeOffre());
	}

	@Test
	public void testGetEntreprise() {
		Offre O = new Offre();
		// Création Entreprise
		Entreprise E =new Entreprise();
		// Ajout Entreprise
		O.setEntreprise(E);
		
		assertEquals(E, O.getEntreprise());
	}

	@Test
	public void testSetEntreprise() {
		Offre O = new Offre();
		// Création Entreprise
		Entreprise E =new Entreprise();
		// Ajout Entreprise
		O.setEntreprise(E);
		
		assertEquals(E, O.getEntreprise());
	}

	@Test
	public void testGetPersonneEmetteur() {
		Offre O = new Offre();
		// Création Personnne
		Personne P=new Personne();

		// Ajout Personne
		 O.setPersonneEmetteur(P);
		 assertEquals(P, O.getPersonneEmetteur());
	}

	@Test
	public void testSetPersonneEmetteur() {
		Offre O = new Offre();
		// Création Personnne
		Personne P=new Personne();

		// Ajout Personne
		 O.setPersonneEmetteur(P);
		 assertEquals(P, O.getPersonneEmetteur());
	}
		 
	@Test
	public void testGetPersonneReceveur() {
		Offre O = new Offre();
		// Création Personnne
		Personne P=new Personne();

		// Ajout Personne
		 O.setPersonneReceveur(P);
		 assertEquals(P, O.getPersonneReceveur());
	}

	@Test
	public void testSetPersonneReceveur() {
		Offre O = new Offre();
		// Création Personnne
		Personne P=new Personne();

		// Ajout Personne
		 O.setPersonneReceveur(P);
		 assertEquals(P, O.getPersonneReceveur());		 
	}

}
