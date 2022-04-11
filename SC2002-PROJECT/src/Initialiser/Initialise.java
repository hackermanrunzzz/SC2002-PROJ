package Initialiser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import classes.*;
import classes.MenuItem.TypeOfMenuItem;
import classes.Room.StatusOfRoom;
import classes.Room.TypeOfBed;
import classes.Room.TypeOfRoom;
import classes.Reservation.StatusOfReservation;
import classes.Payment.methodOfPayment; // For initialising Payment here first, testing


public class Initialise {
	

	
	
	//attributes
	
	public static final int OPENING_HOUR = 14;
    
    public static final int CLOSING_HOUR = 22;
    
    public static final int CHECK_OUT_TIME = 14;
    
    public static final double GST = 0.09;
    

	
	//
	public static ArrayList<Room> rooms = new ArrayList<Room>();
	public static RoomManager room = new RoomManager(rooms);
	
	
	public static ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	public static ReservationManager resm = new ReservationManager(reservations, rooms);
	
	public static ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
	public static MenuManager mm = new MenuManager(menu);
	
	public static CheckInManager checkm = new CheckInManager();
	
	//public static ArrayList<MenuItem> roomServiceitems = new ArrayList<MenuItem>(); // Question, is this gonna be used for the RoomService class to print menu and stuff?
	//
	public static ArrayList<Order> orders =new ArrayList<Order>();
	public static OrderManager om = new OrderManager(orders);	

	public static ArrayList<Guest> guests = new ArrayList<Guest>();

	// Created the above ArrayList for the Reservations Initialiser
	
	public static GuestManager gm = new GuestManager();
	
	
	private static ArrayList<Payment> payments = new ArrayList<Payment>();
	public static PaymentManager pm = new PaymentManager(payments);
	
	
	
	
	
	//methods
	public static void InitialiseMenu(){
	
		//Main

		MenuItem food1 = new MenuItem("Seafood Nasi Goreng",  "Sambal Fried Fish, Prawn Satay, Fried Egg, Fish Cracker and Pickled Achar", TypeOfMenuItem.MAIN , 20.00);
		menu.add(food1);

		MenuItem food2 = new MenuItem("Grass-Fed Angus Sirloin - 250gm", "Toasted Fresh Harvest Vegetable and Roasted Potato", TypeOfMenuItem.MAIN , 42.00);
		menu.add(food2);

		MenuItem food3 = new MenuItem("Seared Chicken - Half",  "Roasted Fresh Harvest Vegetable with Tarragon Sauce", TypeOfMenuItem.MAIN , 28.00);
		menu.add(food3);

		MenuItem food4 = new MenuItem("Assorted Butcher's Platter" , "Four Kinds of Homemade Sausages", TypeOfMenuItem.MAIN , 28.00);
		menu.add(food4);

		MenuItem food5 = new MenuItem("Tandoori Chicken Wrap", "Shredded Chicken with Lime Yogurt Dip and Raita Salad", TypeOfMenuItem.MAIN , 18.00);
		menu.add(food5);

		//Beverage
		MenuItem food6 = new MenuItem("Plain Water", "Chilled", TypeOfMenuItem.BEVERAGE , 2.99);
		menu.add(food6);

		MenuItem food7 = new MenuItem("Coca-Cola", "Chilled", TypeOfMenuItem.BEVERAGE, 4.99);
		menu.add(food7);

		MenuItem food8 = new MenuItem("Lemon Seltzer", "Freshly Squeezed Lemon, Stirred With Hard Seltzer [ Alcohol-Content Present ]", TypeOfMenuItem.BEVERAGE, 6.99);
		menu.add(food8);

		MenuItem food9 = new MenuItem("Sunset Sling", "Mocktail Of Freshly Picked and Squeezed Tropical Fruits, Mango, Apple, Pineapple, and Banana", TypeOfMenuItem.BEVERAGE, 8.99);
		menu.add(food9);

		MenuItem food10 = new MenuItem("Iced Lemon Tea", "Freshly Squeezed Lemon Juice, Stirred With Iced Plain Tea", TypeOfMenuItem.BEVERAGE, 6.99);
		menu.add(food10);

		//Desserts

		MenuItem food11 = new MenuItem("French Fries", "Slightly Salted with Some Salt", TypeOfMenuItem.DESSERT, 10.00);
		menu.add(food11);

		MenuItem food12 = new MenuItem("Sorbet Selection", "Single Scoop of Passion Fruit, Lemongrass or Raspberry Sorbet, Served With Berries", TypeOfMenuItem.DESSERT, 8.99);
		menu.add(food12);

		MenuItem food13 = new MenuItem("Ice Cream", "Single Scoop of Vanilla, Strawberry, Maple Walnut, or Mango", TypeOfMenuItem.DESSERT, 9.99);
		menu.add(food13);

		MenuItem food14 = new MenuItem("Classic Espresso", "Vanilla Vodka, Espresso, Frangelico Chocolate", TypeOfMenuItem.DESSERT, 22.00);
		menu.add(food14);

		MenuItem food15= new MenuItem("Milkshakes", "Vanilla, Strawberry, Chocolate, Coookies and Creamn, Lime and Honey",  TypeOfMenuItem.DESSERT, 12.00);
		menu.add(food15);
		
//		Initialise.menu = menu;
		
	}
	
