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

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;

import fr.dauphine.bank.beans.ConnexionBean;
import fr.dauphine.bank.beans.GestionAdministrateurBean;
import fr.dauphine.bank.beans.GestionInvestisseurBean;
import fr.dauphine.bank.ejb.ServiceAdministrateur;
import fr.dauphine.bank.ejb.ServiceSauvegarde;
import fr.dauphine.bank.ejb.ServiceVerificationData;
import fr.dauphine.bank.entities.Demande;
import fr.dauphine.bank.entities.DemandeHistorique;
import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.OffreHistorique;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;
import fr.dauphine.bank.entities.TypePersonne;
import fr.dauphine.bank.web.Utile;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Utile.class)
public class GestionInvestisseurBeanTest {

	private ConnexionBean connexionBean;
//	private ServiceConnexion serviceConnexion;
	
	private ServiceSauvegarde serviceSauvegarde;
	private HttpSession hs;
	private Personne personne ;
	private FacesContext fc;

	public static final String INV = "inv";
	public static final String ENT = "ent";
	public static final String ADMIN = "admin";

	public static final String BASSEM = "Bassem";
	public static final String NICOLAS = "Nicolas";
	
	//***************
	private GestionInvestisseurBean gestionInvestisseurBean;
	
	private static final long serialVersionUID = 1L;
	private static final String ACTION="Action";
	private static final String REFUSEE="Refusée";
	private static final String ACCEPTEE="Acceptée";
	
	// private Personne personne = null;
	private Personne personneVisite = null;

	private boolean entrepriseChek = false;
	private boolean typeCheck = false;
	private boolean userCheck = false;

	private String entrepriseNom = null;
	private String typeNom = null;
	private String userNom = null;

	private String typeTitreTransaction = null;
	private String nomTitreTransaction = null;

	private int quantiteOffre = 0;
	private double prixOffre = 0;

	private boolean entrepriseCheckRecherche = false;
	private boolean domaineChek = false;

	private String entrepriseCheckRechercheName = null;
	private String domaineChekName = null;

	private Entreprise ficheEntreprise = null;
	//************
	
	
	private ServiceAdministrateur serviceAdministrateur;
	private ServiceVerificationData serviceVerificationData;


	GestionAdministrateurBean gestionAdministrateurBean;

	private Personne personneEntreprise;
	private Entreprise entreprise;
	
	
	//************
	
/*	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		PowerMockito.mockStatic(Utile.class);
		hs = Mockito.mock(HttpSession.class);
		fc = Mockito.mock(FacesContext.class);
		connexionBean = Mockito.spy(new ConnexionBean());
		serviceConnexion = Mockito.mock(ServiceConnexion.class);//*
//		serviceSauvegarde = Mockito.mock(ServiceSauvegarde.class);//*

//		personne = new Personne();

		connexionBean.setServiceConnexion(serviceConnexion);
		connexionBean.setPersonne(personne);
//		Mockito.doReturn(hs).when(connexionBean).getSession();
		Mockito.doReturn(fc).when(connexionBean).getFacesContext();
		
		
		//**********
//		gestionInvestisseurBean = Mockito.spy(new GestionInvestisseurBean());
//		personne = (Personne) hs.getAttribute("personne");
		
		//***********
		
		Personne p1 = new Personne();
		TypePersonne tp1 = new TypePersonne();
		tp1.setIdTypePersonne(3);
		p1.setTypePersonne(tp1);

		Entreprise e1 = new Entreprise();

		Mockito.when(Utile.getSession()).thenReturn(hs);
		Mockito.when(hs.getAttribute("personne")).thenReturn(p1);
		Mockito.when(hs.getAttribute("entreprise")).thenReturn(e1);

		personne = new Personne();
		personneEntreprise = new Personne();
		entreprise = new Entreprise();
		gestionInvestisseurBean = new GestionInvestisseurBean();		
		
	}
	
	/*@Before
	public void init() {
		HttpSession hs = Utile.getSession();
		personne = (Personne) hs.getAttribute("personne");
		setEntrepriseNom("Accenture");
		setTypeNom(ACTION);
		setTypeTitreTransaction(ACTION);

		setEntrepriseCheckRechercheName("");

	}*/
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		PowerMockito.mockStatic(Utile.class);
		hs = Mockito.mock(HttpSession.class);
		connexionBean = Mockito.spy(new ConnexionBean());

		Personne p1 = new Personne();
		TypePersonne tp1 = new TypePersonne();
		tp1.setIdTypePersonne(3);
		p1.setTypePersonne(tp1);

		Entreprise e1 = new Entreprise();

		Mockito.when(Utile.getSession()).thenReturn(hs);
		Mockito.when(hs.getAttribute("personne")).thenReturn(p1);
		Mockito.when(hs.getAttribute("entreprise")).thenReturn(e1);


