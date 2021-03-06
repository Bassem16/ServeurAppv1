package fr.dauphine.mido.as.banquetest.web;

import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import fr.dauphine.mido.as.banquetest.beans.Compte;
import fr.dauphine.mido.as.banquetest.beans.GestionCompte;
import fr.dauphine.mido.as.banquetest.beans.Operation;

import java.sql.Connection;

import fr.dauphine.mido.as.banquetest.ejb.ServicesCompte;
import fr.dauphine.mido.as.banquetest.ejb.ServicesCompteBean;
import fr.dauphine.mido.as.banquetest.ejb.StandaloneBean;
import java.util.concurrent.Future;

/**
 * Servlet implementationclass ServletPrincipal
 */
@WebServlet("/ServletPrincipal")
public class ServletPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private javax.sql.DataSource dataSource = null;

	// Usage direct via la no-interface-view
	@EJB(lookup = "java:global/BanqueTestWeb/ServicesCompteBean!fr.dauphine.mido.as.banquetest.ejb.ServicesCompte")
	ServicesCompte servicesCompte;
	ServicesCompteBean servicesCompteBean;
	
	@EJB
	StandaloneBean standaloneBean;

	/**
	 * @seeHttpServlet#HttpServlet()
	 */
	public ServletPrincipal() {
		super();
		try {
			InitialContext initialContext = new InitialContext();
			this.dataSource = (DataSource) initialContext
					.lookup("java:jboss/datasources/BANQUE_TEST");
		} catch (Exception e2) {
			System.out.println(e2.getMessage().toString() + "(Failure)");
		}
	}

	/**
	 * @seeHttpServlet#doGet(HttpServletRequestrequest, HttpServletResponse
	 *                                                  response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGetVersion1(request, response);
		doGetVersion2(request, response);
	}

	@SuppressWarnings("deprecation")
	protected void doGetVersion1(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<h2>");
		printWriter.println("Entrée dans la servlet à "
				+ new Date().toLocaleString());
		printWriter.println("</h2>");
	}

	@SuppressWarnings("deprecation")
	protected void doGetVersion2(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter printWriter = response.getWriter();
			Connection connection = this.dataSource.getConnection();
			connection.close();
			printWriter.println("<h2>");
			printWriter.println("Connexion à la DB ok à "
					+ new Date().toLocaleString());
			printWriter.println("</h2>");
		} catch (Exception e2) {
			System.out.println(e2.getMessage().toString() + "(Failure)");
		}
	}

	/**
	 * @seeHttpServlet#doPost(HttpServletRequestrequest, HttpServletResponse
	 *                                                   response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// doPostVersion1(request, response);
		// doPostVersion2(request, response);
		// doPostVersion3(request, response);
		// doPostVersion4(request, response);
		// doPostVersion5(request, response);
		// doPostVersion6(request, response);
		// doPostVersion7(request, response);
		doPostVersion8(request, response);
	}

	protected void doPostVersion1(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			String noDeCompte = request.getParameter("noDeCompte");
			Compte unCompte = new Compte();
			unCompte.setNocompte(noDeCompte);
			PrintWriter printWriter = response.getWriter();
			printWriter
					.println("<h2>instanciation d'un compte avec n°de compte = "
							+ unCompte.getNocompte() + "</h2>");
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	protected void doPostVersion2(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			String noDeCompte = request.getParameter("noDeCompte");
			Compte unCompte = new Compte();
			unCompte.setNocompte(noDeCompte);
			PrintWriter printWriter = response.getWriter();
			ArrayList<Operation> listeOperations = GestionCompte
					.rechercheOperations(this.dataSource, unCompte);
			System.out.println(unCompte.getSolde());
			printWriter
					.println("<h2>Liste des opérations sur ce compte : </h2>");
			Operation op = null;
			for (int i = 0; i < listeOperations.size(); i++) {
				op = (Operation) listeOperations.get(i);
				printWriter.println("<h2>Opération n°" + op.getIdOperation()
						+ " de type '" + op.getOperation() + "' le "
						+ op.getDateOperation() + " à "
						+ op.getHeureOperation() + " d'un montant de "
						+ op.getValeur() + " euros</h2>");
			}
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	protected void doPostVersion3(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			String noDeCompte = request.getParameter("noDeCompte");
			Compte unCompte = new Compte();
			unCompte.setNocompte(noDeCompte);
			ArrayList<Operation> listeOperations = GestionCompte
					.rechercheOperations(this.dataSource, unCompte);
			HttpSession session = request.getSession();
			session.setAttribute(Compte._COMPTE_COURANT, unCompte);
			session.setAttribute(Compte._LISTE_OPERATIONS, listeOperations);
			getServletContext().getRequestDispatcher("/listeOperations.jsp")
					.forward(request, response);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	protected void doPostVersion4(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			String noDeCompte = request.getParameter("noDeCompte");
			Compte unCompte = new Compte();
			unCompte.setNocompte(noDeCompte);
			ArrayList<Operation> listeOperations = servicesCompteBean
					.rechercheOperations(unCompte);
			HttpSession session = request.getSession();
			session.setAttribute(Compte._COMPTE_COURANT, unCompte);
			session.setAttribute(Compte._LISTE_OPERATIONS, listeOperations);
			System.out.println(listeOperations.size());
			getServletContext().getRequestDispatcher("/listeOperations.jsp")
					.forward(request, response);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	/*
	 * protected void doPostVersion5(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { try
	 * { response.setContentType("text/html"); String noDeCompte =
	 * request.getParameter("noDeCompte"); Compte unCompte = new Compte();
	 * unCompte.setNocompte(noDeCompte); ArrayList<Operation> listeOperations =
	 * servicesCompte .rechercheOperations(unCompte); HttpSession session =
	 * request.getSession(); session.setAttribute(Compte._COMPTE_COURANT,
	 * unCompte); session.setAttribute(Compte._LISTE_OPERATIONS,
	 * listeOperations);
	 * getServletContext().getRequestDispatcher("/listeOperations.jsp")
	 * .forward(request, response); } catch (IOException ioException) {
	 * ioException.printStackTrace(); } }
	 */
	protected void doPostVersion6(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			String noDeCompte = request.getParameter("noDeCompte");
			Compte unCompte = new Compte();
			unCompte.setNocompte(noDeCompte);
			InitialContext initialContext = new InitialContext();
			ServicesCompte servicesCompte = (ServicesCompte) initialContext
					.lookup("java:global/BanqueTestWeb/ServicesCompteBean!fr.dauphine.mido.as.banquetest.ejb.ServicesCompte");
			ArrayList<Operation> listeOperations = servicesCompte
					.rechercheOperations(unCompte);
			HttpSession session = request.getSession();
			session.setAttribute(Compte._COMPTE_COURANT, unCompte);
			session.setAttribute(Compte._LISTE_OPERATIONS, listeOperations);
			getServletContext().getRequestDispatcher("/listeOperations.jsp")
					.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPostVersion7(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			response.setContentType("text/html");
			HttpSession session = request.getSession();
			String noDeCompte = request.getParameter("noDeCompte");
			// Standalone bean
			Future<String> resultatAsync = standaloneBean.returnMessageAsync();
			while (!resultatAsync.isDone()) {
				try {
					System.out
							.println("On patiente... avec un traitement en //");
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.println("Erreur : " + e.getMessage());
				}
			}
			System.out.println("le résultat est arrivé : "
					+ resultatAsync.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPostVersion8(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			String noDeCompte = request.getParameter("noDeCompte");
			Compte unCompte = new Compte();
			unCompte.setNocompte(noDeCompte);
			InitialContext initialContext = new InitialContext();
			ServicesCompte servicesCompte = (ServicesCompte) initialContext
					.lookup("java:global/BanqueTestWeb/ServicesCompteBean!fr.dauphine.mido.as.banquetest.ejb.ServicesCompte");
			ArrayList<Operation> listeOperations = servicesCompte
					.rechercheOperationsJPQL(unCompte);
			HttpSession session = request.getSession();
			session.setAttribute(Compte._COMPTE_COURANT, unCompte);
			session.setAttribute(Compte._LISTE_OPERATIONS, listeOperations);
			getServletContext().getRequestDispatcher("/listeOperations.jsp")
					.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}