package fr.dauphine.bank.beanstests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import fr.dauphine.bank.beans.InscriptionBean;
import fr.dauphine.bank.entities.Demande;
import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Information;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;
import fr.dauphine.bank.entities.TypePersonne;

public class InscriptionBeanTest {

	@Test
	public void testInscriptionBean() {
		InscriptionBean I = new InscriptionBean();
		assertNotNull(I);
	}

	@Test
	public void testGetResponse() {
		InscriptionBean I = new InscriptionBean();
		String retour = I.getResponse();
		
		assertEquals("Une demande d'inscription a été envoyé", retour);
	}

	@Test
	public void testGetPersonne() {
		InscriptionBean I = new InscriptionBean();
		I.setIdPersonne(1); 
	
		assertEquals(1, I.getPersonne().getIdPersonne());
	}

	@Test
	public void testGetIdPersonne() {
		InscriptionBean I = new InscriptionBean();
		I.setIdPersonne(1); 
	
		assertEquals(1, I.getPersonne().getIdPersonne());
	}

	@Test
	public void testSetIdPersonne() {
		InscriptionBean I = new InscriptionBean();
		I.setIdPersonne(1); 
	
		assertEquals(1, I.getPersonne().getIdPersonne());
	}

	@Test
	public void testGetEmail() {
		InscriptionBean I = new InscriptionBean();
		I.setEmail("TEST"); 
	
		assertEquals("TEST", I.getEmail());
	}

	@Test
	public void testSetEmail() {
		InscriptionBean I = new InscriptionBean();
		I.setEmail("TEST"); 
	
		assertEquals("TEST", I.getEmail());
	}

	@Test
	public void testGetLogin() {
		InscriptionBean I = new InscriptionBean();
		I.setLogin("TEST"); 
	
		assertEquals("TEST", I.getLogin());
	}

	@Test
	public void testSetLogin() {
		InscriptionBean I = new InscriptionBean();
		I.setLogin("TEST"); 
	
		assertEquals("TEST", I.getLogin());
	}

	@Test
	public void testGetMotDePasse() {
		InscriptionBean I = new InscriptionBean();
		I.setMotDePasse("TEST"); 
	
		assertEquals("TEST", I.getMotDePasse());
	}

	@Test
	public void testSetMotDePasse() {
		InscriptionBean I = new InscriptionBean();
		I.setMotDePasse("TEST"); 
	
		assertEquals("TEST", I.getMotDePasse());
	}

	@Test
	public void testGetNomPersonne() {
		InscriptionBean I = new InscriptionBean();
		I.setNomPersonne("TEST"); 
	
		assertEquals("TEST", I.getNomPersonne());
	}

	@Test
	public void testSetNomPersonne() {
		InscriptionBean I = new InscriptionBean();
		I.setNomPersonne("TEST"); 
	
		assertEquals("TEST", I.getNomPersonne());
	}

	@Test
	public void testGetPrenomPersonne() {
		InscriptionBean I = new InscriptionBean();
		I.setPrenomPersonne("TEST"); 
	
		assertEquals("TEST", I.getPrenomPersonne());
	}

	@Test
	public void testSetPrenomPersonne() {
		InscriptionBean I = new InscriptionBean();
		I.setPrenomPersonne("TEST"); 
	
		assertEquals("TEST", I.getPrenomPersonne());
	}

	@Test
	public void testGetEntreprise() {
		InscriptionBean I = new InscriptionBean();
		Entreprise E = new Entreprise();
		I.setEntreprise(E); 
	
		assertEquals(E, I.getEntreprise());
	}

	@Test
	public void testSetEntreprise() {
		InscriptionBean I = new InscriptionBean();
		Entreprise E = new Entreprise();
		I.setEntreprise(E); 
	
		assertEquals(E, I.getEntreprise());
	}

	@Test
	public void testGetDemandes() {
		InscriptionBean I = new InscriptionBean();
		// Création Demande
		Demande O=new Demande();
		Set<Demande> SeteO = new TreeSet<Demande>();
		
		// Ajout Demande
		 I.setDemandes(SeteO);
		 Set <Demande> Sete1 = I.getDemandes();
		 
		 assertEquals(SeteO, Sete1);
	}

	@Test
	public void testSetDemandes() {
		InscriptionBean I = new InscriptionBean();
		// Création Demande
		Demande O=new Demande();
		Set<Demande> SeteO = new TreeSet<Demande>();
		
		// Ajout Demande
		 I.setDemandes(SeteO);
		 Set <Demande> Sete1 = I.getDemandes();
		 
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
		InscriptionBean I = new InscriptionBean();
		// Création Titre
		Titre O=new Titre();
		Set<Titre> SeteO = new TreeSet<Titre>();
		
		// Ajout Titre
		 I.setTitres(SeteO);
		 Set <Titre> Sete1 = I.getTitres();
		 
		 assertEquals(SeteO, Sete1);
	}

