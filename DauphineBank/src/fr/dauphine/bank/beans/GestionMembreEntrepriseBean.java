package fr.dauphine.bank.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import fr.dauphine.bank.ejb.ServiceMembreEntreprise;
import fr.dauphine.bank.ejb.ServiceSauvegarde;
import fr.dauphine.bank.ejb.ServiceVerificationData;
import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Information;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.web.Utile;

@ManagedBean
@SessionScoped
//ATTENTION Cette classe ne doit etre appelé que lorsqu'un utilisateur
//Administrateur est connecté
public class GestionMembreEntrepriseBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Entreprise entreprise = null;
	private Personne personne = null;
	private Information information = null;

	@EJB
	ServiceMembreEntreprise serviceMembreEntreprise;
	@EJB
	ServiceVerificationData serviceVerificationData;
	@EJB
	ServiceSauvegarde serviceSauvegarde;

	public GestionMembreEntrepriseBean(){
		HttpSession hs = Utile.getSession();
		personne = (Personne) hs.getAttribute("personne"); 
		entreprise = personne.getEntreprise();
		information = new Information();
		
	}
	
	public List<Information> getInformations() {
		return serviceMembreEntreprise.listeInformations(entreprise.getIdEntreprise());
	}
	
	
	public void ajouterInformation() {
		information.setEntreprise(entreprise);
		serviceSauvegarde.sauvgarderInformation(information);
	}
	
	public Information getInformation() {
		return this.information;
	}
	
	public int getIdInformation() {
		return getInformation().getIdInformation();
	}
	
	public void setIdInformation(int a) {
		getInformation().setIdInformation(a);
	}
	
	public String getTypeInformation() {
		return getInformation().getTypeInformation();
	}
	
	public void setTypeInformation(String typeInformation) {
		getInformation().setTypeInformation(typeInformation);
	}
	
	public String getTexteInformation() {
		return getInformation().getTexteInformation();
	}
	
	public void setTexteInformation(String typeInformation) {
		getInformation().setTexteInformation(typeInformation);
	}
	
	public Date getDateInformation() {
		return getInformation().getDateInformation();
	}
	
	public void setDateInformation(Date dateInformation) {
		getInformation().setDateInformation(dateInformation);
	}
	
	public Entreprise getEntreprise() {
		return this.entreprise;
	}
	
	public String getNomEntreprise() {
		return getEntreprise().getNomEntreprise();
	}
	
	public void setNomEntreprise(String nomEntreprise) {
		getEntreprise().setNomEntreprise(nomEntreprise);
	}
	
	public String getSecteurEntreprise() {
		return getEntreprise().getSecteurEntreprise();
	}
	
	public void setSecteurEntreprise(String secteurEntreprise) {
		getEntreprise().setSecteurEntreprise(secteurEntreprise);
	}
	
	public int getNombreTitreTotal() {
		return getEntreprise().getNombreTitreTotal();
	}
	
	public void setNombreTitreTotal(int nombreTitreTotal) {
		getEntreprise().setNombreTitreTotal(nombreTitreTotal);
	}
	
	public void setServiceSauvegarde(ServiceSauvegarde s){
		serviceSauvegarde = s;
	}
	
	public void setServiceMembreEntreprise(ServiceMembreEntreprise s){
		serviceMembreEntreprise = s;
	}
	
	public void setServiceVerificationData(ServiceVerificationData s){
		serviceVerificationData = s;
	}

	public void setInformation(Information i){
		information = i;
	}
	
	public void setEntreprise(Entreprise e){
		entreprise = e;
	}
	
}