		personne = new Personne();
		personneEntreprise = new Personne();
		entreprise = new Entreprise();
		gestionInvestisseurBean = Mockito.spy(new GestionInvestisseurBean());
		gestionInvestisseurBean.init();
	}
	
	
	
	@Test
	public void testGestionInvestisseurBean() {
		GestionInvestisseurBean G = new GestionInvestisseurBean();
		assertNotNull(G);
	}

	@Test
	public void testInit() {
		gestionInvestisseurBean.init();
		
		ficheEntreprise = gestionInvestisseurBean.getEntreprises();
		assertEquals("ACCENTURE", ficheEntreprise.getNomEntreprise());
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
		Set<Titre> titres = new HashSet<Titre>();
		Titre t = new Titre();
		t.setIdTitre(1);
		titres.add(t);
		gestionInvestisseurBean.setTitres(titres);

		assertEquals(gestionInvestisseurBean.estVente(t), true);
	}

	@Test
	public void testRechercherTitreString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPersonne() {

		assertNotNull(gestionInvestisseurBean.getPersonne());
	}

	@Test
	public void testGetSetIdPersonne() {
		gestionInvestisseurBean.setIdPersonne(11);
		assertEquals(gestionInvestisseurBean.getIdPersonne(), 11);
	}

	@Test
	public void testGetSetEmail() {
		gestionInvestisseurBean.setEmail("a@ab");
		assertEquals(gestionInvestisseurBean.getEmail(), "a@ab");
	}

	@Test
	public void testGetSetLogin() {
		gestionInvestisseurBean.setLogin(NICOLAS);
		assertEquals(gestionInvestisseurBean.getLogin(), NICOLAS);
	}

	@Test
	public void testGetSetMotDePasse() {
		gestionInvestisseurBean.setMotDePasse(BASSEM);
		assertEquals(gestionInvestisseurBean.getMotDePasse(), BASSEM);
	}

	@Test
	public void testGetSetNomPersonne() {
		gestionInvestisseurBean.setNomPersonne("Nicolas");
		assertEquals(gestionInvestisseurBean.getNomPersonne(), "Nicolas");
	}

	@Test
	public void testGetSetPrenomPersonne() {
		gestionInvestisseurBean.setPrenomPersonne(BASSEM);
		assertEquals(gestionInvestisseurBean.getPrenomPersonne(), BASSEM);
	}

	@Test
	public void testGetSetEntreprises() {
		Entreprise e = new Entreprise();
		gestionInvestisseurBean.setEntreprise(e);
		assertSame(gestionInvestisseurBean.getEntreprises(), e);
	}

	@Test
	public void testGetSetDemandes() {
		Set<Demande> demandes = new HashSet<Demande>();
		Demande d = new Demande();
		demandes.add(d);
		gestionInvestisseurBean.setDemandes(demandes);

		assertSame(gestionInvestisseurBean.getDemandes(), demandes);
	}

	@Test
	public void testAddDemande() {
		Set<Demande> demandes = new HashSet<Demande>();
		Demande d = new Demande();
		demandes.add(d);
		gestionInvestisseurBean.setDemandes(demandes);
		Demande d2 = new Demande();
		demandes.add(d2);
		gestionInvestisseurBean.addDemande(d2);

		assertSame(gestionInvestisseurBean.getDemandes(), demandes);
	}

	@Test
	public void testRemoveDemande() {
		Set<Demande> demandes = new HashSet<Demande>();
		Demande d = new Demande();
		demandes.add(d);
		gestionInvestisseurBean.setDemandes(demandes);
		Demande d2 = new Demande();
		demandes.add(d2);
		gestionInvestisseurBean.addDemande(d2);
		demandes.remove(d2);
		gestionInvestisseurBean.removeDemande(d2);
		
		assertSame(gestionInvestisseurBean.getDemandes(), demandes);
	}

	@Test
	public void testGetTitres() {
		Set<Titre> titres = new HashSet<Titre>();
		Titre t = new Titre();
		titres.add(t);
		gestionInvestisseurBean.setTitres(titres);

		assertSame(gestionInvestisseurBean.getTitres(), titres);
	}

	@Test
	public void testSetTitres() {
		Set<Titre> titres = new HashSet<Titre>();
		Titre t = new Titre();
		titres.add(t);
		personne.setTitres(titres);

		assertSame(gestionInvestisseurBean.getTitres(), titres);
	}

	@Test
	public void testGetOffresEmises() {
		Set<Offre> offres = new HashSet<Offre>();
		Offre o = new Offre();
		offres.add(o);
		gestionInvestisseurBean.setOffresEmises(offres);

		assertSame(gestionInvestisseurBean.getOffresEmises(), offres);
	}

	@Test
	public void testGetOffresRecues() {
		Set<Offre> offres = new HashSet<Offre>();
		Offre o = new Offre();
		offres.add(o);
		gestionInvestisseurBean.setOffresRecues(offres);

		assertSame(gestionInvestisseurBean.getOffresRecues(), offres);
	}

	@Test
	public void testGetOffresEmisesList() {
		Set<Offre> offres = new HashSet<Offre>();
		Offre o = new Offre();
		offres.add(o);
		gestionInvestisseurBean.setOffresEmises(offres);

		assertEquals(gestionInvestisseurBean.getOffresEmisesList().get(0)
				, o);
	}

	@Test
	public void testGetOffresRecuesList() {
		Set<Offre> offres = new HashSet<Offre>();
		Offre o = new Offre();
		offres.add(o);
		gestionInvestisseurBean.setOffresRecues(offres);

		assertEquals(gestionInvestisseurBean.getOffresRecuesList().get(0), o);
	}

	@Test
	public void testSetOffresEmises() {
		Set<Offre> offres = new HashSet<Offre>();
		Offre o = new Offre();
		offres.add(o);
		gestionInvestisseurBean.setOffresEmises(offres);

		assertSame(gestionInvestisseurBean.getOffresEmises(), offres);
	}

	@Test
	public void testSetOffresRecues() {
		Set<Offre> offres = new HashSet<Offre>();
		Offre o = new Offre();
		offres.add(o);
		gestionInvestisseurBean.setOffresRecues(offres);

		assertSame(gestionInvestisseurBean.getOffresRecues(), offres);
	}

	@Test
	public void testAddOffreEmises() {
		Set<Offre> offres = new HashSet<Offre>();
		Offre o = new Offre();
		offres.add(o);
		gestionInvestisseurBean.setOffresEmises(offres);
		Offre o2 = new Offre();
		offres.add(o2);
		gestionInvestisseurBean.addOffreEmises(o2);
		
		assertSame(gestionInvestisseurBean.getOffresEmises(), offres);
	}

	@Test
	public void testAddOffreRecues() {
		Set<Offre> offres = new HashSet<Offre>();
		Offre o = new Offre();
		offres.add(o);
		gestionInvestisseurBean.setOffresRecues(offres);
		Offre o2 = new Offre();
		offres.add(o2);
		gestionInvestisseurBean.addOffreRecues(o2);

		assertSame(gestionInvestisseurBean.getOffresRecues(), offres);
	}

	@Test
	public void testRemoveOffreEmise() {
		Set<Offre> offres = new HashSet<Offre>();
		Offre o = new Offre();
		offres.add(o);
		gestionInvestisseurBean.setOffresEmises(offres);
		Offre o2 = new Offre();
		offres.add(o2);
		gestionInvestisseurBean.addOffreEmises(o2);
		offres.remove(o);
		gestionInvestisseurBean.removeOffreEmise(o);
		
		assertSame(gestionInvestisseurBean.getOffresEmises(), offres);
	}

	@Test
	public void testRemoveOffreRecue() {
		Set<Offre> offres = new HashSet<Offre>();
		Offre o = new Offre();
		offres.add(o);
		gestionInvestisseurBean.setOffresRecues(offres);
		Offre o2 = new Offre();
		offres.add(o2);
		gestionInvestisseurBean.addOffreRecues(o2);
		offres.remove(o);
		gestionInvestisseurBean.removeOffreRecue(o);

		assertSame(gestionInvestisseurBean.getOffresRecues(), offres);
	}

	@Test
	public void testGetSetTypePersonne() {
		TypePersonne typ = new TypePersonne();
		gestionInvestisseurBean.setTypePersonne(typ);

		assertEquals(gestionInvestisseurBean.getTypePersonne(), typ);
	}

	@Test
	public void testGetOffresList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTitresList() {
		Set<Titre> titres = new HashSet<Titre>();
		Titre t = new Titre();
		titres.add(t);
		gestionInvestisseurBean.setTitres(titres);

		assertSame(gestionInvestisseurBean.getTitresList().get(0), t);
	}

	@Test
	public void testGetDemandesList() {
		Set<Demande> demandes = new HashSet<Demande>();
		Demande d = new Demande();
		demandes.add(d);
		gestionInvestisseurBean.setDemandes(demandes);

		assertSame(gestionInvestisseurBean.getDemandesList().get(0), d);
	}

	@Test
	public void testGetOffreHistoriquesEmisesList() {
		Set<OffreHistorique> OffreHistoriques = new HashSet<OffreHistorique>();
		OffreHistorique O = new OffreHistorique();
		OffreHistoriques.add(O);
	//	gestionInvestisseurBean.setOffreHistoriques(OffreHistoriques);

		assertSame(gestionInvestisseurBean.getDemandesList().get(0), O);
	}

	@Test
	public void testGetOffreHistoriquesRecuesList() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetIsEntrepriseChek() {
		gestionInvestisseurBean.setEntrepriseChek(false);
		
		assertSame(gestionInvestisseurBean.isEntrepriseChek(), false);
	}

	@Test
	public void testSetIsTypeCheck() {
		gestionInvestisseurBean.setTypeCheck(false);
		
		assertSame(gestionInvestisseurBean.isTypeCheck(), false);	
	}

	@Test
	public void testGetSetEntrepriseNom() {
		gestionInvestisseurBean.setEntrepriseNom(BASSEM);
		
		assertSame(gestionInvestisseurBean.getEntrepriseNom(), BASSEM);
	}

	@Test
	public void testGetSetTypeNom() {
		gestionInvestisseurBean.setTypeNom(BASSEM);
		
		assertSame(gestionInvestisseurBean.getTypeNom(), BASSEM);
	}
}