	@Test
	public void testSetTitres() {
		InscriptionBean I = new InscriptionBean();
		// Création Titre
		Titre O=new Titre();
		Set<Titre> SeteO = new TreeSet<Titre>();
		
		// Ajout Titre
		 I.setTitres(SeteO);
		 Set <Titre> Sete1 = I.getTitres();
		 
		 assertEquals(SeteO, Sete1);
	}

	@Test
	public void testGetOffresEmises() {
		InscriptionBean I = new InscriptionBean();
		// Création Offre
		Offre O=new Offre();
		Set<Offre> SeteO = new TreeSet<Offre>();

		// Ajout Offre
		 I.setOffresEmises(SeteO);
		 Set <Offre> Sete1 = I.getOffresEmises();
		 
		 assertEquals(SeteO, Sete1);
	}

	@Test
	public void testGetOffresRecues() {
		InscriptionBean I = new InscriptionBean();
		// Création Offre
		Offre O=new Offre();
		Set<Offre> SeteO = new TreeSet<Offre>();

		// Ajout Offre
		 I.setOffresRecues(SeteO);
		 Set <Offre> Sete1 = I.getOffresRecues();
		 
		 assertEquals(SeteO, Sete1);
	}

	@Test
	public void testGetOffresEmisesList() {
		InscriptionBean I = new InscriptionBean();
		// Création Offre
		Offre O=new Offre();
		Set<Offre> SeteO = new TreeSet<Offre>();

		// Ajout Offre
		 I.setOffresEmises(SeteO);
		 ArrayList<Offre> Sete1 = new ArrayList<Offre>(SeteO);
		 
		 assertEquals(Sete1, I.getOffresEmisesList());
	}

	@Test
	public void testGetOffresRecuesList() {
		InscriptionBean I = new InscriptionBean();
		// Création Offre
		Offre O=new Offre();
		Set<Offre> SeteO = new TreeSet<Offre>();

		// Ajout Offre
		 I.setOffresRecues(SeteO);
		 ArrayList<Offre> Sete1 = new ArrayList<Offre>(SeteO);
		 
		 assertEquals(Sete1, I.getOffresRecuesList());
	}

	@Test
	public void testGetTitresList() {
		InscriptionBean I = new InscriptionBean();
		// Création Titre
		Titre O=new Titre();
		Set<Titre> SeteO = new TreeSet<Titre>();
		
		// Ajout Titre
		 I.setTitres(SeteO);
		 ArrayList<Titre> Sete1 = new ArrayList<Titre>(SeteO);
		 
		 assertEquals(Sete1, I.getOffresRecuesList());
	}

	@Test
	public void testGetDemandesList() {
		InscriptionBean I = new InscriptionBean();
		// Création Demande
		Demande O=new Demande();
		Set<Demande> SeteO = new TreeSet<Demande>();
		
		// Ajout Demande
		 I.setDemandes(SeteO);
		 ArrayList<Demande> Sete1 = new ArrayList<Demande>(SeteO);
		 
		 assertEquals(Sete1, I.getOffresRecuesList());
	}

	@Test
	public void testSetOffresEmises() {
		InscriptionBean I = new InscriptionBean();
		// Création Offre
		Offre O=new Offre();
		Set<Offre> SeteO = new TreeSet<Offre>();

		// Ajout Offre
		 I.setOffresEmises(SeteO);
		 Set <Offre> Sete1 = I.getOffresEmises();
		 
		 assertEquals(SeteO, Sete1);
	}

	@Test
	public void testSetOffresRecues() {
		InscriptionBean I = new InscriptionBean();
		// Création Offre
		Offre O=new Offre();
		Set<Offre> SeteO = new TreeSet<Offre>();

		// Ajout Offre
		 I.setOffresRecues(SeteO);
		 Set <Offre> Sete1 = I.getOffresRecues();
		 
		 assertEquals(SeteO, Sete1);
	}

	@Test
	public void testAddOffreEmises() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddOffreRecues() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveOffreEmise() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveOffreRecue() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTypePersonne() {
		InscriptionBean I = new InscriptionBean();
		TypePersonne T = new TypePersonne();
		I.setTypePersonne(T); 
	
		assertEquals(T, I.getTypePersonne());
	}

	@Test
	public void testSetTypePersonne() {
		InscriptionBean I = new InscriptionBean();
		TypePersonne T = new TypePersonne();
		I.setTypePersonne(T); 
	
		assertEquals(T, I.getTypePersonne());
	}

}
