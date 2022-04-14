package ui;


import java.util.Calendar;
import java.util.Scanner;
import Initialiser.Initialise;
import classes.Reservation;
import classes.ReservationManager;


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
		        int choice;
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

		            choice = sc.nextInt();
		            sc.nextLine();

		            switch (choice) {
		                case 1:
		                  Initialise.om.createOrderUI();
		                    break;
		                case 2:
		                    Initialise.om.viewOrderUI();
		                    break;
		                case 3:
		                   // addItemToOrderUI();
		                	Initialise.om.DeleteOrder();
		                    break;
		                case 4:
		                	Initialise.om.showAllOrders();
		                  //  removeItemFromOrderUI();
		                    break;
		                case 5:
		                   Initialise.om.ChangeStatusofOrder();
		                    break;
		                case 6:

		            }
		        } while (choice < 6);
		    }




	    }
