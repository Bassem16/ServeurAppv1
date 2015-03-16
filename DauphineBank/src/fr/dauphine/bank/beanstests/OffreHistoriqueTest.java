package fr.dauphine.bank.beanstests;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import fr.dauphine.bank.entities.DemandeHistorique;
import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.OffreHistorique;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;

public class OffreHistoriqueTest {

	@Test
	public void testOffreHistorique() {
		OffreHistorique O = new OffreHistorique();
		assertNotNull(O);
	}

	@Test
	public void testGetIdOffreHistorique() {
		OffreHistorique O = new OffreHistorique();	
		O.setIdOffreHistorique(0);
		assertEquals(0,O.getIdOffreHistorique());
	}

	@Test
	public void testSetIdOffreHistorique() {
		OffreHistorique O = new OffreHistorique();	
		O.setIdOffreHistorique(1);
		assertEquals(1,O.getIdOffreHistorique());
	}

	@Test
	public void testGetDateOffreHistorique() {
		OffreHistorique D = new OffreHistorique();	
		
		Calendar cal = Calendar.getInstance();
		cal.set(1991, 02, 19);
		Date dateTest = cal.getTime();
		D.setDateOffreHistorique(dateTest);
		
		assertEquals(dateTest ,D.getDateOffreHistorique());
	}

	@Test
	public void testSetDateOffreHistorique() {
		OffreHistorique D = new OffreHistorique();	
		
		Calendar cal = Calendar.getInstance();
		cal.set(1991, 02, 19);
		Date dateTest = cal.getTime();
		D.setDateOffreHistorique(dateTest);
		
		assertEquals(dateTest ,D.getDateOffreHistorique());
	}

	@Test
	public void testGetPrixOffreHistorique() {
		OffreHistorique O = new OffreHistorique();	
		O.setPrixOffreHistorique(0);
		assertEquals(0, O.getPrixOffreHistorique(), 0);
	}

	@Test
	public void testSetPrixOffreHistorique() {
		OffreHistorique O = new OffreHistorique();	
		O.setPrixOffreHistorique(1);
		assertEquals(1,O.getPrixOffreHistorique(), 0);
	}

	@Test
	public void testGetQuantiteOffreHistorique() {
		OffreHistorique O = new OffreHistorique();	
		O.setQuantiteOffreHistorique(0);
		assertEquals(0, O.getQuantiteOffreHistorique(), 0);
	}

	@Test
	public void testSetQuantiteOffreHistorique() {
		OffreHistorique O = new OffreHistorique();	
		O.setQuantiteOffreHistorique(0);
		assertEquals(0, O.getQuantiteOffreHistorique(), 0);
	}

	@Test
	public void testGetStatut() {
		OffreHistorique O = new OffreHistorique();	
		O.setStatut("TEST");
		assertEquals("TEST",O.getStatut());
	}

	@Test
	public void testSetStatut() {
		OffreHistorique O = new OffreHistorique();	
		O.setStatut("TEST");
		assertEquals("TEST",O.getStatut());
	}

	@Test
	public void testGetTypeOffreHistorique() {
		OffreHistorique O = new OffreHistorique();	
		O.setTypeOffreHistorique("TEST");
		assertEquals("TEST",O.getTypeOffreHistorique());
	}

	@Test
	public void testSetTypeOffreHistorique() {
		OffreHistorique O = new OffreHistorique();	
		O.setTypeOffreHistorique("TEST");
		assertEquals("TEST",O.getTypeOffreHistorique());
	}

	@Test
	public void testGetEntreprise() {
		OffreHistorique O = new OffreHistorique();
		// Création Entreprise
		Entreprise E =new Entreprise();
		// Ajout Entreprise
		O.setEntreprise(E);
		
		assertEquals(E, O.getEntreprise());
	}

	@Test
	public void testSetEntreprise() {
		OffreHistorique O = new OffreHistorique();
		// Création Entreprise
		Entreprise E =new Entreprise();
		// Ajout Entreprise
		O.setEntreprise(E);
		
		assertEquals(E, O.getEntreprise());
	}

	@Test
	public void testGetPersonneEmetteur() {
		OffreHistorique O = new OffreHistorique();
		// Création Personnne
		Personne P=new Personne();

		// Ajout Personne
		 O.setPersonneEmetteur(P);
		 assertEquals(P, O.getPersonneEmetteur());
	}

	@Test
	public void testSetPersonneEmetteur() {
		OffreHistorique O = new OffreHistorique();
		// Création Personnne
		Personne P=new Personne();

		// Ajout Personne
		 O.setPersonneEmetteur(P);
		 assertEquals(P, O.getPersonneEmetteur());
	}
		 
	@Test
	public void testGetPersonneReceveur() {
		OffreHistorique O = new OffreHistorique();
		// Création Personnne
		Personne P=new Personne();

		// Ajout Personne
		 O.setPersonneReceveur(P);
		 assertEquals(P, O.getPersonneReceveur());
	}

	@Test
	public void testSetPersonneReceveur() {
		OffreHistorique O = new OffreHistorique();
		// Création Personnne
		Personne P=new Personne();

		// Ajout Personne
		 O.setPersonneReceveur(P);
		 assertEquals(P, O.getPersonneReceveur());		 
	}

	@Test
	public void testGetTitres() {
		Personne P =new Personne();
		// Création Titre
		Titre O=new Titre();
		Set<Titre> SeteO = new TreeSet<Titre>();
		
		// Ajout Titre
		 P.setTitres(SeteO);
		 Set <Titre> Sete1 = P.getTitres();
		 
		 assertEquals(SeteO, Sete1);
	}

	@Test
	public void testSetTitres() {
		Personne P =new Personne();
		// Création Titre
		Titre O=new Titre();
		Set<Titre> SeteO = new TreeSet<Titre>();
		
		// Ajout Titre
		 P.setTitres(SeteO);
		 Set <Titre> Sete1 = P.getTitres();
		 
		 assertEquals(SeteO, Sete1);
	}

	@Test
	public void testGetTitresList() {
		fail("Not yet implemented");
	}

}
