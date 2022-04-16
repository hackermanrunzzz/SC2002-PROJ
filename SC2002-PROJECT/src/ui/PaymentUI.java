package ui;



import java.util.Scanner;

import initialiser.Initialise;

/**
 * @author Darren Wong
 * @version 1.0
 * @since 14th April 2022
 */

public class PaymentUI {
	
	
	/**
	 * displaying the payment options
	 */
	public static void paymentOptions() {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		
		do {
			
	        System.out.println("========================================");
	        System.out.println("Hi! Please select an option:");
	        System.out.println("(1) View All Reservations");
	        System.out.println("(2) Checkout and Make Payment");
	        System.out.println("(3) Display All Past Payments");
	        System.out.println("(4) Go Back To Main Menu");
	        System.out.println("========================================");
	        option = 0;
	        try {
	            option = sc.nextInt();
	            
	        }catch (Exception e) {
	        }
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
	            	break;
	            case 4:
	            	break;
	            default:
	            	System.out.println("Invalid input!");
	            	break;
	        }
	    } while (option!=4);
	}

    


    
}
