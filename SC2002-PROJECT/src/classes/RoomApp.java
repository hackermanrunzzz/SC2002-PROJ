//package classes;
//
//import java.util.ArrayList;
//
//import classes.Room.StatusOfRoom;
//import classes.Room.TypeOfBed;
//import classes.Room.TypeOfRoom;
//
//public class RoomApp {
//
//	public static void main(String[] args) {
//		//testing to see if my eclipse works -darrenchoo
//
//		int i;
//		ArrayList<Room> rooms = new ArrayList<Room>();
//		RoomManager rm = new RoomManager(rooms);
//		
//		
//		//10 single rooms on floor 2
//		for (i=1; i<=10;i++) {
//			Integer.toString(i);
//			Integer.toString(i);
//			rooms.add(new Room("02-" + String.format("%02d", i) ,  TypeOfRoom.SINGLE , TypeOfBed.SINGLE, true, true, false, StatusOfRoom.VACANT, 200) );
//			
//		}
//		
//		//10 single rooms on floor 3
//		for (i=1; i<=10;i++) {
//			Integer.toString(i);
//			Integer.toString(i);
//			rooms.add(new Room("03-" + String.format("%02d", i),  TypeOfRoom.SINGLE , TypeOfBed.SINGLE, true, true, false, StatusOfRoom.VACANT, 200) );
//			//
//		}
//		
//		//8 double rooms on floor 4
//		for (i=1; i<=10;i++) {
//			Integer.toString(i);
//			rooms.add(new Room("04-" + String.format("%02d", i) ,  TypeOfRoom.DOUBLE , TypeOfBed.SINGLE, true, true, false, StatusOfRoom.VACANT, 350) );
//			
//		}
//		
//		//8 double rooms on floor 5
//		for (i=1; i<=10;i++) {
//			Integer.toString(i);
//			rooms.add(new Room("05-" + String.format("%02d", i) ,  TypeOfRoom.DOUBLE , TypeOfBed.SINGLE, true, true, false, StatusOfRoom.VACANT, 350) );
//			
//		}
//		
//		//8 deluxe rooms on floor 6
//		for (i=1; i<=10;i++) {
//			Integer.toString(i);
//            rooms.add(new Room("06-" + String.format("%02d", i) ,  TypeOfRoom.DELUXE , TypeOfBed.QUEEN, true, true, false, StatusOfRoom.VACANT, 400) );
//			
//		}
//		
//		//4 VipSuite rooms on floor 7
//		for (i=1; i<=10;i++) {
//			Integer.toString(i);
//			rooms.add(new Room("07-" + String.format("%02d", i) ,  TypeOfRoom.VIPSUITE , TypeOfBed.KING, true, true, true, StatusOfRoom.VACANT, 500) );
//			
//		}
//				
//		
//		
//		
//	}
//
//}
