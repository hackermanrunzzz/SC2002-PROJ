package classes;
/**
 * @author Vijayanarayanan Sai Arunavan
 * @version 1.0
 * @since 14th April 2022
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
/**
 * create reservation class
 */
public class Reservation {
	/**
	 * initialising enumeration for reservation status of rooms
	 */
	public enum StatusOfReservation{
		/**
		 * reservation is confirmed
		 */
		CONFIRMED,
		/**
		 * reservation is in waitlist to be confirmed
		 */
		IN_WAITLIST,
		/**
		 * guest(s) who booked the reservation has checked in
		 */
		CHECKED_IN,
		/**
		 * reservation has expired
		 */
		EXPIRED}
	/**
	 * unique identifier for each reservation
	 */
	private int reservationID;
	/**
	 * array of guest objects
	 */
	private ArrayList<Guest> guestDetails; 
	/**
	 * room object
	 */
	private Room roomDetails;
	/**
	 * credit card name and number of paying guest
	 */
	private String billingInformation; 
	/**
	 * calendar type object to get check-in date
	 */
	private Calendar checkInDate;
	/**
	 * calendar type object to get check-out date
	 */
	private Calendar checkOutDate;
	/**
	 * number of adults
	 */
	private int adultCount;
	/**
	 * number of children
	 */
	private int childrenCount;
	/**
	 * whether reservation is confirmed, in waitlist, checked in or expired
	 */
	private StatusOfReservation reservationStatus;
	/**
	 * number of nights to be spent in the room(s)
	 */
	private int numberOfNights;
	/**
	 * constructor for reservation class
	 * @param reservationID unique identifier for a reservation
	 * @param guestDetails array of guest objects
	 * @param roomDetails room object
	 * @param billingInformation credit card name and number of paying guest
	 * @param checkInDate calendar 
	 * @param checkOutDate
	 * @param adultCount
	 * @param childrenCount
	 * @param reservationStatus
	 * @param numberOfNights
	 */
	public Reservation(int reservationID, ArrayList<Guest> guestDetails, Room roomDetails, String billingInformation,
			Calendar checkInDate, Calendar checkOutDate, int adultCount, int childrenCount,
			StatusOfReservation reservationStatus, int numberOfNights) {
		
		this.reservationID = reservationID;
		this.guestDetails = guestDetails;
		this.roomDetails = roomDetails;
		this.billingInformation = billingInformation;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.adultCount = adultCount;
		this.childrenCount = childrenCount;
		this.reservationStatus = reservationStatus;
		this.numberOfNights = numberOfNights;
		
	}
	/**
	 * gets the unique identifier for a reservation
	 * @return reservation id
	 */

	public int getReservationID() {
		return reservationID;
	}
	/**
	 * sets unique identifier for a reservation
	 * @param reservationID unique identifier for a reservation
	 */
	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}
	/**
	 * gets the array of guest objects
	 * @return array of guest objects
	 */
	public ArrayList<Guest> getGuestDetails() {
		return guestDetails;
	}
	/**
	 * sets array of guest objects 
	 * @param guestDetails array of guest objects
	 */
	public void setGuestDetails(ArrayList<Guest> guestDetails) {
		this.guestDetails = guestDetails;
	}
	/**
	 * gets room object 
	 * @return room object
	 */
	public Room getRoomDetails() {
		return roomDetails;
	}
	/**
	 * sets room object
	 * @param roomDetails room object
	 */
	public void setRoomDetails(Room roomDetails) {
		this.roomDetails = roomDetails;
	}
	/**
	 * gets credit card name and number of guest(s)
	 * @return credit card name and number of guest(s)
	 */
	public String getBillingInformation() {
		return billingInformation;
	}
	/**
	 * sets credit card name and number of guest(s)
	 * @param billingInformation credit card name and number of guest(s)
	 */
	public void setBillingInformation(String billingInformation) {
		this.billingInformation = billingInformation;
	}
	/**
	 * gets check-in date of guest(s)
	 * @return check-in date of guest(s)
	 */
	public Calendar getCheckInDate() {
		return checkInDate;
	}
	/**
	 * sets check-in date of guest(s)
	 * @param checkInDate check-in date of guest(s)
	 */
	public void setCheckInDate(Calendar checkInDate) {
		this.checkInDate = checkInDate;
	}
	/**
	 * gets check-out date of guest(s)
	 * @return check-out date of guest(s)
	 */
	public Calendar getCheckOutDate() {
		return checkOutDate;
	}
	/**
	 * sets check-out date of guest(s)
	 * @param checkOutDate check-out date of guest(s)
	 */
	public void setCheckOutDate(Calendar checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	/**
	 * gets number of adults
	 * @return number of adults
	 */
	public int getAdultCount() {
		return adultCount;
	}
	/**
	 * sets number of adults
	 * @param adultCount number of adults
	 */
	public void setAdultCount(int adultCount) {
		this.adultCount = adultCount;
	}
	/**
	 * gets number of children
	 * @return number of children
	 */
	public int getChildrenCount() {
		return childrenCount;
	}
	/**
	 * sets number of children
	 * @param childrenCount number of children
	 */
	public void setChildrenCount(int childrenCount) {
		this.childrenCount = childrenCount;
	}
	/**
	 * gets the status of reservation
	 * @return status of reservation
	 */
	public StatusOfReservation getReservationStatus() {
		return reservationStatus;
	}
	/**
	 * sets status of reservation
	 * @param reservationStatus status of reservation
	 */
	public void setReservationStatus(StatusOfReservation reservationStatus) {
		this.reservationStatus = reservationStatus;
	}
	/**
	 * gets number of nights booked
	 * @return number of nights booked
	 */
	public int getnumberOfNights() {
		return numberOfNights;
	}
	/**
	 * sets number of nights booked
	 * @param numberOfNights number of nights booked
	 */
	public void setnumberOfNights(int numberOfNights) {
		this.numberOfNights = numberOfNights;
	}
	/**
	 * prints reservation details
	 * @return prints attributes of reservation onto the console
	 */
	public String printReservation() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String strDateIn = dateFormat.format(this.checkInDate.getTime());
        
        String strDateOut = dateFormat.format(this.checkOutDate.getTime());

        return "Guest Name: \t\t\t" + this.guestDetails.get(0).getName() + "\nContact:\t\t\t" + this.guestDetails.get(0).getContact()
                +"\nCheck In time: \t\t\t" + strDateIn +"\nCheck Out time: \t\t" + strDateOut + "\nNumber of Nights: \t\t" + this.getnumberOfNights() + "\nReservation ID: \t\t" + this.reservationID
                + "\nRoom Number: \t\t\t" + this.roomDetails.getRoomNumber() + "\nReservation Status:\t\t" + this.getReservationStatus() + "\nRoom Status:\t\t\t" + this.roomDetails.getRoomStatus();
    }
}
