package classes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import Initialiser.Initialise;


public class Order {
	private enum StatusOfOrder{CONFIRMED, PREPARING, DELIVERED}
	
	private String OrderID;
	private int ResID;
	private Calendar time;
	private String remarks;
	private StatusOfOrder orderStatus;
	private double totalPrice;
	private Room room;
	private String RoomNumber;
	private ArrayList<MenuItem> menuI;
	

	 public Order() {
	        this.OrderID = UUID.randomUUID().toString();
	        this.ResID = ResID;
	        this.time = Calendar.getInstance();
	        this.orderStatus = orderStatus;
	        this.room = room;
	        this.totalPrice = 0;// need to be calculated
	        this.menuI = Initialise.menu;
;	    }
	

	public Order(String orderID, Calendar time, String remarks, StatusOfOrder orderStatus, double totalPrice) {
		this.OrderID = UUID.randomUUID().toString();
		this.time = time;
		this.remarks = remarks;
		this.orderStatus = orderStatus;
		this.totalPrice = totalPrice;
		this.menuI = Initialise.menu;
	}
	
	public Order(int ResID,String RoomNumber,  ArrayList<MenuItem> menuI) {
		this.OrderID = UUID.randomUUID().toString();
		this.RoomNumber = room.getRoomNumber();
		this.time = time;
		this.remarks = remarks;
		this.orderStatus = orderStatus;
		this.totalPrice = totalPrice;
		this.menuI = Initialise.menu;
	}




    public String getOrderID() {
		return OrderID;
	}


	public void setOrderID(String orderID) {
		OrderID = orderID;
	}


	public int getResID() {
		return ResID;
	}


	public void setResID(int resID) {
		ResID = resID;
	}


	public Calendar getTime() {
		return time;
	}


	public void setTime(Calendar time) {
		this.time = time;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public StatusOfOrder getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(StatusOfOrder orderStatus) {
		this.orderStatus = orderStatus;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public Room getRoom() {
		return room;
	}


	public void setRoom(Room room) {
		this.room = room;
	}


	public String getRoomNumber() {
		return RoomNumber;
	}


	public void setRoomNumber(String roomNumber) {
		RoomNumber = roomNumber;
	}


	public ArrayList<MenuItem> getMenuI() {
		return menuI;
	}


	public void setMenuI(ArrayList<MenuItem> menuI) {
		this.menuI = menuI;
	}


	
    /**
     * create an order
     * @param order to be created
     * @return order
     */
  
    /**
     * check if food exists in menu
     * @param food item being ordered
     * @return value if food is in menu
     */
//    public int checkFood(MenuItem food) {
//        int exists = 0;
//        for (MenuItem f : this.menuM.getMenu()) {
//            if (f.getName().equals(food.getName())) return 1;
//        }
//        return 0;
//    }



    /**
     * add food item to order
     * @param order to add food item
     * @param food item to be added to order
     */
//    public void addFoodOrder(Order order, MenuItem food){
//        order.menuM.getMenu().add(food);
//        calculateAmount();
//    }



    /**
     * remove food item from order
     * @param food item to be removed
     */
//    public void removeFoodOrder(MenuItem food){
//        if(checkFood(food)==0){
//            System.out.println("Food item is not in the order. Cannot be removed.");
//            return;
//        }
//        this.menuM.getMenu().remove(food);
//        calculateAmount();
//    }

  

    /**
     * view the order
     */
 
	
	

}

