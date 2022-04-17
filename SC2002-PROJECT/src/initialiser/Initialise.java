package initialiser;
import java.util.ArrayList;


import java.util.Timer;

import classes.*;
import serialize.ReadHotelDB;



/**
 * @author Darren Choo
 * @version 1.0
 * @since 14th April 2022
 */
public class Initialise {
	

	
	
	//attributes
	
	/**
	 * hotel opens at 2pm
	 */
	public static final int OPENING_HOUR = 14;
    
	/**
	 * hotel closes at 10pm
	 */
    public static final int CLOSING_HOUR = 22;
    
    /**
     * hotel default check out time 2pm
     */
    public static final int CHECK_OUT_TIME = 14;
    
    /**
     * hotel gst at 9%
     */
    public static final double GST = 0.09;
    

	
	/**
	 *array list of rooms
	 */
	public static ArrayList<Room> rooms = new ArrayList<Room>();
	/**
	 * room manager in hotel
	 */
	public static RoomManager room = new RoomManager(rooms);
	/**
	 * array list of reservations
	 */
	public static ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	/**
	 * reservation manager in hotel
	 */
	public static ReservationManager resm = new ReservationManager(reservations, rooms);
	/**
	 * array list of menu items
	 */
	public static ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
	/**
	 * menu manger in hotel
	 */
	public static MenuManager mm = new MenuManager(menu);
	/**
	 * check-in manager in hotel
	 */
	public static CheckInManager checkm = new CheckInManager();
	/**
	 * array list of orders
	 */
	public static ArrayList<Order> orders =new ArrayList<Order>();
	/**
	 * order manager in hotel
	 */
	public static OrderManager om = new OrderManager(orders);	
	/**
	 * array list of guests
	 */
	public static ArrayList<Guest> guests = new ArrayList<Guest>();
	/**
	 * guest manager in hotel
	 */
	public static GuestManager gm = new GuestManager();
	/**
	 * array list of payments
	 */
	public static ArrayList<Payment> payments = new ArrayList<Payment>();
	/**
	 * payment manager in hotel
	 */
	public static PaymentManager pm = new PaymentManager(payments);
	
	

	
	/**
	 *auto expiry function that runs every 50s
	 */
	public static void autoExpiry(){
        Timer time = new Timer();
        ReservationExpiry re = new ReservationExpiry(Initialise.reservations); // Instantiate ScheduledTask class
        time.schedule(re, 0,50000); // Create Repetitively task for every 50 seconds
    }


	/**
	 * function to initialise serialize and auto expiry
	 */
	public static void InitialiseHotel() {
		ReadHotelDB.readHotelDB();
		autoExpiry();

		
	}
}
