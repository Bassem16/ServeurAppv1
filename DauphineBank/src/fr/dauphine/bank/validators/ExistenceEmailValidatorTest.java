package fr.dauphine.bank.validators;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import fr.dauphine.bank.ejb.ServiceVerificationData;
import fr.dauphine.bank.entities.Personne;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FacesContext.class)
public class ExistenceEmailValidatorTest {

	private ServiceVerificationData serviceVerificationData;
	private ExistenceEmailValidator validator;
	private FacesContext fc;

	@Before
	public void setUp() throws Exception {
		PowerMockito.mockStatic(FacesContext.class);
		serviceVerificationData = Mockito.mock(ServiceVerificationData.class);
		fc = Mockito.mock(FacesContext.class);

		Mockito.when(FacesContext.getCurrentInstance()).thenReturn(fc);

	}

	@Test
	public void testValidate() {
		UIComponent UI = Mockito.mock(UIComponent.class);
		List<Personne> personnes = new ArrayList<Personne>();
		Personne p = new Personne();
		personnes.add(p);
		Mockito.when(
				serviceVerificationData.trouverCompteEmail("bassem@hotmail.fr"))
				.thenReturn(personnes);
		validator = new ExistenceEmailValidator();
		validator.setServiceVerificationData(serviceVerificationData);

		validator.validate(fc, UI, "bassem@hotmail.fr");

	}

}
