package classes;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import Initialiser.Initialise;

/**
 * @author Darren Wong 
 * @version 1.0
 * @since 14/4/2022
 */
public class Order implements Serializable{
	
	/**
	 *  status of order
	 */
	public enum StatusOfOrder{
		/**
		 * order is confirmed
		 */
		CONFIRMED, 
		/**
		 * order is being prepared
		 */
		PREPARING,
		/**
		 * order is being delivered
		 */
		DELIVERED}
	
	/**
	 *  unique identifier of order
	 */
	private String OrderID;
	/**
	 * unique identifier of reservation
	 */
	private int ResID;
	/**
	 *  room number
	 */
	private String RoomNumber;
	/**
	 *  time of order
	 */
	private Calendar timeOfOrder;
	/**
	 *  additional remarks for food
	 */
	private String remarks;
	/**
	 *  status of order
	 */
	private StatusOfOrder orderStatus;
	/**
	 *  total price of order
	 */
	private double totalPrice;
	/**
	 * array list of menu items ordered
	 */
	private ArrayList<MenuItem> menuI;
	


	/**
	 * 
	 * @param OrderID unique identifier for order
	 * @param ResID unique identifier for reservation
	 * @param RoomNumber room number
	 * @param time time of order
	 * @param remarks additional remarks
	 * @param orderStatus status of order
	 * @param totalPrice total price of order
	 * @param menuI array list of menu items ordered
	 */
	public Order(String OrderID, int ResID,String RoomNumber, Calendar time, String remarks, StatusOfOrder orderStatus, double totalPrice, ArrayList<MenuItem> menuI) 
	{
		this.OrderID = OrderID;
		this.ResID = ResID;
		this.RoomNumber = RoomNumber;
		this.timeOfOrder = time;
		this.remarks = remarks;
		this.orderStatus = orderStatus;
		this.totalPrice = totalPrice;
		this.menuI = menuI;
	}








	/**
	 * get order id
	 * @return order id
	 */
    public String getOrderID() {
		return OrderID;
	}




    /**
     * set order id
     * @param orderID order id
     */
	public void setOrderID(String orderID) {
		OrderID = orderID;
	}




	/**
	 * get reservation id
	 * @return reservation id
	 */
	public int getResID() {
		return ResID;
	}




	/**
	 * set reservation id
	 * @param resID reservation id
	 */
	public void setResID(int resID) {
		ResID = resID;
	}




	/**
	 * get time of order
	 * @return time of order
	 */
	public Calendar getTimeOfOrder() {
		
		
		return timeOfOrder;
	}




	/**
	 * set time of order
	 * @param timeOfOrder time of order
	 */
	public void setTimeOfOrder(Calendar timeOfOrder) {
		this.timeOfOrder = timeOfOrder;
	}




	/**
	 * get additional remarks of order
	 * @return additional remarks of order
	 */
	public String getRemarks() {
		return remarks;
	}




	/**
	 * set additional remarks
	 * @param remarks additional remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}




	/**
	 * get status of order
	 * @return status of order
	 */
	public StatusOfOrder getOrderStatus() {
		return orderStatus;
	}




	/**
	 * set status of order
	 * @param orderStatus status of order
	 */
	public void setOrderStatus(StatusOfOrder orderStatus) {
		this.orderStatus = orderStatus;
	}




	/**
	 * get total price of order
	 * @return total price of order
	 */
	public double getTotalPrice() {
		return totalPrice;
	}




	/**
	 * set total price of order
	 * @param totalPrice total price of order
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}







	/**
	 * get room number of order
	 * @return room number of order
	 */
	public String getRoomNumber() {
		return RoomNumber;
	}




	/**
	 * set room number of order
	 * @param roomNumber room number
	 */
	public void setRoomNumber(String roomNumber) {
		RoomNumber = roomNumber;
	}




	/**
	 * get array list of menu items ordered
	 * @return array list of menu items ordered
	 */
	public ArrayList<MenuItem> getMenuI() {
		return menuI;
	}




	/**
	 * set array list of menu items
	 * @param menuI array list of menu items
	 */
	public void setMenuI(ArrayList<MenuItem> menuI) {
		this.menuI = menuI;
	}




	/**
	 * view order
	 * @return order
	 */
	public String printOrder() {
		  DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	        String strtimeOfOrder = dateFormat.format(this.timeOfOrder.getTime());
	        
	      
      

        return "OrderID : \t\t\t" + this.getOrderID() + "\nResid: \t\t\t\t" + this.getResID()  + "\nRoomNumber: \t\t\t" + this.getRoomNumber() + "\nTime Of Order: \t\t\t"  + strtimeOfOrder + "\nRemarks : \t\t\t" + this.getRemarks()  + "\nStatus Of Order:  \t\t"
   + this.getOrderStatus() +  "\nTotal Price : \t\t\t" + "$"+ this.getTotalPrice();            
              
    }
	
	
	
	
	/**
	 * print menu items
	 * @param menuitems array list of menu items
	 */
	 public void printIndividualfood (ArrayList<MenuItem> menuitems) {
		  
		  for (int y = 0 ; y<menuitems.size(); y++) {
			  
			  System.out.println(menuitems.get(y).getName() +"           " +  menuitems.get(y).getPrice() + "\n" );
		  }
	  }
	
	

}

