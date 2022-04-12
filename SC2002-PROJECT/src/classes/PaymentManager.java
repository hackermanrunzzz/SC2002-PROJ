package classes;

import java.time.temporal.ChronoUnit;
import java.util.*;


import Initialiser.Initialise;
import classes.Payment.methodOfPayment;
import classes.Reservation.StatusOfReservation;
<<<<<<< Updated upstream
import classes.Room.StatusOfRoom; // Imported to set room to vacant after Reservation was deleted
=======
import classes.Room.StatusOfRoom;
>>>>>>> Stashed changes

public class PaymentManager {

    Scanner sc = new Scanner(System.in);
    
    private static ArrayList<Payment> payments;
	
    
	public PaymentManager(ArrayList<Payment> payments) {
		PaymentManager.payments = payments;
    } // Constructor
	
	public void setPayments(ArrayList<Payment> payments) {
		PaymentManager.payments = payments;
		
	}
	
	double roomChargesGlobal = 0;
<<<<<<< Updated upstream
    double totalChargesGlobal = 0;
    double roomServicesGlobal = 0;
    double discountGlobal = 0;
    int numberOfNightsGlobal = 0;
    Reservation toCheckOut=null;
    String globalPaymentType;
    ArrayList<Order> checkOutRoomOrders = new ArrayList<Order>();
    
    

=======
	double totalChargesGlobal = 0;
	double roomServicesGlobal = 0;
	double discountGlobal = 0;
	int numberOfNightsGlobal = 0;
	String roomNumberGlobal;
>>>>>>> Stashed changes
	
