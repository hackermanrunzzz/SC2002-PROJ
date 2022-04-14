package classes;
/**
 * @author Vijayanarayanan Sai Arunavan
 * @version 1.0
 * @since 14th April 2022
 */

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
import java.time.temporal.ChronoUnit;

import Initialiser.Initialise;
import classes.Reservation.*;
import classes.Room.StatusOfRoom;
import classes.Room.TypeOfRoom;
/**
 * create reservation manager class
 */
public class ReservationManager {
	/**
	 * create an array of reservation items
	 */
	private static ArrayList<Reservation> reservations;
	/**
	 *create an array of room items
	 */
	private static ArrayList<Room> rooms;
	/**
	 * constructor for reservation manager
	 * @param reservations array list of reservation objects
	 * @param rooms array list of room objects
	 */	
	public ReservationManager(ArrayList<Reservation> reservations, ArrayList<Room> rooms) {
		ReservationManager.reservations = reservations;
		ReservationManager.rooms = rooms;
    }
	/**
	 * sets the reservation and room arrays
	 * @param reservations array list of reservation objects
	 * @param rooms array list of room objects
	 */
	public void setReservations(ArrayList<Reservation> reservations, ArrayList<Room> rooms) {
		ReservationManager.reservations = reservations;
		ReservationManager.rooms = rooms;
	}
	/**
	 * user interface to make a reservation object, to add into the array of reservation objects
	 */
	public void makeReservationUI(){
		Scanner sc = new Scanner(System.in);
		int adults=0, children=0;
        int pax = 0;
        int maxOccupancy=0;
        int roomcounter = 0;
        String typeofroomUpper = "";
        ArrayList<String> vacantRooms = new ArrayList<String>();
        boolean RoomMatch = true;
    	ArrayList<Guest> currentGuestArr = new ArrayList<Guest>();
    	String creditCardNumber;
    	Calendar checkInDate;
    	Calendar checkOutDate;
    	String roomNumber ="";
    	int numberOfNights;


        while(true) {
        	boolean roomTypeCheck = true;
        	while(roomTypeCheck) {
		        System.out.println("Please enter the type of room that you want (SINGLE/DOUBLE/DELUXE/VIPSUITE): ");
		        String typeofroom = sc.nextLine();
		        typeofroomUpper = typeofroom.toUpperCase();
		        
		        if(typeofroomUpper.equals("SINGLE") || typeofroomUpper.equals("DOUBLE") || typeofroomUpper.equals("DELUXE") || typeofroomUpper.equals("VIPSUITE")) {
		        	roomTypeCheck = false;
		        }
		        else {
		        	System.out.println("Invalid room type entered.");
		        }
        	}
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
        	
        	
        	Room thisRoom = ReturnRoom(roomNumber);
            
            checkInDate = getValidCheckInDateTime();
            checkOutDate = getValidCheckOutDateTime(checkInDate);
            numberOfNights = calcNumberOfDays(checkInDate,checkOutDate);

            System.out.printf("You have booked %d night(s).\n", numberOfNights);
            

            makeReservation(currentGuestArr, thisRoom,currentGuestArr.get(0).getCreditCardNumber(), checkInDate, checkOutDate, adults, children, numberOfNights);
        }
    }
	/**
	 * makes a reservation object
	 */
	public void makeReservation(ArrayList<Guest> guestDetails, Room roomDetails, String billingInformation,
			Calendar checkInDate, Calendar checkOutDate, int adultCount, int childrenCount, int numberOfNights){

		if(roomDetails.getRoomStatus() == Room.StatusOfRoom.VACANT) {
	        int reservationID = 10000;
	        if(Initialise.reservations.size() > 0){
	        	reservationID = Initialise.reservations.get(Initialise.reservations.size()-1).getReservationID()+1;
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
		}
    }

	/**
	 * assigns a room to a guest, via reservation
	 * @param guestDetails array of guest objects
	 * @param roomDetails array of room objects
	 * @param billingInformation credit card name and number of paying guest(s)
	 * @param checkInDate calendar type object to get check-in date
	 * @param checkOutDate calendar type object to get check-out date
	 * @param adultCount number of adults
	 * @param childrenCount number of children
	 * @param numberOfNights number of nights to be staying
	 */
	public void makeCheckIn(ArrayList<Guest> guestDetails, Room roomDetails, String billingInformation,
			Calendar checkInDate, Calendar checkOutDate, int adultCount, int childrenCount, int numberOfNights){

		if(roomDetails.getRoomStatus() == Room.StatusOfRoom.VACANT) {
	        int reservationID = 10000;
	        if(Initialise.reservations.size() > 0){
	        	reservationID = Initialise.reservations.get(Initialise.reservations.size()-1).getReservationID()+1;
	        }
	
	        System.out.println("\nReservation is Confirmed!\nReservation ID:" + reservationID);
	        reservations.add(new Reservation(reservationID, guestDetails, roomDetails, billingInformation,
	    			checkInDate, checkOutDate, adultCount, childrenCount,
	    			StatusOfReservation.CHECKED_IN, numberOfNights));
	        
	        roomDetails.setRoomStatus(Room.StatusOfRoom.OCCUPIED);
	        
	        return;
		}
		else {
			System.out.println("The room is " + roomDetails.getRoomStatus() + ".");
		}
    }
	/**
	 * searches for a specific reservation
	 * @param resId unique identifier for reservations
	 * @return 1 if search is successful, 0 otherwise, and -1 if an error is encountered
	 */
	public int searchReservation(int resId) {
        if(reservations.isEmpty() == true){
            System.out.println("\nThere are currently no reservations");
            return 0;
        }
        else{
            for(Reservation r: reservations){
                if(r.getReservationID() == resId){
                    System.out.println("========================================");

                    System.out.println("\nFound reservation: ");
                    System.out.println(r.printReservation());
                    return 1;
                }
            }
            System.out.println("Reservation ID not found.");
        }
        return -1;
    }
	/**
	 * prints out information on all reservations made
	 */
	public void showAllReservations() {

        if (reservations.isEmpty() == true) {
            System.out.println("\nThere are currently no reservations");
        } 
        else {
            System.out.println("============ ALL RESERVATIONS ===============");

            for (Reservation r : reservations) {
                System.out.println(r.printReservation());
                System.out.println();
            }
        }
    }
	/**
	 * shows limited information about reservations made
	 * @return reservation information
	 */
	public int showShortReservation(){
        if (reservations.isEmpty() == true) {
            System.out.println("There are currently no reservations");
            return 0;
        } 
        else {
            System.out.println("============ ALL RESERVATIONS ===============");
            for (Reservation r : reservations) {
                Date date = r.getCheckInDate().getTime();
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                String strDate = dateFormat.format(date);
                System.out.println("ID: "+ r.getReservationID() + "\t Date: "+ strDate);
             }
            return 1;
        }
    }
	/**
	 * cancels reservations
	 * @return 1 if successful, 0 if otherwise
	 */
	public int cancelReservation(){ 
		int resId;
		int cancel = Initialise.resm.showShortReservation();
		int correctId=0;
		Scanner sc = new Scanner(System.in);
		
		if(cancel == 1) {
			System.out.println();
			System.out.println("Please enter the reservation ID that you wish to cancel:");
	    	resId = sc.nextInt();
	    	
	    	//checking for valid reservation ID
	    	for(Reservation r : reservations){
	            if(r.getReservationID() == resId){
	            	correctId = 1;
	            }
	        }
	    	
	    	if(correctId == 1) {
	    		System.out.println("Are you sure you wish to remove reservation "+ resId + "?");
				System.out.println("Press (1) to confirm, Press any other number to cancel");
				int choice = sc.nextInt();
				if (choice == 1) {
			        int index = 0;
			        for(Reservation r : reservations){
			            if(r.getReservationID() == resId){
			            	r.getRoomDetails().setRoomStatus(Room.StatusOfRoom.VACANT);
			                reservations.remove(index);
			                
			                System.out.println("Reservation successfully removed.");
			                return 1;
			            }
			            index++;
			        }
				}
				else {
					System.out.println("Reservation removal cancelled.");
				}
	    		
	    	}
	    	else {
	    		System.out.println("Invalid Reservation ID entered.");
	    	}
		}
        return 0;
    }
	/**
	 * 
	 * @param date calendar type object to get date
	 * @return false if reservation is made too far before current date, true if date is valid
	 */
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
	/**
	 * checks if the time of the reservation is valid
	 * @param time calendar type object which contains the time of the reservation
	 * @return true if time is valid, false otherwise
	 */
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
	/**
	 * gets the check-in date and the time
	 * @return check-in date and time
	 */
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
	/**
	 * gets the check-out date and time for the reservation
	 * @param checkInDate  calendar type object which contains the check-in date of the reservation
	 * @return check-out date
	 */
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
        
        
        System.out.println("Input accepted, Check Out has to be done before 2pm.");

        return checkOutDate;
    }
	/**
	 * compares the check-in and check-out date of the reservation 
	 * @param checkInDate calendar type object which contains the check-in date of the reservation
	 * @param checkOutDate calendar type object which contains the check-out date of the reservation
	 * @return true if dates are valid, false otherwise
	 */
    public boolean compareCheckInCheckOut(Calendar checkInDate, Calendar checkOutDate ) {
    	if(checkInDate.before(checkOutDate)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
	/**
	 * shows timings available for booking
	 * @param date calendar type object which contains the current date 
	 * @return list of times available for selection if successful
	 */
    public List checkReservations(Calendar date){

        List times = new ArrayList();
        String enteredDate = new SimpleDateFormat("dd/MM/yyyy").format(date.getTime());
        times = showTimeSlots(date);


        for(Reservation r: reservations){
            String resDate = new SimpleDateFormat("dd/MM/yyyy").format(r.getCheckInDate().getTime());
        }
        return times;
    }
	/**
	 * shows time slots for a certain interval
	 * @param date calendar type object which contains the current date
	 * @return list of time slots
	 */
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
	/**
	 * returns room object which reservation is for
	 * @param roomNumber room number of room object
	 * @return room object if successful, null otherwise
	 */
    public Room ReturnRoom(String roomNumber) {
    	for (Room r : Initialise.rooms) {
    		if (r.getRoomNumber().equals(roomNumber)) {
    				return r;
    		}
    	}
    	return null;
    }
	/**
	 * calculates number of days between the check-in and the check-out date
	 * @param checkInDate calendar type object which contains the check-in date of the reservation
	 * @param checkOutDate calendar type object which contains the check-out date of the reservation
	 * @return the number of days between the check-in and the check-out date
	 */
    public int calcNumberOfDays(Calendar checkInDate, Calendar checkOutDate) {

    	long numberOfSeconds = ChronoUnit.SECONDS.between(checkInDate.getTime().toInstant(), checkOutDate.getTime().toInstant());
    	float numberOfSecondsdouble = (float)numberOfSeconds;
    	//covertion from seconds to days
    	int numberOfDays = Math.round((numberOfSecondsdouble/(60*60*24)));
    	return numberOfDays;



    }
    /**
	 * invalidates a reservation
	 * @param resId unique identifier for each reservation
	 * @return 1 if successful, 0 otherwise
	 */
    public int expireReservation(int resId){ 
        int index = 0;
        for(Reservation r : reservations){
            if(r.getReservationID() == resId){
            	r.getRoomDetails().setRoomStatus(Room.StatusOfRoom.VACANT);
                reservations.remove(index);
                return 1;
            }
            index++;
        }
        return 0;
    }
	
	
}
