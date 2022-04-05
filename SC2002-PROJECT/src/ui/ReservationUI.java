package ui;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import initialize.Restaurant;


public class ReservationUI {
	
	public static void showReservationOptions(){
		Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("========================================");
            System.out.println("Select choice: ");
            System.out.println("(1) Make reservation");
            System.out.println("(2) Remove reservation");
            System.out.println("(3) Show reservation"); //show all OR individual via resID
            
            System.out.println("(4) Show room via occupancy"); //single: 10 out of 20
            													//rooms: 02-03, 03-04.....
            
            System.out.println("(5) Show room via status"); //Vacant:
            													//rooms: 03-06, 05-04.....
            												//Occupied:
            													//rooms: 02-04.....
            System.out.println("(6) Make Walk-in");
            System.out.println("(7) Go Back To Main Menu");
            System.out.println("========================================");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
//                    makeReservationUI();
                    break;
                case 2:
                    
                    break;
                case 3:
                	showReservationsUI();
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                default:
                	break;
            }
        } while (choice < 7);
	}
//	 static void makeReservationUI(){
//        int pax = 0;
//        String custContact = "";
//
//        if(Restaurant.reservationManager.getReservations().size() > 9 ){
//            System.out.println("We are fully booked!");
//            return;
//        }
//
//        System.out.print("Enter amount of pax: ");
//        pax = sc.nextInt();
//        sc.nextLine();
//        if(pax > 10){
//            System.out.println("Sorry, number of pax is not valid");
//            return;
//        }
//            Calendar reservationDate = Restaurant.reservationManager.getValidReservationDateTime();
//            int tableId = Restaurant.tableManager.findReservationTable(reservationDate, pax);
//            if (tableId == -1){
//                return;
//            }else{
//                System.out.print("Enter customer name: ");
//                String custName = sc.nextLine();
//
//                do{
//                    System.out.print("Enter customer phone number: ");
//                    custContact = sc.next();
//                }while(!isValidMobileNo(custContact));
//
//                Restaurant.reservationManager.makeReservation(custName, Integer.parseInt(custContact), pax,reservationDate, tableId);
//            }
//
//        return;
//    }
	
	
	//implement in case 3
	private static void showReservationsUI(){
        int choice;
        int resId;

        System.out.println("\nDo you want to view, ");
            System.out.println("(1) All Reservations");
            System.out.println("(2) Search Reservation");
            System.out.println("(3) Go back");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    Restaurant.reservationManager.showAllReservations();
                    break;
                case 2:
                    try {
                        int id = Restaurant.reservationManager.showReservationShort();
                        if(id==0)break;
                        System.out.print("Enter reservation id: ");
                        resId = sc.nextInt();
                        sc.nextLine();
                        Restaurant.reservationManager.searchReservation(resId);
                    } catch (InputMismatchException e){
                        System.out.println("Invalid reservation id.");
                    }
                    break;
            }
    }
        
        
    
}
