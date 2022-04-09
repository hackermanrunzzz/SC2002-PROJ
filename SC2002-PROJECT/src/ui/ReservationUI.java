package ui;



import java.util.Scanner;

import Initialiser.Initialise;


public class ReservationUI {
	
	public static void showReservationOptions(){
		
		
		
//		ArrayList<Room> rooms = new ArrayList<Room>();
//		RoomManager roomm = new RoomManager(rooms);
//		
//		
//		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
//		ReservationManager resm = new ReservationManager(reservations, rooms);
		
		
		//we need to initialise rooms here
//		Initialise.InitialiseRoom();
		
		Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("========================================");
            System.out.println("Select choice: ");
            System.out.println("(1) Make reservation");
            System.out.println("(2) Remove reservation");
            System.out.println("(3) Show all reservation"); 
            System.out.println("(4) Search individual reservation");
            System.out.println("(5) Show room via occupancy");
            System.out.println("(6) Show room via status");
            System.out.println("(7) Go Back To Main Menu");
            System.out.println("========================================");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                	Initialise.resm.makeReservationUI();
                    break;
                case 2:
//                	System.out.println("Please enter the reservation ID that you wish to cancel:");
//                	int resID = sc.nextInt();
                	Initialise.resm.cancelReservation();
                    break;
                case 3:
                	Initialise.resm.showAllReservations();
                    break;
                case 4:
                	System.out.println("Please enter the reservation ID: ");
                	int input = sc.nextInt();
                	Initialise.resm.searchReservation(input);
                    break;
                case 5:
                	Initialise.roomm.displayRoomViaOccupancy();;
                    break;
                case 6:
                	Initialise.roomm.displayRoomViaStatus();
                    break;
                default:
                	break;
            }
        } while (choice < 7);
	}
}
