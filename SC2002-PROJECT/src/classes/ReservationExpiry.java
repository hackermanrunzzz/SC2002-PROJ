package classes;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimerTask;

import Initialiser.Initialise;


public class ReservationExpiry extends TimerTask {
	
 
    private ArrayList<Reservation> reservations;

    public ReservationExpiry(ArrayList<Reservation> reservations){
    	this.reservations = reservations;
	}

  
    public void run(){
        int i = 0;
        synchronized (Initialise.reservations) {
            Calendar now = Calendar.getInstance();
//            System.out.println("running expiry every 50s");
            if (Initialise.reservations.size() > 0) {
                long expiryTime =  Initialise.reservations.get(i).getCheckInDate().getTimeInMillis()+2700000; //this is 45min
                long nowMilli = now.getTimeInMillis();
                if (expiryTime<nowMilli) {
                    System.out.println("\n---- Removing expired reservation ---- Reservation ID " + Initialise.reservations.get(i).getReservationID());
                    Initialise.resm.expireReservation(Initialise.reservations.get(i).getReservationID());
                }
            }
        }


    }

}


