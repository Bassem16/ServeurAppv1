package fr.dauphine.mido.as;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.jdbc.Statement;


public class AppClient {
	private final static String _SELECT1 = "SELECT * FROM TABLE_TEST1";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer resultStringBuffer;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/BANQUE_TEST","root", "");
			stmt = (com.mysql.jdbc.Statement) conn.createStatement();
			rs = stmt.executeQuery(_SELECT1);
			resultStringBuffer = new StringBuffer("Résultat :\n");
			while (rs.next()) {
				resultStringBuffer.append(rs.getString(1));
				resultStringBuffer.append("=");
				resultStringBuffer.append(rs.getString(2));
				resultStringBuffer.append(" ");
				resultStringBuffer.append(rs.getString(3));
				resultStringBuffer.append("\n");
			}
			System.out.println(resultStringBuffer.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
			rs.close();
			} catch (Exception e2) {
				System.out.println("resultSet à null");
				}
				try {
				stmt.close();
				} catch (Exception e2) {
				System.out.println("stmt à null");
				}
				try {
				conn.close();
				} catch (Exception e2) {
				System.out.println("conn à null");
				}
		}
	}
}
			