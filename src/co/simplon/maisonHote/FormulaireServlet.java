package co.simplon.maisonHote;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import co.simplon.maisonHote.Jdbc;
import co.simplon.maisonHote.Reservation;
import co.simplon.maisonHote.ReservationInterface;
import co.simplon.maisonHote.ReservationImplement;
import co.simplon.maisonHote.ReservationManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormulaireServlet
 */
@WebServlet("/FormulaireServlet")
public class FormulaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Reservation> listeReserv;
	Jdbc baseDonnees = new Jdbc();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormulaireServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récupération des reservations effectuées de la map
		// request.setAttribute("reservations",
		// ReservationManager.getInstance().getReservations().values());

		// connection BdD
		try {
			baseDonnees.connectToDB();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		// Affichage données de la base
		try {
			listeReserv = baseDonnees.showData();
			request.setAttribute("reservations", listeReserv);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		baseDonnees.closeDB();

		getServletContext().getRequestDispatcher("/WEB-INF/listeReserv.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		// recuperation des données du formulaire
		String paramNom = request.getParameter("nom");
		String paramPrenom = request.getParameter("prenom");
		String paramTel = request.getParameter("telephone");
		String paramEmail = request.getParameter("email");
		String paramNbNuit = request.getParameter("nbNuit");
		String paramNbPersonne = request.getParameter("nbPersonne");
		String paramTypeSejour = request.getParameter("typeSejour");
		String paramAnimal = request.getParameter("animal");
		String paramFumeur = request.getParameter("fumeur");
		String paramParking = request.getParameter("parking");

		// transfert des données récupérées dans la classe java
		Reservation reservation = new Reservation();
		reservation.setNom(paramNom);
		reservation.setPrenom(paramPrenom);
		reservation.setTelephone(paramTel);
		reservation.setEmail(paramEmail);
		reservation.setNbNuit(paramNbNuit);
		reservation.setNbPersonne(paramNbPersonne);
		reservation.setTypeSejour(paramTypeSejour);
		reservation.setAnimal(paramAnimal);
		reservation.setFumeur(paramFumeur);
		reservation.setParking(paramParking);

		ReservationManager.getInstance().addReservation(reservation);
		try {
			baseDonnees.connectToDB();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		// Ajout de la réservation dans la base de données
		try {
			baseDonnees.insertData(paramNom, paramPrenom, paramTel, paramEmail, paramNbNuit, paramNbPersonne,
					paramTypeSejour, paramAnimal, paramFumeur, paramParking);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}


		baseDonnees.closeDB();

		request.setAttribute("reservation", reservation);
		// Récupération des reservations
		request.setAttribute("reservations", ReservationManager.getInstance().getReservations().values());
		this.getServletContext().getRequestDispatcher("/WEB-INF/showReservation.jsp").forward(request, response);

	}

}
