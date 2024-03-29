package ui;

import java.util.Scanner;

import initialiser.Initialise;

/**
 * @author Darren Choo
 * @version 1.0
 * @since 14th April 2022
 */

public class CheckInUI {	
	/**
	 * displaying options to check in
	 */
	public static void checkInOptions() {
		
		Scanner sc = new Scanner(System.in);
		int option = 0;

		
		do {
			
	        System.out.println("========================================");
	        System.out.println("Hi! Please select an option:");
	        System.out.println("(1) View All Reservations");
	        System.out.println("(2) Check In Guest with Reservation");
	        System.out.println("(3) Make Walk In");
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
	            	System.out.println("Please enter the reservation ID that you wish to check the guest in for:");
	            	int reserID = sc.nextInt();
	            	Initialise.checkm.checkIn(reserID);
	                break;
	            case 3:
	            	Initialise.checkm.walkIn();
	                break;
	            case 4:
	            	break;
	            default:
	            	System.out.println("Invalid input!");
	            	break;
	        }
	    } while(option != 4);
	}
	
	
	
	

}
