package dauphineBank.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class ServletInscriptionUtilisateur
 */
@WebServlet("/ServletInscriptionUtilisateur")
public class ServletInscriptionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource dataSource = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletInscriptionUtilisateur() {
		super();
		try {
			InitialContext initialContext = new InitialContext();
			this.dataSource = (DataSource) initialContext
					.lookup("java:jboss/datasources/DauphineBank");
		} catch (Exception e2) {
			System.out.println(e2.getMessage().toString() + "(Failure)");
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
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
		printWriter.println("Entree dans la servlet à "
				+ new Date().toLocaleString());
		printWriter.println("</h2>");
	}

	@SuppressWarnings("deprecation")
	protected void doGetVersion2(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			HttpSession session = request.getSession();
			getServletContext().getRequestDispatcher("/CreationCompte.xhtml")
					.forward(request, response);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
