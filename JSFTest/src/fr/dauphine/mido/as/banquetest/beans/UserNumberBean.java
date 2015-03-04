package fr.dauphine.mido.as.banquetest.beans;

import java.io.Serializable;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UserNumberBean implements Serializable {
	static final long serialVersionUID = 1L;
	Integer randomInt = null;
	Integer userNumber = null;
	String response = null;
	private int nombreTentatives = 0;
	private long maximum = 100;
	private long minimum = 0;

	public UserNumberBean() {
		Random randomGR = new Random();
		randomInt = new Integer(randomGR.nextInt(10));
	}

	public void setUserNumber(Integer user_number) {
		userNumber = user_number;
	}

	public Integer getUserNumber() {
		return userNumber;
	}

	public String getResponse() {
		setNombreTentatives(getNombreTentatives() + 1);
		if ((null != userNumber) && (userNumber.compareTo(randomInt) == 0)) {
			return "Valeur trouvée en " + getNombreTentatives() + " coups !";
		} else {
			String comparaison;
			if (userNumber.intValue() > randomInt.intValue())
				comparaison = "inférieure";
			else
				comparaison = "supérieure";
			return "Désolé, " + userNumber
					+ " est incorrect. la bonne valeur est " + comparaison;
		}
	}

	public int getNombreTentatives() {
		return (this.nombreTentatives);
	}

	public void setNombreTentatives(int unNombre) {
		this.nombreTentatives = unNombre;
	}

	public long getMaximum() {
		return (this.maximum);
	}

	public void setMaximum(long maximum) {
		this.maximum = maximum;
	}

	public long getMinimum() {
		return (this.minimum);
	}

	public void setMinimum(long minimum) {
		this.minimum = minimum;
	}
}