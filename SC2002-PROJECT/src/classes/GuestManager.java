package classes;

import java.util.ArrayList;
import java.util.Scanner;
import Initialiser.Initialise;
import classes.Guest;

public class GuestManager {
	
	Scanner sc = new Scanner(System.in);
	
	public Guest searchGuest(String guestname){
		for(Reservation r: Initialise.reservations) {
			for(Guest g: r.getGuestDetails()) {
				if(g.getName().toLowerCase().contains(guestname.toLowerCase())) {
					System.out.println("Is this the guest you are searching for? (Enter 1 for Yes, 0 for No)");
					System.out.println("Guest Name: \t\t\t" + g.getName() + "\nReservation ID: \t\t" + r.getReservationID()
										+"\nCredit Card Name: \t\t" + g.getCreditCardName() +"\nCredit Card Number: \t\t" + g.getCreditCardNumber() + "\nAddress: \t\t\t" + g.getAddress() 
										+ "\nCountry: \t\t\t" + g.getCountry() + "\nGender: \t\t\t" + g.getGender() + "\nIdentity Number: \t\t"+ g.getIdentity()
										+ "\nNationality: \t\t\t" + g.getNationality() + "\nContact:\t\t\t" + g.getContact());
					String confirmation = sc.nextLine();
					if(confirmation.equals("1")) {
						return g;
					}
					else
						continue;
				}
			}
		}
		return null;
	}
	
	public void updateGuestName(Guest guest) {
		System.out.println("Current guest name: " + guest.getName());
		System.out.println("Please enter updated guest name (Enter 0 to cancel): ");
		String updatedName = sc.nextLine();
		if(updatedName.equals("0")) {
			System.out.println("Cancelling change...");
			return;
		}
		System.out.println("Update guest name from " + guest.getName()+" to " + updatedName +" ? (Enter 1 to confirm, 0 to cancel)");
		String confirmation = sc.nextLine();
		if(confirmation.equals("1")) {
			guest.setName(updatedName);
			System.out.println("Update Successful!");
			return;
		}
		System.out.println("Cancelling change...");
		return;
	}
	
	public void updateGuestCardName(Guest guest) {
		System.out.println("Current guest name: " + guest.getCreditCardName());
		System.out.println("Please enter updated guest credit card name (Enter 0 to cancel): ");
		String updatedCardName = sc.nextLine();
		if(updatedCardName.equals("0")) {
			System.out.println("Cancelling change...");
			return;
		}
		System.out.println("Update guest credit card name from " + guest.getCreditCardName()+" to " + updatedCardName +" ? (Enter 1 to confirm, 0 to cancel)");
		String confirmation = sc.nextLine();
		if(confirmation.equals("1")) {
			guest.setCreditCardName(updatedCardName);
			System.out.println("Update Successful!");
			return;
		}
		System.out.println("Cancelling change...");
		return;
	}
	
	public void updateGuestCardNumber(Guest guest) {
		System.out.println("Current guest name: " + guest.getCreditCardNumber());
		System.out.println("Please enter updated guest credit card number (Enter 0 to cancel): ");
		String updatedCardNumber = sc.nextLine();
		if(updatedCardNumber.equals("0")) {
			System.out.println("Cancelling change...");
			return;
		}
		System.out.println("Update guest credit card number from " + guest.getCreditCardNumber()+" to " + updatedCardNumber +" ? (Enter 1 to confirm, 0 to cancel)");
		String confirmation = sc.nextLine();
		if(confirmation.equals("1")) {
			guest.setCreditCardNumber(updatedCardNumber);
			System.out.println("Update Successful!");
			return;
		}
		System.out.println("Cancelling change...");
		return;
	}
	
	public void updateGuestAddress(Guest guest) {
		System.out.println("Current guest name: " + guest.getAddress());
		System.out.println("Please enter updated guest address (Enter 0 to cancel): ");
		String updatedAddress = sc.nextLine();
		if(updatedAddress.equals("0")) {
			System.out.println("Cancelling change...");
			return;
		}
		System.out.println("Update guest address from " + guest.getAddress()+" to " + updatedAddress +" ? (Enter 1 to confirm, 0 to cancel)");
		String confirmation = sc.nextLine();
		if(confirmation.equals("1")) {
			guest.setAddress(updatedAddress);
			System.out.println("Update Successful!");
			return;
		}
		System.out.println("Cancelling change...");
		return;
	}
	
