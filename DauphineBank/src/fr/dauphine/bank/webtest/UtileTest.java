package fr.dauphine.bank.webtest;

import static org.junit.Assert.*;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import fr.dauphine.bank.web.Utile;

public class UtileTest {

	@Test
	public void testGetSession() {
		HttpSession h =  (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		assertSame(Utile.getSession(),h);
	}

	@Test
	public void testGetRequest() {
		fail("Not yet implemented");
	}

}
