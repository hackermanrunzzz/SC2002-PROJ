package classes;

import java.text.DateFormat;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;

import Initialiser.Initialise;
import classes.MenuItem.TypeOfMenuItem;
import classes.Reservation.*;
import classes.Room.StatusOfRoom;
import classes.Room.TypeOfRoom;

public class ReservationManager {

	private static ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	
	private static ArrayList<Room> rooms;
	
	
	
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
		int adults=0, children=0;
        int pax = 0;
        int maxOccupancy=0;
        int roomcounter = 0;
        String typeofroomUpper;
        ArrayList<String> vacantRooms = new ArrayList<String>();
        boolean RoomMatch = true;
    	ArrayList<Guest> currentGuestArr = new ArrayList<Guest>();
    	String creditCardNumber;
    	Calendar checkInDate;
    	Calendar checkOutDate;
    	String roomNumber ="";
    	int numberOfNights;
        

//        if(Restaurant.reservationManager.getReservations().size() > 9 ){
//            System.out.println("We are fully booked!");
//            return;
//        }
        while(true) {
	        System.out.println("Please enter the type of room that you want (SINGLE/DOUBLE/DELUXE/VIPSUITE): ");
	        String typeofroom = sc.nextLine();
	        typeofroomUpper = typeofroom.toUpperCase();
	        
	        
	        
	        System.out.print("Enter amount of Adults: ");
	        adults = sc.nextInt();
	        
	        System.out.print("Enter amount of Children: ");
	        children = sc.nextInt();
	        
	        pax = adults + children;
	        
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
        	for (Room r : Initialise.rooms) {
        		 if (r.getRoomType().equals(TypeOfRoom.SINGLE) && r.getRoomStatus().equals(StatusOfRoom.VACANT)) {
        			 System.out.println(r.getRoomNumber());
        			 roomcounter++;
        			 vacantRooms.add(r.getRoomNumber());
        		 }
        	}
        }
        else if(typeofroomUpper.equals("DOUBLE")) {
        	System.out.println("These are the vacant Double Rooms:");
        	for (Room r : Initialise.rooms) {
        		 if (r.getRoomType().equals(TypeOfRoom.DOUBLE) && r.getRoomStatus().equals(StatusOfRoom.VACANT)) {
        			 System.out.println(r.getRoomNumber());
        			 roomcounter++;
        			 vacantRooms.add(r.getRoomNumber());
        		 }
        	}
        }
        else if(typeofroomUpper.equals("DELUXE")) {
        	System.out.println("These are the vacant Deluxe Rooms:");
        	for (Room r : Initialise.rooms) {
        		 if (r.getRoomType().equals(TypeOfRoom.DELUXE) && r.getRoomStatus().equals(StatusOfRoom.VACANT)) {
        			 System.out.println(r.getRoomNumber());
        			 roomcounter++;
        			 vacantRooms.add(r.getRoomNumber());
        		 }
        	}
        }
        else if(typeofroomUpper.equals("VIPSUITE")) {
        	System.out.println("These are the vacant VIP Suites:");
        	for (Room r : Initialise.rooms) {
        		 if (r.getRoomType().equals(TypeOfRoom.VIPSUITE) && r.getRoomStatus().equals(StatusOfRoom.VACANT)) {
        			 System.out.println(r.getRoomNumber());
        			 roomcounter++;
        			 vacantRooms.add(r.getRoomNumber());
        		 }
        	}
        }
        sc.nextLine();
        
        if(roomcounter == 0) {
        	System.out.println("There are no available rooms available.");
        }
        else {
        	while(RoomMatch) {
	        	System.out.println("Enter the selected room that you wish to assign to the guest:");
	        	roomNumber = sc.nextLine();
	        	
	        	for(String vacant : vacantRooms) {
	        		if(roomNumber.equals(vacant)) {
	        			RoomMatch = false;
	        			break;
	        		}
	        			
	        	}
	        	
	        	if(RoomMatch) {
	        		System.out.println("Invalid Room Number.");
	        	}
        	}
        	
        	

        	
        	
        	System.out.println("Ensure that the first guest details is the one footing the bill !!!");
        	
        	for(int i=0; i<pax;i++) {
        		System.out.printf("Please enter the guest %d name:\n", i+1);
        		String guestName = sc.nextLine();
        		
        		System.out.println("Please enter the credit card name:");
        		String creditCardName = sc.nextLine();
        		
        		while(true) {
        			System.out.println("Please enter the credit card number (Enter \"-\" if not applicable): ");
        			creditCardNumber = sc.nextLine();
        		
        			if(i==0 && creditCardNumber.equals("-")) {
        				System.out.println("Please enter a valid Credit Card Number for the first guest.");
        			}
        			else {
        				break;
        			}
        		}
        		
        		System.out.println("Please enter your address:");
        		String address = sc.nextLine();
        		
        		System.out.println("Please enter your country:");
        		String country = sc.nextLine();
        		
        		System.out.println("Please enter your gender (M/F):");
        		char gender = sc.next().charAt(0);
        		sc.nextLine();
        		
        		System.out.println("Please enter your identity:");
        		String identity = sc.nextLine();
        		
        		System.out.println("Please enter your nationality:");
        		String nationality = sc.nextLine();
        		
        		System.out.println("Please enter your contact number:");
        		String contact = sc.nextLine();
        		
        		Guest guestx = new Guest(guestName,creditCardName,creditCardNumber,address,country,gender,identity,nationality,contact);
        		currentGuestArr.add(guestx);
        	}
        }
        Room thisRoom = ReturnRoom(roomNumber);
        
