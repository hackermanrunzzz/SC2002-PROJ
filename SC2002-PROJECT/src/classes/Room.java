package classes;

public class Room {
	public enum StatusOfRoom {VACANT, OCCUPIED, RESERVED, UNDER_MAINTENANCE}
	public enum TypeOfRoom {SINGLE, DOUBLE, DELUXE, VIPSUITE}
	public enum TypeOfBed {SINGLE, QUEEN, KING}

	private String roomNumber;
	private TypeOfRoom roomType;
	private TypeOfBed bedType;
	private boolean wifiEnabled;
	private boolean view;
	private boolean smokingAllowed;
	private StatusOfRoom roomStatus;
	private int rate;

	public Room(String roomNumber, TypeOfRoom roomType, TypeOfBed bedType, boolean wifiEnabled, boolean view, boolean smokingAllowed, StatusOfRoom roomStatus, int rate) {
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.bedType = bedType;
		this.wifiEnabled = wifiEnabled;
		this.view = view;
		this.smokingAllowed = smokingAllowed;
		this.roomStatus = roomStatus;
		this.rate = rate;
	}

	public void setRoomStatus(StatusOfRoom roomStatus) {
		this.roomStatus = roomStatus;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public TypeOfRoom getRoomType() {
		return roomType;
	}

	public TypeOfBed getBedType() {
		return bedType;
	}

	public boolean isWifiEnabled() {
		return wifiEnabled;
	}

	public boolean isView() {
		return view;
	}

	public boolean isSmokingAllowed() {
		return smokingAllowed;
	}

	public StatusOfRoom getRoomStatus() {
		return roomStatus;
	}

	public int getRate() {
		return rate;
	}

	public void printRoomInfo(){
		System.out.println("Room " + this.getRoomNumber() + " is " + this.getRoomStatus());
	}
}
