package fr.dauphine.bank.entitiesTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
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
		Titre t = new Titre();
		assertNotNull(t);
	}

	@Test
	public void testGetIdTitre() {
		Titre t = new Titre();
		t.setIdTitre(0);
		assertEquals(0, t.getIdTitre());
	}

	@Test
	public void testSetIdTitre() {
		Titre t = new Titre();
		t.setIdTitre(0);
		assertEquals(0, t.getIdTitre());
	}

	@Test
	public void testGetEtatTitre() {
		Titre t = new Titre();
		t.setEtatTitre(0);
		assertEquals(0, t.getEtatTitre());
	}

	@Test
	public void testSetEtatTitre() {
		Titre t = new Titre();
		t.setEtatTitre(0);
		assertEquals(0, t.getEtatTitre());
	}

	@Test
	public void testGetNomTitre() {
		Titre t = new Titre();
		t.setNomTitre("TEST");
		assertEquals("TEST", t.getNomTitre());
	}

	@Test
	public void testSetNomTitre() {
		Titre t = new Titre();
		t.setNomTitre("TEST");
		assertEquals("TEST", t.getNomTitre());
	}

	@Test
	public void testGetTypeTitre() {
		Titre t = new Titre();
		t.setTypeTitre("TEST");
		assertEquals("TEST", t.getTypeTitre());
	}

	@Test
	public void testSetTypeTitre() {
		Titre t = new Titre();
		t.setTypeTitre("TEST");
		assertEquals("TEST", t.getTypeTitre());
	}

	@Test
	public void testGetEntreprise() {
		Titre t = new Titre();
		// Création Entreprise
		Entreprise e = new Entreprise();
		// Ajout Entreprise
		t.setEntreprise(e);

		assertEquals(e, t.getEntreprise());
	}

	@Test
	public void testSetEntreprise() {
		Titre t = new Titre();
		// Création Entreprise
		Entreprise e = new Entreprise();
		// Ajout Entreprise
		t.setEntreprise(e);

		assertEquals(e, t.getEntreprise());
	}

	@Test
	public void testGetOffreHistoriques() {
		Titre t = new Titre();
		Set<OffreHistorique> seteO = new TreeSet<OffreHistorique>();

		// Ajout Offre
		t.setOffreHistoriques(seteO);
		Set<OffreHistorique> sete1 = t.getOffreHistoriques();

		assertEquals(seteO, sete1);
	}

	@Test
	public void testSetOffreHistoriques() {
		Titre t = new Titre();
		Set<OffreHistorique> seteO = new TreeSet<OffreHistorique>();

		// Ajout Offre
		t.setOffreHistoriques(seteO);
		Set<OffreHistorique> sete1 = t.getOffreHistoriques();

		assertEquals(seteO, sete1);
	}

	@Test
	public void testGetOffres() {
		Titre t = new Titre();
		Set<Offre> seteO = new TreeSet<Offre>();

		// Ajout Offre
		t.setOffres(seteO);
		Set<Offre> sete1 = t.getOffres();

		assertEquals(seteO, sete1);
	}

	@Test
	public void testSetOffres() {
		Titre t = new Titre();
		Set<Offre> seteO = new TreeSet<Offre>();

		// Ajout Offre
		t.setOffres(seteO);
		Set<Offre> sete1 = t.getOffres();

		assertEquals(seteO, sete1);
	}

	@Test
	public void testGetPersonne() {
		Titre t = new Titre();
		// Création Personne
		Personne p = new Personne();
		// Ajout Personne
		t.setPersonne(p);

		assertEquals(p, t.getPersonne());
	}

	@Test
	public void testSetPersonne() {
		Titre t = new Titre();
		// Création Personne
		Personne p = new Personne();
		// Ajout Personne
		t.setPersonne(p);

		assertEquals(p, t.getPersonne());
	}

	@Test
	public void testGetOffresList() {
		Titre t = new Titre();
		Offre o = new Offre();
		Set<Offre> setO = new HashSet<Offre>();
		t.setOffres(setO);
		t.getOffres().add(o);
		assertEquals("Resultat", 1, t.getOffresList().size());

	}

	@Test
	public void testEstVente() {
		Titre t = new Titre();
		t.setEtatTitre(1);

		assertTrue(t.estVente());

		t.setEtatTitre(0);

		assertTrue(!t.estVente());
	}

	@Test
	public void testComparatorNbrOffre() {
		List<Titre> titres = new ArrayList<Titre>();
		Titre t1 = new Titre();
		Titre t2 = new Titre();

		Offre o1 = new Offre();
		Offre o2 = new Offre();
		Offre o3 = new Offre();

		t1.setOffres(new HashSet<Offre>());
		t2.setOffres(new HashSet<Offre>());

		t1.getOffres().add(o1);
		t2.getOffres().add(o2);
		t2.getOffres().add(o3);

		titres.add(t1);
		titres.add(t2);
		Collections.sort(titres, Titre.nbrOffre);

		assertEquals(true, titres.get(0).getOffres().size() <= titres.get(0)
				.getOffres().size());
	}
	
	@Test
	public void testComparatorAlphabetique() {
		List<Titre> titres = new ArrayList<Titre>();
		Titre t1 = new Titre();
		Titre t2 = new Titre();
		
		t2.setNomTitre("b");
		t1.setNomTitre("a");
		
		titres.add(t2);
		titres.add(t1);

		
		Collections.sort(titres, Titre.alphabetique);

		assertEquals("a", titres.get(0).getNomTitre());
	}

}
