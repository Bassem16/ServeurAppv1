package fr.dauphine.bank.beanstests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;

import fr.dauphine.bank.beans.ConnexionBean;
import fr.dauphine.bank.ejb.ServiceConnexion;
import fr.dauphine.bank.ejb.ServiceSauvegarde;
import fr.dauphine.bank.entities.Demande;
import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;
import fr.dauphine.bank.entities.TypePersonne;


public class ConnexionBeanTest {

	private ConnexionBean connexionBean;
	private ServiceConnexion serviceConnexion;
	private HttpSession hs;
	private Personne personne;
	private FacesContext fc;

	public static final String INV = "inv";
	public static final String ENT = "ent";
	public static final String ADMIN = "admin";

	public static final String BASSEM = "Bassem";
	public static final String NICOLAS = "Nicolas";

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		hs = Mockito.mock(HttpSession.class);
		fc = Mockito.mock(FacesContext.class);
		connexionBean = Mockito.spy(new ConnexionBean());
		serviceConnexion = Mockito.mock(ServiceConnexion.class);
		Mockito.mock(ServiceSauvegarde.class);

		personne = new Personne();

		connexionBean.setServiceConnexion(serviceConnexion);
		connexionBean.setPersonne(personne);
		Mockito.doReturn(hs).when(connexionBean).getSession();
		Mockito.doReturn(fc).when(connexionBean).getFacesContext();
	}

	@Test
	public void testDoLogin() {
		// Givev
		Personne p1 = new Personne();
		TypePersonne tp1 = new TypePersonne();
		tp1.setIdTypePersonne(1);
		p1.setTypePersonne(tp1);

		Personne p2 = new Personne();
		TypePersonne tp2 = new TypePersonne();
		tp2.setIdTypePersonne(2);
		p2.setTypePersonne(tp2);

		Personne p3 = new Personne();
		TypePersonne tp3 = new TypePersonne();
		tp3.setIdTypePersonne(3);
		p3.setTypePersonne(tp3);

		Personne p4 = new Personne();
		TypePersonne tp4 = new TypePersonne();
		tp4.setIdTypePersonne(4);
		p4.setTypePersonne(tp4);

		Mockito.when(serviceConnexion.verificationPersonne(INV, INV))
				.thenReturn(p1);
		Mockito.when(serviceConnexion.verificationPersonne(ENT, ENT))
				.thenReturn(p2);
		Mockito.when(serviceConnexion.verificationPersonne(ADMIN, ADMIN))
				.thenReturn(p3);
		Mockito.when(serviceConnexion.verificationPersonne("aucun", "aucun"))
				.thenReturn(p4);

		connexionBean.setLogin(INV);
		connexionBean.setMotDePasse(INV);
		String a = connexionBean.doLogin();
		assertEquals("/Investisseur/home.xhtml?faces-redirect=true", a);

		connexionBean.setLogin(ENT);
		connexionBean.setMotDePasse(ENT);
		a = connexionBean.doLogin();
		assertEquals(
				"/MembreEntreprise/homeMembreEntreprise.xhtml?faces-redirect=true",
				a);

		connexionBean.setLogin(ADMIN);
		connexionBean.setMotDePasse(ADMIN);
		a = connexionBean.doLogin();
		assertEquals(
				"/Administrateur/homeAdministrateur.xhtml?faces-redirect=true",
				a);

		connexionBean.setLogin("aucun");
		connexionBean.setMotDePasse("aucun");
		a = connexionBean.doLogin();
		assertEquals("Visiteur/login.xhtml", a);

		connexionBean.setLogin("test");
		connexionBean.setMotDePasse("test");
		a = connexionBean.doLogin();
		assertEquals("Visiteur/login.xhtml", a);

	}

	@Test
	public void testConnexionBean() {
		ConnexionBean con = new ConnexionBean();
		assertNotNull(con);
		assertNotNull(con.getPersonne());
	}

	@Test
	public void testIsConnected() {

		Mockito.doReturn(new Personne()).when(hs).getAttribute("personne");
		assertTrue("Connecté", connexionBean.isConnected());

		Mockito.doReturn(null).when(hs).getAttribute("personne");
		assertTrue("Déconnecté", !connexionBean.isConnected());

	}

	@Test
	public void testDoLogout() {
		assertEquals("/index.xhtml", connexionBean.doLogout());
	}

	@Test
	public void testGetPersonne() {
		assertSame(personne, connexionBean.getPersonne());
	}

	@Test
	public void testGetIdPersonne() {
		personne.setIdPersonne(1);
		assertEquals(connexionBean.getIdPersonne(), 1);

	}

	@Test
	public void testSetIdPersonne() {
		connexionBean.setIdPersonne(2);
		assertEquals(connexionBean.getIdPersonne(), 2);
	}

	@Test
	public void testGetEmail() {
		personne.setEmail("a@ab");
		assertEquals(connexionBean.getEmail(), "a@ab");
	}

	@Test
	public void testSetEmail() {
		connexionBean.setEmail("a@a");
		assertEquals(connexionBean.getEmail(), "a@a");
	}

	@Test
	public void testGetLogin() {
		personne.setLogin(BASSEM);
		assertEquals(connexionBean.getLogin(), BASSEM);
	}

	@Test
	public void testSetLogin() {
		connexionBean.setLogin(NICOLAS);
		assertEquals(connexionBean.getLogin(), NICOLAS);
	}

	@Test
	public void testGetMotDePasse() {
		personne.setMotDePasse(BASSEM);
		assertEquals(connexionBean.getMotDePasse(), BASSEM);
	}

	@Test
	public void testSetMotDePasse() {
		connexionBean.setMotDePasse(NICOLAS);
		assertEquals(connexionBean.getMotDePasse(), NICOLAS);
	}

	@Test
	public void testGetNomPersonne() {
		personne.setNomPersonne(NICOLAS);
		assertEquals(connexionBean.getNomPersonne(), NICOLAS);
	}

	@Test
	public void testSetNomPersonne() {
		connexionBean.setNomPersonne(BASSEM);
		assertEquals(connexionBean.getNomPersonne(), BASSEM);
	}

	@Test
	public void testGetPrenomPersonne() {
		personne.setPrenomPersonne(BASSEM);
		assertEquals(connexionBean.getPrenomPersonne(), BASSEM);
	}

	@Test
	public void testSetPrenomPersonne() {
		connexionBean.setPrenomPersonne(NICOLAS);
		assertEquals(connexionBean.getPrenomPersonne(), NICOLAS);
	}

	@Test
	public void testGetEntreprises() {
		Entreprise e = new Entreprise();
		personne.setEntreprise(e);
		assertSame(connexionBean.getEntreprises(), e);

	}

	@Test
	public void testSetEntreprise() {
		Entreprise entreprise = new Entreprise();
		connexionBean.setEntreprise(entreprise);
		assertSame(connexionBean.getEntreprises(), entreprise);
	}

	@Test
	public void testGetDemandes() {
		Set<Demande> demandes = new HashSet<Demande>();
		Demande d = new Demande();
		demandes.add(d);
		personne.setDemandes(demandes);

		assertSame(connexionBean.getDemandes(), demandes);

	}

	@Test
	public void testSetDemandes() {
		Set<Demande> demandes = new HashSet<Demande>();
		Demande d = new Demande();
		demandes.add(d);
		connexionBean.setDemandes(demandes);

		assertSame(connexionBean.getDemandes(), demandes);
	}

	@Test
	public void testGetTitres() {
		Set<Titre> titres = new HashSet<Titre>();
		Titre t = new Titre();
		titres.add(t);
		personne.setTitres(titres);

		assertSame(connexionBean.getTitres(), titres);
	}

	@Test
	public void testSetTitres() {
		Set<Titre> titres = new HashSet<Titre>();
		Titre t = new Titre();
		titres.add(t);
		connexionBean.setTitres(titres);

		assertSame(connexionBean.getTitres(), titres);
	}

	@Test
	public void testGetOffresEmises() {
		Set<Offre> offres = new HashSet<Offre>();
		Offre o = new Offre();
		offres.add(o);
		personne.setOffresEmises(offres);

		assertSame(connexionBean.getOffresEmises(), offres);
	}

	@Test
	public void testGetOffresRecues() {
		Set<Offre> offres = new HashSet<Offre>();
		Offre o = new Offre();
		offres.add(o);
		personne.setOffresRecues(offres);

		assertSame(connexionBean.getOffresRecues(), offres);
	}

	@Test
	public void testGetOffresEmisesList() {
		Set<Offre> offres = new HashSet<Offre>();
		Offre o = new Offre();
		offres.add(o);
		connexionBean.setOffresEmises(offres);

		assertEquals(connexionBean.getOffresEmisesList().get(0), o);
	}

	@Test
	public void testGetOffresRecuesList() {
		Set<Offre> offres = new HashSet<Offre>();
		Offre o = new Offre();
		offres.add(o);
		connexionBean.setOffresRecues(offres);

		assertEquals(connexionBean.getOffresRecuesList().get(0), o);
	}

	@Test
	public void testSetOffresEmises() {
		Set<Offre> offres = new HashSet<Offre>();
		Offre o = new Offre();
		offres.add(o);
		connexionBean.setOffresEmises(offres);

		assertSame(connexionBean.getOffresEmises(), offres);
	}

	@Test
	public void testSetOffresRecues() {
		Set<Offre> offres = new HashSet<Offre>();
		Offre o = new Offre();
		offres.add(o);
		connexionBean.setOffresRecues(offres);

		assertSame(connexionBean.getOffresRecues(), offres);
	}

	@Test
	public void testGetTypePersonne() {
		TypePersonne typ = new TypePersonne();
		personne.setTypePersonne(typ);

		assertEquals(connexionBean.getTypePersonne(), typ);
	}

	@Test
	public void testSetTypePersonne() {
		TypePersonne typ = new TypePersonne();
		connexionBean.setTypePersonne(typ);

		assertEquals(connexionBean.getTypePersonne(), typ);
	}

	@Test
	public void testGetSoldePersonne() {
		personne.setSoldePersonne(1.02);
		assertEquals(connexionBean.getSoldePersonne(), 1.02, 0.0001);
	}

	@Test
	public void testSetSoldePersonne() {
		connexionBean.setSoldePersonne(1.02);
		assertEquals(connexionBean.getSoldePersonne(), 1.02, 0.0001);
	}

	@Test
	public void testGetTitresList() {
		Set<Titre> titres = new HashSet<Titre>();
		Titre t = new Titre();
		titres.add(t);
		personne.setTitres(titres);

		assertSame(connexionBean.getTitresList().get(0), t);
	}

	@Test
	public void testGetDemandesList() {
		Set<Demande> demandes = new HashSet<Demande>();
		Demande d = new Demande();
		demandes.add(d);
		personne.setDemandes(demandes);

		assertSame(connexionBean.getDemandesList().get(0), d);
	}
	
	@Test
	public void testgetSession() {
		assertSame(connexionBean.getSession(),hs);
	}
	
	@Test
	public void testgetFacesContext() {
		assertSame(connexionBean.getFacesContext(),fc);
	}

}
