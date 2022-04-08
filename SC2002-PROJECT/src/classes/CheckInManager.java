package classes;

import java.util.Scanner;

import Initialiser.Initialise;
import classes.Reservation.StatusOfReservation;
import classes.Room.StatusOfRoom;

public class CheckInManager {
	
	Scanner sc = new Scanner(System.in);
	public CheckInManager() {};
	
	public void CheckIn(int resID) {
		int check = Initialise.resm.searchReservation(resID);
		if(check == 0 || check == -1) {
			return;
		}
		else {
			System.out.println();
			System.out.println("Do you wish to check in the above guest?");
			System.out.println("Press (1) to confirm, Press any other number to cancel");
			int choice = sc.nextInt();
			if(choice == 1) {
				for(Reservation r: Initialise.reservations) {
					if(r.getReservationID() == resID) {
						r.setReservationStatus(StatusOfReservation.CHECKED_IN);
						r.getRoomDetails().setRoomStatus(StatusOfRoom.OCCUPIED);
					}
					
				}
				System.out.println("Check In Confirmed.");
			}
			else {
				System.out.println("Check In Cancelled.");
			}
		}
		
	}
	
	public void WalkIn() {
		
	}
	
	

}
