package co.simplon.maisonHote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Jdbc {

	private final static String BDPATH = "jdbc:mysql://localhost:3306/maison_hote";
	private final static String DBUSER = "root";
	private final static String DBPASSWORD = "ZERsdfxcv+01";

	private static Connection connection;
	private static Statement statement = null;
	private static ResultSet resultSet = null;

	private Reservation reservation = new Reservation();

	public void connectToDB() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver ok");
			// Setup the connection with the DB
			// connection = DriverManager.getConnection(
			// BDPATH + "?" + "user=" + user + "&password=" + passwd);
			connection = DriverManager.getConnection(BDPATH, DBUSER, DBPASSWORD);
			System.out.println("connection ok");
		} catch (Exception e) {
			System.out.println("no connection");
			throw e;
		}
	}

	public void closeDB() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connection != null) {
				connection.close();
				System.out.println("fermeture ok");
			}
		} catch (Exception e) {

		}
	}

	public static void insertData(String nom, String prenom, String telephone, String email, String nbNuit,
			String nbPersonne, String typeSejour, String animal, String fumeur, String parking)
			throws SQLException, ClassNotFoundException {

		Statement statement = null;

		try {
			statement = connection.createStatement();
			String sql = "INSERT INTO `reservations` (`nom`, `prenom`, `telephone`, `email`, `nbNuit`, `nbPersonne`, `typeSejour`, `animal`, `fumeur`, `parking`) VALUES ('"
					+ nom + "', '" + prenom + "', '" + telephone + "', '" + email + "', '" + nbNuit + "', '"
					+ nbPersonne + "', '" + typeSejour + "', '" + animal + "', '" + fumeur + "', '" + parking + "')";
			statement.executeUpdate(sql);
			System.out.println("implementation ok");
		} catch (SQLException e) {
			System.out.println("An error occured trying to insert the new data !");
		} finally {
			statement.close();
		}

		System.out.println();

	}

	public static ArrayList<Reservation> showData() throws SQLException, ClassNotFoundException {
		ArrayList<Reservation> listeReservations = new ArrayList();

		try {
			// Create the statement
			statement = connection.createStatement();
			String sql = "SELECT * FROM reservations";

			// Execute the query
			resultSet = statement.executeQuery(sql);

			// Loop on the results extracted from the database
			System.out.println("Liste actuelle des reservations :");
			while (resultSet.next()) {
				Reservation reservation = new Reservation();
				reservation.setNom(resultSet.getString("nom"));
				reservation.setPrenom(resultSet.getString("prenom"));
				reservation.setTelephone(resultSet.getString("telephone"));
				reservation.setEmail(resultSet.getString("email"));
				reservation.setNbNuit(resultSet.getString("nbNuit"));
				reservation.setNbPersonne(resultSet.getString("nbPersonne"));
				reservation.setTypeSejour(resultSet.getString("typeSejour"));
				reservation.setAnimal(resultSet.getString("animal"));
				reservation.setFumeur(resultSet.getString("fumeur"));
				reservation.setParking(resultSet.getString("parking"));

				listeReservations.add(reservation);
				//System.out.println("lecture ok");
			}
		} catch (SQLException e) {
			System.out.println("An error occured trying to read the data !");
		} finally {
			statement.close();
		}
		//System.out.println(listeReservations);
		return listeReservations;
	}
}