        checkInDate = getValidCheckInDateTime();
        checkOutDate = getValidCheckOutDateTime(checkInDate);
        numberOfNights = calcNumberOfDays(checkInDate,checkOutDate);

        
        

        makeReservation(currentGuestArr, thisRoom,currentGuestArr.get(0).getCreditCardNumber(), checkInDate, checkOutDate, adults, children, numberOfNights);



    }
	
	
	public void makeReservation(ArrayList<Guest> guestDetails, Room roomDetails, String billingInformation,
			Calendar checkInDate, Calendar checkOutDate, int adultCount, int childrenCount, int numberOfNights){

		if(roomDetails.getRoomStatus() == Room.StatusOfRoom.VACANT) {
	        int reservationID = 10000;
	        if(reservations.size() > 0){
	        	reservationID = reservations.get(reservations.size()-1).getReservationID()+1;
	        }
	
	        System.out.println("\nReservation is Confirmed!\nReservation ID:" + reservationID);
	        reservations.add(new Reservation(reservationID, guestDetails, roomDetails, billingInformation,
	    			checkInDate, checkOutDate, adultCount, childrenCount,
	    			StatusOfReservation.CONFIRMED, numberOfNights));
	        
	        roomDetails.setRoomStatus(Room.StatusOfRoom.RESERVED);
	        
	        return;
		}
		else {
			System.out.println("The room is " + roomDetails.getRoomStatus() + ".");
//			System.out.println("The room is unavailable");
		}
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
            System.out.println("! ERROR: Booking is only valid for 3 months in advance");
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

    public Calendar getValidCheckInDateTime(){
        String date = "";
        String time = "";
        List times = new ArrayList();
        Date parsedDate = null;
        SimpleDateFormat dateFormat = null;
        boolean validDate = false;
        Calendar checkInDate = Calendar.getInstance();
        
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter Check In date (dd/MM/yyyy): ");
            date = sc.nextLine();
            //create a date format for user to input
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                parsedDate = dateFormat.parse(date);
            } catch (ParseException e) {
                System.out.println("! ERROR: Entered reservation date is in the wrong format!");
                continue;
            }
            checkInDate.setTime(parsedDate);
            validDate = checkValidReservationDate(checkInDate);
            times = checkReservations(checkInDate);

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
                    checkInDate.setTime(parsedDate);
                    validDate = checkValidReservationTime(checkInDate);
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
            checkInDate.setTime(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return checkInDate;
    }
    
    public Calendar getValidCheckOutDateTime(Calendar checkInDate){
        String date = "";
        String time = "";
        List times = new ArrayList();
        Date parsedDate = null;
        SimpleDateFormat dateFormat = null;
        boolean validDate = false;
        boolean validCheckOutDate = false;
        Calendar checkOutDate = Calendar.getInstance();
        
        Scanner sc = new Scanner(System.in);
        
        do {
	        do {
	            System.out.print("Enter Check Out date (dd/MM/yyyy): ");
	            date = sc.nextLine();
	            //create a date format for user to input
	            dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	            try {
	                parsedDate = dateFormat.parse(date);
	            } catch (ParseException e) {
	                System.out.println("! ERROR: Entered reservation date is in the wrong format!");
	                continue;
	            }
	            checkOutDate.setTime(parsedDate);
	            validDate = checkValidReservationDate(checkOutDate);
	            times = checkReservations(checkOutDate);
	
	        } while (!validDate);
	
	        dateFormat = new SimpleDateFormat("HH:mm");
	        time = "14:00";
	        date = date + " " + time;
	        dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	        try {
	            Date d = dateFormat.parse(date);
	            checkOutDate.setTime(d);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        
	        
	        validCheckOutDate = compareCheckInCheckOut(checkInDate, checkOutDate);
        }while(!validCheckOutDate);
        
        
        System.out.println("Input accepted, Check Out has to be done before 2pm");

        return checkOutDate;
    }
	
    public boolean compareCheckInCheckOut(Calendar checkInDate, Calendar checkOutDate ) {
    	if(checkInDate.before(checkOutDate)) {
    		return true;
    	}
    	else {
    		return false;
    	}
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

    public Room ReturnRoom(String roomNumber) {
    	for (Room r : Initialise.rooms) {
    		if (r.getRoomNumber().equals(roomNumber)) {
    				return r;
    		}
    	}
    	return null;
    }
	
    public int calcNumberOfDays(Calendar checkInDate, Calendar checkOutDate) {

    	long numberOfSeconds = ChronoUnit.SECONDS.between(checkInDate.getTime().toInstant(), checkOutDate.getTime().toInstant());
    	float numberOfSecondsdouble = (float)numberOfSeconds;
    	//covertion from seconds to days
    	int numberOfDays = Math.round((numberOfSecondsdouble/(60*60*24)));
    	return numberOfDays;



    }
	
	
}
