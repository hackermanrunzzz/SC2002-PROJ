package classes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimerTask;

import classes.*;

public class ReservationExpiry extends TimerTask {
	
 
    private ArrayList<Reservation> reservations = new ArrayList<Reservation>();

   
    public ReservationExpiry(ArrayList<Reservation> reservations){this.reservations = reservations;}

  
    public void run(){
        int i = 0;
        synchronized (reservations) {
            Calendar now = Calendar.getInstance();
//            System.out.println("running");
            if (reservations.size() > 0) {
                long expiryTime =  reservations.get(i).getArrivalTime().getTimeInMillis()+2700000;
                long nowMilli = now.getTimeInMillis();
                if (expiryTime<nowMilli) {
                    System.out.println("\n---- Removing expired reservation ---- Reservation ID " + reservations.get(i).getReservationID());
                    Restaurant.reservationManager.removeReservation(reservations.get(i).getReservationID());
                }
            }
        }


    }

}
