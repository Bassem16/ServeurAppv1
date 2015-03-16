package fr.dauphine.bank.beanstests;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import fr.dauphine.bank.entities.Demande;
import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;
import fr.dauphine.bank.entities.TypePersonne;

public class PersonneTest {

	@Test
	public void testPersonne() {
		Personne P = new Personne();
		assertNotNull(P);
	}

	@Test
	public void testGetIdPersonne() {
		Personne P = new Personne();	
		P.setIdPersonne(1);
		assertEquals(1,P.getIdPersonne());
	}

	@Test
	public void testSetIdPersonne() {
		Personne P = new Personne();	
		P.setIdPersonne(1);
		assertEquals(1,P.getIdPersonne());
	}

	@Test
	public void testGetEmail() {
		Personne P = new Personne();	
		P.setEmail("test@test.com");
		assertEquals("test@test.com",P.getEmail());
	}

	@Test
	public void testSetEmail() {
		Personne P = new Personne();	
		P.setEmail("test@test.com");
		assertEquals("test@test.com",P.getEmail());
	}

	@Test
	public void testGetLogin() {
		Personne P = new Personne();	
		P.setLogin("test");
		assertEquals("test",P.getLogin());
	}

	@Test
	public void testSetLogin() {
		Personne P = new Personne();	
		P.setLogin("test");
		assertEquals("test",P.getLogin());
	}

	@Test
	public void testGetMotDePasse() {
		Personne P = new Personne();	
		P.setMotDePasse("testtest");
		assertEquals("testtest",P.getMotDePasse());
	}

	@Test
	public void testSetMotDePasse() {
		Personne P = new Personne();	
		P.setMotDePasse("testtest");
		assertEquals("testtest",P.getMotDePasse());
	}

	@Test
	public void testGetNomPersonne() {
		Personne P = new Personne();	
		P.setNomPersonne("testtest");
		assertEquals("testtest",P.getNomPersonne());
	}

	@Test
	public void testSetNomPersonne() {
		Personne P = new Personne();	
		P.setNomPersonne("testtest");
		assertEquals("testtest",P.getNomPersonne());
	}

	@Test
	public void testGetPrenomPersonne() {
		Personne P = new Personne();	
		P.setPrenomPersonne("testtest");
		assertEquals("testtest",P.getPrenomPersonne());
	}

	@Test
	public void testSetPrenomPersonne() {
		Personne P = new Personne();	
		P.setPrenomPersonne("testtest");
		assertEquals("testtest",P.getPrenomPersonne());
	}

	@Test
	public void testGetEntreprise() {
		Personne P = new Personne();	
		// Création Entreprise
		Entreprise E =new Entreprise();
		// Ajout Entreprise
		P.setEntreprise(E);
		
		assertEquals(E, P.getEntreprise());
	}

	@Test
	public void testSetEntreprise() {
		Personne P = new Personne();	
		// Création Entreprise
		Entreprise E =new Entreprise();
		// Ajout Entreprise
		P.setEntreprise(E);
		
		assertEquals(E, P.getEntreprise());
	}

	@Test
	public void testGetDemandes() {
		Personne P =new Personne();
		// Création Demande
		Demande O=new Demande();
		Set<Demande> SeteO = new TreeSet<Demande>();
		
		// Ajout Demande
		 P.setDemandes(SeteO);
		 Set <Demande> Sete1 = P.getDemandes();
		 
		 assertEquals(SeteO, Sete1);
	}

	@Test
	public void testSetDemandes() {
		Personne P =new Personne();
		// Création Demande
		Demande O=new Demande();
		Set<Demande> SeteO = new TreeSet<Demande>();
		
		// Ajout Demande
		 P.setDemandes(SeteO);
		 Set <Demande> Sete1 = P.getDemandes();
		 
		 assertEquals(SeteO, Sete1);
	}

	@Test
	public void testAddDemande() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveDemande() {
		fail("Not yet implemented");
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
	public void testGetOffresEmises() {
		Personne P =new Personne();
		// Création Offre
		Offre O=new Offre();
		Set<Offre> SeteO = new TreeSet<Offre>();

		// Ajout Offre
		 P.setOffresEmises(SeteO);
		 Set <Offre> Sete1 = P.getOffresEmises();
		 
		 assertEquals(SeteO, Sete1);
	}

	@Test
	public void testSetOffresEmises() {
		Personne P =new Personne();
		// Création Offre
		Offre O=new Offre();
		Set<Offre> SeteO = new TreeSet<Offre>();

		// Ajout Offre
		 P.setOffresEmises(SeteO);
		 Set <Offre> Sete1 = P.getOffresEmises();
		 
		 assertEquals(SeteO, Sete1);
	}

	@Test
	public void testGetOffresRecues() {
		Personne P =new Personne();
		// Création Offre
		Offre O=new Offre();
		Set<Offre> SeteO = new TreeSet<Offre>();

		// Ajout Offre
		 P.setOffresRecues(SeteO);
		 Set <Offre> Sete1 = P.getOffresRecues();
		 
		 assertEquals(SeteO, Sete1);
	}

	@Test
	public void testSetOffresRecues() {
		Personne P =new Personne();
		// Création Offre
		Offre O=new Offre();
		Set<Offre> SeteO = new TreeSet<Offre>();

		// Ajout Offre
		 P.setOffresRecues(SeteO);
		 Set <Offre> Sete1 = P.getOffresRecues();
		 
		 assertEquals(SeteO, Sete1);
	}

	@Test
	public void testAddOffre() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveOffre() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTypePersonne() {
		Personne P = new Personne();	
		TypePersonne test = new TypePersonne();
		P.setTypePersonne(test);
		assertEquals(test,P.getTypePersonne());
	}

	@Test
	public void testSetTypePersonne() {
		Personne P = new Personne();	
		TypePersonne test = new TypePersonne();
		P.setTypePersonne(test);
		assertEquals(test,P.getTypePersonne());
	}

}
