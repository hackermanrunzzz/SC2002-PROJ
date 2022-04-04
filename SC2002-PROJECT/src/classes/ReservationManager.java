package classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import classes.Reservation.*;

public class ReservationManager {

	private static ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	
	private static ArrayList<Room> rooms = new ArrayList<Room>();
	
	public ReservationManager(ArrayList<Reservation> reservations) {
		ReservationManager.reservations = reservations;
    }
	
	public void setReservations(ArrayList<Reservation> reservations) {
		ReservationManager.reservations = reservations;
		
	}
	
	
	public void makeReservation(Guest guestDetails, Room roomDetails, String billingInformation,
			Calendar checkInDate, Calendar checkOutDate, int adultCount, int childrenCount,
			StatusOfReservation reservationStatus, int numberOfDays){

		if(roomDetails.getRoomStatus() == Room.StatusOfRoom.VACANT) {
	        double reservationID = 10000;
	        if(reservations.size() > 0){
	        	reservationID = reservations.get(reservations.size()-1).getReservationID()+1;
	        }
	
	        System.out.println("\nReservation is Confirmed!\nReservation ID:" + reservationID);
	        reservations.add(new Reservation(reservationID, guestDetails, roomDetails, billingInformation,
	    			checkInDate, checkOutDate, adultCount, childrenCount,
	    			reservationStatus, numberOfDays));
	        
	        roomDetails.setRoomStatus(Room.StatusOfRoom.RESERVED);
	        
	        return;
		}
		else {
			System.out.println("The room is " + roomDetails.getRoomStatus() + ".");
//			System.out.println("The room is unavailable");
		}
    }
	
	
	public void searchReservation(double resId) {
        if(reservations.isEmpty() == true){
            System.out.println("\nThere are currently no reservations");
        }
        else{
            for(Reservation r: reservations){
                if(r.getReservationID() == resId){
                    System.out.println("========================================");

                    System.out.println("\nFound reservation: ");
//                    Date date = r.getCheckInDate().getTime();
//                    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
//                    String strDate = dateFormat.format(date);
                    System.out.println(r.printReservation());
                    return;
                }
           }
        }
        System.out.println("Reservation can't be found");
    }
	
	public void showAllReservations() {

        if (reservations.isEmpty() == true) {
            System.out.println("\nThere are currently no reservations");
        } 
        else {
            System.out.println("============ ALL RESERVATIONS ===============");

            for (Reservation r : reservations) {
//                Date date = r.getCheckInDate().getTime();
//                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
//                String strDate = dateFormat.format(date);
                System.out.println(r.printReservation());
            }
        }
    }
	
	//manual cancellation
	public int cancelReservation(int resId){
        int index = 0;
        for(Reservation r : reservations){
            if(r.getReservationID() == resId){
            	r.getRoomDetails().setRoomStatus(Room.StatusOfRoom.VACANT);
                reservations.remove(index);
                return resId;
            }
            index++;
        }
        return 0;
    }
	
	
	
	
}
