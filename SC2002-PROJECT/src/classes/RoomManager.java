package classes;

import java.util.ArrayList;



public class RoomManager {
	
    private static ArrayList<Room> rooms=new ArrayList<Room>();
    
    
    
    public RoomManager(ArrayList<Room> rooms) {
    	this.rooms = rooms;
    }
    
    
    public void DisplayRoom(){
        for (int i = 0; i < rooms.size(); i++) {
          System.out.printf("room number:%s, room type: %s, bed type: %s, status: %s \n", rooms.get(i).getRoomNumber(), rooms.get(i).getRoomType(), rooms.get(i).getBedType(), rooms.get(i).getRoomStatus() );
        }
      }
    
    public void setRooms(ArrayList<Room> rooms) {
        RoomManager.rooms = rooms;
    }
    


}
