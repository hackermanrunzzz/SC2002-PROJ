package classes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.UUID;

import Initialiser.Initialise;
import classes.Order.StatusOfOrder;
import classes.Reservation.StatusOfReservation;


public class OrderManager {
	private static ArrayList<Reservation> reservations = new ArrayList<Reservation>();

   private static ArrayList<Order> orders = new ArrayList<Order>();
    /**
     * create an array of paid orders
     */
	Scanner sc = new Scanner(System.in);

    /**
     * constructor for order manager
     * @param pendingOrders array of pending orders
     * @param paidOrders array of paid orders
     */
    public OrderManager(ArrayList<Order> orders) {
        OrderManager.orders = orders;
       
    }

    public static ArrayList<Reservation> getReservations() {
		return reservations;
	}

	public static void setReservations(ArrayList<Reservation> reservations) {
		OrderManager.reservations = reservations;
	} 
	// Needed to create the above getter and setter to resolve error in line 11

	/**
     * get the pending order for the table
     * @param tableID table belonging to the pending order
     * @return order
     */

    
    public Order getOrder(int ResID){
        for(Order o: orders )
		{
            if(o.getResID() == ResID)
			{
				return o;
			}
        }
        return new Order(null, ResID, null, null, null, null, ResID, null); // Resolved some errors
    } // No error-checking required here
    
//
//    
//    public Order getOrder(int ResID){
//        for(Order o: orders )
//		{
//            if(o.getResID() == ResID)
//			{
//				return o;
//			}
//        }
//        return new Order();
//    }
//    

    /**
     * check if the order is pending
     * @param tableID table belonging to the order
     * @return boolean value
     */
  
