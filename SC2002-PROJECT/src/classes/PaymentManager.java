package classes;

import java.time.temporal.ChronoUnit;

import java.util.*;


import Initialiser.Initialise;
import classes.Payment.methodOfPayment;
import classes.Reservation.StatusOfReservation;
import classes.Room.StatusOfRoom; // Imported to set room to vacant after Reservation was deleted


/**
 * @author Darren Choo
 * @version 1.0
 * @since 14th April 2022
 */
public class PaymentManager {
	
	/**
	 * taking in user input
	 */
    Scanner sc = new Scanner(System.in);
    
    /**
     * array list of payments
     */
    private static ArrayList<Payment> payments;
	
    /**
     * constructor of payment manager
     * @param payments array list of payments
     */
	public PaymentManager(ArrayList<Payment> payments) {
		PaymentManager.payments = payments;
    }
	
	/**
	 * sets array list of payments
	 * @param payments array list of payments
	 */
	public void setPayments(ArrayList<Payment> payments) {
		PaymentManager.payments = payments;
		
	}
	
    
    

	/**
	 * allow the guest to make payment and checkout
	 */
	public void makePaymentUI() {
		String confirmation = "0";
		boolean validRoomFound = false;
		double tax;
		double roomChargesGlobal = 0;
	    double totalChargesGlobal = 0;
	    double roomServicesGlobal = 0;
	    double discountGlobal = 0;
	    int numberOfNightsGlobal = 0;
	    Reservation toCheckOut=null;
	    String globalPaymentType = "";
	    ArrayList<Order> checkOutRoomOrders = new ArrayList<Order>();
		
		
		//finding room for check out
		System.out.println("Hi! Please enter the room to check out from (Enter 0 to cancel check out):");
		String roomNumber = sc.nextLine();
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
		numberOfNightsGlobal = calcNumberOfNights(toCheckOut.getCheckInDate());
		roomChargesGlobal = Math.round(toCheckOut.getRoomDetails().getRate() * numberOfNightsGlobal*100.0)/100.0;
		tax = Initialise.GST;
		
		for(Order o: Initialise.orders) {
			if(o.getResID()==toCheckOut.getReservationID()) {
				checkOutRoomOrders.add(o);
			}
		}
		
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
		printFullReceipt(toCheckOut, numberOfNightsGlobal, roomChargesGlobal, roomServicesGlobal, discountGlobal, totalChargesGlobal); // Printing receipt before user decides how to pay
		System.out.println("Please enter (1) if you would like to pay by Cash. Enter (2) if you would like to pay by Card instead");
		choice = sc.nextInt();
		if (choice==1){
			globalPaymentType = "Cash";
			System.out.println("Please enter the appropriate number for which bill, $1000, $100, or $50, you would like to use. Enter (4) to exit");
			System.out.println("========== Cash Input ==========");
			System.out.println("|Enter '1' for $1000 input     |");
			System.out.println("|Enter '2' for $100 input      |");
			System.out.println("|Enter '3' for $50 input       |");
			System.out.println("|Enter '4' for input of change |");
			while (total<=totalChargesGlobal){
				bills = sc.nextInt();
				if (bills == 1){
					total += 1000;
				}
				
				else if (bills == 2){
					total += 100;
				}
				
				else if (bills == 3){
					total += 50;
				}
				
				else if (bills == 4){
					System.out.println("Please enter the amount of money you would like to use as change: ");
					double temp = sc.nextDouble();
					total += temp;
				}
				System.out.println("Total cash paid: " + total);
			}
			double change = total - totalChargesGlobal;
			System.out.println("You have paid " + total + " in cash.");
			System.out.printf("Your change is: %.2f.\n",change);
			System.out.println("Thank you for your stay! Have a safe trip back home!");
			
			makePaymentObject(roomChargesGlobal, tax, roomServicesGlobal, discountGlobal, totalChargesGlobal, methodOfPayment.CASH, checkOutRoomOrders, numberOfNightsGlobal, toCheckOut.getGuestDetails().get(0).getCreditCardName() , toCheckOut.getGuestDetails().get(0).getAddress(), toCheckOut.getGuestDetails().get(0).getCreditCardNumber());
			
			
			
		}
		else if (choice == 2){
			globalPaymentType = "Card";
			int check = 0;
			System.out.println("Please verify that this is your credit card name: " + toCheckOut.getGuestDetails().get(0).getCreditCardName() + ". If yes, enter (1). Else, enter (0)");
			check = sc.nextInt();
			if (check == 1){
				System.out.println("Please enter your CCV / CVV: ");
				int ccv = sc.nextInt(); // Just for confirmation of guest, one-time use, don't need to use
				sc.nextLine();
				System.out.println("The amount of $" + totalChargesGlobal + " will be charged to your card, under the name " + toCheckOut.getGuestDetails().get(0).getCreditCardName() + ", with the number " + toCheckOut.getGuestDetails().get(0).getCreditCardNumber() + ", to the address " + toCheckOut.getGuestDetails().get(0).getAddress());
				System.out.println("Thank you for your stay! Have a safe trip back home!");
				
				makePaymentObject(roomChargesGlobal, tax, roomServicesGlobal, discountGlobal, totalChargesGlobal, methodOfPayment.CARD, checkOutRoomOrders, numberOfNightsGlobal,toCheckOut.getGuestDetails().get(0).getCreditCardName() , toCheckOut.getGuestDetails().get(0).getAddress(), toCheckOut.getGuestDetails().get(0).getCreditCardNumber());
			}
			else if  (check == 0){
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
				
				makePaymentObject(roomChargesGlobal, tax, roomServicesGlobal, discountGlobal, totalChargesGlobal, methodOfPayment.CARD, checkOutRoomOrders, numberOfNightsGlobal, toCheckOut.getGuestDetails().get(0).getCreditCardName() , toCheckOut.getGuestDetails().get(0).getAddress(), toCheckOut.getGuestDetails().get(0).getCreditCardNumber()); // Calling the method
				
			}
		}
		
		// Room set to Vacant here
		toCheckOut.getRoomDetails().setRoomStatus(StatusOfRoom.VACANT); 
		
		
		
		//deleting the reservation while iterating through
		Iterator<Reservation> itr = Initialise.reservations.iterator();
		while(itr.hasNext()) {
			Reservation r = itr.next();
    		if(r.equals(toCheckOut)) {
              itr.remove();
                
        	}
    	}

	}
	
