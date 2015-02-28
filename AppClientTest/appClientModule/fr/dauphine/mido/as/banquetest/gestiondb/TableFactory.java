package fr.dauphine.mido.as.banquetest.gestiondb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Time;
import com.mysql.jdbc.Statement;
import java.math.BigDecimal;

public class TableFactory {
	private final static String _CREATE_TABLE_COMPTES = "CREATE TABLE IF NOT EXISTS COMPTES"
			+ "(NOCOMPTE CHAR(4) NOT NULL PRIMARY KEY,"
			+ "NOM VARCHAR(20) NOT NULL,"
			+ "PRENOM VARCHAR(20) NOT NULL,"
			+ "SOLDE DECIMAL(10,2) NOT NULL)";
	private final static String _INSERT_TABLE_COMPTES = "INSERT INTO COMPTES"
			+ "(NOCOMPTE,NOM,PRENOM,SOLDE)"
			// + "VALUES('0001','DUPONT','PIERRE',100.25)";
			+ "VALUES(?,?,?,?)";
	private final static String _CREATE_TABLE_OPERATIONS = "CREATE TABLE IF NOT EXISTS OPERATIONS"
			+ "(IDOPERATION INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
			+ "NOCOMPTE CHAR(4) NOT NULL,"
			+ "DATE DATE NOT NULL,"
			+ "HEURE TIME NOT NULL,"
			+ "OP CHAR(1) NOT NULL,"
			+ "VALEUR DECIMAL(10,2) NOT NULL)";
	private final static String _INSERT_TABLE_OPERATIONS = "INSERT INTO OPERATIONS"
			+ "(NOCOMPTE,DATE,HEURE,OP,VALEUR)"
			// + "VALUES('0001',CURRENT_DATE,CURRENT_TIME,'+',100.00)";
			+ "VALUES(?,?,?,?,?)";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		// Statement stmt = null;
		Statement stmt = null;
		PreparedStatement preparedStmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/BANQUE_TEST", "root", "");
			stmt = (com.mysql.jdbc.Statement) conn.createStatement();
			stmt.executeUpdate(_CREATE_TABLE_COMPTES);
			stmt.executeUpdate(_CREATE_TABLE_OPERATIONS);
			// stmt.executeUpdate(_INSERT_TABLE_COMPTES);
			// stmt.executeUpdate(_INSERT_TABLE_OPERATIONS);
			stmt.close();
			int i = 0;
			String operationRequested;
			while (i < args.length) {
				operationRequested = (String) args[i++];
				if (operationRequested.equalsIgnoreCase("INSERT_COMPTES")) {
					preparedStmt = conn.prepareStatement(_INSERT_TABLE_COMPTES);
					preparedStmt.setString(1, (String) args[i++]);
					preparedStmt.setString(2, (String) args[i++]);
					preparedStmt.setString(3, (String) args[i++]);
					preparedStmt.setBigDecimal(4, new BigDecimal(args[i++]));
				} else if (operationRequested
						.equalsIgnoreCase("INSERT_OPERATIONS")) {
					preparedStmt = conn
							.prepareStatement(_INSERT_TABLE_OPERATIONS);
					preparedStmt.setString(1, (String) args[i++]);
					preparedStmt.setDate(2, Date.valueOf(args[i++]));
					preparedStmt.setTime(3, Time.valueOf(args[i++]));
					preparedStmt.setString(4, (String) args[i++]);
					preparedStmt.setBigDecimal(5, new BigDecimal(args[i++]));
				}

				else {
					throw new Exception(new StringBuffer(
							"Error: The Operation'").append(operationRequested)
							.append("' requested is unknown.'").toString());
				}
				try {
					preparedStmt.executeUpdate();
				} catch (Exception e2) {
					System.out
							.println("Erreur dans l'exécution du preparedStatement : "
									+ preparedStmt.toString());
				}
				try {
					preparedStmt.close();
				} catch (Exception e2) {
					System.out.println("preparedStatement non fermé");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			/*
			 * try { stmt.close(); } catch (Exception e2) {
			 * System.out.println("stmt non fermé"); }
			 */
			try {
				conn.close();
			} catch (Exception e2) {
				System.out.println("conn non fermé");
			}
		}
	}
}