    /**
     * create an order
     * @param staffID to attend to order
     * @param tableID table at which order is made
     * @param menu menu to order from
     */
    public void createOrder( int ResID, String RoomNumber, ArrayList<MenuItem> menu) {
        Order new_order= new Order(ResID,RoomNumber, menu);
        orders.add(new_order);
    public void createOrder( int ResID,String RoomNumber, Calendar time, String remarks, double totalPrice, ArrayList<MenuItem> menuI) {
    	 String OrderID = UUID.randomUUID().toString();

        Order ordering = new Order( OrderID, ResID, RoomNumber,  time,  remarks,StatusOfOrder.CONFIRMED, totalPrice, menuI);
        orders.add(ordering);
    }

    /**
     * find the order for a table
     * @param TableID at which order is being placed
     * @return the order id
     */
    public static String findOrderID(int ResID,String RoomNumber) {
        for (Order o : orders)
		{
            if (o.getResID() == ResID)
			{
				return o.getOrderID();
			}
        }
        System.out.println("No existing order for this room");
        return null;
    }

    /**
     * find the order for a table
     * @param TableID at which order is being placed
     * @return the order
     */

    
    public double calculateAmount() {
        double amount = 0;

        for (int i = 0; i < orders.size(); i++) {
        	for (int y = 0; y < orders.get(i).getMenuI().size(); y++)
            amount = amount + orders.get(i).getMenuI().get(y).getPrice();
        }
        return amount; // This returns total price of ALL MenuItems

     
        return amount;
    }
	
	   public void addFoodOrder(Order order, MenuItem food){
	      //  order.menu.getFoods().add(food);
	        calculateAmount();
	        
	        order.getMenuI().add(food);
	        calculateAmount();
	    }
	   
	   
	   
	   
	   
	   public void createOrderUI(){
			Scanner sc = new Scanner(System.in);
			int found = 0;
			
	        System.out.println("========================================");
	        System.out.println("Creating Room Service Order");
	        System.out.println("----------------------------------------");

	        int table =0;
	        
	        System.out.println("Enter Reservation ID : ");
	        int  ResID = sc.nextInt();
	        System.out.println("Enter Room Number");
	        String RoomNumber = sc.next();

	        
	      
	        //sc.nextLine();
	        
	        for (int i = 0 ; i < Initialise.reservations.size(); i++)
			{
	        	if (ResID == Initialise.reservations.get(i).getReservationID() && Initialise.reservations.get(i).getReservationStatus().equals(StatusOfReservation.CHECKED_IN))
	        	{
	        		found = 1;
	        	}
	        	else 
				{
	        		found = -1;
	        		System.out.println("reservation not found");
	        	}
	        }
	        if (found == 1) 
	        {
	        	System.out.println(("reservation found please proceed to order"));
	        }
	        else
			{
	        	System.out.println("reservation not found");
	        	return;
	        }

			// Removed the not_found variable above, since can just use found for the if-else statements
	        	
	        	
//	        if(!Restaurant.tableManager.checkAvailability(table)){
//	            System.out.println("Table is not occupied.");
//	            return;
//	        }
//	        if(Restaurant.allOrders.checkPendingOrder(table)){
//	            System.out.println("Order already created. Please add/remove items to order instead.");
//	            return;
//	        }

	        //ensure no more than 4
	        sc.nextLine();

	        Initialise.mm.printMenu();
	        int choice;
	        do{
	            System.out.println("Enter index of a-la-carte menu items ordered: (Enter -1 to exit)");
	            choice = sc.nextInt();
	            sc.nextLine();
	            if(choice ==-1)
				{
					break;
				}
	            try
				{
	                MenuItem food = Initialise.menu.get(choice-1);
	                
	                Initialise.roomServiceitems.add(food);
	                
	               
	                
	              
	              //  menu.getFoods().add(food);
	                System.out.print(choice+". ");
	                System.out.println(food.getName()+" has been added to order.");
	                System.out.println("--------------------------------------------------------------------------------");
	            }
	            catch(IndexOutOfBoundsException e)
				{
	                System.out.println("Index of menu item is invalid. Please re-enter");
	            }

	        }while(choice!=-1);
	       // Restaurant.menu.printShortPromoMenu();
	        //Initialise.mm.printMenu();
	        
	        System.out.println("Please Enter Additional Remarks (If Any)");
	        String remarks = sc.next();
	        
	        
//	        do {
//
//	            System.out.println("Enter index of Promotion Set Package ordered: (Enter -1 to exit)");
//	            choice = sc.nextInt();
//	            sc.nextLine();
//	            if(choice ==-1)break;
//	            try{
//	                PromotionSet promo = Restaurant.menu.getPromos().get(choice-1);
//	                menu.getPromos().add(promo);
//	                System.out.print(choice+". ");
//	                System.out.println(promo.getName()+" has been added to order.");
//	                System.out.println("--------------------------------------------------------------------------------");
//	            }
//	            catch(IndexOutOfBoundsException e){
//	                System.out.println("Index of Promotion Set Package is invalid. Please re-enter");
//	            }
//
//	        } while(choice!=-1);

	       // Restaurant.allOrders.createOrder(staff,table,menu);
	        Calendar timenow = Calendar.getInstance();
	        double totalp = 0;
	        for (int i = 0; i < Initialise.roomServiceitems.size();i++) 
	        {		
		         totalp = totalp + Initialise.roomServiceitems.get(i).getPrice(); 		
		      }
	        
	        for (int f = 0 ; f < Initialise.roomServiceitems.size(); f++) {
	        	System.out.println(Initialise.roomServiceitems.get(f).getName());
	        }
	        
	        createOrder(ResID, RoomNumber,timenow,remarks, totalp,Initialise.roomServiceitems);
//	       System.out.println( orders.get(0));
//	       System.out.println( orders.get(0).getResID());
	       System.out.println( orders.get(0).printOrder());
	       printIndividualfood(Initialise.roomServiceitems);
	       
//	  
	    }
	        
	        


	       
	     
	    	
	
	
	  public void viewOrderUI(){
			Scanner sc = new Scanner(System.in);
			Order test;
	        System.out.println("--------------------------------------------------------------------------------");
	        System.out.println("Enter RES ID and Room Number to view room order.");
	        int resIDROOM;
	        String roomNum;
	        while(true) {
	            System.out.println("Enter RESID (Press -1 to Exit)  : ");
	            resIDROOM = sc.nextInt();
	            System.out.println("Enter RoomNumber (Press -1 to exit)");
	            roomNum = sc.nextLine();
	            
	            
	            if (resIDROOM != 1 && roomNum != "-1") {
	            	break;
	            }
	            
	        }
	         
	       
	        
	        searchOrders(resIDROOM,roomNum);
	  }
	            
	            
//	        if(Initialise.roomm.){
//	            System.out.println("Table is not occupied.");
//	            return;
//	        }
//	        if(!Restaurant.allOrders.checkPendingOrder(table)){
//	            System.out.println("There are no existing orders for table "+table);
//	            return;
//	        }


	        try{
	        	Order order =  OrderManager.findOrder(resIDROOM, roomNum);
	            System.out.println("============================= CURRENT TABLE ORDER =================================");
	    
//	  
//	  public Order findOrder(int ResID,String RoomNumber) {
//	        String id = findOrderID(ResID, RoomNumber);
//	       
//	        for (Order o : orders) {
//	            if (id == o.getOrderID()) return o;
//	        }
//	        return order;
//	    }
//	  
	  public int searchOrders( int ResID, String RoomNumber) {
      if(orders.isEmpty() == true){
          System.out.println("\nThere are currently no orders");
          return 0;
      }
      else{
          for(int k = 0 ; k <orders.size(); k ++){
              if(orders.get(k).getResID() == ResID){
                  System.out.println("========================================");

                  System.out.println("\nFound Order: ");
                  System.out.println(orders.get(k).printOrder());
                  return 1;
              }
          }
          System.out.println("Order not found.");
      }
      return -1;
	  }
	  
	  public void printIndividualfood (ArrayList<MenuItem> menuitems) {
		  
		  for (int y = 0 ; y<menuitems.size(); y++) {
			
			  System.out.println(menuitems.get(y).getName() +"           " +  menuitems.get(y).getPrice() + "\n" );
		  }
	  }

	  
	  public void showAllOrders() {

	        if (orders.isEmpty() == true) {
	            System.out.println("\nThere are currently no reservations");
	        } 
	        else 
			{
	            System.out.println("============ ALL Orders ===============");

	    	}
		}
	  
	  
	  public static Order findOrder(int ResID,String RoomNumber) {
	        String id = findOrderID(ResID, RoomNumber);
	        Order order = new Order();
	        for (Order o : OrderManager.orders)
			{
	            if (id == o.getOrderID())
				{
					return o;
				}
	            for (Order q : orders) {
//	                Date date = r.getCheckInDate().getTime();
//	                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
//	                String strDate = dateFormat.format(date);
	                System.out.println(o.printOrder());
	                System.out.println();
	            }
	        }
	    }
	    	


	}
