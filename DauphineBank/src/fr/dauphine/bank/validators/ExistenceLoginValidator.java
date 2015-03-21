package fr.dauphine.bank.validators;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import fr.dauphine.bank.ejb.ServiceVerificationData;

@ManagedBean
@RequestScoped
public class ExistenceLoginValidator implements Validator {

	private static final String LOGIN_EXISTE_DEJA = "Ce login est déjà utilisée";

	@EJB
	private ServiceVerificationData serviceVerificationData;

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

		String login = (String) value;
		try {
			if (serviceVerificationData.trouverCompteLogin(login) != null
					&& !serviceVerificationData.trouverCompteLogin(login).isEmpty()) {

				throw new ValidatorException(new FacesMessage(
						FacesMessage.SEVERITY_ERROR, LOGIN_EXISTE_DEJA, null));
			}
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(component.getClientId(facesContext),
					message);
		}
	}
}