	public static void InitialiseRoom(){
		int i;
		
		
		//10 single rooms on floor 2
		for (i=1; i<=10;i++) {
			Integer.toString(i);
			Integer.toString(i);
			rooms.add(new Room("02-" + String.format("%02d", i) ,  TypeOfRoom.SINGLE , TypeOfBed.SINGLE, true, true, false, StatusOfRoom.VACANT, 200) );
			
		}
		
		//10 single rooms on floor 3
		for (i=1; i<=10;i++) {
			Integer.toString(i);
			Integer.toString(i);
			rooms.add(new Room("03-" + String.format("%02d", i),  TypeOfRoom.SINGLE , TypeOfBed.SINGLE, true, true, false, StatusOfRoom.VACANT, 200) );
			//
		}
		
		//8 double rooms on floor 4
		for (i=1; i<=8;i++) {
			Integer.toString(i);
			rooms.add(new Room("04-" + String.format("%02d", i) ,  TypeOfRoom.DOUBLE , TypeOfBed.SINGLE, true, true, false, StatusOfRoom.VACANT, 350) );
			
		}
		
		//8 double rooms on floor 5
		for (i=1; i<=8;i++) {
			Integer.toString(i);
			rooms.add(new Room("05-" + String.format("%02d", i) ,  TypeOfRoom.DOUBLE , TypeOfBed.SINGLE, true, true, false, StatusOfRoom.VACANT, 350) );
			
		}
		
		//8 deluxe rooms on floor 6
		for (i=1; i<=8;i++) {
			Integer.toString(i);
            rooms.add(new Room("06-" + String.format("%02d", i) ,  TypeOfRoom.DELUXE , TypeOfBed.QUEEN, true, true, false, StatusOfRoom.VACANT, 400) );
			
		}
		
		//4 VipSuite rooms on floor 7
		for (i=1; i<=4;i++) {
			Integer.toString(i);
			rooms.add(new Room("07-" + String.format("%02d", i) ,  TypeOfRoom.VIPSUITE , TypeOfBed.KING, true, true, true, StatusOfRoom.VACANT, 500) );
			
		}
//		Initialise.rooms = rooms;
	}

	public static Calendar convert(String source) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(dateFormat.parse(source));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return calendar;
	  } // Added this to convert String to Calendar type

	public static void InitialiseReservation() // Created for TESTING
	{

		Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2= Calendar.getInstance();
        Calendar calendar3= Calendar.getInstance();
        Calendar calendar4 = Calendar.getInstance();


    	String date1_1 = "13/04/2022 12:30";
		Calendar date1 = convert(date1_1);
        String date2_2 = "14/04/2021 14:30";
		Calendar date2 = convert(date2_2);
        String date3_3 = "15/04/2021 16:30";
		Calendar date3 = convert(date3_3);
        String date4_4 = "16/04/2021 18:30";
		Calendar date4 = convert(date4_4);

		// Initialising 4 TEST Guests inside the Guests Array
		Guest guest_one = new Guest("Derrick", "James", "96785757", "The Ritz, Avenue 6", "Singapore", 'M', "Indian", "Singaporean", "96978575");
		guests.add(guest_one);
		Guest guest_two = new Guest("Mark", "Black", "96684738", "Patriots' Street 58", "Malaysia", 'F', "Chinese", "Malaysian", "77778888");
		guests.add(guest_two);
		Guest guest_three = new Guest("Darren", "Williams", "77665544", "Fourier Avenue 69", "Sweden", 'M', "Indonesian", "American", "12345678");
		guests.add(guest_three);
		Guest guest_four = new Guest("Blake", "Johnson", "11234578", "Salem Avenue 23", "Denmark", 'M', "Armenian", "Australian", "90807060");
		guests.add(guest_four);

		// First Guest is assumed to be Checked-in, was assigned a Deluxe Room
		Reservation reserv_one  = new Reservation(10001, guests, rooms.get(36), "Name is: " + guests.get(0).getCreditCardName() + ", and Credit Card Number is: " + guests.get(0).getCreditCardNumber(), calendar1, date1,2,2,StatusOfReservation.CHECKED_IN,3);
		reservations.add(reserv_one);


		// Second Guest has a reseved Reservation, was assigned a Single Room
		Reservation reserv_two = new Reservation(10002, guests, rooms.get(0), "Name is: " + guests.get(1).getCreditCardName() + ", and Credit Card Number is: " + guests.get(1).getCreditCardNumber(), calendar2,date2,1,0,StatusOfReservation.CONFIRMED,5);
		reservations.add(reserv_two);


		// Third Guest is in the waitlist, was assigned a Deluxe Room
		Reservation reserv_three = new Reservation(10003, guests, rooms.get(44), "Name is: " + guests.get(2).getCreditCardName() + ", and Credit Card Number is: " + guests.get(2).getCreditCardNumber(), calendar3, date3,3,2,StatusOfReservation.IN_WAITLIST,5);
		reservations.add(reserv_three);

		//Fourth Guest's Reservation Expired Alrdy, was assigned a Double Room
		Reservation reserv_four = new Reservation(10004, guests, rooms.get(20), "Name is: " + guests.get(3).getCreditCardName() + ", and Credit Card Number is: " + guests.get(3).getCreditCardNumber(), calendar4, date4,1,1,StatusOfReservation.EXPIRED,5);
		reservations.add(reserv_four);
	}

	public static void InitialiseRoomService()
	{
		
	}
	
	public static void autoExpiry(){
        Timer time = new Timer();
        ReservationExpiry re = new ReservationExpiry(Initialise.reservations); // Instantiate ScheduledTask class
        time.schedule(re, 0,50000); // Create Repetitively task for every 20 seconds
    }

	public static void InitialisePayment()
	{

	}

	
	public static void InitialiseHotel() {
		InitialiseMenu();
		InitialiseRoom();
		autoExpiry();
//		InitialiseReservation();
		
	}
}
