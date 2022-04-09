package classes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Reservation {
	
	public enum StatusOfReservation{CONFIRMED,IN_WAITLIST,CHECKED_IN,EXPIRED}
	private int reservationID;
	private ArrayList<Guest> guestDetails; 
	private Room roomDetails;
	private String billingInformation; // For cash or credit card
	private Calendar checkInDate;
	private Calendar checkOutDate;
	private int adultCount;
	private int childrenCount;
	private StatusOfReservation reservationStatus;
	private int numberOfNights;
	
	
	
	

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

	




	public int getReservationID() {
		return reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}


	public ArrayList<Guest> getGuestDetails() {
		return guestDetails;
	}


	public void setGuestDetails(ArrayList<Guest> guestDetails) {
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

	public int getnumberOfNights() {
		return numberOfNights;
	}

	public void setnumberOfNights(int numberOfNights) {
		this.numberOfNights = numberOfNights;
	}
	
	public String printReservation() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String strDateIn = dateFormat.format(this.checkInDate.getTime());
        
        String strDateOut = dateFormat.format(this.checkOutDate.getTime());

        return "Guest Name: \t\t\t" + this.guestDetails.get(0).getName() + "\nContact:\t\t\t" + this.guestDetails.get(0).getContact()
                +"\nCheck In time: \t\t\t" + strDateIn +"\nCheck Out time: \t\t" + strDateOut + "\nNumber of Nights: \t\t" + this.getnumberOfNights() + "\nReservation ID: \t\t" + this.reservationID
                + "\nRoom Number: \t\t\t" + this.roomDetails.getRoomNumber() + "\nReservation Status:\t\t" + this.getReservationStatus() + "\nRoom Status:\t\t\t" + this.roomDetails.getRoomStatus();
    }

}
