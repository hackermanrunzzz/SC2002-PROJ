enum StatusOfRoom{
	Vacant,
	Occupied,
	Reserved,
	Under_Maintenance
}


enum TypeOfRoom{
	Single,
	Double,
	Deluxe,
	VIPSuite
}


enum TypeOfBed{
	Single,
	Queen,
	King
}
public class Room {
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
