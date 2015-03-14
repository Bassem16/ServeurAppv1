package fr.dauphine.bank.beanstests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Information;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.Personne;

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
		setP.add(P);
		// Ajout Personne
		 E.setPersonnes(setP);
		 assertEquals(setP, E.getPersonnes());
	}

	@Test
	public void testSetPersonnes() {
		Entreprise E=new Entreprise();
		// Création Personnne
		Personne P=new Personne();
		List<Personne> listeP = new ArrayList<Personne>();
		listeP.add(P);
		// Ajout Personne
		 E.setPersonnes(listeP);
		 assertEquals(listeP, E.getPersonnes());
	}

	@Test
	public void testGetInformations() {
		Entreprise E=new Entreprise();
		// Création Information
		Information I=new Information();
		List<Information> listeI = new ArrayList<Information>();
		listeI.add(I);
		// Ajout Information
		 E.setInformations(listeI);
		 assertEquals(listeI, E.getInformations());
	}

	@Test
	public void testSetInformations() {
		Entreprise E=new Entreprise();
		// Création Information
		Information I=new Information();
		List<Information> listeI = new ArrayList<Information>();
		listeI.add(I);
		// Ajout Information
		 E.setInformations(listeI);
		 assertEquals(listeI, E.getInformations());
	}

	@Test
	public void testAddInformation() {
		Entreprise E=new Entreprise();
		// Création Information
		Information I=new Information();
		List<Information> listeI = new ArrayList<Information>();
		listeI.add(I);
		
		// Ajout Information
		 List<Information> listeVide = new ArrayList<Information>();
		 E.setInformations(listeVide);
		 E.addInformation(I);
		
		//getInformations().add(information);
		//information.setEntreprise(this);
		 
		 assertEquals(listeI, E.getInformations());
	}

	@Test
	public void testRemoveInformation() {
		Entreprise E=new Entreprise();
		// Création Information
		Information I=new Information();
		List<Information> listeVide = new ArrayList<Information>();
		
		// Ajout Information
		 List<Information> liste = new ArrayList<Information>();
		 E.setInformations(liste);
		 E.addInformation(I);
		 E.removeInformation(I);
		 
		 assertEquals(listeVide, E.getInformations());	 
	}

	@Test
	public void testGetOffres() {
		Entreprise E=new Entreprise();
		// Création Offre
		Offre O=new Offre();
		List<Offre> listeO = new ArrayList<Offre>();
		listeO.add(O);
		
		// Ajout Offre
		 E.setOffres(listeO);
		 
		 assertEquals(listeO, E.getOffres());
	}

	@Test
	public void testSetOffres() {
		Entreprise E=new Entreprise();
		// Création Offre
		Offre O=new Offre();
		List<Offre> listeO = new ArrayList<Offre>();
		listeO.add(O);
		
		// Ajout Offre
		 E.setOffres(listeO);
		 
		 assertEquals(listeO, E.getOffres());
	}

	@Test
	public void testAddOffre() {
		Entreprise E=new Entreprise();
		// Création Offre
		Offre O=new Offre();
		List<Offre> listeO = new ArrayList<Offre>();
		listeO.add(O);
		
		// Ajout Offre
		 List<Offre> liste = new ArrayList<Offre>();
		 E.setOffres(liste);
		 E.addOffre(O);
		 
		 assertEquals(listeO, E.getOffres());
	}

	@Test
	public void testRemoveOffre() {
		Entreprise E=new Entreprise();
		// Création Offre
		Offre O=new Offre();
		List<Offre> listeVide = new ArrayList<Offre>();
		
		// Ajout Offre
		 List<Offre> liste = new ArrayList<Offre>();
		 E.setOffres(liste);
		 E.addOffre(O);
		 E.removeOffre(O);
		 
		 assertEquals(listeVide, E.getOffres());
	}

	@Test
	public void testGetTitres() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTitres() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddTitre() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveTitre() {
		fail("Not yet implemented");
	}

}
