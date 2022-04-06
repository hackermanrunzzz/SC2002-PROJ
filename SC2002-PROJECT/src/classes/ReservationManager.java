package classes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Initialiser.Initialise;
import classes.MenuItem.TypeOfMenuItem;
import classes.Reservation.*;
import classes.Room.StatusOfRoom;
import classes.Room.TypeOfRoom;

public class ReservationManager {

	private static ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	
	private static ArrayList<Room> rooms = new ArrayList<Room>();
	
	public ReservationManager(ArrayList<Reservation> reservations, ArrayList<Room> rooms) {
		ReservationManager.reservations = reservations;
		ReservationManager.rooms = rooms;
    }
	
	public void setReservations(ArrayList<Reservation> reservations, ArrayList<Room> rooms) {
		ReservationManager.reservations = reservations;
		ReservationManager.rooms = rooms;
		
	}
	
	//fix this, include stuff like asking for all the details
	//this makeReservationUI calls the below makeReservation function
	public void makeReservationUI(){
		Scanner sc = new Scanner(System.in);
        int pax = 0;
        int maxOccupancy=0;
        int roomcounter = 0;
        String custContact = "";
        String typeofroomUpper;
        
        

//        if(Restaurant.reservationManager.getReservations().size() > 9 ){
//            System.out.println("We are fully booked!");
//            return;
//        }
        while(true) {
	        System.out.println("Please enter the type of room that you want (SINGLE/DOUBLE/DELUXE/VIPSUITE): ");
	        String typeofroom = sc.nextLine();
	        typeofroomUpper = typeofroom.toUpperCase();
	        
	        
	        
	        System.out.print("Enter amount of pax: ");
	        pax = sc.nextInt();
	        
	        if(typeofroomUpper.equals("SINGLE")) {
	        	maxOccupancy=1;
	        	
	        }
	        else if(typeofroomUpper.equals("DOUBLE")) {
	        	maxOccupancy=2;
	        	
	        }
	        else if(typeofroomUpper.equals("DELUXE")) {
	        	maxOccupancy=4;
	        	
	        }
	        else if(typeofroomUpper.equals("VIPSUITE")) {
	        	maxOccupancy=6;
	        	
	        }
	        
	        if(pax > maxOccupancy) {
	        	System.out.println("Invalid input! Number of pax greater than max occupany, please reenter pax or choose another room");
	        }
	        else {
	        	break;
	        }
	        sc.nextLine();
        }
        
        //printing all the available rooms that are vacant and of the selected room type
        if(typeofroomUpper.equals("SINGLE")) {
        	System.out.println("These are the vacant Single Rooms:");
        	for (Room r : rooms) {
        		 if (r.getRoomType().equals(TypeOfRoom.SINGLE) && r.getRoomStatus().equals(StatusOfRoom.VACANT)) {
        			 System.out.println(r.getRoomNumber());
        			 roomcounter++;
        		 }
        	}
        }
        else if(typeofroomUpper.equals("DOUBLE")) {
        	System.out.println("These are the vacant Double Rooms:");
        	for (Room r : rooms) {
        		 if (r.getRoomType().equals(TypeOfRoom.DOUBLE) && r.getRoomStatus().equals(StatusOfRoom.VACANT)) {
        			 System.out.println(r.getRoomNumber());
        			 roomcounter++;
        		 }
        	}
        }
        else if(typeofroomUpper.equals("DELUXE")) {
        	System.out.println("These are the vacant Deluxe Rooms:");
        	for (Room r : rooms) {
        		 if (r.getRoomType().equals(TypeOfRoom.DELUXE) && r.getRoomStatus().equals(StatusOfRoom.VACANT)) {
        			 System.out.println(r.getRoomNumber());
        			 roomcounter++;
        		 }
        	}
        }
        else if(typeofroomUpper.equals("VIPSUITE")) {
        	System.out.println("These are the vacant VIP Suites:");
        	for (Room r : rooms) {
        		 if (r.getRoomType().equals(TypeOfRoom.VIPSUITE) && r.getRoomStatus().equals(StatusOfRoom.VACANT)) {
        			 System.out.println(r.getRoomNumber());
        			 roomcounter++;
        		 }
        	}
        }
        
        if(roomcounter == 0) {
        	System.out.println("There are no available rooms available.");
        }
        else {
        	System.out.println("Enter the selected room that you wish to assign to the guest:");
        	
        }
        
       
        
        

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
            System.out.println("Reservation ID not found.");
            
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
	//can integrate all the user inputs inside this func, or we just get input from the ui
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
	
	
	public boolean checkValidReservationDate(Calendar date){
        Calendar now = Calendar.getInstance();
        if(date.get(Calendar.DAY_OF_YEAR) == now.get(Calendar.DAY_OF_YEAR) &&
                date.get(Calendar.YEAR) == now.get(Calendar.YEAR)){
            return true;
        }else if(date.before(now)){
            System.out.println("! ERROR: This date is invalid");
            return false;
        }
        long diff = date.getTimeInMillis() - now.getTimeInMillis();
        long ddays = diff / (24 * 60 * 60 * 1000);
        if(ddays>90){
            System.out.println("! ERROR: Booking is only valid for 3 months in advannce");
            return false;
        }
        return true;
    }

    public boolean checkValidReservationTime(Calendar time){
        if((time.get(Calendar.HOUR_OF_DAY)) < Initialise.OPENING_HOUR || (time.get(Calendar.HOUR_OF_DAY)) > Initialise.CLOSING_HOUR) {
            System.out.println("! ERROR: Invalid time, beyond working hours");
            return false;
        }else if((time.get(Calendar.MINUTE)) == 0 || (time.get(Calendar.MINUTE)) == 30){
            return true;
        }
        System.out.println("! ERROR: Invalid time");
        return false;
    }

    public Calendar getValidReservationDateTime(){
        String date = "";
        String time = "";
        List times = new ArrayList();
        Date parsedDate = null;
        SimpleDateFormat dateFormat = null;
        boolean validDate = false;
        Calendar arrivalTime = Calendar.getInstance();
        
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter reservation date (dd/MM/yyyy): ");
            date = sc.nextLine();
            //create a date format for user to input
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                parsedDate = dateFormat.parse(date);
            } catch (ParseException e) {
                System.out.println("! ERROR: Entered reservation date is not in the correct format!");
                continue;
            }
            arrivalTime.setTime(parsedDate);
            validDate = checkValidReservationDate(arrivalTime);
            times = checkReservations(arrivalTime);

        } while (!validDate);

