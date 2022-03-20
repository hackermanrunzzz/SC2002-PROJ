enum StatusOfReservation{
	Confirmed,
	In_Waitlist,
	Checked_In,
	Expired
}
public class Reservation {
	public double reservationCode;
	public Guest guestDetails; // Assuming one guest to a reservation
	public Room[] roomInformation; // For more than one room a reservation
	public String billingInformation; // For cash or credit card
	public String checkInDate;
	public String checkOutDate;
	public int adultCount;
	public int childrenCount;
	public StatusOfReservation reservationStatus;
	public int numberOfRooms;
	
	public Reservation()
	{
		
	}
	

}
