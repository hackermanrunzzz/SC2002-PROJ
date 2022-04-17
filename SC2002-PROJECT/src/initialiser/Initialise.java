package initialiser;
import java.util.ArrayList;


import java.util.Timer;

import classes.*;
import serialize.ReadHotelDB;


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
	
	public static ArrayList<Order> orders =new ArrayList<Order>();
	public static OrderManager om = new OrderManager(orders);	

	public static ArrayList<Guest> guests = new ArrayList<Guest>();

	// Created the above ArrayList for the Reservations Initialiser
	
	public static GuestManager gm = new GuestManager();
	
	
	public static ArrayList<Payment> payments = new ArrayList<Payment>();
	public static PaymentManager pm = new PaymentManager(payments);
	
	


	
	public static void autoExpiry(){
        Timer time = new Timer();
        ReservationExpiry re = new ReservationExpiry(Initialise.reservations); // Instantiate ScheduledTask class
        time.schedule(re, 0,50000); // Create Repetitively task for every 50 seconds
    }


	
	public static void InitialiseHotel() {
		ReadHotelDB.readHotelDB();
		autoExpiry();

		
	}
}