	public void makePayment() {
		String confirmation = "0";
		boolean validRoomFound = false;
		double tax;
<<<<<<< Updated upstream
		
=======
		double roomServices;
		double discount;
		double totalCharges;
		String roomNumber;
		ArrayList<Order> checkOutRoomOrders = new ArrayList<Order>();
>>>>>>> Stashed changes
		
		//finding room for check out
		System.out.println("Hi! Please enter the room to check out from (Enter 0 to cancel check out):");
		roomNumberGlobal = roomNumber = sc.nextLine();
		if(roomNumber.equals("0")) {
			System.out.println("Cancelling check out...");
			return;
		}
		for(Reservation r: Initialise.reservations) {
			//reservation found
			if(r.getRoomDetails().getRoomNumber().equals(roomNumber) && r.getReservationStatus().equals(StatusOfReservation.CHECKED_IN)) {
				System.out.println("Valid checked in reservation for " + roomNumber +
								" found, proceed to check out? (Enter 1 for yes, 0 to cancel check out)");
				confirmation = sc.nextLine();
				if(confirmation.equals("0")) {
					System.out.println("Cancelling check out...");
					return;
				}
				validRoomFound = true;
				//assigns reservation object r to local reservation object toCheckout
				toCheckOut = r;
				break;
			}
			//reservation matched but reservation not checked in
			else if(!r.getReservationStatus().equals(StatusOfReservation.CHECKED_IN)) {
				System.out.println("Invalid entry! Reservation is not checked in.");
				System.out.println("Cancelling check out...");
				return;
			}
			
		}
		if(!validRoomFound) {
			System.out.println("Invalid entry! Unable to find any reservations for this room!");
			System.out.println("Cancelling check out...");
			return;
		}
		
		//assigning attributes
<<<<<<< Updated upstream
		numberOfNightsGlobal = calcNumberOfNights(toCheckOut.getCheckInDate());
		roomChargesGlobal = Math.round(toCheckOut.getRoomDetails().getRate() * numberOfNightsGlobal*100.0)/100.0;
=======
		numberOfNightsGlobal = numberOfNights = calcNumberOfNights(toCheckOut.getCheckInDate());
		roomChargesGlobal = roomCharges = Math.round(toCheckOut.getRoomDetails().getRate() * numberOfNights*100.0)/100.0;
>>>>>>> Stashed changes
		tax = Initialise.GST;
		
		for(Order o: Initialise.orders) {
			if(o.getResID()==toCheckOut.getReservationID()) {
				checkOutRoomOrders.add(o);
			}
		}
		
<<<<<<< Updated upstream
		roomServicesGlobal = Math.round(calcRoomServices(checkOutRoomOrders)*100.0)/100.0;
		//getting discount value
		System.out.println("Please enter discount value in % (Enter 0 for no discount, enter only the numerical value without '%'): ");
		discountGlobal = sc.nextDouble()/100;
		
		//Calculating total charges
		totalChargesGlobal = Math.round(((roomChargesGlobal+roomServicesGlobal)*(1-discountGlobal)*(1+tax))*100.0)/100.0;
		
		//need to add billing info and payment method
		int bills = 0; // to identify the type of bill put into the system
		double total = 0; // for computing total number of bills put into the system
		int choice = 0;
		printFullReceipt(); // Printing receipt before user decides how to pay
		System.out.println("Please enter (1) if you would like to pay by Cash. Enter (2) if you would like to pay by Card instead");
		if (choice==1)
		{
			globalPaymentType = "Cash";
			System.out.println("Please enter the appropriate number for which bill, $50, $10, or $5, you would like to use. Enter (4) to exit");
			while (total<totalChargesGlobal)
			{
				System.out.println("========= Cash Input =========");
				System.out.println("|Enter '1' for $50 input |");
				System.out.println("|Enter '2' for $10 input |");
				System.out.println("|Enter '3' for $5 input  |");
				System.out.println("|Enter '4' for input of change|");
				bills = sc.nextInt();
				if (bills == 1)
				{
					total += 50;
				}
				
				else if (bills == 2)
				{
					total += 10;
				}
				
				else if (bills == 3)
				{
					total += 5;
				}
				
				else if (bills == 4)
				{
					System.out.println("Please enter the amount of money you would like to use as change: ");
					double temp = sc.nextDouble();
					total += temp;
				}
			}
			if (total <= totalChargesGlobal)
			{
				double change = totalChargesGlobal - total;
				System.out.println("You have paid " + total + "in cash");
				System.out.println("Your change is: " + change);
				System.out.println("Thank you for your stay! Have a safe trip back home!");
			}
			else if (total>=totalChargesGlobal)
			{
				double change = total - totalChargesGlobal;
				System.out.println("You have paid " + total + "in cash");
				System.out.println("Your change is: " + change);
				System.out.println("Thank you for your stay! Have a safe trip back home!");
			}
			else
			{
				System.out.println("You have paid " + total + "in cash");
				System.out.println("Thank you for your stay! Have a safe trip back home!");
			}
			
			if (payments.size()>0)
			{
				makePaymentObject(payments.get(payments.size()-1).getPaymentID()+1, roomChargesGlobal, tax, roomServicesGlobal, discountGlobal, totalChargesGlobal, methodOfPayment.CASH, checkOutRoomOrders, numberOfNightsGlobal, toCheckOut.getGuestDetails().get(0).getCreditCardName() , toCheckOut.getGuestDetails().get(0).getAddress(), toCheckOut.getGuestDetails().get(0).getCreditCardNumber()); // Calling the method
			}
			else 
			{
				makePaymentObject(1, roomChargesGlobal, tax, roomServicesGlobal, discountGlobal, totalChargesGlobal, methodOfPayment.CASH, checkOutRoomOrders, numberOfNightsGlobal, toCheckOut.getGuestDetails().get(0).getCreditCardName() , toCheckOut.getGuestDetails().get(0).getAddress(), toCheckOut.getGuestDetails().get(0).getCreditCardNumber()); // If arrayList isn't created yet, assign this payment the ID of 1
			}
			
			
			
		}
		else if (choice == 2)
		{
			globalPaymentType = "Card";
			int check = 0;
			System.out.println("Please verify that this is your credit card name: " + toCheckOut.getGuestDetails().get(0).getCreditCardName() + ". If yes, enter (1). Else, enter (0)");
			check = sc.nextInt();
			if (check == 1)
			{
				System.out.println("Please enter your CCV / CVV: ");
				int ccv = sc.nextInt(); // Just for confirmation of guest, one-time use, don't need to use
				System.out.println("The amount of $" + totalChargesGlobal + " will be charged to your card, under the name " + toCheckOut.getGuestDetails().get(0).getCreditCardName() + " with the number " + toCheckOut.getGuestDetails().get(0).getCreditCardNumber() + "to the address " + toCheckOut.getGuestDetails().get(0).getAddress());
				System.out.println("Thank you for your stay! Have a safe trip back home!");
				makePaymentObject(payments.get(payments.size()-1).getPaymentID()+1, roomChargesGlobal, tax, roomServicesGlobal, discountGlobal, totalChargesGlobal, methodOfPayment.CARD, checkOutRoomOrders, numberOfNightsGlobal,toCheckOut.getGuestDetails().get(0).getCreditCardName() , toCheckOut.getGuestDetails().get(0).getAddress(), toCheckOut.getGuestDetails().get(0).getCreditCardNumber());
			}
			else if  (check == 0)
			{
				String address;
				String name;
				String number;
				System.out.println("Plese enter your credit card name: ");
				name = sc.nextLine();
				System.out.println("Please enter your credit card number: ");
				number = sc.nextLine();
				System.out.println("Please enter your billing address: ");
				address = sc.nextLine();
				System.out.println("The amount of $" + totalChargesGlobal + " will be charged to your card, under the name, " + name + ", with the number " + number + ", to your billing address at " + address);
				System.out.println("Thank you for your stay! Have a safe trip back home!");
				if (payments.size() > 0)
				{
					makePaymentObject(payments.get(payments.size()-1).getPaymentID()+1, roomChargesGlobal, tax, roomServicesGlobal, discountGlobal, totalChargesGlobal, methodOfPayment.CARD, checkOutRoomOrders, numberOfNightsGlobal, toCheckOut.getGuestDetails().get(0).getCreditCardName() , toCheckOut.getGuestDetails().get(0).getAddress(), toCheckOut.getGuestDetails().get(0).getCreditCardNumber()); // Calling the method
				}
				else
				{
					makePaymentObject(1, roomChargesGlobal, tax, roomServicesGlobal, discountGlobal, totalChargesGlobal, methodOfPayment.CARD, checkOutRoomOrders, numberOfNightsGlobal, toCheckOut.getGuestDetails().get(0).getCreditCardName() , toCheckOut.getGuestDetails().get(0).getAddress(), toCheckOut.getGuestDetails().get(0).getCreditCardNumber()); // If arrayList isn't created yet, assign this payment the ID of 1
				}
				
			}
			
			toCheckOut.getRoomDetails().setRoomStatus(StatusOfRoom.VACANT); // Room was set to Vacant here
	        
	        for (Reservation r : Initialise.reservations)
	        {
	            if (toCheckOut.equals(r))
	            {
	                Initialise.reservations.remove(r); // Removing Reservation here
	            }
	        }	
		}
=======
		roomServicesGlobal = roomServices = Math.round(calcRoomServices(checkOutRoomOrders)*100.0)/100.0;
		//getting discount value
		System.out.println("Please enter discount value in % (Enter 0 for no discount, enter only the numerical value without '%'): ");
		discountGlobal = discount = sc.nextDouble()/100;
		//Calculating total charges
		totalChargesGlobal = totalCharges = Math.round(((roomCharges+roomServices)*(1-discount)*(1+tax))*100.0)/100.0;
		
		toCheckOut.getRoomDetails().setRoomStatus(StatusOfRoom.VACANT); // Room was set to Vacant here
		
		for (Reservation r : Initialise.reservations)
		{
			if (toCheckOut.equals(r))
			{
				Initialise.reservations.remove(r); // Removed Reservation
			}
		}
		
		
		
//		System.out.println("Please enter your preferred payment method: (1) for Cash and (2) for Card");
		
		//need to add billing info and payment method
		//create payment object and add to payment array
		//print receipt
		
		
		
>>>>>>> Stashed changes
	}
	
