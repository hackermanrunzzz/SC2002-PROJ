package classes;

import java.util.ArrayList;

public class ReservationApp {
	public static void main (String [] args) {
		
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		ReservationManager reservationManager = new ReservationManager(reservations);
		
		
		
		reservationManager.makeReservation(null, null, null, null, null, 0, 0, null, 0);
	
		
	}

}
