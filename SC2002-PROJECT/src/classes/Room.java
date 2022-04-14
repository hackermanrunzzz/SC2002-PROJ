package classes;


/**
 * @author Darren Wong
 * @version 1.0
 * @since 14 april 2022
 */
public class Room {
	
	/**
	 * status of room
	 */
	public enum StatusOfRoom {
		/**
		 *  room is vacant
		 */
		VACANT, 
		/**
		 * room is occupied
		 */
		OCCUPIED, 
		/**
		 * room is reserved
		 */
		RESERVED, 
		/**
		 * room is under maintenance
		 */
		UNDER_MAINTENANCE}
	/**
	 * type of room
	 */
	public enum TypeOfRoom {
		/**
		 *  single room
		 */
		SINGLE,
		/**
		 * double room
		 */
		DOUBLE, 
		/**
		 * deluxe room
		 */
		DELUXE, 
		/**
		 * vip suite room
		 */
		VIPSUITE}
	/**
	 *  type of bed
	 */
	public enum TypeOfBed {
		/**
		 * single bed
		 */
		SINGLE, 
		/**
		 * queen bed
		 */
		QUEEN, 
		/**
		 * king bed
		 */
		KING}

	/**
	 * room number
	 */
	private String roomNumber;
	/**
	 *  type of room
	 */
	private TypeOfRoom roomType;
	/**
	 *  type of bed
	 */
	private TypeOfBed bedType;
	/**
	 * room with wifi/room with no wifi
	 */
	private boolean wifiEnabled;
	/**
	 * view or no view
	 */
	private boolean view;
	/**
	 * smoking room/ non-smoking room
	 */
	private boolean smokingAllowed;
	/**
	 * status of room
	 */
	private StatusOfRoom roomStatus;
	/**
	 * room rates
	 */
	private int rate;
	/**
	 * constructor for room
	 * @param roomNumber room number
	 * @param roomType type of room
	 * @param bedType type of bed
	 * @param wifiEnabled room with wifi/ room with no wifi
	 * @param view room with a view/ room with no view
	 * @param smokingAllowed smoking room / non-smoking room
	 * @param roomStatus status of room
	 * @param rate room rates
	 */

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
	
	/**
	 * set status of room
	 * @param roomStatus status of room
	 */

	public void setRoomStatus(StatusOfRoom roomStatus) {
		this.roomStatus = roomStatus;
	}
	/**
	 * set room rates
	 * @param rate room rates
	 */

	public void setRate(int rate) {
		this.rate = rate;
	}
	/**
	 * gets room number
	 * @return room number
	 */

	public String getRoomNumber() {
		return roomNumber;
	}
	/**
	 * get type of room
	 * @return type of room
	 */

	public TypeOfRoom getRoomType() {
		return roomType;
	}
	/**
	 * get type of bed
	 * @return type of bed
	 */

	public TypeOfBed getBedType() {
		return bedType;
	}
	/**
	 * checks if room has wifi
	 * @return room has wifi/ room doesn't have wifi
	 */

	public boolean isWifiEnabled() {
		return wifiEnabled;
	}
	/**
	 * check if room has a view
	 * @return room has a view / room doesnt have a view
	 */

	public boolean isView() {
		return view;
	}
	/**
	 * check if smoking is allowed in the room
	 * @return is smoking allowed in the room
	 */

	public boolean isSmokingAllowed() {
		return smokingAllowed;
	}
	/**
	 * get status of room
	 * @return status of room
	 */

	public StatusOfRoom getRoomStatus() {
		return roomStatus;
	}
	/**
	 * get room rates
	 * @return rate 
	 */
	

	public int getRate() {
		return rate;
	}


}
