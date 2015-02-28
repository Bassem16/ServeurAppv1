package fr.dauphine.mido.as.banquetest.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Servlet implementationclass ServletPrincipal
 */
@WebServlet("/ServletPrincipal")
public class ServletPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
			Connection connection = dataSource.getConnection(); //On se connecte
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
	}

}
