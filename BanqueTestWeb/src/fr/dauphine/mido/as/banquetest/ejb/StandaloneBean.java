package fr.dauphine.mido.as.banquetest.ejb;

import java.util.concurrent.Future;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

@Stateless
public class StandaloneBean {
	private static final String message = "Un message";
	private int compteur = 0;

	public String returnMessage() {
		compteur++;
		return message + ". Valeur compteur = " + compteur;
	}

	@Asynchronous
	public Future<String> returnMessageAsync() {
		String status = message + " en mode async";
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			System.err.println("Erreur : " + e.getMessage());
		}
		System.out
				.println("retour du résultat de la méthode appelée en mode async");
		return new AsyncResult<String>(status);
	}

	public StandaloneBean() {
		// TODO Auto-generated constructor stub
	}

}
