package classes;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.TimerTask;

import Initialiser.Initialise;
import classes.Reservation.StatusOfReservation;


public class ReservationExpiry extends TimerTask {
	
 
    private ArrayList<Reservation> reservations;

    public ReservationExpiry(ArrayList<Reservation> reservations){
    	this.reservations = reservations;
	}

  
//    public void run(){
//        int i = 0;
//        synchronized (Initialise.reservations) {
//            Calendar now = Calendar.getInstance();
//            System.out.println("running expiry");
//            if (Initialise.reservations.size() > 0) {
//            	if(Initialise.reservations.get(i).getReservationStatus().equals(StatusOfReservation.CHECKED_IN)) {
////            		System.out.println("running expiry");
//	                long expiryTime =  Initialise.reservations.get(i).getCheckInDate().getTimeInMillis()+10000; //this is 45min
//	                long nowMilli = now.getTimeInMillis();
//	                if (expiryTime<nowMilli) {
//	                    System.out.println("\n---- Removing expired reservation ---- Reservation ID " + Initialise.reservations.get(i).getReservationID());
//	                    Initialise.reservations.remove(0);
//	                }
//            	}
//            }
//        }
//
//
//    }
    
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
    	                    System.out.println("\n---- Removing expired reservation ---- Reservation ID " + r.getReservationID());
    	                    itr.remove();
    	                }
                	}
            	}
            }
        }
    }

}


