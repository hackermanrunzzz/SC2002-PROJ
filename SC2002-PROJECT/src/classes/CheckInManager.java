package classes;

import java.util.ArrayList;

import java.util.Calendar;
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
	
//	public void WalkIn() {
//		Scanner sc = new Scanner(System.in);
//		int adults=0, children=0;
//        int pax = 0;
//        int maxOccupancy=0;
//        int roomcounter = 0;
//        String typeofroomUpper = "";
//        ArrayList<String> vacantRooms = new ArrayList<String>();
//        boolean RoomMatch = true;
//    	ArrayList<Guest> currentGuestArr = new ArrayList<Guest>();
//    	String creditCardNumber;
//    	Calendar checkInDate;
//    	Calendar checkOutDate;
//    	String roomNumber ="";
//    	int numberOfNights;
//        
//
//        while(true) {
//        	
//        	boolean roomTypeCheck = true;
//        	while(roomTypeCheck) {
//		        System.out.println("Please enter the type of room that you want (SINGLE/DOUBLE/DELUXE/VIPSUITE): ");
//		        String typeofroom = sc.nextLine();
//		        typeofroomUpper = typeofroom.toUpperCase();
//		        
//		        if(typeofroomUpper.equals("SINGLE") || typeofroomUpper.equals("DOUBLE") || typeofroomUpper.equals("DELUXE") || typeofroomUpper.equals("VIPSUITE")) {
//		        	roomTypeCheck = false;
//		        }
//		        else {
//		        	System.out.println("Invalid room type entered.");
//		        }
//        	}
//	        
//	        System.out.print("Enter amount of Adults: ");
//	        adults = sc.nextInt();
//	        
//	        System.out.print("Enter amount of Children: ");
//	        children = sc.nextInt();
//	        
//	        pax = adults + children;
//	        
//	        if(typeofroomUpper.equals("SINGLE")) {
//	        	maxOccupancy=1;
//	        	
//	        }
//	        else if(typeofroomUpper.equals("DOUBLE")) {
//	        	maxOccupancy=2;
//	        	
//	        }
//	        else if(typeofroomUpper.equals("DELUXE")) {
//	        	maxOccupancy=4;
//	        	
//	        }
//	        else if(typeofroomUpper.equals("VIPSUITE")) {
//	        	maxOccupancy=6;
//	        	
//	        }
//	        
//	        if(pax > maxOccupancy) {
//	        	System.out.println("Invalid input! Number of pax greater than max occupany, please reenter pax or choose another room");
//	        }
//	        else {
//	        	break;
//	        }
//	        sc.nextLine();
//        }
//        
//        //printing all the available rooms that are vacant and of the selected room type
//        if(typeofroomUpper.equals("SINGLE")) {
//        	System.out.println("These are the vacant Single Rooms:");
//        	for (Room r : Initialise.rooms) {
//        		 if (r.getRoomType().equals(TypeOfRoom.SINGLE) && r.getRoomStatus().equals(StatusOfRoom.VACANT)) {
//        			 System.out.println(r.getRoomNumber());
//        			 roomcounter++;
//        			 vacantRooms.add(r.getRoomNumber());
//        		 }
//        	}
//        }
//        else if(typeofroomUpper.equals("DOUBLE")) {
//        	System.out.println("These are the vacant Double Rooms:");
//        	for (Room r : Initialise.rooms) {
//        		 if (r.getRoomType().equals(TypeOfRoom.DOUBLE) && r.getRoomStatus().equals(StatusOfRoom.VACANT)) {
//        			 System.out.println(r.getRoomNumber());
//        			 roomcounter++;
//        			 vacantRooms.add(r.getRoomNumber());
//        		 }
//        	}
//        }
//        else if(typeofroomUpper.equals("DELUXE")) {
//        	System.out.println("These are the vacant Deluxe Rooms:");
//        	for (Room r : Initialise.rooms) {
//        		 if (r.getRoomType().equals(TypeOfRoom.DELUXE) && r.getRoomStatus().equals(StatusOfRoom.VACANT)) {
//        			 System.out.println(r.getRoomNumber());
//        			 roomcounter++;
//        			 vacantRooms.add(r.getRoomNumber());
//        		 }
//        	}
//        }
//        else if(typeofroomUpper.equals("VIPSUITE")) {
//        	System.out.println("These are the vacant VIP Suites:");
//        	for (Room r : Initialise.rooms) {
//        		 if (r.getRoomType().equals(TypeOfRoom.VIPSUITE) && r.getRoomStatus().equals(StatusOfRoom.VACANT)) {
//        			 System.out.println(r.getRoomNumber());
//        			 roomcounter++;
//        			 vacantRooms.add(r.getRoomNumber());
//        		 }
//        	}
//        }
//        sc.nextLine();
//        
//        if(roomcounter == 0) {
//        	System.out.println("There are no available rooms available.");
//        }
//        else {
//        	while(RoomMatch) {
//	        	System.out.println("Enter the selected room that you wish to assign to the guest:");
//	        	roomNumber = sc.nextLine();
//	        	
//	        	for(String vacant : vacantRooms) {
//	        		if(roomNumber.equals(vacant)) {
//	        			RoomMatch = false;
//	        			break;
//	        		}
//	        			
//	        	}
//	        	
//	        	if(RoomMatch) {
//	        		System.out.println("Invalid Room Number.");
//	        	}
//        	}
//        	
//        	
//
//        	
//        	
//        	System.out.println("Ensure that the first guest details is the one footing the bill !!!");
//        	
//        	for(int i=0; i<pax;i++) {
//        		System.out.printf("Please enter the guest %d name:\n", i+1);
//        		String guestName = sc.nextLine();
//        		
//        		System.out.println("Please enter the credit card name:");
//        		String creditCardName = sc.nextLine();
//        		
//        		while(true) {
//        			System.out.println("Please enter the credit card number (Enter \"-\" if not applicable): ");
//        			creditCardNumber = sc.nextLine();
//        		
//        			if(i==0 && creditCardNumber.equals("-")) {
//        				System.out.println("Please enter a valid Credit Card Number for the first guest.");
//        			}
//        			else {
//        				break;
//        			}
//        		}
//        		
//        		System.out.println("Please enter your address:");
//        		String address = sc.nextLine();
//        		
//        		System.out.println("Please enter your country:");
//        		String country = sc.nextLine();
//        		
//        		System.out.println("Please enter your gender (M/F):");
//        		char gender = sc.next().charAt(0);
//        		sc.nextLine();
//        		
//        		System.out.println("Please enter your identity:");
//        		String identity = sc.nextLine();
//        		
//        		System.out.println("Please enter your nationality:");
//        		String nationality = sc.nextLine();
//        		
//        		System.out.println("Please enter your contact number:");
//        		String contact = sc.nextLine();
//        		
//        		Guest guestx = new Guest(guestName,creditCardName,creditCardNumber,address,country,gender,identity,nationality,contact);
//        		currentGuestArr.add(guestx);
//        	}
//        }
//        Room thisRoom = Initialise.resm.ReturnRoom(roomNumber);
//        
//        //set checkInDate as current date time
//        checkInDate = 
//        checkOutDate = Initialise.resm.getValidCheckOutDateTime(checkInDate);
//        numberOfNights = Initialise.resm.calcNumberOfDays(checkInDate,checkOutDate);
//
//        System.out.printf("You have booked %d day(s).\n", numberOfNights);
//        
//
//        Initialise.resm.makeReservation(currentGuestArr, thisRoom,currentGuestArr.get(0).getCreditCardNumber(), checkInDate, checkOutDate, adults, children, numberOfNights);
//		
//	}
	
	

}
