package fr.dauphine.bank.beanstests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;

import fr.dauphine.bank.beans.GestionAdministrateurBean;
import fr.dauphine.bank.ejb.ServiceAdministrateur;
import fr.dauphine.bank.ejb.ServiceSauvegarde;
import fr.dauphine.bank.ejb.ServiceVerificationData;
import fr.dauphine.bank.entities.Demande;
import fr.dauphine.bank.entities.DemandeHistorique;
import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.TypePersonne;
import fr.dauphine.bank.web.Utile;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Utile.class)
public class GestionAdministrateurBeanTest {

	private ServiceAdministrateur serviceAdministrateur;
	private ServiceVerificationData serviceVerificationData;
	private ServiceSauvegarde serviceSauvegarde;
	private HttpSession hs;

	GestionAdministrateurBean gestionAdministrateurBean;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		PowerMockito.mockStatic(Utile.class);
		hs = Mockito.mock(HttpSession.class);

		Personne p1 = new Personne();
		TypePersonne tp1 = new TypePersonne();
		tp1.setIdTypePersonne(3);
		p1.setTypePersonne(tp1);

		Entreprise e1 = new Entreprise();

		Mockito.when(Utile.getSession()).thenReturn(hs);
		Mockito.when(hs.getAttribute("personne")).thenReturn(p1);
		Mockito.when(hs.getAttribute("entreprise")).thenReturn(e1);

		serviceAdministrateur = Mockito.mock(ServiceAdministrateur.class);
		serviceVerificationData = Mockito.mock(ServiceVerificationData.class);
		serviceSauvegarde = Mockito.mock(ServiceSauvegarde.class);

		
		gestionAdministrateurBean = new GestionAdministrateurBean();