	public void updateGuestCountry(Guest guest) {
		System.out.println("Current guest name: " + guest.getCountry());
		System.out.println("Please enter updated guest country (Enter 0 to cancel): ");
		String updatedCountry = sc.nextLine();
		if(updatedCountry.equals("0")) {
			System.out.println("Cancelling change...");
			return;
		}
		System.out.println("Update guest country from " + guest.getCountry()+" to " + updatedCountry +" ? (Enter 1 to confirm, 0 to cancel)");
		String confirmation = sc.nextLine();
		if(confirmation.equals("1")) {
			guest.setCountry(updatedCountry);
			System.out.println("Update Successful!");
			return;
		}
		System.out.println("Cancelling change...");
		return;
	}
	
	public void updateGuestGender(Guest guest) {
		System.out.println("Current guest name: " + guest.getGender());
		System.out.println("Please enter updated guest gender (Enter 0 to cancel): ");
		char updatedGender = sc.next().charAt(0);
		// 48 is decimal value of char 0
		if(updatedGender == 48) {
			System.out.println("Cancelling change...");
			return;
		}
		sc.nextLine();
		System.out.println("Update guest gender from " + guest.getName()+" to " + updatedGender +" ? (Enter 1 to confirm, 0 to cancel)");
		String confirmation = sc.nextLine();
		if(confirmation.equals("1")) {
			guest.setGender(updatedGender);
			System.out.println("Update Successful!");
			return;
		}
		System.out.println("Cancelling change...");
		return;
	}
	
	public void updateGuestIdentity(Guest guest) {
		System.out.println("Current guest name: " + guest.getIdentity());
		System.out.println("Please enter updated guest identity number (Enter 0 to cancel): ");
		String updatedIdentity = sc.nextLine();
		if(updatedIdentity.equals("0")) {
			System.out.println("Cancelling change...");
			return;
		}
		System.out.println("Update guest identity number from " + guest.getIdentity() +" to " + updatedIdentity +" ? (Enter 1 to confirm, 0 to cancel)");
		String confirmation = sc.nextLine();
		if(confirmation.equals("1")) {
			guest.setIdentity(updatedIdentity);
			System.out.println("Update Successful!");
			return;
		}
		System.out.println("Cancelling change...");
		return;
	}
	
	public void updateGuestNationality(Guest guest) {
		System.out.println("Current guest name: " + guest.getNationality());
		System.out.println("Please enter updated guest nationality (Enter 0 to cancel): ");
		String updatedNationality = sc.nextLine();
		if(updatedNationality.equals("0")) {
			System.out.println("Cancelling change...");
			return;
		}
		System.out.println("Update guest nationality from " + guest.getNationality()+" to " + updatedNationality +" ? (Enter 1 to confirm, 0 to cancel)");
		String confirmation = sc.nextLine();
		if(confirmation.equals("1")) {
			guest.setIdentity(updatedNationality);
			System.out.println("Update Successful!");
			return;
		}
		System.out.println("Cancelling change...");
		return;
	}
	
	public void updateGuestContact(Guest guest) {
		System.out.println("Current guest name: " + guest.getContact());
		System.out.println("Please enter updated guest contact (Enter 0 to cancel): ");
		String updatedContact = sc.nextLine();
		if(updatedContact.equals("0")) {
			System.out.println("Cancelling change...");
			return;
		}
		System.out.println("Update guest contact from " + guest.getContact() +" to " + updatedContact +" ? (Enter 1 to confirm, 0 to cancel)");
		String confirmation = sc.nextLine();
		if(confirmation.equals("1")) {
			guest.setContact(updatedContact);
			System.out.println("Update Successful!");
			return;
		}
		System.out.println("Cancelling change...");
		return;
	}

}
