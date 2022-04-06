package ui;

import java.util.ArrayList;

import java.util.Calendar;

import java.util.Scanner;

import Initialiser.Initialise;
import classes.*;


public class ReservationUI {
	
	public static void showReservationOptions(){
		
		ArrayList<Room> rooms = new ArrayList<Room>();
		RoomManager roomm = new RoomManager(rooms);
		
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		ReservationManager resm = new ReservationManager(reservations, rooms);
		
		
		//we need to initialise rooms here
		Initialise.InitialiseRoom();
		
		Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("========================================");
            System.out.println("Select choice: ");
            System.out.println("(1) Make reservation");
            System.out.println("(2) Remove reservation");
            System.out.println("(3) Show all reservation"); 
            System.out.println("(4) Search individual reservation");
            System.out.println("(5) Show room via occupancy"); //single: 10 out of 20
            													//rooms: 02-03, 03-04.....
            
            System.out.println("(6) Show room via status"); //Vacant:
            													//rooms: 03-06, 05-04.....
            												//Occupied:
            													//rooms: 02-04.....
            System.out.println("(7) Make Walk-in");
            System.out.println("(8) Go Back To Main Menu");
            System.out.println("========================================");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                	resm.makeReservationUI();
                    break;
                case 2:
                    
                    break;
                case 3:
                	resm.showAllReservations();
                    break;
                case 4:
                	System.out.println("Please enter the reservation ID: ");
                	int input = sc.nextInt();
                	resm.searchReservation(input);
                    break;
                case 5:
                	roomm.displayRoom();
                    break;
                case 6:
                    
                    break;
                default:
                	break;
            }
        } while (choice < 7);
	}
	
	
	
	
	
	
	//implement in case 3
//	private static void showReservationsUI(){
//		Scanner sc = new Scanner(System.in);
//        int choice;
//        int resId;
//
//        System.out.println("\nDo you want to view, ");
//            System.out.println("(1) All Reservations");
//            System.out.println("(2) Search Reservation");
//            System.out.println("(3) Go back");
//            
//            choice = sc.nextInt();
//            sc.nextLine();
//
//            switch(choice) {
//                case 1:
//                    
//                    break;
//                case 2:
//                    try {
//                        int id = Restaurant.reservationManager.showReservationShort();
//                        if(id==0)break;
//                        System.out.print("Enter reservation id: ");
//                        resId = sc.nextInt();
//                        sc.nextLine();
//                        Restaurant.reservationManager.searchReservation(resId);
//                    } catch (InputMismatchException e){
//                        System.out.println("Invalid reservation id.");
//                    }
//                    break;
//            }
//    }
        
        
    
}
