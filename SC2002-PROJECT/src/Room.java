public class Room {
	public enum StatusOfRoom {VACANT, OCCUPIED, RESERVED, UNDER_MAINTENANCE}
	public enum TypeOfRoom {SINGLE, DOUBLE, DELUXE, VIPSUITE}
	public enum TypeOfBed {SINGLE, QUEEN, KING}
	public String roomNumber;
	public TypeOfRoom roomType;
	public TypeOfBed bedType;
	public boolean wifiEnabled;
	public boolean view;
	public boolean smokingAllowed;
	public StatusOfRoom roomStatus;
	public int rate;
	
	public Room()
	{
		
	}
	

}