	public void makePaymentObject(int paymentID, double roomCharges, double tax, double roomServices, double discount, double totalCharges, methodOfPayment methodOfPayment, ArrayList<Order> r, int numberOfNights, String name, String address, String number)
	{
		Payment paymentObject = new Payment(payments.get(payments.size()-1).getPaymentID()+1, roomChargesGlobal, tax, roomServicesGlobal, discountGlobal, totalChargesGlobal, classes.Payment.methodOfPayment.CARD, checkOutRoomOrders, numberOfNightsGlobal, name, address, number);
		payments.add(paymentObject); // Added the payment object to the payment array
	} // To call inside the makePayment Method
	
	//Any checkout after the required checkout time of 2pm is charged an extra day
	public int calcNumberOfNights(Calendar checkInDate)
	{
		float numberOfSeconds = ChronoUnit.SECONDS.between(checkInDate.getTime().toInstant(), Calendar.getInstance().toInstant());
    	//covertion from seconds to days
    	int numberOfNights = (int)Math.ceil((numberOfSeconds/(60*60*24)));
    	return numberOfNights;
	}
	
	
	//this function helps to add up the price of each room service order to get the total roomservice charge
	public double calcRoomServices(ArrayList<Order> orderThisRoom)
	{
		double RoomServices = 0;
		if (orderThisRoom.isEmpty())
			return 0;
		for(Order o:orderThisRoom) {
			RoomServices += o.getTotalPrice();
		}
		return RoomServices;
	}
	
<<<<<<< Updated upstream
	public void showAllPaidReservations()
	{
		if (payments.size() == 0)
		{
			System.out.println("Error! No Payments were made yet!");
		}
		for (int i = 0; i < payments.size(); i++)
		{
			System.out.println(payments.get(i));
		}
	}
	
