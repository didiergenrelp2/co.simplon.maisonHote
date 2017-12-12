package co.simplon.maisonHote;

import java.io.IOException;

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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormulaireServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Récupération des reservations effectuées
				request.setAttribute("reservations", ReservationManager.getInstance().getReservations().values());
				
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

		request.setAttribute("reservation", reservation);
		// Récupération des reservations
		request.setAttribute("reservations", ReservationManager.getInstance().getReservations().values());
		this.getServletContext().getRequestDispatcher("/WEB-INF/showReservation.jsp").forward(request, response);

		
	}

}
