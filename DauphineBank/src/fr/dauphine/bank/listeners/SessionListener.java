package fr.dauphine.bank.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
 
public class SessionListener implements HttpSessionListener {
 
  private static int totalActiveSessions;
 
  public static int getTotalActiveSession(){
	return totalActiveSessions;
  }
 
  @Override
  public void sessionCreated(HttpSessionEvent event) {
	totalActiveSessions++;
	System.out.println("session Created Id: "+ event.getSession().getId());
  }
 
  @Override
  public void sessionDestroyed(HttpSessionEvent event) {
	totalActiveSessions--;
	System.out.println("session Destroyed Id: "+ event.getSession().getId());
	
  }	
}