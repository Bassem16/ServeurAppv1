package fr.dauphine.bank.entitiesTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;

public class OffreTest {

	@Test
	public void testOffre() {
		Offre o = new Offre();
		assertNotNull(o);
	}

	@Test
	public void testGetIdOffre() {
		Offre o = new Offre();
		o.setIdOffre(0);
		assertEquals(0, o.getIdOffre());
	}

	@Test
	public void testSetIdOffre() {
		Offre o = new Offre();
		o.setIdOffre(1);
		assertEquals(1, o.getIdOffre());
	}

	@Test
	public void testGetPrixOffre() {
		Offre o = new Offre();
		o.setPrixOffre(0);
		assertEquals(0, o.getPrixOffre(), 0);
	}

	@Test
	public void testGetDateOffre() {
		Offre o = new Offre();
		Date date = new Date(System.currentTimeMillis());
		o.setDateOffre(date);
		assertEquals(date, o.getDateOffre());
	}

	@Test
	public void testSetPrixOffre() {
		Offre o = new Offre();
		o.setPrixOffre(1);
		assertEquals(1, o.getPrixOffre(), 0);
	}

	@Test
	public void testGetQuantiteOffre() {
		Offre o = new Offre();
		o.setQuantiteOffre(0);
		assertEquals(0, o.getQuantiteOffre(), 0);
	}

	@Test
	public void testSetQuantiteOffre() {
		Offre o = new Offre();
		o.setQuantiteOffre(0);
		assertEquals(0, o.getQuantiteOffre(), 0);
	}

	@Test
	public void testGetSetStatut() {
		Offre o = new Offre();
		o.setStatut("vendu");
		assertEquals("vendu", o.getStatut());
	}

	@Test
	public void testGetTypeOffre() {
		Offre o = new Offre();
		o.setTypeOffre("TEST");
		assertEquals("TEST", o.getTypeOffre());
	}

	@Test
	public void testSetTypeOffre() {
		Offre o = new Offre();
		o.setTypeOffre("TEST");
		assertEquals("TEST", o.getTypeOffre());
	}

	@Test
	public void testGetEntreprise() {
		Offre o = new Offre();
		// Création Entreprise
		Entreprise e = new Entreprise();
		// Ajout Entreprise
		o.setEntreprise(e);

		assertEquals(e, o.getEntreprise());
	}

	@Test
	public void testSetEntreprise() {
		Offre o = new Offre();
		// Création Entreprise
		Entreprise e = new Entreprise();
		// Ajout Entreprise
		o.setEntreprise(e);

		assertEquals(e, o.getEntreprise());
	}

	@Test
	public void testGetPersonneEmetteur() {
		Offre o = new Offre();
		// Création Personnne
		Personne p = new Personne();

		// Ajout Personne
		o.setPersonneEmetteur(p);
		assertEquals(p, o.getPersonneEmetteur());
	}

	@Test
	public void testSetPersonneEmetteur() {
		Offre o = new Offre();
		// Création Personnne
		Personne p = new Personne();

		// Ajout Personne
		o.setPersonneEmetteur(p);
		assertEquals(p, o.getPersonneEmetteur());
	}

	@Test
	public void testGetPersonneReceveur() {
		Offre o = new Offre();
		// Création Personnne
		Personne p = new Personne();

		// Ajout Personne
		o.setPersonneReceveur(p);
		assertEquals(p, o.getPersonneReceveur());
	}

	@Test
	public void testSetPersonneReceveur() {
		Offre o = new Offre();
		// Création Personnne
		Personne p = new Personne();

		// Ajout Personne
		o.setPersonneReceveur(p);
		assertEquals(p, o.getPersonneReceveur());
	}

	@Test
	public void testSetTitres() {
		Offre o = new Offre();
		Titre t = new Titre();
		
		Set<Titre> titres = new HashSet<Titre>();
		
		titres.add(t);
		o.setTitres(titres);
		
		assertSame(titres, o.getTitres());
	}
	
	@Test
	public void testSetTitresList() {
		Offre o = new Offre();
		Titre t = new Titre();
		
		Set<Titre> titres = new HashSet<Titre>();
		
		titres.add(t);
		o.setTitres(titres);
		
		assertSame(t, o.getTitresList().get(0));
	}

	@Test
	public void testComparator() {
		List<Offre> offres = new ArrayList<Offre>();
		Offre o1 = new Offre();
		Offre o2 = new Offre();

		o1.setPrixOffre(1.25);
		o2.setPrixOffre(45.02);

		offres.add(o2);
		offres.add(o1);

		Collections.sort(offres, Offre.prix);

		assertTrue(offres.get(0).getPrixOffre() <= offres.get(1).getPrixOffre());
	}

	@Test
	public void testComparatorAlphabetique() {
		List<Offre> offres = new ArrayList<Offre>();
		Offre o1 = new Offre();
		Offre o2 = new Offre();

		Date d1 = new Date(System.currentTimeMillis());
		Date d2 = new Date(System.currentTimeMillis());

		o1.setDateOffre(d1);
		o2.setDateOffre(d2);

		offres.add(o2);
		offres.add(o1);

		Collections.sort(offres, Offre.date);

		assertEquals(d1, offres.get(0).getDateOffre());
	}

}
