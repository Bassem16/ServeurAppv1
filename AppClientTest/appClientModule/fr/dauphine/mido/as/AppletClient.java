
package fr.dauphine.mido.as;

import java.applet.Applet;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.jdbc.Statement;


public class AppletClient extends Applet {
	static final long serialVersionUID = 2;
	private final static String _SELECT1 = "SELECT * FROM TABLE_TEST1";
	
	// resize the screen
	public void init() {
		resize(150, 25);
	}
	
	public void start() { }
	
	// draw with the Graphics class object a string on the canvas, point 50, 25
	public void paint(Graphics graphicsObj) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer resultStringBuffer;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/BANQUE_TEST","root", "");
		//DriverManager.getLoginTimeout();
		stmt = (com.mysql.jdbc.Statement)conn.createStatement();
		rs =stmt.executeQuery(_SELECT1);
		resultStringBuffer = new StringBuffer("Résultat : ");
		while (rs.next()) {
			resultStringBuffer.append(rs.getString(1));
			resultStringBuffer.append("=");
			resultStringBuffer.append(rs.getString(2));
			resultStringBuffer.append(" ");
			resultStringBuffer.append(rs.getString(3));
			resultStringBuffer.append("\n");
		}
	} catch (Exception e) {
		resultStringBuffer = new StringBuffer("Erreur");
		} finally {
			try {
				rs.close();
				} catch (Exception e2) {
					resultStringBuffer = new StringBuffer("resultSet à null");
				} try {
					stmt.close();
				} catch (Exception e2) {
					resultStringBuffer = new StringBuffer("stmt à null");
				} try {
					conn.close();
				} catch (Exception e2) {
					resultStringBuffer = new StringBuffer("conn à null");
				}
			}
		
		graphicsObj.drawString(resultStringBuffer.toString(), 50, 25);
	}
	
	public void stop() { }
	
	public void destroy() { }
	}
