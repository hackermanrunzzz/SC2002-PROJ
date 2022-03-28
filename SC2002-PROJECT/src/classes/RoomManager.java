package classes;

import java.util.ArrayList;



public class RoomManager {
	
    private static ArrayList<Room> rooms=new ArrayList<Room>();
    
    
    
    public RoomManager(ArrayList<Room> rooms) {
    	RoomManager.rooms = rooms; // Made a change here cos the static reference wasn't accepted
    }
    
    public void setRooms(ArrayList<Room> rooms) {
        RoomManager.rooms = rooms;
    }
    
    
    public void displayRoom(){
        for (int i = 0; i < rooms.size(); i++) {
          System.out.printf("room number: %s, room type: %s, bed type: %s, status: %s \n", rooms.get(i).getRoomNumber(), rooms.get(i).getRoomType(), rooms.get(i).getBedType(), rooms.get(i).getRoomStatus() );
        }
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
