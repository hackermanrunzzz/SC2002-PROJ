package classes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.UUID;

import Initialiser.Initialise;
import classes.Order.StatusOfOrder;
import classes.Reservation.StatusOfReservation;


public class OrderManager {
//	private static ArrayList<Reservation> reservations = new ArrayList<Reservation>();  //should we declare new here?, or take from initialise
//
//	private static ArrayList<Order> orders = new ArrayList<Order>();
	
	private static ArrayList<Reservation> reservations;
	private static ArrayList<Order> orders;
   
   

	Scanner sc = new Scanner(System.in);


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



    
    public Order getOrder(int ResID){
        for(Order o: Initialise.orders ){
            if(o.getResID() == ResID){
				return o;
			}
        }
        return null; 
    }
    // Resolved some errors
    // No error-checking required here
    
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


//    public void createOrder( int ResID, String RoomNumber, ArrayList<MenuItem> menu) {
//        Order new_order= new Order(1001,ResID,RoomNumber,Calendar.getInstance(), menu); // Did you mean to use the other constructor here? @ Warren
//        orders.add(new_order);
//	}
    public void createOrder( int ResID,String RoomNumber, Calendar time, String remarks, double totalPrice, ArrayList<MenuItem> menuI) {
    	 String OrderID = UUID.randomUUID().toString();

        Order ordering = new Order( OrderID, ResID, RoomNumber,  time,  remarks,StatusOfOrder.CONFIRMED, totalPrice, menuI);
        Initialise.orders.add(ordering);
    }


    public static String findOrderID(int ResID,String RoomNumber) {
        for (Order o : Initialise.orders)
		{
            if (o.getResID() == ResID)
			{
				return o.getOrderID();
			}
        }
        System.out.println("No existing order for this room");
        return null;
    }



    
    public double calculateAmount() {
        double amount = 0;

        for (int i = 0; i < Initialise.orders.size(); i++) {
        	for (int y = 0; y < Initialise.orders.get(i).getMenuI().size(); y++)
            amount = amount + Initialise.orders.get(i).getMenuI().get(y).getPrice();
        }
        return amount; // This returns total price of ALL MenuItems

   
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
			ArrayList<MenuItem> roomServiceitems = new ArrayList<MenuItem>();
			
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
	                
	                roomServiceitems.add(food);
	                
	               
	                
	              
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
	        for (int i = 0; i < roomServiceitems.size();i++) 
	        {		
		         totalp = totalp + roomServiceitems.get(i).getPrice(); 		
		      }
	        
//	        for (int f = 0 ; f < Initialise.roomServiceitems.size(); f++) {
//	        	System.out.println(Initialise.roomServiceitems.get(f).getName());
//	        }
	        
	        createOrder(ResID, RoomNumber,timenow,remarks, totalp,roomServiceitems);
//	       System.out.println( orders.get(0));
//	       System.out.println( orders.get(0).getResID());
	        printIndividualfood(roomServiceitems);
	        System.out.println("Total Price :" + "\t\t\t" + "$" + totalp);
	       
	     
	       
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
	             sc.nextLine();
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


//	        try{
//	        	Order order =  OrderManager.findOrder(resIDROOM, roomNum);
//	            System.out.println("============================= CURRENT TABLE ORDER =================================");
//			}
//	    
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
		  int found = 0;
	      if(Initialise.orders.isEmpty() == true){
	          System.out.println("\nThere are currently no orders");
	          return 0;
	      }
	      else{
	          for(int k = 0 ; k <Initialise.orders.size(); k ++){
	        	 
	              if(orders.get(k).getResID() == ResID && orders.get(k).getRoomNumber().equals(RoomNumber) ){
	                  System.out.println("========================================");
	
	                  System.out.println("\n==============Found Order============== ");
	                  System.out.println(Initialise.orders.get(k).printOrder());
	                  found  = 1;
                  
              }
              
          }
          if (found==0) {
        	  System.out.println("Order not found.");
          }
      }
      return -1;
	  }
	  
