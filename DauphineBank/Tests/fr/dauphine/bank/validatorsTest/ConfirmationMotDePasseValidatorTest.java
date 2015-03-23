package fr.dauphine.bank.validatorsTest;

import static org.junit.Assert.*;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import fr.dauphine.bank.validators.ConfirmationMotDePasseValidator;

public class ConfirmationMotDePasseValidatorTest {

	private FacesContext fc;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testValidate() {
		fc = Mockito.mock(FacesContext.class);
//		UIComponent component = Mockito.mock(UIComponent.class);
//		String ss= "salut";
//		
//		ConfirmationMotDePasseValidator confirmation = new ConfirmationMotDePasseValidator();
//		
//		confirmation.validate(fc,component, ss);
//		
	}

}
