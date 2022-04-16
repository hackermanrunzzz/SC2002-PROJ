package ui;



import java.util.Scanner;

import initialiser.Initialise;



/**
 * @author Darren Wong
 * @version 1.0
 * @since 14th April 2022
 */

public class ReservationUI {
	
	
	/**
	 * display reservation options 
	 */
	public static void showReservationOptions(){
		
	
		Scanner sc = new Scanner(System.in);
		
		int option;
        do{
            System.out.println("========================================");
            System.out.println("Select choice: ");
            System.out.println("(1) Make reservation");
            System.out.println("(2) Remove reservation");
            System.out.println("(3) Show all reservation"); 
            System.out.println("(4) Search individual reservation");
            System.out.println("(5) Show room via occupancy");
            System.out.println("(6) Show room via status");
            System.out.println("(7) Change Room Status");
            System.out.println("(8) Go Back To Main Menu");
            System.out.println("========================================");
            
            option = 0;
	        try {
	            option = sc.nextInt();
	            
	        }catch (Exception e) {
	        }
	        sc.nextLine();

            switch(option){
                case 1:
                	Initialise.resm.makeReservationUI();
                    break;
                case 2:
                	Initialise.resm.cancelReservation();
                    break;
                case 3:
                	Initialise.resm.showAllReservations();
                    break;
                case 4:
                	System.out.println("Please enter the reservation ID: ");
                	int input = 0;
        	        try {
        	        	input = sc.nextInt();
                    	sc.nextLine();
                    	Initialise.resm.searchReservation(input);
        	        }catch (Exception e) {
        	        	System.out.println("Invalid input!");
        	        	sc.nextLine();
        	        }
                    break;
                case 5:
                	Initialise.room.displayRoomViaOccupancy();;
                    break;
                case 6:
                	Initialise.room.displayRoomViaStatus();
                    break;
                case 7:
                	Initialise.room.changeRoomStatus();
                    break;
                case 8:
                	break;
                default:
                	System.out.println("Invalid input!");
                	break;
            }
        } while (option != 8);
	}
}
