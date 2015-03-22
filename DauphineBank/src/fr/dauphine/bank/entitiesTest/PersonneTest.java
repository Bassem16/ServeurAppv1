package fr.dauphine.bank.entitiesTest;

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

	public static final String MAIL = "test@test.com";
	public static final String TEST = "TEST";
	@Test
	public void testPersonne() {
		Personne p = new Personne();
		assertNotNull(p);
	}

	@Test
	public void testGetIdPersonne() {
		Personne p = new Personne();	
		p.setIdPersonne(1);
		assertEquals(1,p.getIdPersonne());
	}

	@Test
	public void testSetIdPersonne() {
		Personne p = new Personne();	
		p.setIdPersonne(1);
		assertEquals("Ok", 1,p.getIdPersonne());
	}

	@Test
	public void testGetEmail() {
		Personne p = new Personne();	
		p.setEmail(MAIL);
		assertEquals(MAIL,p.getEmail());
	}

	@Test
	public void testSetEmail() {
		Personne p = new Personne();	
		p.setEmail(MAIL);
		assertEquals(MAIL,p.getEmail());
	}

	@Test
	public void testGetLogin() {
		Personne p = new Personne();	
		p.setLogin(TEST);
		assertEquals(TEST,p.getLogin());
	}

	@Test
	public void testSetLogin() {
		Personne p = new Personne();	
		p.setLogin(TEST);
		assertEquals(TEST,p.getLogin());
	}

	@Test
	public void testGetMotDePasse() {
		Personne p = new Personne();	
		p.setMotDePasse(TEST);
		assertEquals(TEST,p.getMotDePasse());
	}

	@Test
	public void testSetMotDePasse() {
		Personne p = new Personne();	
		p.setMotDePasse(TEST);
		assertEquals(TEST,p.getMotDePasse());
	}

	@Test
	public void testGetNomPersonne() {
		Personne p = new Personne();	
		p.setNomPersonne(TEST);
		assertEquals(TEST,p.getNomPersonne());
	}

	@Test
	public void testSetNomPersonne() {
		Personne p = new Personne();	
		p.setNomPersonne(TEST);
		assertEquals(TEST,p.getNomPersonne());
	}

	@Test
	public void testGetPrenomPersonne() {
		Personne p = new Personne();	
		p.setPrenomPersonne(TEST);
		assertEquals(TEST,p.getPrenomPersonne());
	}

	@Test
	public void testSetPrenomPersonne() {
		Personne p = new Personne();	
		p.setPrenomPersonne(TEST);
		assertEquals(TEST,p.getPrenomPersonne());
	}

	@Test
	public void testGetEntreprise() {
		Personne p = new Personne();	
		// Création Entreprise
		Entreprise e =new Entreprise();
		// Ajout Entreprise
		p.setEntreprise(e);
		
		assertEquals(e, p.getEntreprise());
	}

	@Test
	public void testSetEntreprise() {
		Personne p = new Personne();	
		// Création Entreprise
		Entreprise e =new Entreprise();
		// Ajout Entreprise
		p.setEntreprise(e);
		
		assertEquals(e, p.getEntreprise());
	}

	@Test
	public void testGetDemandes() {
		Personne p =new Personne();
		Set<Demande> seteO = new TreeSet<Demande>();
		
		// Ajout Demande
		 p.setDemandes(seteO);
		 Set <Demande> sete1 = p.getDemandes();
		 
		 assertEquals(seteO, sete1);
	}

	@Test
	public void testSetDemandes() {
		Personne p =new Personne();
		Set<Demande> seteO = new TreeSet<Demande>();
		
		// Ajout Demande
		 p.setDemandes(seteO);
		 Set <Demande> sete1 = p.getDemandes();
		 
		 assertEquals(seteO, sete1);
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
	public void testGetOffresEmises() {
		Personne p =new Personne();
		Set<Offre> seteO = new TreeSet<Offre>();

		// Ajout Offre
		 p.setOffresEmises(seteO);
		 Set <Offre> sete1 = p.getOffresEmises();
		 
		 assertEquals(seteO, sete1);
	}

	@Test
	public void testSetOffresEmises() {
		Personne p =new Personne();
		Set<Offre> seteO = new TreeSet<Offre>();

		// Ajout Offre
		 p.setOffresEmises(seteO);
		 Set <Offre> sete1 = p.getOffresEmises();
		 
		 assertEquals(seteO, sete1);
	}

	@Test
	public void testGetOffresRecues() {
		Personne p =new Personne();
		Set<Offre> seteO = new TreeSet<Offre>();

		// Ajout Offre
		 p.setOffresRecues(seteO);
		 Set <Offre> sete1 = p.getOffresRecues();
		 
		 assertEquals(seteO, sete1);
	}

	@Test
	public void testSetOffresRecues() {
		Personne p =new Personne();
		Set<Offre> seteO = new TreeSet<Offre>();

		// Ajout Offre
		 p.setOffresRecues(seteO);
		 Set <Offre> sete1 = p.getOffresRecues();
		 
		 assertEquals(seteO, sete1);
	}

	
	

	@Test
	public void testGetTypePersonne() {
		Personne p = new Personne();	
		TypePersonne test = new TypePersonne();
		p.setTypePersonne(test);
		assertEquals(test,p.getTypePersonne());
	}

	@Test
	public void testSetTypePersonne() {
		Personne p = new Personne();	
		TypePersonne test = new TypePersonne();
		p.setTypePersonne(test);
		assertEquals(test,p.getTypePersonne());
	}

}
