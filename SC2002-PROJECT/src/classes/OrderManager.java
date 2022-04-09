package classes;

import java.util.ArrayList;
import java.util.Scanner;

import Initialiser.Initialise;
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
        return new Order();
    }
    

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
        Order ordering = new Order(ResID,RoomNumber, menu);
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
        System.out.println("No existing order for this table");
        return null;
    }

    /**
     * find the order for a table
     * @param TableID at which order is being placed
     * @return the order
     */

    
	public double calculateAmount() {
        double amount = 0;
        for (int i = 0; i < Initialise.menu.size(); i++)
		{
            amount += Initialise.menu.get(i).getPrice();
        }
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
			int not_found=0;
			
	        System.out.println("========================================");
	        System.out.println("Creating Room Service Order");
	        System.out.println("----------------------------------------");

	        int table =0;
	        
	        System.out.println("Enter Reservation ID : ");
	        int  ResID = sc.nextInt();
	        System.out.println("Enter Room Number");
	        String RoomNumber = sc.next();

	        
	      
	        //sc.nextLine();
	        
	        for (int i = 0 ; i < Initialise.reservations.size(); i++) {
	        	if (ResID == Initialise.reservations.get(i).getReservationID() && Initialise.reservations.get(i).getReservationStatus().equals(StatusOfReservation.CHECKED_IN))
	        	{
	        		found = 1;
	        	
	        	}
	        	else {
	        		not_found = -1;
	        		System.out.println("reservation not found");
	        }
	        }
	        if (found == 1) 
	        {
	        	System.out.println(("reservation found please proceed to order"));
	        }
	        else {
	        	System.out.println("reservation not found");
	        	return;
	        }
	        	
	        	
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
	        do {
	            System.out.println("Enter index of a-la-carte menu items ordered: (Enter -1 to exit)");
	            choice = sc.nextInt();
	            sc.nextLine();
	            
	          
	            

	            if(choice ==-1)break;
	            try{
	                MenuItem food = Initialise.menu.get(choice-1);
	                
	                Initialise.roomServiceitems.add(food);
	                
	               
	                
	              
	              //  menu.getFoods().add(food);
	                System.out.print(choice+". ");
	                System.out.println(food.getName()+" has been added to order.");
	                System.out.println("--------------------------------------------------------------------------------");
	            }
	            catch(IndexOutOfBoundsException e){
	                System.out.println("Index of menu item is invalid. Please re-enter");
	            }

	        } while(choice!=-1);
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
	        System.out.println(Initialise.roomServiceitems);
	        Initialise.om.createOrder(ResID, RoomNumber, Initialise.roomServiceitems);
	    }
	        
	        

	

	       
	     
	    	
	
	
	  public void viewOrderUI(){
			Scanner sc = new Scanner(System.in);
			Order test;
	        System.out.println("--------------------------------------------------------------------------------");
	        System.out.println("Enter RES ID and Room Number to view room order.");
	        int resIDROOM =0;
	        String roomNum;
	        do{
	            System.out.println("Enter RESID  : ");
	            resIDROOM = sc.nextInt();
	            System.out.println("Enter RoomNumber");
	            roomNum = sc.next();
	            
	         findOrder(resIDROOM,roomNum);
	            
	            sc.nextLine();} while(findOrder(resIDROOM,roomNum) == null);
//	        if(Initialise.roomm.){
//	            System.out.println("Table is not occupied.");
//	            return;
//	        }
//	        if(!Restaurant.allOrders.checkPendingOrder(table)){
//	            System.out.println("There are no existing orders for table "+table);
//	            return;
//	        }


	        try{
	        Order order =  Initialise.om.findOrder(resIDROOM, roomNum);
	            System.out.println("============================= CURRENT TABLE ORDER =================================");

	      
	            System.out.println("Order ID : " + order.getOrderID());
	    		System.out.println("ResID :"  + order.getResID());
	    		System.out.println("RoomNumber : " + order.getRoomNumber());
	    		System.out.println(
	    				"=============================== A-LA CARTE ORDER ===================================");
	    		for (int j = 0; j < Initialise.menu.size(); j++) {
	    			int quantity = 0;
	    			for (int i = 0; i < order.getMenuI().size(); i++) {
	    				if (Initialise.menu.get(j).equals(order.getMenuI().get(i))) {   					
	    					quantity++;
	    				}
	    			}
	    			if (quantity != 0) {
	    				System.out.print((j + 1) + ". " + Initialise.mm.getFoods().get(j).getName()
	    						+ "          Quantity : " + quantity);
	    				System.out.printf("          Total Price : $%.2f\n",
	    						((double) quantity * Initialise.mm.getFoods().get(j).getPrice()));
	    			}
	    		}
	    		double totalp = 0;
	    		for ( int k = 0 ; k < orders.size(); k++) {
	    			totalp  = totalp + orders.get(k).getTotalPrice();
	    			
	    		}
	    		System.out.println(
	    				"====================================================================================");

	    		System.out.printf( 
	    				"                                                     Current Total Bill : $%.2f",
	    				totalp);
	    		System.out.println();

	    		
;}
	        catch(NullPointerException e){
	            System.out.println("No order"+e);
	        }

	    }
	  
	  
	  public static Order findOrder(int ResID,String RoomNumber) {
	        String id = findOrderID(ResID, RoomNumber);
	        Order order = new Order();
	        for (Order o : Initialise.om.orders) {
	            if (id == o.getOrderID()) return o;
	        }
	        return order;
	    }
	  
	  

	 

	    	


	}
