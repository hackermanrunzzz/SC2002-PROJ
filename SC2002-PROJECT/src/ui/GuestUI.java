package ui;

import java.util.Scanner;
import Initialiser.Initialise;
import classes.Guest;


public class GuestUI {
	public static void guestOptions() {
		
		
		Scanner sc = new Scanner(System.in);
		int option;
		boolean searchSuccessful = false;
		Guest guest = null;
		
		while(!searchSuccessful) {
			System.out.println("========================================");
			System.out.println("Hi! Please enter guest name (Enter 0 to return to previous menu): ");
			String guestName = sc.nextLine();
			if(guestName.equals("0")) {
				return;
			}
			guest = Initialise.gm.searchGuest(guestName);
			if(guest != null) {
				searchSuccessful = true;
			}
			System.out.println("Guest not found!");
		}

		

		do {
            System.out.println("========================================");
            System.out.println("Hi! Please select an option:");
            System.out.println("(1) Update guest's name");
            System.out.println("(2) Update guest's card name");
            System.out.println("(3) Update guest's card number");
            System.out.println("(4) Update guest's address");
            System.out.println("(5) Update guest's country");
            System.out.println("(6) Update guest's gender");
            System.out.println("(7) Update guest's identity");
            System.out.println("(8) Update guest's nationality");
            System.out.println("(9) Update guest's contact");
            System.out.println("(10) Go Back To Previous Page");
            System.out.println("========================================");

            option = sc.nextInt();
            sc.nextLine();

            switch(option) {
                case 1:
                	Initialise.gm.updateGuestName(guest);
                    break;
                case 2:
                	
                    break;
                case 3:
                	
                    break;
                case 4:
                	
                    break;
            }
        } while (option<10);
    }
	

}
