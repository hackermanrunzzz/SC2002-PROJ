package classes;

import java.util.ArrayList;

import classes.Room.TypeOfRoom;



public class RoomManager {
	
    private static ArrayList<Room> rooms=new ArrayList<Room>();
    
    
    
    public RoomManager(ArrayList<Room> rooms) {
    	RoomManager.rooms = rooms; // Made a change here cos the static reference wasn't accepted
    }
    
    public void setRooms(ArrayList<Room> rooms) {
        RoomManager.rooms = rooms;
    }
    
    
    public void displayRoomViaOccupancy(){
    	int singlerm = 0, doublerm = 0, deluxerm = 0, vipsuiterm = 0;
    	System.out.println("============ SINGLE ============");
    	System.out.print("Rooms: ");
        for(Room r: rooms) {
        	if(r.getRoomType().equals(Room.TypeOfRoom.SINGLE) && r.getRoomStatus().equals(Room.StatusOfRoom.VACANT)) {
        		System.out.print(r.getRoomNumber() + ", ");
        		singlerm++;
        	}
        }
        System.out.println();
        System.out.printf("Number: %d out of 20\n", singlerm);
        System.out.println();
        
        System.out.println("============ DOUBLE ============");
    	System.out.print("Rooms: ");
        for(Room r: rooms) {
        	if(r.getRoomType().equals(Room.TypeOfRoom.DOUBLE) && r.getRoomStatus().equals(Room.StatusOfRoom.VACANT)) {
        		System.out.print(r.getRoomNumber() + ", ");
        		doublerm++;
        	}
        }
        System.out.println();
        System.out.printf("Number: %d out of 16\n", doublerm);
        System.out.println();
        
        System.out.println("============ DELUXE ============");
    	System.out.print("Rooms: ");
        for(Room r: rooms) {
        	if(r.getRoomType().equals(Room.TypeOfRoom.DELUXE) && r.getRoomStatus().equals(Room.StatusOfRoom.VACANT)) {
        		System.out.print(r.getRoomNumber() + ", ");
        		deluxerm++;
        	}
        }
        System.out.println();
        System.out.printf("Number: %d out of 8\n", deluxerm);
        System.out.println();
        
        System.out.println("=========== VIPSUITE ===========");
    	System.out.print("Rooms: ");
        for(Room r: rooms) {
        	if(r.getRoomType().equals(Room.TypeOfRoom.VIPSUITE) && r.getRoomStatus().equals(Room.StatusOfRoom.VACANT)) {
        		System.out.print(r.getRoomNumber() + ", ");
        		vipsuiterm++;
        	}
        }
        System.out.println();
        System.out.printf("Number: %d out of 4\n", vipsuiterm);
        System.out.println();
    }
    
    public void displayRoomViaStatus(){
    	int vacant = 0, occupied = 0, inMaintenance = 0, reserved = 0;
    	System.out.println("============ VACANT ============");
    	System.out.print("Rooms: ");
        for(Room r: rooms) {
        	if(r.getRoomStatus().equals(Room.StatusOfRoom.VACANT)) {
        		System.out.print(r.getRoomNumber() + ", ");
        		vacant++;
        	}
        }
        System.out.println();
        System.out.printf("Number: %d vacant room(s).\n", vacant);
        System.out.println();
        
        System.out.println("=========== OCCUPIED ===========");
    	System.out.print("Rooms: ");
        for(Room r: rooms) {
        	if(r.getRoomStatus().equals(Room.StatusOfRoom.OCCUPIED)) {
        		System.out.print(r.getRoomNumber() + ", ");
        		occupied++;
        	}
        }
        System.out.println();
        System.out.printf("Number: %d occupied room(s).\n", occupied);
        System.out.println();
        
        
        System.out.println("=========== RESERVED ===========");
    	System.out.print("Rooms: ");
        for(Room r: rooms) {
        	if(r.getRoomStatus().equals(Room.StatusOfRoom.RESERVED)) {
        		System.out.print(r.getRoomNumber() + ", ");
        		reserved++;
        	}
        }
        System.out.println();
        System.out.printf("Number: %d reserved room(s).\n", reserved);
        System.out.println();
        
      
        System.out.println("======= UNDER MAINTENANCE ======");
    	System.out.print("Rooms: ");
        for(Room r: rooms) {
        	if(r.getRoomStatus().equals(Room.StatusOfRoom.UNDER_MAINTENANCE)) {
        		System.out.print(r.getRoomNumber() + ", ");
        		inMaintenance++;
        	}
        }
        System.out.println();
        System.out.printf("Number: %d room(s) under maintenance.\n", inMaintenance);
        System.out.println();
        
        
    }
    
    public void setToMaintenance(String roomNumber){
        for(Room r: rooms){
            if(r.getRoomNumber() == roomNumber) {
            	r.setRoomStatus(Room.StatusOfRoom.UNDER_MAINTENANCE);
            }
        }
    }
    
    public void setToVacant(String roomNumber){
        for(Room r: rooms){
            if(r.getRoomNumber() == roomNumber) {
            	r.setRoomStatus(Room.StatusOfRoom.VACANT);
            }
        }
    }
    
    


}
