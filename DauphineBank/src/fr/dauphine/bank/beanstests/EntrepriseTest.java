package fr.dauphine.bank.beanstests;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.TreeSet;
import java.util.Set;
import java.util.Set;
import java.util.TreeSet;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Information;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;

public class EntrepriseTest {

	@Test
	public void testEntreprise() {
		Entreprise E=new Entreprise();
		assertNotNull(E);
	}

	@Test
	public void testGetIdEntreprise() {
		Entreprise E=new Entreprise();
		E.setIdEntreprise(0);
		assertEquals(0,E.getIdEntreprise());
	}

	@Test
	public void testSetIdEntreprise() {
		Entreprise E=new Entreprise();
		E.setIdEntreprise(1);
		assertEquals(1,E.getIdEntreprise());
	}

	@Test
	public void testGetNombreTitreTotal() {
		Entreprise E=new Entreprise();
		E.setNombreTitreTotal(0);
		assertEquals(0,E.getNombreTitreTotal());
	}

	@Test
	public void testSetNombreTitreTotal() {
		Entreprise E=new Entreprise();
		E.setNombreTitreTotal(1);
		assertEquals(1,E.getNombreTitreTotal());
	}

	@Test
	public void testGetNomEntreprise() {
		Entreprise E=new Entreprise();
		E.setNomEntreprise("TEST");
		assertEquals("TEST",E.getNomEntreprise());
	}

	@Test
	public void testSetNomEntreprise() {
		Entreprise E=new Entreprise();
		E.setNomEntreprise("TEST");
		assertEquals("TEST", E.getNomEntreprise());
	}

	@Test
	public void testGetSecteurEntreprise() {
		Entreprise E=new Entreprise();
		E.setSecteurEntreprise("TEST");
		assertEquals("TEST",E.getSecteurEntreprise());
	}

	@Test
	public void testSetSecteurEntreprise() {
		Entreprise E=new Entreprise();
		E.setSecteurEntreprise("TEST");
		assertEquals("TEST",E.getSecteurEntreprise());
	}

	@Test
	public void testGetPersonnes() {
		Entreprise E=new Entreprise();
		// Création Personnne
		Personne P=new Personne();
		Set<Personne> setP = new TreeSet<Personne>();

		// Ajout Personne
		 E.setPersonnes(setP);
		 assertEquals(setP, E.getPersonnes());
	}

	@Test
	public void testSetPersonnes() {
		Entreprise E=new Entreprise();
		// Création Personnne
		Personne P=new Personne();
		Set<Personne> SeteP = new TreeSet<Personne>();

		// Ajout Personne
		 E.setPersonnes(SeteP);
		 assertEquals(SeteP, E.getPersonnes());
	}

	@Test
	public void testGetInformations() {
		Entreprise E=new Entreprise();
		// Création Information
		Information I =new Information();
		Set<Information> SeteI = new TreeSet<Information>();

		// Ajout Information
		 E.setInformations(SeteI);
		 assertEquals(SeteI, E.getInformations());
	}

	@Test
	public void testSetInformations() {
		Entreprise E=new Entreprise();
		// Création Information
		Information I=new Information();
		Set<Information> SeteI = new TreeSet<Information>();

		// Ajout Information
		 E.setInformations(SeteI);
		 assertEquals(SeteI, E.getInformations());
	}

	

	@Test
	public void testGetOffres() {
		Entreprise E=new Entreprise();
		// Création Offre
		Offre O=new Offre();
		Set<Offre> SeteO = new TreeSet<Offre>();
		
		// Ajout Offre
		 E.setOffres(SeteO);
		 Set <Offre> Sete1 = E.getOffres();
		 
		 assertEquals(SeteO, Sete1);
	}

	@Test
	public void testSetOffres() {
		Entreprise E=new Entreprise();
		// Création Offre
		Offre O=new Offre();
		Set<Offre> SeteO = new TreeSet<Offre>();

		// Ajout Offre
		 E.setOffres(SeteO);
		 Set <Offre> Sete1 = E.getOffres();
		 
		 assertEquals(SeteO, Sete1);
	}

	
	

	@Test
	public void testGetTitres() {
		Entreprise E=new Entreprise();
		// Création Titre
		Titre O=new Titre();
		Set<Titre> SeteO = new TreeSet<Titre>();
		
		// Ajout Titre
		 E.setTitres(SeteO);
		 Set <Titre> Sete1 = E.getTitres();
		 
		 assertEquals(SeteO, Sete1);
	}

	@Test
	public void testSetTitres() {
		Entreprise E=new Entreprise();
		// Création Titre
		Titre O=new Titre();
		Set<Titre> SeteO = new TreeSet<Titre>();
		
		// Ajout Titre
		 E.setTitres(SeteO);
		 Set <Titre> Sete1 = E.getTitres();
		 
		 assertEquals(SeteO, Sete1);
	}

}