	  public void printIndividualfood (ArrayList<MenuItem> menuitems) {
		  System.out.println("============================Order Receipt========================");
		  
		  for (int y = 0 ; y<menuitems.size(); y++) {
			
			  System.out.print(menuitems.get(y).getName() + "\t\t\t" + "$"+menuitems.get(y).getPrice());
			  System.out.print("\n");
		  }
		  
		  
		  System.out.println("---------------------------------------------------------------------");
		  System.out.println("---------------------------------------------------------------------");

		  
		  
	  }

	  
	  public void showAllOrders() {

	        if (Initialise.orders.isEmpty() == true) {
	            System.out.println("\nThere are currently no reservations");
	        } 
	        else 
			{
	            System.out.println("============ ALL Orders ===============");
	       
	            for (int i = 0 ; i < Initialise.orders.size(); i++) {
	            	System.out.println(Initialise.orders.get(i).printOrder());
	            	System.out.println("================================================");
	            	
	            }

	    	}
		}
	  
	  
//	  public static void findOrder(int ResID,String RoomNumber) {
//	        String id = findOrderID(ResID, RoomNumber);
//	        Order order = new Order();
//	        for (Order o : OrderManager.orders)
//			{
//	            if (id == o.getOrderID())
//				{
//					return o;
//				}
//	            for (Order q : orders) {
////	                Date date = r.getCheckInDate().getTime();
////	                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
////	                String strDate = dateFormat.format(date);
//	                System.out.println(o.printOrder());
//	                System.out.println();
//	            }
//	        }
//	    }
	    
	  public static Order findOrder(int ResID, String RoomNumber) {
		  String id = findOrderID(ResID, RoomNumber);
		  Order temp = null;
		  int found  = 0;
		  for (int y = 0 ; y < Initialise.orders.size(); y++) {
			  if (Initialise.orders.get(y).getOrderID().equals(id)) {
				temp = Initialise.orders.get(y);
			  }
			  else {
				  temp = null;
			  }
		  }
		  
		  if (temp != null) {
			  System.out.println("Order Found");
		  }
		  else {
			  System.out.println("Order Not Found");
		  }
		  return temp;
		  
	
		  
		  
		  
	  }
	  
	  public void DeleteOrder() {
		  Scanner sc = new Scanner(System.in);
		  
		  while(true) {
		  System.out.println("Enter ResID");
		  int rd = sc.nextInt();
		  
		  sc.nextLine();
		  
		  System.out.println("Enter room Number");
		  String rn = sc.nextLine();
		  
		  
		  Order temp = findOrder(rd,rn);
		  
		  if (temp.getOrderStatus().equals(StatusOfOrder.PREPARING)) {
			  System.out.println("Order Is Already Being Prepared and Cannot be Deleted");
			  break;
		  }
		//  else if (temp.getOrderStatus().equals(StatusOfOrder.))
			  
		  
		  
		 
		  }
		  
	  }
	  
	  public void ChangeStatusofOrder() {
		  int choice;
		  Scanner sc = new Scanner(System.in);
	        do {
	            System.out.println("========================================");
	            System.out.println("Select choice: ");
	            System.out.println("(1) Send Order to the Kitchen");
	            System.out.println("(2) Room Service order has been Delivered");
	            System.out.println("(3) Go Back To Main Menu");
	            System.out.println("========================================");

	            choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice) {
	                case 1:
	                	System.out.println("Enter ResID and RoomNumber to find Order");
	                	System.out.println("Enter ResID");
	                	int resID = sc.nextInt();
	                	sc.nextLine();
	                	System.out.println("Enter RoomNumber");
	                	String rN = sc.nextLine();
	                	
	                	searchOrders(resID,rN);
	                	while(true) {
	                		System.out.println("Do You Wish to Send Order to the Kitchen. Press(1) to Send , Press(0) to Return to Main Menu " );
	                		int send = sc.nextInt();
	                		if (send == 0) {
	                			break;
	                		}
	                		else if (send ==1) {
	                			Order rsOrder = findOrder(resID,rN);
	                			rsOrder.setOrderStatus(StatusOfOrder.PREPARING);
	                			System.out.println("Order is Being Prepared now");
	                			break;
	                			
	                		}
	                		else {
	                			System.out.println("You Have Keyed in a Invalid key. PLease Re-Enter your choice");
	                		}
	                		
	                	}
	                	
	  
	                    break;
	                case 2:
	                	System.out.println("Enter ResID and RoomNumber to find Order");
	                	System.out.println("Enter ResID");
	                	int ID = sc.nextInt();
	                	sc.nextLine();
	                	System.out.println("Enter RoomNumber");
	                	String rNum = sc.nextLine();
	                	
	                	searchOrders(ID,rNum);
	                	while(true) {
	                		System.out.println("Has Order Been Delivered Press(1) for Yes , Press(0) to Return to Main Menu " );
	                		int send = sc.nextInt();
	                		if (send == 0) {
	                			break;
	                		}
	                		else if (send ==1) {
	                			Order rsOrder = findOrder(ID,rNum);
	                			rsOrder.setOrderStatus(StatusOfOrder.DELIVERED);
	                			System.out.println("Order Has Been Delivered");
	                			break;
	                			
	                		}
	                		else {
	                			System.out.println("You Have Keyed in a Invalid key. PLease Re-Enter your choice");
	                		}
	                		
	                	}
	                	
	                  
	                    break;
	                case 3:
	                	break;
	            }
	        } while (choice < 3);
	    }


	}
