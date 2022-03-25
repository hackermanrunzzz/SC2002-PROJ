package classes;

import java.util.ArrayList;

import classes.Room.StatusOfRoom;
import classes.Room.TypeOfBed;
import classes.Room.TypeOfRoom;

public class RoomApp {

	public static void main(String[] args) {
		//testing to see if my eclipse works -darrenchoo

		int i;
		ArrayList<Room> rooms = new ArrayList<Room>();
		RoomManager rm = new RoomManager(rooms);
		
		for (i=0; i<48;i++) {
			rooms.add(new Room(" 02-" + Integer.toString(i).format("%02d",i) ,  TypeOfRoom.SINGLE , TypeOfBed.SINGLE, true, true, false, StatusOfRoom.VACANT, 200) );
			
		}
		
		//rooms.add(new Room(" 02-03 ",  TypeOfRoom.SINGLE , TypeOfBed.SINGLE, true, true, false, StatusOfRoom.VACANT, 200));
		//rooms.add(new Room(" 02-04 ",  TypeOfRoom.DOUBLE , TypeOfBed.QUEEN, true, true, false, StatusOfRoom.VACANT, 200));

		
		rm.setRooms(rooms);
		rm.DisplayRoom();
		
		
		
		
	}

}
