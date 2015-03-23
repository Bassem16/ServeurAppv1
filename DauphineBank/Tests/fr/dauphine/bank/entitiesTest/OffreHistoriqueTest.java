package fr.dauphine.bank.entitiesTest;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.OffreHistorique;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;

public class OffreHistoriqueTest {

	public static final String TEST= "TEST";
	@Test
	public void testOffreHistorique() {
		OffreHistorique o = new OffreHistorique();
		assertNotNull(o);
	}
	
	@Test
	public void testGetDateOffre() {
		OffreHistorique o = new OffreHistorique();
		o.setIdOffreHistorique(10);
		
		int Id = o.getIdOffreHistorique();
		assertEquals(10,Id);
	}

	@Test
	public void testGetIdOffreHistorique() {
		OffreHistorique o = new OffreHistorique();	
		o.setIdOffreHistorique(150);
		assertEquals(150,o.getIdOffreHistorique());
	}

	@Test
	public void testSetIdOffreHistorique() {
		OffreHistorique offre = new OffreHistorique();	
		offre.setIdOffreHistorique(1);
		assertEquals("OK", 1,offre.getIdOffreHistorique());
	}

	@Test
	public void testGetDateOffreHistorique() {
		OffreHistorique oh = new OffreHistorique();	
		Date dateTest = new Date(System.currentTimeMillis());
		oh.setDateOffreHistorique(dateTest);
		
		assertEquals(dateTest ,oh.getDateOffreHistorique());
	}

	@Test
	public void testSetDateOffreHistorique() {
		OffreHistorique d = new OffreHistorique();	
		
		Date dateTest = new Date(System.currentTimeMillis());
		d.setDateOffreHistorique(dateTest);
		
		assertEquals(dateTest ,d.getDateOffreHistorique());
	}

	@Test
	public void testGetPrixOffreHistorique() {
		OffreHistorique o = new OffreHistorique();	
		o.setPrixOffreHistorique(0);
		assertEquals(0, o.getPrixOffreHistorique(), 0);
	}

	@Test
	public void testSetPrixOffreHistorique() {
		OffreHistorique o = new OffreHistorique();	
		o.setPrixOffreHistorique(1);
		assertEquals(1,o.getPrixOffreHistorique(), 0);
	}

	@Test
	public void testGetQuantiteOffreHistorique() {
		OffreHistorique o = new OffreHistorique();	
		o.setQuantiteOffreHistorique(0);
		assertEquals(0, o.getQuantiteOffreHistorique(), 0);
	}

	@Test
	public void testSetQuantiteOffreHistorique() {
		OffreHistorique o = new OffreHistorique();	
		o.setQuantiteOffreHistorique(0);
		assertEquals(0, o.getQuantiteOffreHistorique(), 0);
	}

	@Test
	public void testGetStatut() {
		OffreHistorique o = new OffreHistorique();	
		o.setStatut(TEST);
		assertEquals(TEST,o.getStatut());
	}

	@Test
	public void testSetStatut() {
		OffreHistorique o = new OffreHistorique();	
		o.setStatut(TEST);
		assertEquals(TEST,o.getStatut());
	}

	@Test
	public void testGetTypeOffreHistorique() {
		OffreHistorique o = new OffreHistorique();	
		o.setTypeOffreHistorique(TEST);
		assertEquals(TEST,o.getTypeOffreHistorique());
	}

	@Test
	public void testSetTypeOffreHistorique() {
		OffreHistorique o = new OffreHistorique();	
		o.setTypeOffreHistorique(TEST);
		assertEquals(TEST,o.getTypeOffreHistorique());
	}

	@Test
	public void testGetEntreprise() {
		OffreHistorique o = new OffreHistorique();
		// Création Entreprise
		Entreprise e =new Entreprise();
		// Ajout Entreprise
		o.setEntreprise(e);
		
		assertEquals(e, o.getEntreprise());
	}

	@Test
	public void testSetEntreprise() {
		OffreHistorique o = new OffreHistorique();
		// Création Entreprise
		Entreprise e =new Entreprise();
		// Ajout Entreprise
		o.setEntreprise(e);
		
		assertEquals(e, o.getEntreprise());
	}

	@Test
	public void testGetPersonneEmetteur() {
		OffreHistorique o = new OffreHistorique();
		// Création Personnne
		Personne p=new Personne();

		// Ajout Personne
		 o.setPersonneEmetteur(p);
		 assertEquals(p, o.getPersonneEmetteur());
	}

	@Test
	public void testSetPersonneEmetteur() {
		OffreHistorique o = new OffreHistorique();
		// Création Personnne
		Personne p=new Personne();

		// Ajout Personne
		 o.setPersonneEmetteur(p);
		 assertEquals(p, o.getPersonneEmetteur());
	}
		 
	@Test
	public void testGetPersonneReceveur() {
		OffreHistorique o = new OffreHistorique();
		// Création Personnne
		Personne p=new Personne();

		// Ajout Personne
		 o.setPersonneReceveur(p);
		 assertEquals(p, o.getPersonneReceveur());
	}

	@Test
	public void testSetPersonneReceveur() {
		OffreHistorique o = new OffreHistorique();
		// Création Personnne
		Personne p=new Personne();

		// Ajout Personne
		 o.setPersonneReceveur(p);
		 assertEquals(p, o.getPersonneReceveur());		 
	}

	@Test
	public void testGetTitres() {
		Personne p =new Personne();
		Set<Titre> seteO = new TreeSet<Titre>();
		
		// Ajout Titre
		 p.setTitres(seteO);
		 Set <Titre> sete1 = p.getTitres();
		 
		 assertEquals(seteO, sete1);
	}

	@Test
	public void testSetTitres() {
		Personne p =new Personne();
		Set<Titre> seteO = new TreeSet<Titre>();
		
		// Ajout Titre
		 p.setTitres(seteO);
		 Set <Titre> sete1 = p.getTitres();
		 
		 assertEquals(seteO, sete1);
	}

	@Test
	public void testGetTitresList() {
		OffreHistorique oh = new OffreHistorique();
		oh.setTitres(new HashSet<Titre>());
		Titre t = new Titre();
		oh.getTitres().add(t);
		Titre t1 = oh.getTitresList().get(0);
		
		assertEquals(t.hashCode(),t1.hashCode());
	}
	
	
	
	
	
}
