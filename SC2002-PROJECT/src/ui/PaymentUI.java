package ui;

import java.util.Scanner;

import Initialiser.Initialise;

public class PaymentUI {
	
	public static void paymentOptions() {
		Scanner sc = new Scanner(System.in);
		int option;
		
		do {
			
	        System.out.println("========================================");
	        System.out.println("Hi! Please select an option:");
	        System.out.println("(1) View All Reservations");
	        System.out.println("(2) Make Payment");
	        System.out.println("(3) Go Back To Main Menu");
	        System.out.println("========================================");
	
	        option = sc.nextInt();
	        sc.nextLine();
	
	        switch(option) {
	            case 1:
	            	Initialise.resm.showAllReservations();
	                break;
	            case 2:
	            	//call payment manager functions
//	            	Initialise.pm.
	                break;
	            default:
	            	break;
	        }
	    } while (option<3);
	}

    


    
}
