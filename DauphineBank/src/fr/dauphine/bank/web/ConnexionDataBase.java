package fr.dauphine.bank.web;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

public class ConnexionDataBase {

	
	  @PersistenceUnit
	  private static EntityManagerFactory emf;
	   
	  //Constructeur privé
	  private ConnexionDataBase(){
	  
	      emf = Persistence
	  			.createEntityManagerFactory("DauphineBank");
	       
	  }
	   
	  //Méthode qui va nous retourner notre instance et la créer si elle n'existe pas
	   public static EntityManagerFactory getConnexion(){
	    if(emf == null){
	      @SuppressWarnings("unused")
	      ConnexionDataBase connexion = new ConnexionDataBase();
	      System.out.println("Creation de la connexion...OK");
	    }
	    return emf;   
	  }   
	}