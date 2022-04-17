package serialize;


import initialiser.*;


/**
 * @author Darren Choo
 * @version 1.0
 * @since 14th April 2022
 */
public class WriteHotelDB {
	
	/**
	 * writes data in the program onto files
	 */
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