		gestionAdministrateurBean
				.setServiceAdministrateur(serviceAdministrateur);
		gestionAdministrateurBean.setServiceSauvegarde(serviceSauvegarde);
		gestionAdministrateurBean
				.setServiceVerificationData(serviceVerificationData);

	}

	@Test
	public void testGestionAdministrateurBean() {

		gestionAdministrateurBean = new GestionAdministrateurBean();
		assertNotNull(gestionAdministrateurBean);

	}

	@Test
	public void testGetDemandes() {
		List<Demande> demandes = new ArrayList<Demande>();
		Mockito.when(serviceAdministrateur.listeDemandes())
				.thenReturn(demandes);
		assertSame(demandes, gestionAdministrateurBean.getDemandes());
	}

	@Test
	public void testGetEntreprises() {
		List<Entreprise> entreprises = new ArrayList<Entreprise>();
		Mockito.when(serviceAdministrateur.listeEntreprise()).thenReturn(
				entreprises);
		assertSame(entreprises, gestionAdministrateurBean.getEntreprises());
	}

	@Test
	public void testGetMembresSociete() {
		List<Personne> personnes = new ArrayList<Personne>();
		Mockito.when(serviceAdministrateur.listeMembresSociete()).thenReturn(
				personnes);
		assertSame(personnes, gestionAdministrateurBean.getMembresSociete());
	}

	@Test
	public void testGetDemandesHistorique() {
		List<DemandeHistorique> demandeHistoriques = new ArrayList<DemandeHistorique>();
		Mockito.when(serviceAdministrateur.listeDemandesHistorique())
				.thenReturn(demandeHistoriques);
		assertSame(demandeHistoriques,
				gestionAdministrateurBean.getDemandesHistorique());
	}

	@Test
	public void testPasserOffreADemande() {
		Demande d = new Demande();

		d.setDateDemande(new Date(System.currentTimeMillis()));
		d.setDescriptifDemande("aaa");
		d.setStatutDemande("Traite");
		d.setPersonne(new Personne());

		gestionAdministrateurBean.passerOffreADemande(d);

		Mockito.verify(serviceAdministrateur).supprimerDemande(d);
		Mockito.verify(serviceSauvegarde).sauvgarderDemandeHistorique(
				(DemandeHistorique) Mockito.any());
	}

	@Test
	public void testValiderDemandePersonne() {
		Demande d = new Demande();

		d.setDateDemande(new Date(System.currentTimeMillis()));
		d.setDescriptifDemande("aaa");
		d.setStatutDemande("Traite");
		d.setPersonne(new Personne());

		gestionAdministrateurBean.validerDemandePersonne(d);

	}

	@Test
	public void testSupprimerDemandePersonne() {
		Demande d = new Demande();
		gestionAdministrateurBean.supprimerDemandePersonne(d);
	}

	@Test
	public void testAjouterEntreprise() {
		gestionAdministrateurBean.ajouterEntreprise();
		Mockito.verify(serviceSauvegarde).sauvgarderEntreprise(
				gestionAdministrateurBean.getEntreprise());
	}

	@Test
	public void testAjouterMembreEntreprise() {
		gestionAdministrateurBean.ajouterMembreEntreprise();
		Mockito.verify(serviceSauvegarde).sauvegardeCompteEntreprise(
				gestionAdministrateurBean.getPersonneEntreprise());
	}

	@Test
	public void testGetPersonne() {

		assertNotNull(gestionAdministrateurBean.getPersonne());
	}

	@Test
	public void testGetSetIdPersonne() {
		gestionAdministrateurBean.setIdPersonne(11);
		assertEquals(gestionAdministrateurBean.getIdPersonne(), 11);
	}

	@Test
	public void testGetSetEmail() {
		gestionAdministrateurBean.setEmail("a@a");
		assertEquals(gestionAdministrateurBean.getEmail(), "a@a");
	}

	@Test
	public void testGetSetLogin() {
		gestionAdministrateurBean.setLogin("Bassem16");
		assertEquals(gestionAdministrateurBean.getLogin(), "Bassem16");
	}

	@Test
	public void testGetSetMotDePasse() {
		gestionAdministrateurBean.setMotDePasse("123456");
		assertEquals(gestionAdministrateurBean.getMotDePasse(), "123456");
	}

	@Test
	public void testGetSetNomPersonne() {
		gestionAdministrateurBean.setNomPersonne("Nicolas");
		assertEquals(gestionAdministrateurBean.getNomPersonne(), "Nicolas");
	}

	@Test
	public void testGetSetPrenomPersonne() {
		gestionAdministrateurBean.setPrenomPersonne("Alexis");
		assertEquals(gestionAdministrateurBean.getPrenomPersonne(), "Alexis");
	}

	@Test
	public void testSetEntreprise() {
		Entreprise e = new Entreprise();
		gestionAdministrateurBean.setEntreprise(e);
		assertSame(gestionAdministrateurBean.getPersonne().getEntreprise(), e);
	}

	@Test
	public void testGetEntreprise() {
		Entreprise e = new Entreprise();
		gestionAdministrateurBean.setEntrepriseTHIS(e);
		assertSame(gestionAdministrateurBean.getEntreprise(), e);
	}

	@Test
	public void testSetDemandes() {
		Set<Demande> demandes = new HashSet<Demande>();
		gestionAdministrateurBean.setDemandes(demandes);
		assertEquals(gestionAdministrateurBean.getPersonne().getDemandes(),
				demandes);
	}

	@Test
	public void testGetSetNomEntreprise() {
		gestionAdministrateurBean.setNomEntreprise("BNP");
		assertEquals(gestionAdministrateurBean.getNomEntreprise(), "BNP");
	}

	@Test
	public void testGetSetSecteurEntreprise() {
		gestionAdministrateurBean.setSecteurEntreprise("Banque");
		assertEquals(gestionAdministrateurBean.getSecteurEntreprise(), "Banque");
	}

	@Test
	public void testGetSetNombreTitreTotal() {
		gestionAdministrateurBean.setNombreTitreTotal(11);
		assertEquals(gestionAdministrateurBean.getNombreTitreTotal(), 11);
	}

	@Test
	public void testGetSetLogoEntreprise() {
		gestionAdministrateurBean.setLogoEntreprise("www.wiki.com");
		assertEquals(gestionAdministrateurBean.getLogoEntreprise(),
				"www.wiki.com");
	}

	@Test
	public void testSetIdPersonneEntreprise() {
		gestionAdministrateurBean.setIdPersonneEntreprise(9523);
		assertEquals(9523, gestionAdministrateurBean.getPersonne()
				.getIdPersonne());
	}

	@Test
	public void testGetSetEmailEntreprise() {
		gestionAdministrateurBean.setEmailEntreprise("nn@bnp.com");
		assertEquals(gestionAdministrateurBean.getEmailEntreprise(),
				"nn@bnp.com");
	}

	@Test
	public void testGetSetLoginEntreprise() {
		gestionAdministrateurBean.setLoginEntreprise("BNPLOGIN");
		assertEquals(gestionAdministrateurBean.getLoginEntreprise(), "BNPLOGIN");
	}

	@Test
	public void testGetSetMotDePasseEntreprise() {
		gestionAdministrateurBean.setMotDePasseEntreprise("bnp123");
		assertEquals(gestionAdministrateurBean.getMotDePasseEntreprise(),
				"bnp123");
	}

	@Test
	public void testGetNomPersonneEntreprise() {
		gestionAdministrateurBean.setNomPersonneEntreprise("PAPA");
		assertEquals(gestionAdministrateurBean.getPersonneEntreprise()
				.getNomPersonne(), "PAPA");
	}

	@Test
	public void testSetNomPersonneEntreprise() {
		gestionAdministrateurBean.setNomPersonneEntreprise("BNP PARIBAS");
		assertEquals(gestionAdministrateurBean.getPersonneEntreprise()
				.getNomPersonne(), "BNP PARIBAS");
	}

	@Test
	public void testGetPrenomPersonneEntreprise() {
		gestionAdministrateurBean.setPrenomPersonneEntreprise("Francois");
		assertEquals(gestionAdministrateurBean.getPrenomPersonneEntreprise(),
				"Francois");
	}

}
