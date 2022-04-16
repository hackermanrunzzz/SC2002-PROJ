package ui;


import java.util.Calendar;
import java.util.Scanner;

import classes.Reservation;
import classes.ReservationManager;
import initialiser.Initialise;


/**
 * @author Darren Wong
 * @version 1.0
 * @since 14th April 2022
 */

public class OrderUI {

		/**
		 * takes in user input
		 */
		private static Scanner sc = new Scanner(System.in);

		  /**
		   * displaying the room service options
		   */
		    public static void orderOptions() {
		        int option = 0;
		        do {
		            System.out.println("========================================");
		            System.out.println("Select choice: ");
		            System.out.println("(1) Create Room Service Order");
		            System.out.println("(2) View Room Service Order");
		            System.out.println("(3) Delete Order");
		            System.out.println("(4) Show All Orders");
		            System.out.println("(5) Change Order Status");
		            System.out.println("(6) Go Back To Main Menu");
		            System.out.println("========================================");
		            option = 0;
			        try {
			            option = sc.nextInt();
			            
			        }catch (Exception e) {
			        }
			        sc.nextLine();
			        	

		            switch (option) {
		                case 1:
		                  Initialise.om.createOrderUI();
		                    break;
		                case 2:
		                    Initialise.om.viewOrderUI();
		                    break;
		                case 3:
		                	Initialise.om.DeleteOrder();
		                    break;
		                case 4:
		                	Initialise.om.showAllOrders();
		                    break;
		                case 5:
		                   Initialise.om.ChangeStatusofOrder();
		                    break;
		                case 6:
		                	break;
	                	default:
	                		System.out.println("Invalid input!");

		            }
		        } while (option != 6);
		    }




	    }
