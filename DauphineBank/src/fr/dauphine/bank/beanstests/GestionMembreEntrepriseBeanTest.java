package fr.dauphine.bank.beanstests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import fr.dauphine.bank.beans.GestionAdministrateurBean;
import fr.dauphine.bank.beans.GestionMembreEntrepriseBean;
import fr.dauphine.bank.ejb.ServiceAdministrateur;
import fr.dauphine.bank.ejb.ServiceMembreEntreprise;
import fr.dauphine.bank.ejb.ServiceSauvegarde;
import fr.dauphine.bank.ejb.ServiceVerificationData;
import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Information;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.TypePersonne;
import fr.dauphine.bank.web.Utile;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Utile.class)
public class GestionMembreEntrepriseBeanTest {

	private ServiceMembreEntreprise serviceMembreEntreprise;
	private ServiceVerificationData serviceVerificationData;
	private ServiceSauvegarde serviceSauvegarde;
	private HttpSession hs;

	GestionMembreEntrepriseBean g;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		PowerMockito.mockStatic(Utile.class);
		hs = Mockito.mock(HttpSession.class);

		serviceMembreEntreprise = Mockito.mock(ServiceMembreEntreprise.class);
		serviceVerificationData = Mockito.mock(ServiceVerificationData.class);
		serviceSauvegarde = Mockito.mock(ServiceSauvegarde.class);

		Personne p1 = new Personne();
		TypePersonne tp1 = new TypePersonne();
		tp1.setIdTypePersonne(2);
		p1.setTypePersonne(tp1);

		Entreprise e1 = new Entreprise();

		Mockito.when(Utile.getSession()).thenReturn(hs);
		Mockito.when(hs.getAttribute("personne")).thenReturn(p1);
		Mockito.when(hs.getAttribute("entreprise")).thenReturn(e1);

	}

	@Test
	public void testGestionMembreEntrepriseBean() {
		GestionMembreEntrepriseBean g = new GestionMembreEntrepriseBean();
	}

	@Test
	public void testGetInformations() {
		GestionMembreEntrepriseBean g1 = new GestionMembreEntrepriseBean();
		List<Information> informations = new ArrayList<Information>();
		Entreprise e = new Entreprise();

		e.setIdEntreprise(159);
		g1.setServiceMembreEntreprise(serviceMembreEntreprise);
		g1.setEntreprise(e);

		Mockito.when(
				serviceMembreEntreprise.listeInformations(g1.getEntreprise()
						.getIdEntreprise())).thenReturn(informations);

		assertSame(g1.getInformations(), informations);
		Mockito.verify(serviceMembreEntreprise).listeInformations(
				e.getIdEntreprise());

	}

	@Test
	public void testAjouterInformation() {
		GestionMembreEntrepriseBean g1 = new GestionMembreEntrepriseBean();
		Information i = new Information();
		Entreprise e = new Entreprise();

		g1.setServiceSauvegarde(serviceSauvegarde);
		g1.setInformation(i);
		g1.setEntreprise(e);

		g1.ajouterInformation();

		Mockito.verify(serviceSauvegarde).sauvgarderInformation(
				(Information) Mockito.any());
	}

	@Test
	public void testGetInformation() {
		GestionMembreEntrepriseBean g1 = new GestionMembreEntrepriseBean();
		Information i = new Information();

		g1.setInformation(i);
		assertSame(i, g1.getInformation());
	}

	@Test
	public void testGetSetIdInformation() {
		GestionMembreEntrepriseBean g1 = new GestionMembreEntrepriseBean();
		Information i = new Information();
		g1.setInformation(i);
		g1.setIdInformation(142);
		assertEquals(142, g1.getIdInformation());
	}

	@Test
	public void testGetSetTypeInformation() {
		GestionMembreEntrepriseBean g1 = new GestionMembreEntrepriseBean();
		Information i = new Information();
		g1.setInformation(i);
		g1.setTypeInformation("Management");

		assertEquals("Management", g1.getTypeInformation());
	}

	@Test
	public void testGetSetTexteInformation() {
		GestionMembreEntrepriseBean g1 = new GestionMembreEntrepriseBean();
		Information i = new Information();
		g1.setInformation(i);
		g1.setTexteInformation("L'inforamtion en continue!");

		assertEquals("L'inforamtion en continue!", g1.getTexteInformation());
	}

	@Test
	public void testGetSetDateInformation() {
		GestionMembreEntrepriseBean g1 = new GestionMembreEntrepriseBean();
		Information i = new Information();
		Date d = new Date(System.currentTimeMillis());
		g1.setInformation(i);
		g1.setDateInformation(d);

		assertEquals(d, g1.getDateInformation());
	}

	@Test
	public void testGetSetEntreprise() {
		GestionMembreEntrepriseBean g1 = new GestionMembreEntrepriseBean();
		Entreprise e = new Entreprise();
		g1.setEntreprise(e);

		assertSame(e, g1.getEntreprise());
	}

	@Test
	public void testGetSetNomEntreprise() {
		GestionMembreEntrepriseBean g1 = new GestionMembreEntrepriseBean();
		Entreprise e = new Entreprise();

		g1.setEntreprise(e);
		g1.setNomEntreprise("BNP");

		assertEquals("BNP", g1.getNomEntreprise());
	}

	@Test
	public void testGetSetSecteurEntreprise() {
		GestionMembreEntrepriseBean g1 = new GestionMembreEntrepriseBean();
		Entreprise e = new Entreprise();

		g1.setEntreprise(e);
		g1.setSecteurEntreprise("Banque");

		assertEquals("Banque", g1.getSecteurEntreprise());
	}

	@Test
	public void testGetSetNombreTitreTotal() {
		GestionMembreEntrepriseBean g1 = new GestionMembreEntrepriseBean();
		Entreprise e = new Entreprise();

		g1.setEntreprise(e);
		g1.setNombreTitreTotal(1200);

		assertEquals(1200, g1.getNombreTitreTotal());
	}
	
	@Test
	public void testSetServiceVerificationData() {
		GestionMembreEntrepriseBean g1 = new GestionMembreEntrepriseBean();
		g1.setServiceVerificationData(serviceVerificationData);

		
	}

}
