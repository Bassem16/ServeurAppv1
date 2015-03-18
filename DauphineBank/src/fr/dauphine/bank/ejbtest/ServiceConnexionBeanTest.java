package fr.dauphine.bank.ejbtest;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.dauphine.bank.ejb.ServiceConnexion;
import fr.dauphine.bank.ejb.ServiceConnexionBean;

public class ServiceConnexionBeanTest {
	
	 ServiceConnexion commentService;
	    EntityManager entityManager;

	   
	
	
	@Test
	public void testVerificationPersonne() {
		
	}

}
