package fr.dauphine.bank.beanstests;

import static org.junit.Assert.*;

import java.util.HashSet;
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
		assertEquals("Resultat",1,t.getOffresList().size());

	}

	@Test
	public void testEstVente() {
		Titre t = new Titre();
		t.setEtatTitre(1);

		assertEquals(true, t.estVente());
	}

}
