package classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import classes.Reservation.StatusOfReservation;

public class ReservationManager {

	private static ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	
	private static ArrayList<Room> rooms = new ArrayList<Room>();
	
	public ReservationManager(ArrayList<Reservation> reservations) {
        ReservationManager.reservations = reservations;
    }
	
	public void setReservations(ArrayList<Reservation> reservations) {
        ReservationManager.reservations = reservations;
	}
	
//	public void displayReservation() {
//		
//	}
	
	public void makeReservation(Guest guestDetails, Room roomDetails, String billingInformation,
			Calendar checkInDate, Calendar checkOutDate, int adultCount, int childrenCount,
			StatusOfReservation reservationStatus, int numberOfDays){

        boolean status = true;
        double reservationID = 10000;
        if(reservations.size() > 0){
        	reservationID = reservations.get(reservations.size()-1).getReservationID()+1;
        }

        System.out.println("\nReservation is Confirmed!\nReservation ID:" + reservationID);
        reservations.add(new Reservation(reservationID, guestDetails, roomDetails, billingInformation,
    			checkInDate, checkOutDate, adultCount, childrenCount,
    			reservationStatus, numberOfDays));
        
//        tables.get(tableId-1).setTableStatus(Table.TableStatus.OCCUPIED);
        
        roomDetails.setRoomStatus(Room.StatusOfRoom.RESERVED);
        
        return;
    }
	
	
	public void searchReservation(int resId) {
        if(reservations.isEmpty() == true){
            System.out.println("\nThere are currently no reservations");
        }
        else{
            for(Reservation r: reservations){
                if(r.getReservationID() == resId){
                    System.out.println("========================================");

                    System.out.println("\nFound reservation: ");
                    Date date = r.getCheckInDate().getTime();
                    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                    String strDate = dateFormat.format(date);
                    System.out.println(r.printReservation());
                    return;
                }
           }
        }
        System.out.println("Reservation can't be found");

    }
	
}