package Initialiser;
import java.util.ArrayList;

import classes.*;
import classes.MenuItem.TypeOfMenuItem;
import classes.Room.StatusOfRoom;
import classes.Room.TypeOfBed;
import classes.Room.TypeOfRoom;


public class Initialise {
	

	
	
	//attributes
	
	public static final int OPENING_HOUR = 14;
    
    public static final int CLOSING_HOUR = 22;
    
    public static final int CHECK_OUT_TIME = 14;
    

	
	//
	public static ArrayList<Room> rooms = new ArrayList<Room>();
	public static RoomManager roomm = new RoomManager(rooms);
	
	
	public static ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	public static ReservationManager resm = new ReservationManager(reservations, rooms);
	
	public static ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
	public static MenuManager mm = new MenuManager(menu);
	
	public static CheckInManager checkm = new CheckInManager();
	
	public static ArrayList<MenuItem> roomServiceitems = new ArrayList<MenuItem>();
	//
	public static ArrayList<Order> order=new ArrayList<Order>();
	public static OrderManager om = new OrderManager(order);	
	
	
	
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

	
	public static void InitialiseHotel() {
		InitialiseMenu();
		InitialiseRoom();
		
	}
}
