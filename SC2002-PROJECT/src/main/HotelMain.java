package main;

import ui.*;
import serialize.*;

import java.util.Scanner;

import initialiser.Initialise;

public class HotelMain {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		Initialise.InitialiseHotel(); 
		
		
		
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
            
            option = 0;
            try {
	            option = sc.nextInt();
	            sc.nextLine();
	            
            }catch (Exception e) {
            }
	           
	            
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
                	PaymentUI.paymentOptions();
                	break;
                case 7:
                	WriteHotelDB.writeHotelDB();
                	System.exit(0);
                	break;
                default:
                	System.out.println("Invalid input!");
                	break;
            }

            
        } while (true);
	}
}
