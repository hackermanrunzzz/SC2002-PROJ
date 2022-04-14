package classes;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.TimerTask;

import Initialiser.Initialise;
import classes.Reservation.StatusOfReservation;
import classes.Room.StatusOfRoom;

/**
 * @author Darren Choo
 * @version 1.0
 * @since 14th April 2022
 */

public class ReservationExpiry extends TimerTask {
	
	/**
	 * array list of reservations
	 */
    private ArrayList<Reservation> reservations;
    
    /**
     * constructor of reservation expirty
     * @param reservations array list of reservations
     */
    public ReservationExpiry(ArrayList<Reservation> reservations){
    	this.reservations = reservations;
	}

    /**
     * Function executes at scheduled time if there is a reservation
     * It will remove a reservation when it expires
     * Right now it is set to 10s after the supposed check-in time
     */
    public void run(){
    	
        synchronized (Initialise.reservations) {
            Calendar now = Calendar.getInstance();
//            System.out.println("running expiry");
            if (Initialise.reservations.size() > 0) {
            	
            	Iterator<Reservation> itr = Initialise.reservations.iterator();

        		while(itr.hasNext()) {
        			Reservation r = itr.next();
            		if(r.getReservationStatus().equals(StatusOfReservation.CONFIRMED)) {
    	                long expiryTime =  r.getCheckInDate().getTimeInMillis()+10000; //this is 45min
    	                long nowMilli = now.getTimeInMillis();
    	                if (expiryTime<nowMilli) {
    	                	r.getRoomDetails().setRoomStatus(StatusOfRoom.VACANT); //setting room back to vacant
    	                    System.out.println("\n---- Removing expired reservation ---- Reservation ID " + r.getReservationID());
    	                    itr.remove();
    	                }
                	}
            	}
            }
        }
    }

}


