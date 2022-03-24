package classes;

import java.util.ArrayList;



public class RoomManager {
	
    private static ArrayList<Room> rooms=new ArrayList<Room>();
    
    
    
    public RoomManager(ArrayList<Room> rooms) {
    	this.rooms = rooms;
    }
    
    
    public void DisplayRoom(){
        for (int i = 0; i < rooms.size(); i++) {
          System.out.println("room number is" + rooms.get(i).getRoomNumber() );
        }
      }
    
    public void setRooms(ArrayList<Room> rooms) {
        RoomManager.rooms = rooms;
    }
    


}