        System.out.print( "Available time slots: ") ;
        System.out.print(times +" \n");

        validDate = false;

        if(times.size()>0) {
            do {
                System.out.print("Enter reservation time: ");
                time = sc.nextLine();
                if (times.contains(time)) {
                    //create a date format for user to input
                    dateFormat = new SimpleDateFormat("HH:mm");
                    try {
                        parsedDate = dateFormat.parse(time);

                    } catch (ParseException e) {
                        System.out.println("! ERROR: Entered reservation time is not in the correct format!");
                        continue;
                    }
                    arrivalTime.setTime(parsedDate);
                    validDate = checkValidReservationTime(arrivalTime);
                } else {
                    System.out.println("! ERROR: Invalid time");
                }

            } while (!validDate);
        }else{
            System.out.println("! ERROR: Invalid time");
            return null;
        }
            date = date + " " + time;
            dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            Date d = dateFormat.parse(date);
            arrivalTime.setTime(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return arrivalTime;
    }
	
    
    public List checkReservations(Calendar date){

        List times = new ArrayList();
        String enteredDate = new SimpleDateFormat("dd/MM/yyyy").format(date.getTime());
        times = showTimeSlots(date);

        /* this for loop to check if select date matches any reservation date,
        and then display the available time slots for the date */

        for(Reservation r: reservations){
            String resDate = new SimpleDateFormat("dd/MM/yyyy").format(r.getCheckInDate().getTime());
        }
        return times;
    }
    
    public List showTimeSlots(Calendar date){
        int gapInMinutes =  30;  
        int j;
        List<String> times = new ArrayList<>() ;
        LocalTime t = LocalTime.of(14,0);
        int min = 30;

        for(j = 0; j<16; j++){
            times.add(t.toString());
            t = t.plusMinutes(min);
        }

        LocalDateTime now = LocalDateTime.now();
        if(date.get(Calendar.DAY_OF_YEAR) == now.getDayOfYear() &&
                date.get(Calendar.YEAR) == now.getYear()){
            int n = 0;
            if(now.getHour() >= 14 && now.getHour() <22){
                n = (now.getHour()-14)*2+1;

                if(now.getMinute() > 30){
                    n = (now.getHour()-14)*2+2;
                }
            }

            times = times.subList(n,times.size());

            return times;
        }

        return times;

    }
	
	
	
}
