package classes;
import java.util.Calendar;

public class Reservation {
	public enum StatusOfReservation{CONFIRMED,IN_WAITLIST,CHECKED_IN,EXPIRED}
	private double reservationCode;
	private Guest guestDetails; // Assuming one guest to a reservation (the guestdetails will be the object name)
	private String billingInformation; // For cash or credit card
	private Calendar checkInDate;
	private Calendar checkOutDate;
	private int adultCount;
	private int childrenCount;
	private StatusOfReservation reservationStatus;
	private int numberOfRooms;
	private int numberOfDays;
	
	
	
	

	

}
