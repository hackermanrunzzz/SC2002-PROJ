package Serialize;
import java.util.List;

import Initialiser.*;

public class WriteHotelDB {
	public static void writeHotelDB(){
		try	{

				SerializeHotelDB.writeSerializedObject("MenuItem.dat", Initialise.menu);
				SerializeHotelDB.writeSerializedObject("Room.dat", Initialise.rooms);
				SerializeHotelDB.writeSerializedObject("Reservation.dat", Initialise.reservations);
				SerializeHotelDB.writeSerializedObject("Order.dat", Initialise.orders);
				SerializeHotelDB.writeSerializedObject("Payment.dat", Initialise.payments);

		}  catch ( Exception e ) {
					System.out.println( "Exception >> " + e.getMessage() );
		}
	}
}
