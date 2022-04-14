package ui;



import java.util.Scanner;
import Initialiser.Initialise;

/**
 * @author darren wong
 * @version 1.0
 * @since 14/04/2022
 */


/**
 * creating a payment user interface class
 */
public class PaymentUI {
	
	
	/**
	 * displaying the payment options
	 */
	public static void paymentOptions() {
		Scanner sc = new Scanner(System.in);
		int option;
		
		do {
			
	        System.out.println("========================================");
	        System.out.println("Hi! Please select an option:");
	        System.out.println("(1) View All Reservations");
	        System.out.println("(2) Checkout and Make Payment");
	        System.out.println("(3) Display All Past Payments");
	        System.out.println("(4) Go Back To Main Menu");
	        System.out.println("========================================");
	
	        option = sc.nextInt();
	        sc.nextLine();
	
	        switch(option) {
	            case 1:
	            	Initialise.resm.showAllReservations();
	                break;
	            case 2:
	            	Initialise.pm.makePaymentUI();
	                break;
	            case 3:
	            	Initialise.pm.showAllPaidReservation();
	            default:
	            	break;
	        }
	    } while (option<4);
	}

    


    
}
