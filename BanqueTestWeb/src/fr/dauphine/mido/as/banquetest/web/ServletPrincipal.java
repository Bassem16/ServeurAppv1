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
import javax.naming.InitialContext;
import javax.sql.DataSource;

import fr.dauphine.mido.as.banquetest.beans.Compte;
import fr.dauphine.mido.as.banquetest.beans.GestionCompte;
import fr.dauphine.mido.as.banquetest.beans.Operation;

import java.sql.Connection;

/**
 * Servlet implementationclass ServletPrincipal
 */
@WebServlet("/ServletPrincipal")
public class ServletPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * public DataSource getDataSource(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { try
	 * { InitialContext initialContext = new InitialContext();
	 * javax.sql.DataSource dataSource = (DataSource) initialContext
	 * .lookup("java:jboss/datasources/BANQUE_TEST"); return dataSource; } catch
	 * (Exception e2) { System.out.println(e2.getMessage().toString() +
	 * "(Failure)"); }
	 * 
	 * return null; }
	 */

	/**
	 * @seeHttpServlet#HttpServlet()
	 */
	public ServletPrincipal() {
		super();
		// TODO Auto-generatedconstructorstub
	}

	/**
	 * @seeHttpServlet#doGet(HttpServletRequestrequest, HttpServletResponse
	 *                                                  response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generatedmethodstub
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
			InitialContext initialContext = new InitialContext();
			javax.sql.DataSource dataSource = (DataSource) initialContext
					.lookup("java:jboss/datasources/BANQUE_TEST");
			Connection connection = dataSource.getConnection(); // On se
																// connecte
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
		// TODO Auto-generatedmethodstub
		doPostVersion1(request, response);
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
					.rechercheOperations(getDataSource(), unCompte);
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
}
