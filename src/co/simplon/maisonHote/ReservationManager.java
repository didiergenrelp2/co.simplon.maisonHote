package co.simplon.maisonHote;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ReservationManager {

	private final static ReservationManager INSTANCE = new ReservationManager();
	private final Map<String, Reservation> reservations = new HashMap<String, Reservation>();
	
	private ReservationManager(){
	}
	
	public static ReservationManager getInstance() {
		return INSTANCE;
	}
	
	public Map<String, Reservation> getReservations(){
		return reservations;
	}
	
	public void addReservation(Reservation reservation) {//throws Exception{
//		if(reservations.containsKey(reservation.getTicketId()))
//			throw new Exception("Ce billet a déjà été enregistré !");
		
//		reservation.setDateEnregistrement(new Date());
		reservations.put(reservation.getNom(), reservation);
	}
	
	
}
