/**
 * @author Gladys Loh and Gabriel Tang
 * @version 1.0
 * @since 9th November 2021
 */

package classmgr;

import classes.Reservation;
import initialize.Restaurant;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimerTask;

/**
 * create scheduled task
 */
public class ScheduledTask extends TimerTask {
    /**
     * This is an array of reservations
     */
    private ArrayList<Reservation> reservations = new ArrayList<Reservation>();

    /**
     * Creates a new Scheduled task to reservations array
     * @param reservations array of reservations
     */
    public ScheduledTask(ArrayList<Reservation> reservations){this.reservations = reservations;}

    //add task here

    /**
     * Function will be executed at scheduled time when reservations exists
     * Only will remove reservation when the reservation arrival time after 15 minutes of actual time
     * Once it is removed, the system will print the ID that is going to be removed.
     * it will be successfully removed only if the table does not have any pending order
     */
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