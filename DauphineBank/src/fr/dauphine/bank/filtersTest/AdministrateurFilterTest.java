package fr.dauphine.bank.filtersTest;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import fr.dauphine.bank.filters.AdministrateurFilter;

public class AdministrateurFilterTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDestroy() {
		// NO
	}

	@Test
	public void testDoFilter() throws IOException, ServletException {
//	
//		ServletRequest req =Mockito.mock(ServletRequest.class, Mockito.withSettings().extraInterfaces(HttpServletRequest.class));
//		ServletResponse res = Mockito.mock(ServletResponse.class,Mockito.withSettings().extraInterfaces(HttpServletResponse.class));
//		FilterChain chain = Mockito.mock(FilterChain.class);
//		HttpSession hs = Mockito.mock(HttpSession.class);
//		
//		//Mockito.when(req.getR);)
//		AdministrateurFilter filtre = new AdministrateurFilter();
//		filtre.doFilter(req,res,chain);
		
	}

	@Test
	public void testInit() {
		// NO
	}

}
