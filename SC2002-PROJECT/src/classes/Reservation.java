package classes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Reservation {
	
	public enum StatusOfReservation{CONFIRMED,IN_WAITLIST,CHECKED_IN,EXPIRED}
	private double reservationID;
	private Guest guestDetails; // Assuming one guest to a reservation (the guestdetails will be the object name)
	private Room roomDetails;
	private String billingInformation; // For cash or credit card
	private Calendar checkInDate;
	private Calendar checkOutDate;
	private int adultCount;
	private int childrenCount;
	private StatusOfReservation reservationStatus;
	private int numberOfDays;
	
	
	
	
	
	
	public Reservation(double reservationID, Guest guestDetails, Room roomDetails, String billingInformation,
			Calendar checkInDate, Calendar checkOutDate, int adultCount, int childrenCount,
			StatusOfReservation reservationStatus, int numberOfDays) {
		super();
		this.reservationID = reservationID;
		this.guestDetails = guestDetails;
		this.roomDetails = roomDetails;
		this.billingInformation = billingInformation;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.adultCount = adultCount;
		this.childrenCount = childrenCount;
		this.reservationStatus = reservationStatus;
		this.numberOfDays = numberOfDays;
	}









	public double getReservationID() {
		return reservationID;
	}









	public void setReservationID(double reservationID) {
		this.reservationID = reservationID;
	}









	public Guest getGuestDetails() {
		return guestDetails;
	}









	public void setGuestDetails(Guest guestDetails) {
		this.guestDetails = guestDetails;
	}









	public Room getRoomDetails() {
		return roomDetails;
	}









	public void setRoomDetails(Room roomDetails) {
		this.roomDetails = roomDetails;
	}









	public String getBillingInformation() {
		return billingInformation;
	}









	public void setBillingInformation(String billingInformation) {
		this.billingInformation = billingInformation;
	}









	public Calendar getCheckInDate() {
		return checkInDate;
	}









	public void setCheckInDate(Calendar checkInDate) {
		this.checkInDate = checkInDate;
	}









	public Calendar getCheckOutDate() {
		return checkOutDate;
	}









	public void setCheckOutDate(Calendar checkOutDate) {
		this.checkOutDate = checkOutDate;
	}









	public int getAdultCount() {
		return adultCount;
	}









	public void setAdultCount(int adultCount) {
		this.adultCount = adultCount;
	}









	public int getChildrenCount() {
		return childrenCount;
	}









	public void setChildrenCount(int childrenCount) {
		this.childrenCount = childrenCount;
	}









	public StatusOfReservation getReservationStatus() {
		return reservationStatus;
	}









	public void setReservationStatus(StatusOfReservation reservationStatus) {
		this.reservationStatus = reservationStatus;
	}









	public int getNumberOfDays() {
		return numberOfDays;
	}









	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}









	public String printReservation() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String strDate = dateFormat.format(this.checkInDate.getTime());

        return "Guest Name: \t\t\t" + this.guestDetails.getName() + "\nContact:\t\t\t\t" + this.guestDetails.getContact()
                +"\nCheck in time: \t\t\t" + strDate + "\nReservation ID: \t\t" + this.reservationID
                + "\nRoom Number: \t\t\t\t" + this.roomDetails.getRoomNumber() + "\n";
    }
	
	
	

	

}
