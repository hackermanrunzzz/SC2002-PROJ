package classes;


import java.util.ArrayList;
import java.util.Scanner;

import classes.Room.TypeOfRoom;
import initialiser.Initialise;


/**
 * @author darren wong
 * @version 1.0
 * @since 14/04/2022
 */
public class RoomManager {
	/**
	 * create an array list of rooms
	 */
    private static ArrayList<Room> rooms=new ArrayList<Room>();
    
    
    /**
     * constructor of room manager
     * @param rooms array list of rooms
     */
    public RoomManager(ArrayList<Room> rooms) {
    	RoomManager.rooms = rooms; // Made a change here cos the static reference wasn't accepted
    }
    
    /**
     * set array list of rooms
     * @param rooms array list of rooms
     */
    public void setRooms(ArrayList<Room> rooms) {
        RoomManager.rooms = rooms;
    }
    
    /**
     *  displaying the different rooms via occupancy
     */
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
    
    
    /**
     * displaying the different rooms via room status
     */
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
    
    
    /**
     * setting room status to under maintenance
     * @param roomNumber room number
     */
    
    public void setToMaintenance(String roomNumber){
        for(Room r: rooms){
            if(r.getRoomNumber().equals(roomNumber)) {
            	r.setRoomStatus(Room.StatusOfRoom.UNDER_MAINTENANCE);
            	System.out.println("Room status successfully updated to: UNDER_MAINTENANCE");
            	return;
            }
        }
        System.out.println("Unable to find Room Number.");
    }
    
    
    /**
     * set room status to vacant
     * @param roomNumber room number
     */
    public void setToVacant(String roomNumber){
        for(Room r: rooms){
            if(r.getRoomNumber().equals(roomNumber)) {
            	r.setRoomStatus(Room.StatusOfRoom.VACANT);
            	System.out.println("Room status successfully updated to: VACANT");
            	return;
            }
        }
        System.out.println("Unable to find Room Number.");
    }
    
    
    /**
     *  change room status
     */
    public void changeRoomStatus() {
    	Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("========================================");
            System.out.println("Select choice: ");
            System.out.println("(1) Set Room to Under-Maintenance");
            System.out.println("(2) Set Room to Vacant");
            System.out.println("(3) Go Back To Main Menu");
            System.out.println("========================================");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                	System.out.println("Please enter the Room Number: ");
                	String roomNum = sc.nextLine();
                	setToMaintenance(roomNum);
                    break;
                case 2:
                	System.out.println("Please enter the Room Number: ");
                	String roomNum2 = sc.nextLine();
                	setToVacant(roomNum2);
                    break;   
                default:
                	break;
            }
        } while (choice < 3);
    }
    
    


}