	public void printFullReceipt()
	{
		System.out.println("==========This is your Total Bill for your stay==========");
		System.out.println("Name: " + toCheckOut.getGuestDetails().get(0).getName()); // Prints out name of the first name of Guest Details
		System.out.println("Payment Type: " + globalPaymentType); // Calls the global variable for PaymentType
		System.out.println("Room Number: " + toCheckOut.getRoomDetails().getRoomNumber());
		System.out.println("Check-In Date: " + toCheckOut.getCheckInDate());
		System.out.println("Check-Out Date: " + toCheckOut.getCheckOutDate());
		System.out.println("Number of Nights Stayed: " + numberOfNightsGlobal);
		System.out.println("Room Charges: " + roomChargesGlobal);
		System.out.println("Room Service Charges: " + roomServicesGlobal);
		System.out.println("Discount: " + discountGlobal);
		System.out.println("Tax: " + Initialise.GST);
		System.out.println("Total Charges: " + totalChargesGlobal);
	}
	
	public void printShortReceipt()
	{
		System.out.println("==========This is your Total Bill for your stay==========");
		System.out.println("Name: " + toCheckOut.getGuestDetails().get(0).getName());
		System.out.println("Payment Type: " + globalPaymentType); // Calls the global variable for PaymentType
		System.out.println("Check-Out Date: " + toCheckOut.getCheckOutDate()); // Date of payment		System.out.println("Total Charges: " + totalChargesGlobal); // Total Bill
=======
	public void printReceipt() 
	{
		System.out.println("Guest Name: " + );
		System.out.println("Room Number: " + roomNumberGlobal);
		System.out.println("Check-In Date: " + );
		System.out.println("Check-Out Date: " + );
		System.out.println("Number of Night Stayed: " + numberOfNightsGlobal);
		System.out.println("Room Charges: " + roomChargesGlobal);
		System.out.println("Tax: " + Initialise.GST);
		System.out.println("Room Service Charges " + roomServicesGlobal);
		System.out.println("Discount: " + discountGlobal);
		System.out.println("Your total charges are: " + totalChargesGlobal);
>>>>>>> Stashed changes
	}
	
}
