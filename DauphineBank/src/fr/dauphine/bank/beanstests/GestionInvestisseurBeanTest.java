package fr.dauphine.bank.beanstests;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.dauphine.bank.beans.GestionInvestisseurBean;
import fr.dauphine.bank.beans.InscriptionBean;
import fr.dauphine.bank.entities.Personne;

public class GestionInvestisseurBeanTest {

	@Test
	public void testGestionInvestisseurBean() {
		GestionInvestisseurBean G = new GestionInvestisseurBean();
		assertNotNull(G);
	}

	@Test
	public void testInit() {
		fail("Not yet implemented");
	}

	@Test
	public void testRechercherTitre() {
		fail("Not yet implemented");
	}

	@Test
	public void testListEntreprise() {
		fail("Not yet implemented");
	}

	@Test
	public void testOffreAHistorique() {
		fail("Not yet implemented");
	}

	@Test
	public void testCloturerOffre() {
		fail("Not yet implemented");
	}

	@Test
	public void testMettreSurMarcherTitre() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetirerDuMarcherTitre() {
		fail("Not yet implemented");
	}

	@Test
	public void testPasserOffreAHistorique_Titre() {
		fail("Not yet implemented");
	}

	@Test
	public void testPasserOffreAHistorique_Offre() {
		fail("Not yet implemented");
	}

	@Test
	public void testAccepterOffre() {
		fail("Not yet implemented");
	}

	@Test
	public void testRefuserOffre() {
		fail("Not yet implemented");
	}

	@Test
	public void testEstVente() {
		fail("Not yet implemented");
	}

	@Test
	public void testRechercherTitreString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPersonne() {
		GestionInvestisseurBean G = new GestionInvestisseurBean();
		Personne p = new Personne();
		G.getPersonne() ; 
		G.setIdPersonne(1); 
		
		assertEquals(1, G.getPersonne().getIdPersonne());
	}

	@Test
	public void testGetIdPersonne() {
		GestionInvestisseurBean G = new GestionInvestisseurBean();
		G.setIdPersonne(1); 
		
		assertEquals(1, G.getPersonne().getIdPersonne());
	}

	@Test
	public void testSetIdPersonne() {
		GestionInvestisseurBean G = new GestionInvestisseurBean();
		G.setIdPersonne(1); 
		
		assertEquals(1, G.getPersonne().getIdPersonne());
	}

	@Test
	public void testGetEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMotDePasse() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMotDePasse() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNomPersonne() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNomPersonne() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPrenomPersonne() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPrenomPersonne() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEntreprises() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEntreprise() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDemandes() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDemandes() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

	@Test
	public void testSetTitres() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOffresEmises() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOffresRecues() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOffresEmisesList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOffresRecuesList() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetOffresEmises() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetOffresRecues() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

	@Test
	public void testSetTypePersonne() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOffresList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTitresList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDemandesList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOffreHistoriquesEmisesList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOffreHistoriquesRecuesList() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEntrepriseChek() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEntrepriseChek() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsTypeCheck() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTypeCheck() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEntrepriseNom() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEntrepriseNom() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTypeNom() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTypeNom() {
		fail("Not yet implemented");
	}

}
