package ui;

import java.util.Scanner;
import Initialiser.Initialise;
import classes.Guest;

/**
 * @author Darren Choo
 * @version 1.0
 * @since 14th April 2022
 */


public class GuestUI {
	/**
	 * displaying options to update guest details
	 */
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
			else
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
                	Initialise.gm.updateGuestCardName(guest);
                    break;
                case 3:
                	Initialise.gm.updateGuestCardNumber(guest);
                    break;
                case 4:
                	Initialise.gm.updateGuestAddress(guest);
                    break;
                case 5:
                	Initialise.gm.updateGuestCountry(guest);
                    break;
                case 6:
                	Initialise.gm.updateGuestGender(guest);
                    break;
                case 7:
                	Initialise.gm.updateGuestIdentity(guest);
                    break;
                case 8:
                	Initialise.gm.updateGuestNationality(guest);
                    break;
                case 9:
                	Initialise.gm.updateGuestContact(guest);
                    break;
            }
        } while (option<10);
		
    }
	

}
