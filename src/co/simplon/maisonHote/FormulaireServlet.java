package co.simplon.maisonHote;

import java.io.IOException;

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

		// Récupération des reservations
				request.setAttribute("reservations", ReservationManager.getInstance().getReservations().values());
				
				//getServletContext().getRequestDispatcher("/listereservations.jsp").forward(request, response);

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

		// transfert des données récupérées dans la classe java
		Reservation newReservation = new Reservation();
		newReservation.setNom(paramNom);
		newReservation.setPrenom(paramPrenom);
		newReservation.setTelephone(paramTel);
		newReservation.setEmail(paramEmail);

		request.setAttribute("reservation", newReservation);
		this.getServletContext().getRequestDispatcher("/WEB-INF/showReservation.jsp").forward(request, response);

		doGet(request, response);
	}

}
