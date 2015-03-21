package fr.dauphine.bank.beanstests;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import fr.dauphine.bank.entities.Personne;
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
		TypePersonne t =new TypePersonne();
		Set<Personne> seteO = new TreeSet<Personne>();
		
		// Ajout Offre
		 t.setPersonnes(seteO);
		 Set <Personne> sete1 = t.getPersonnes();
		 
		 assertEquals(seteO, sete1);
	}

	@Test
	public void testSetPersonnes() {
		TypePersonne t =new TypePersonne();
		Set<Personne> seteO = new TreeSet<Personne>();
		
		// Ajout Offre
		 t.setPersonnes(seteO);
		 Set <Personne> sete1 = t.getPersonnes();
		 
		 assertEquals(seteO, sete1);
	}



}
