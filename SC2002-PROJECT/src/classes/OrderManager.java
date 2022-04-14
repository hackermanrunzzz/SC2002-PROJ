package classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.InputMismatchException;
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






    public void createOrder(int ResID,String RoomNumber, Calendar time, String remarks, double totalPrice, ArrayList<MenuItem> menuI) {
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
        System.out.println("No existing order for this room.");
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
			int ResID=0;
			String RoomNumber = "";
			ArrayList<MenuItem> roomServiceitems = new ArrayList<MenuItem>();
			
	        System.out.println("========================================");
	        System.out.println("Creating Room Service Order");
	        System.out.println("----------------------------------------");

	        int table =0;
	        
	        
        
	        try {
	        	
		        System.out.println("Enter Reservation ID: ");
        		ResID = sc.nextInt();
		        sc.nextLine();
		        System.out.println("Enter Room Number: ");
		        
		        RoomNumber = sc.nextLine();
		 
		        

	        	}
	        
	        
	        catch(InputMismatchException e)
	        {
	        
	      	
	        	
	        }
		      
	        
	      
	        //sc.nextLine();
	        
	        for (Reservation r: Initialise.reservations)
			{
	        	if (ResID == r.getReservationID() && r.getReservationStatus().equals(StatusOfReservation.CHECKED_IN) && r.getRoomDetails().getRoomNumber().equals(RoomNumber))
	        	{
	        		found = 1;
	        		break;
	        	}
	        	else 
				{
	        		found = -1;
	 
	        	}
	        }
	        
	        if (found == 1) 
	        {
	        	System.out.println(("Reservation found please proceed to order."));
	        	
	        }
	        else
			{
	        	System.out.println("Reservation not found.");
	        	return;
	        }

		
	       

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
	                System.out.println("Index of menu item is invalid. Please re-enter: ");
	            }

	        }while(choice!=-1);
	       // Restaurant.menu.printShortPromoMenu();
	        //Initialise.mm.printMenu();
	        
	        System.out.println("Please Enter Additional Remarks (If Any): ");
	        String remarks = sc.next();
	        

	        Calendar timenow = Calendar.getInstance();
	        
	        double totalp = 0;
	        for (int i = 0; i < roomServiceitems.size();i++) 
	        {		
		         totalp = totalp + roomServiceitems.get(i).getPrice(); 		
		      }
	        

	        
	        createOrder(ResID, RoomNumber,timenow,remarks, totalp,roomServiceitems);

	        printIndividualfood(roomServiceitems);
	        System.out.println("Total Price :" + "\t\t\t" + "$" + totalp);
	       
	     
	       
	  
	    }
	        
	        


	       
	     
	    	
	
	
	  public void viewOrderUI(){
			Scanner sc = new Scanner(System.in);
			Order test;
			System.out.println("========================================");
	        System.out.println("Enter RES ID and Room Number to view room order.");
	        int resIDROOM;
	        String roomNum;
	        while(true) {
	            System.out.println("Enter RESID (Press -1 to Exit): ");
	            resIDROOM = sc.nextInt();
	   
	            System.out.println("Enter Room Number (Press -1 to exit): ");
	             sc.nextLine();
	             roomNum = sc.nextLine();
	            
	            if (resIDROOM != 1 && roomNum != "-1") {
	            	break;
	            }
	            
	        }
	         
	       
	        
	      //  searchOrders(resIDROOM,roomNum);
	        searchRoomServiceOrder(resIDROOM,roomNum);
	  }
	            
	            


	  public int searchOrders( int ResID, String RoomNumber) {
		  int found = 0;
	      if(Initialise.orders.isEmpty() == true){
	          System.out.println("\nThere are currently no orders.");
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
		  
		  
		  System.out.println("========================================");

		  
		  
	  }

	  
	  public void showAllOrders() {

	        if (Initialise.orders.isEmpty() == true) {
	            System.out.println("\nThere are currently no Orders.");
	        } 
	        else 
			{
	            System.out.println("============= ALL ORDERS ==============");
	       
	            for (int i = 0 ; i < Initialise.orders.size(); i++) {
	            	System.out.println(Initialise.orders.get(i).printOrder());
	            	System.out.println("========================================");	            	
	            }

	    	}
		}
	  
	  

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
			  System.out.println("Order Found.");
		  }
		  else {
			  System.out.println("Order Not Found.");
		  }
		  return temp;
		  
	
		  
	  }
	  
	  
	  public Order searchRoomServiceOrder(int ResID, String RoomNumber){
		  
		  int not_found = 0;
			for(Order o: Initialise.orders) {
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			      String strtimeOfOrder = dateFormat.format(o.getTimeOfOrder().getTime());
				 
					if(o.getResID() == ResID && o.getRoomNumber().equals(RoomNumber)) {
						System.out.println("Is this the Order you are searching for? (Enter 1 for Yes, 0 for No)");
						System.out.println("========================================");
						System.out.println("OrderID: \t\t\t" + o.getOrderID() + "\nReservation ID: \t\t" + o.getResID()
						+ "\nRoomNumber: \t\t\t" + o.getRoomNumber() + "\nTime Of Order:\t\t\t" +strtimeOfOrder + "\nRemarks: \t\t\t" + o.getRemarks() +
						"\nOrder Status: \t\t\t"+ o.getOrderStatus()+"\nTotal Price: \t\t\t" + o.getTotalPrice());
											
						String confirmation = sc.nextLine();
						if(confirmation.equals("1")) {
							return o;
						}
						else
							not_found = 1;
							continue;
					}
				
			}
			if (not_found == 1) {
				System.out.println("Order Not Found.");
			}
			return null;
		}
	  
	  public void DeleteOrder() {
		  Scanner sc = new Scanner(System.in);
		  int ResID = 0;
		  String RoomNumber = "";
	        try {
	        	
		        System.out.println("Enter Reservation ID: ");
        		ResID = sc.nextInt();
		        sc.nextLine();
		        System.out.println("Enter Room Number: ");
		        
		        RoomNumber = sc.nextLine();
		 
		        

	        	}
	        
	        
	        catch(InputMismatchException e)
	        {
	        
	      	
	        	
	        }
		     
		  Order temp = searchRoomServiceOrder(ResID,RoomNumber);
		  
		  if (temp.getOrderStatus().equals(StatusOfOrder.PREPARING)) {
			  System.out.println("Order Is Already Being Prepared and Cannot be Deleted.");
			 
		  }
		  
		   
		  else if (temp.getOrderStatus().equals(StatusOfOrder.CONFIRMED)){
			  for (Order o : Initialise.orders) {
				  if (o.equals(temp)) {
					 Initialise.orders.remove(temp);
					 System.out.println("Order Has Been Removed.");
					 break;
				  }
			  }
		  }
		  else {
			  System.out.println("Order Has Already Been Delivered.");
			  
		  }
		  
	
			  
		  
		  
		 
		  
		  
	  }
	  
	  public void ChangeStatusofOrder() {
		  int choice;
		  Scanner sc = new Scanner(System.in);
	        do {
	        	System.out.println("========================================");	            System.out.println("Select choice: ");
	            System.out.println("(1) Send Order to the Kitchen");
	            System.out.println("(2) Room Service order has been Delivered");
	            System.out.println("(3) Go Back To Main Menu");
	            System.out.println("========================================");

	            choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice) {
	                case 1:
	                	System.out.println("Enter ResID and Room Number to find Order: ");
	                	System.out.println("Enter ResID: ");
	                	int resID = sc.nextInt();
	                	sc.nextLine();
	                	System.out.println("Enter Room Number: ");
	                	String rN = sc.nextLine();
	                	
	                	Order rsOrder = searchRoomServiceOrder(resID,rN);
	                	while(true) {
	                		System.out.println("Do You Wish to Send Order to the Kitchen? Press(1) to Send , Press(0) to Return to Main Menu");
	                		int send = sc.nextInt();
	                		if (send == 0) {
	                			break;
	                		}
	                		else if (send ==1) {
	                			
	                			rsOrder.setOrderStatus(StatusOfOrder.PREPARING);
	                			System.out.println("Order is Being Prepared now.");
	                			break;
	                			
	                		}
	                		else {
	                			System.out.println("You Have Keyed in a Invalid key. PLease Re-Enter your choice");
	                		}
	                		
	                	}
	                	
	  
	                    break;
	                case 2:
	                	System.out.println("Enter ResID and Room Number to find Order: ");
	                	System.out.println("Enter ResID:");
	                	int ID = sc.nextInt();
	                	sc.nextLine();
	                	System.out.println("Enter Room Number: ");
	                	String rNum = sc.nextLine();
	                	
	                	Order deliveredO = searchRoomServiceOrder(ID,rNum);
	                	while(true) {
	                		System.out.println("Has Order Been Delivered? Press(1) for Yes , Press(0) to Return to Main Menu");
	                		int send = sc.nextInt();
	                		if (send == 0) {
	                			break;
	                		}
	                		else if (send ==1) {
	                			deliveredO.setOrderStatus(StatusOfOrder.DELIVERED);
	                			System.out.println("Order Has Been Delivered.");
	                			break;
	                			
	                		}
	                		else {
	                			System.out.println("You Have Keyed in a Invalid key. PLease Re-Enter your choice: ");
	                		}
	                		
	                	}
	                	
	                  
	                    break;
	                case 3:
	                	break;
	            }
	        } while (choice < 3);
	    }


	}
