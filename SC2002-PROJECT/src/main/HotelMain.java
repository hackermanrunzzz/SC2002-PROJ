package main;

import ui.*;



import Initialiser.Initialise;

import java.util.Scanner;

public class HotelMain {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int option;
		Initialise.InitialiseHotel(); 
		//this is like redundant, but we may have issues to initialise rooms, since right now the UIs are the ones initialising their respective ites
		//Room doesnt have a UI, unless its  under Reservation UI then i guess thats fine...
		
		
		
		 System.out.println("================================================================================");
	     System.out.println("                 Welcome To NTU Hotel");
	     System.out.println("================================================================================");
		
        do{
            System.out.println("========================================");
            System.out.println("Hello! Please select an option:");
            System.out.println("(1) Update/search guest's detail by name");
            System.out.println("(2) Menu Options");
            System.out.println("(3) Reservations/Room Details");
            System.out.println("(4) Check in");
            System.out.println("(5) Room Service");
            System.out.println("(6) Payment");
            System.out.println("(7) Exit Program");
            System.out.println("========================================");


            option = sc.nextInt();
            sc.nextLine();

            switch(option){
                case 1 :
                	GuestUI.guestOptions();
                    break;
                case 2 :
                	MenuItemUI.menuOptions();
                    break;
                case 3 : 
                	ReservationUI.showReservationOptions();
                    break;
                case 4 :
                	CheckInUI.checkInOptions();
                     break;
                case 5:
                	OrderUI.orderOptions();
                	break;
                case 6:
                	break;
                default :
                      break;

            }
        } while (option<7);
	}

	

}