	/**
	 * 
	 * @param roomCharges room charges for all the nights
	 * @param tax tax on total charges
	 * @param roomServices room service charges
	 * @param discount discount applied
	 * @param totalCharges total charges
	 * @param paymentMethod method of payment
	 * @param orderThisRoom array list of orders for a room
	 * @param numberOfNights number of nights stayed
	 * @param creditCardName guest's credit card name
	 * @param billingAddress guest's billing address
	 * @param billingCardNumber guest's billing card number
	 */
	public void makePaymentObject(double roomCharges, double tax, double roomServices, double discount,
			double totalCharges, methodOfPayment paymentMethod, ArrayList<Order> orderThisRoom, int numberOfNights,
			String creditCardName, String billingAddress, String billingCardNumber){

		
	        int paymentID = 20000;
	        if(Initialise.payments.size() > 0){
	        	paymentID = Initialise.payments.get(Initialise.payments.size()-1).getPaymentID()+1;
	        }
	
	        System.out.println("\nPayment has been made!\nPayment ID: " + paymentID);
	        payments.add(new Payment(paymentID, roomCharges, tax, roomServices, discount, totalCharges, paymentMethod, orderThisRoom, 
	        		numberOfNights, creditCardName, billingAddress, billingCardNumber));
		
    }
	
	//Any checkout after the required checkout time of 2pm is charged an extra day
	/**
	 * 
	 * @param checkInDate check in date of the guest
	 * @return number of nights stayed
	 */
	public int calcNumberOfNights(Calendar checkInDate){
		float numberOfSeconds = ChronoUnit.SECONDS.between(checkInDate.getTime().toInstant(), Calendar.getInstance().toInstant());
    	//covertion from seconds to days
    	int numberOfNights = (int)Math.ceil((numberOfSeconds/(60*60*24)));
    	return numberOfNights;
	}
	
	
	//this function helps to add up the price of each room service order to get the total roomservice charge
	/**
	 * 
	 * @param orderThisRoom array list of orders for a room
	 * @return total room service charges
	 */
	public double calcRoomServices(ArrayList<Order> orderThisRoom){
		double RoomServices = 0;
		if (orderThisRoom.isEmpty())
			return 0;
		for(Order o:orderThisRoom) {
			RoomServices += o.getTotalPrice();
		}
		return RoomServices;
	}
	
	/**
	 *displays all previous payments made
	 */
	public void showAllPaidReservation(){
		if (payments.size() == 0){
			System.out.println("No Past Payment History Available.");
		}
		else {
			System.out.println("============ PAYMENT HISTORY ===========");
			for(Payment p: Initialise.payments){
				printShortReceipt(p);
			}
			
		}
	}
	
	/**
	 * prints the full receipt for the guest to make payment
	 * @param toCheckOut check out date
	 * @param numberOfNightsGlobal numer of nights stayed
	 * @param roomChargesGlobal room charges
	 * @param roomServicesGlobal room service charges
	 * @param discountGlobal discount applied
	 * @param totalChargesGlobal total charges after discount
	 */
	public void printFullReceipt(Reservation toCheckOut, int numberOfNightsGlobal,  double roomChargesGlobal, double roomServicesGlobal,  double discountGlobal,  double totalChargesGlobal){
		System.out.println("======== This is your Total Bill for your stay ========");
		System.out.println("Name: " + toCheckOut.getGuestDetails().get(0).getName()); // Prints out name of the first name of Guest Details
		System.out.println("Room Number: " + toCheckOut.getRoomDetails().getRoomNumber());
		System.out.println("Check-In Date: " + toCheckOut.getCheckInDate().getTime());
		System.out.println("Check-Out Date: " + Calendar.getInstance().getTime());
		System.out.println("Number of Nights Stayed: " + numberOfNightsGlobal);
		System.out.println("Room Charges: " + roomChargesGlobal);
		System.out.println("Room Service Charges: " + roomServicesGlobal);
		System.out.println("Discount: " + discountGlobal);
		System.out.println("Tax: " + Initialise.GST);
		System.out.println("Total Charges: " + totalChargesGlobal);
	}
	
	/**
	 * prints a short receipt to display past payments made
	 * @param p payment object
	 */
	public void printShortReceipt(Payment p){
		System.out.println("Payment ID: " + p.getPaymentID());
		System.out.println("Name: " + p.getCreditCardName());
		System.out.println("Total Amount: " + p.getTotalCharges());
		System.out.println("Payment Type: " + p.getPaymentMethod()); 
//		System.out.println("Check-Out Date: " + ); 
		System.out.println();
	}
	
}
