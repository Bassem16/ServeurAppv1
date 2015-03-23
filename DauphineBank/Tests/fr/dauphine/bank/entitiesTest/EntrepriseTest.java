package fr.dauphine.bank.entitiesTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.Set;

import org.junit.Test;

import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Information;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.OffreHistorique;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;

public class EntrepriseTest {

	@Test
	public void testEntreprise() {
		Entreprise e=new Entreprise();
		assertNotNull(e);
	}

	@Test
	public void testGetIdEntreprise() {
		Entreprise e=new Entreprise();
		e.setIdEntreprise(0);
		assertEquals(0,e.getIdEntreprise());
	}

	@Test
	public void testSetIdEntreprise() {
		Entreprise e=new Entreprise();
		e.setIdEntreprise(1);
		assertEquals(1,e.getIdEntreprise());
	}

	@Test
	public void testGetNombreTitreTotal() {
		Entreprise e=new Entreprise();
		e.setNombreTitreTotal(120);
		assertEquals(120,e.getNombreTitreTotal());
	}

	@Test
	public void testSetNombreTitreTotal() {
		Entreprise e=new Entreprise();
		e.setNombreTitreTotal(1);
		assertEquals(1,e.getNombreTitreTotal());
	}

	@Test
	public void testGetNomEntreprise() {
		Entreprise e=new Entreprise();
		e.setNomEntreprise("TEST");
		assertEquals("TEST",e.getNomEntreprise());
	}

	@Test
	public void testSetNomEntreprise() {
		Entreprise e=new Entreprise();
		e.setNomEntreprise("TEST");
		assertEquals("TEST", e.getNomEntreprise());
	}

	@Test
	public void testGetSecteurEntreprise() {
		Entreprise e=new Entreprise();
		e.setSecteurEntreprise("TEST");
		assertEquals("TEST",e.getSecteurEntreprise());
	}

	@Test
	public void testSetSecteurEntreprise() {
		Entreprise e=new Entreprise();
		e.setSecteurEntreprise("TEST");
		assertEquals("TEST",e.getSecteurEntreprise());
	}

	@Test
	public void testGetPersonnes() {
		Entreprise e=new Entreprise();
		Set<Personne> setP = new TreeSet<Personne>();

		// Ajout Personne
		 e.setPersonnes(setP);
		 assertEquals(setP, e.getPersonnes());
	}
	
	@Test
	public void testGetLogo() {
		Entreprise e=new Entreprise();
	

		
		 e.setLogo("logo");
		 assertEquals("logo", e.getLogo());
	}

	@Test
	public void testSetPersonnes() {
		Entreprise e=new Entreprise();
		Set<Personne> seteP = new TreeSet<Personne>();

		// Ajout Personne
		 e.setPersonnes(seteP);
		 assertEquals(seteP, e.getPersonnes());
	}

	@Test
	public void testGetInformations() {
		Entreprise e=new Entreprise();
		Set<Information> seteI = new TreeSet<Information>();

		// Ajout Information
		 e.setInformations(seteI);
		 assertEquals(seteI, e.getInformations());
	}

	@Test
	public void testSetInformations() {
		Entreprise e=new Entreprise();
		Set<Information> SeteI = new TreeSet<Information>();

		// Ajout Information
		 e.setInformations(SeteI);
		 assertEquals(SeteI, e.getInformations());
	}

	

	@Test
	public void testGetOffres() {
		Entreprise e=new Entreprise();
		Set<Offre> seteO = new TreeSet<Offre>();
		
		// Ajout Offre
		 e.setOffres(seteO);
		 Set <Offre> sete1 = e.getOffres();
		 
		 assertEquals(seteO, sete1);
	}

	@Test
	public void testSetOffres() {
		Entreprise e=new Entreprise();
		Set<Offre> seteO = new TreeSet<Offre>();

		// Ajout Offre
		 e.setOffres(seteO);
		 Set <Offre> sete1 = e.getOffres();
		 
		 assertEquals(seteO, sete1);
	}
	
	@Test
	public void testGetSetOffreHistorique() {
		Entreprise e=new Entreprise();
		Set<OffreHistorique> seteO = new HashSet<OffreHistorique>();

		// Ajout Offre
		 e.setOffreHistoriques(seteO);
		 Set <OffreHistorique> sete1 = e.getOffreHistoriques();
		 
		 assertEquals(seteO, sete1);
	}

	
	

	@Test
	public void testGetTitres() {
		Entreprise e=new Entreprise();
		Set<Titre> seteO = new TreeSet<Titre>();
		
		// Ajout Titre
		 e.setTitres(seteO);
		 Set <Titre> sete1 = e.getTitres();
		 
		 assertEquals(seteO, sete1);
	}

	@Test
	public void testSetTitres() {
		Entreprise e=new Entreprise();
		Set<Titre> seteO = new TreeSet<Titre>();
		
		// Ajout Titre
		 e.setTitres(seteO);
		 Set <Titre> sete1 = e.getTitres();
		 
		 assertEquals(seteO, sete1);
	}
	
	@Test
	public void testComparator() {
		List<Entreprise> entreprises = new ArrayList<Entreprise>();
		Entreprise e1=new Entreprise();
		Entreprise e2=new Entreprise();
		
		e1.setNomEntreprise("a");
		e2.setNomEntreprise("b");
		
		entreprises.add(e2);
		entreprises.add(e1);
		
		
		Collections.sort(entreprises, Entreprise.alphabetique);
		 
		 assertTrue(entreprises.get(0).getNomEntreprise()=="a");
	}
	
	

}
