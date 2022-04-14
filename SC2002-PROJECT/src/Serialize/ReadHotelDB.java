package Serialize;

import java.util.ArrayList;
import java.util.List;
import Initialiser.*;
import classes.*;

public class ReadHotelDB {
	
	public static void readHotelDB() {
		List list;
		try	{
				// read from serialized file the list of professors
				list = (ArrayList)SerializeHotelDB.readSerializedObject("MenuItem.dat");
				for (int i = 0 ; i < list.size() ; i++) {
					MenuItem menuItem = (MenuItem)list.get(i);
					Initialise.menu.add(menuItem);
				}
				
				list = (ArrayList)SerializeHotelDB.readSerializedObject("Room.dat");
				for (int i = 0 ; i < list.size() ; i++) {
					Room room = (Room)list.get(i);
					Initialise.rooms.add(room);
				}
				
				list = (ArrayList)SerializeHotelDB.readSerializedObject("Reservation.dat");
				for (int i = 0 ; i < list.size() ; i++) {
					Reservation reservations = (Reservation)list.get(i);
					Initialise.reservations.add(reservations);
				}
				
				list = (ArrayList)SerializeHotelDB.readSerializedObject("Order.dat");
				for (int i = 0 ; i < list.size() ; i++) {
					Order order = (Order)list.get(i);
					Initialise.orders.add(order);
				}
				
				list = (ArrayList)SerializeHotelDB.readSerializedObject("Payment.dat");
				for (int i = 0 ; i < list.size() ; i++) {
					Payment payment = (Payment)list.get(i);
					Initialise.payments.add(payment);
				}



		}  catch ( Exception e ) {
					System.out.println( "Exception >> " + e.getMessage() );
		}
	}

}
