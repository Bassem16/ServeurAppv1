package fr.dauphine.bank.beanstests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.OffreHistorique;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;

public class TitreTest {

	@Test
	public void testTitre() {
		Titre T = new Titre();
		assertNotNull(T);
	}

	@Test
	public void testGetIdTitre() {
		Titre T = new Titre();	
		T.setIdTitre(0);
		assertEquals(0,T.getIdTitre());
	}

	@Test
	public void testSetIdTitre() {
		Titre T = new Titre();	
		T.setIdTitre(0);
		assertEquals(0,T.getIdTitre());
	}

	@Test
	public void testGetEtatTitre() {
		Titre T = new Titre();	
		T.setEtatTitre(0);
		assertEquals(0,T.getEtatTitre());
	}
	
	@Test
	public void testSetEtatTitre() {
		Titre T = new Titre();	
		T.setEtatTitre(0);
		assertEquals(0,T.getEtatTitre());
	}

	@Test
	public void testGetNomTitre() {
		Titre T = new Titre();	
		T.setNomTitre("TEST");
		assertEquals("TEST",T.getNomTitre());
	}

	@Test
	public void testSetNomTitre() {
		Titre T = new Titre();	
		T.setNomTitre("TEST");
		assertEquals("TEST",T.getNomTitre());
	}

	@Test
	public void testGetTypeTitre() {
		Titre T = new Titre();	
		T.setTypeTitre("TEST");
		assertEquals("TEST",T.getTypeTitre());
	}

	@Test
	public void testSetTypeTitre() {
		Titre T = new Titre();	
		T.setTypeTitre("TEST");
		assertEquals("TEST",T.getTypeTitre());
	}

	@Test
	public void testGetEntreprise() {
		Titre T = new Titre();
		// Création Entreprise
		Entreprise E =new Entreprise();
		// Ajout Entreprise
		T.setEntreprise(E);
		
		assertEquals(E, T.getEntreprise());
	}

	@Test
	public void testSetEntreprise() {
		Titre T = new Titre();
		// Création Entreprise
		Entreprise E =new Entreprise();
		// Ajout Entreprise
		T.setEntreprise(E);
		
		assertEquals(E, T.getEntreprise());
	}

	@Test
	public void testGetOffreHistoriques() {
		Titre T =new Titre();
		// Création Offre
		OffreHistorique O=new OffreHistorique();
		Set<OffreHistorique> SeteO = new TreeSet<OffreHistorique>();
		
		// Ajout Offre
		 T.setOffreHistoriques(SeteO);
		 Set <OffreHistorique> Sete1 = T.getOffreHistoriques();
		 
		 assertEquals(SeteO, Sete1);
	}

	@Test
	public void testSetOffreHistoriques() {
		Titre T =new Titre();
		// Création Offre
		OffreHistorique O=new OffreHistorique();
		Set<OffreHistorique> SeteO = new TreeSet<OffreHistorique>();
		
		// Ajout Offre
		 T.setOffreHistoriques(SeteO);
		 Set <OffreHistorique> Sete1 = T.getOffreHistoriques();
		 
		 assertEquals(SeteO, Sete1);
	}

	@Test
	public void testGetOffres() {
		Titre T =new Titre();
		// Création Offre
		Offre O=new Offre();
		Set<Offre> SeteO = new TreeSet<Offre>();
		
		// Ajout Offre
		 T.setOffres(SeteO);
		 Set <Offre> Sete1 = T.getOffres();
		 
		 assertEquals(SeteO, Sete1);
	}

	@Test
	public void testSetOffres() {
		Titre T =new Titre();
		// Création Offre
		Offre O=new Offre();
		Set<Offre> SeteO = new TreeSet<Offre>();

		// Ajout Offre
		 T.setOffres(SeteO);
		 Set <Offre> Sete1 = T.getOffres();
		 
		 assertEquals(SeteO, Sete1);
	}
	
	@Test
	public void testGetPersonne() {
		Titre T = new Titre();
		// Création Personne
		Personne P =new Personne();
		// Ajout Personne
		T.setPersonne(P);
		
		assertEquals(P, T.getPersonne());
	}

	@Test
	public void testSetPersonne() {
		Titre T = new Titre();
		// Création Personne
		Personne P =new Personne();
		// Ajout Personne
		T.setPersonne(P);
		
		assertEquals(P, T.getPersonne());
	}

		@Test
	public void testGetOffresList() {
			fail("Not yet implemented");
			
	}
	
		@Test
	public void testEstVente() {
		Titre T = new Titre();
		T.setEtatTitre(1);
		
		assertEquals(true, T.estVente());
	}

}
