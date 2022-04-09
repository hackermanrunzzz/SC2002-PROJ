/**
 * @author Gladys Loh
 * @version 1.0
 * @since 9th November 2021
 */

package classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * create reservation class
 */
public class Reservation {
    /**
     * Reservation ID
     */
    private int reservationID;

    /**
     * Number of people for reservation
     */
    private int numOfPax;

    /**
     * Preferred name of the custoemr
     */
    private String customerName;

    /**
     * Contact number of customer
     */
    private int customerContact;

    /**
     * Status of reservation if it is made
     */
    private boolean status;

    /**
     * Reservation date and time for customer
     */
    private Calendar arrivalTime;

    /**
     * Table id of the restaurant
     */
    private int tableId;


    /**
     * Create new reservation
     * @param reservationID of reservation being made
     * @param numOfPax number of people
     * @param customerName name of customer
     * @param customerContact phone number of customer
     * @param status if reservation is made
     * @param arrivalTime time customer will arrive
     * @param tableId table that is reserved
     */
    public Reservation(int reservationID, int numOfPax, String customerName, int customerContact, boolean status, Calendar arrivalTime, int tableId) {
        this.reservationID = reservationID;
        this.numOfPax = numOfPax;
        this.customerName = customerName;
        this.customerContact = customerContact;
        this.status = status;
        this.arrivalTime = arrivalTime;
        this.tableId = tableId;
    }

    /**
     * Format reservation information in a readable format
     * @return a reservation detail
     */
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String strDate = dateFormat.format(this.arrivalTime.getTime());

        return "Customer Name: \t\t\t" + this.customerName + "\nContact:\t\t\t\t" + this.customerContact
                +"\nArrival time: \t\t\t" + strDate + "\nReservation ID: \t\t" + this.reservationID
                + "\nTable ID: \t\t\t\t" + this.tableId + "\n";
    }

    /**
     * Gets the reservation date and time of the customer
     * @return reservation date and time
     */
    public Calendar getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Gets the ID of reservation
     * @return reservation id
     */

    public int getReservationID(){
        return this.reservationID;
    }

    /**
     * Gets the table for reservation
     * @return table Id
     */
    public int getTableId(){
        return this.tableId;
    }
}
