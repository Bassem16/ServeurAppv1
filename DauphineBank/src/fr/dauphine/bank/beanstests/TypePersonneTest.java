package fr.dauphine.bank.beanstests;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import fr.dauphine.bank.entities.Demande;
import fr.dauphine.bank.entities.OffreHistorique;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;
import fr.dauphine.bank.entities.TypePersonne;

public class TypePersonneTest {

	@Test
	public void testTypePersonne() {
		TypePersonne t =new TypePersonne();
		assertNotNull(t);
	}

	@Test
	public void testGetIdTypePersonne() {
		TypePersonne t =new TypePersonne();
		t.setIdTypePersonne(1);
		assertEquals(1,t.getIdTypePersonne());
	}

	@Test
	public void testSetIdTypePersonne() {
		TypePersonne t =new TypePersonne();
		t.setIdTypePersonne(1);
		assertEquals(1,t.getIdTypePersonne());
	}

	@Test
	public void testGetTypePersonne() {
		TypePersonne t =new TypePersonne();
		t.setTypePersonne("TEST");
		assertEquals("TEST",t.getTypePersonne());
	}

	@Test
	public void testSetTypePersonne() {
		TypePersonne t =new TypePersonne();
		t.setTypePersonne("TEST");
		assertEquals("TEST",t.getTypePersonne());
	}

	@Test
	public void testGetPersonnes() {
		TypePersonne T =new TypePersonne();
		// Création Offre
		Personne O=new Personne();
		Set<Personne> SeteO = new TreeSet<Personne>();
		
		// Ajout Offre
		 T.setPersonnes(SeteO);
		 Set <Personne> Sete1 = T.getPersonnes();
		 
		 assertEquals(SeteO, Sete1);
	}

	@Test
	public void testSetPersonnes() {
		TypePersonne T =new TypePersonne();
		// Création Offre
		Personne O=new Personne();
		Set<Personne> SeteO = new TreeSet<Personne>();
		
		// Ajout Offre
		 T.setPersonnes(SeteO);
		 Set <Personne> Sete1 = T.getPersonnes();
		 
		 assertEquals(SeteO, Sete1);
	}

	@Test
	public void testAddPersonne() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemovePersonne() {
		fail("Not yet implemented");
	}

}
