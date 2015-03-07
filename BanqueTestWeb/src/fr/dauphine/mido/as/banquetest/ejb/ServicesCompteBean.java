package fr.dauphine.mido.as.banquetest.ejb;

import javax.ejb.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;

import fr.dauphine.mido.as.banquetest.beans.Compte;
import fr.dauphine.mido.as.banquetest.beans.Operation;
import java.util.List;
import javax.persistence.Query;

@Stateless
public class ServicesCompteBean implements ServicesCompte {

	private final static String _SQL_SELECT_OPERATIONS = "select* from BANQUE_TEST.OPERATIONS where NOCOMPTE like ?";

	@PersistenceUnit
	private EntityManagerFactory emf;

	public ArrayList<Operation> rechercheOperations(Compte unCompte) {
		DataSource dataSource = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Operation> resultat = null;
		Operation operation = null;
		String num = unCompte.getNocompte();
		String nom = unCompte.getNom();
		try {
			InitialContext initialContext = new InitialContext();
			dataSource = (DataSource) initialContext
					.lookup("java:jboss/datasources/BANQUE_TEST");
			connection = dataSource.getConnection();
			preparedStatement = connection
					.prepareStatement(_SQL_SELECT_OPERATIONS);
			preparedStatement.setString(1, unCompte.getNocompte());
			resultSet = preparedStatement.executeQuery();
			resultat = new ArrayList<Operation>();
			while (resultSet.next()) {
				operation = new Operation();
				operation.setIdOperation(new Integer(resultSet.getString(1))
						.intValue());
				operation.setNoCompte(resultSet.getString(2));
				operation.setDateOperation(resultSet.getString(3));
				operation.setHeureOperation(resultSet.getString(4));
				operation.setOperation(resultSet.getString(5).toCharArray()[0]);
				operation.setValeur(new Float(resultSet.getString(6)));
				resultat.add(operation);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage().toString());
			}
		}
		return resultat;
	}

	public ArrayList<Operation> rechercheOperationsJPQL(Compte unCompte) {
		EntityManager em = emf.createEntityManager();
		Query query = em
				.createQuery("SELECT s FROM Operation as s where s.noCompte like :unnocompte");
		query.setParameter("unnocompte", unCompte.getNocompte());
		List<Operation> listeOperations = query.getResultList();
		ArrayList<Operation> resultat = new ArrayList<Operation>();
		Operation operation = null;
		for (Operation operationJPA : listeOperations) {
			operation = new Operation();
			operation.setIdOperation(operationJPA.getIdOperation());
			operation.setNoCompte(operationJPA.getNoCompte());
			operation.setDateOperation(operationJPA.getDateOperation());
			operation.setHeureOperation(operationJPA.getHeureOperation());
			operation.setOperation(operationJPA.getOperation());
			operation.setValeur(operationJPA.getValeur());
			resultat.add(operation);
		}
		em.close();
		return resultat;
	}
}
