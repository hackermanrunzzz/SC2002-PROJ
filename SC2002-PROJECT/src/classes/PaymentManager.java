package classes;

import java.time.temporal.ChronoUnit;
import java.util.*;


import Initialiser.Initialise;
import classes.Reservation.StatusOfReservation;

public class PaymentManager {

    Scanner sc = new Scanner(System.in);
    
    private static ArrayList<Payment> payments;
	
    
	public PaymentManager(ArrayList<Payment> payments) {
		PaymentManager.payments = payments;
    }
	
	public void setPayments(ArrayList<Payment> payments) {
		PaymentManager.payments = payments;
		
	}

	
	public void makePayment() {
		String confirmation = "0";
		boolean validRoomFound = false;
		int numberOfNights;
		Reservation toCheckOut=null;
		double roomCharges;
		double tax;
		double roomServices;
		double discount;
		double totalCharges;
		ArrayList<Order> checkOutRoomOrders = new ArrayList<Order>();
		
		//finding room for check out
		System.out.println("Hi! Please enter the room to check out from (Enter 0 to cancel check out):");
		String roomNumber = sc.nextLine();
		if(roomNumber.equals("0")) {
			System.out.println("Cancelling check out...");
			return;
		}
		for(Reservation r: Initialise.reservations) {
			if(r.getRoomDetails().getRoomNumber().equals(roomNumber) && r.getReservationStatus().equals(StatusOfReservation.CHECKED_IN)) {
				System.out.println("Valid checked in reservation for " + roomNumber +
								"found, proceed to check out? (Enter 1 for yes, 0 to cancel check out)");
				confirmation = sc.nextLine();
				if(confirmation.equals("0")) {
					System.out.println("Cancelling check out...");
					return;
				}
				validRoomFound = true;
				toCheckOut = r;
				break;
			}
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
		numberOfNights = calcNumberOfNights(toCheckOut.getCheckInDate());
		roomCharges = Math.round(toCheckOut.getRoomDetails().getRate() * numberOfNights*100.0)/100.0;
		tax = Initialise.GST;
		
		for(Order o: Initialise.orders) {
			if(o.getResID()==toCheckOut.getReservationID()) {
				checkOutRoomOrders.add(o);
			}
		}
		
		roomServices = Math.round(calcRoomServices(checkOutRoomOrders)*100.0)/100.0;
		//getting discount value
		System.out.println("Please enter discount value in % (Enter 0 for no discount, enter only the numerical value without '%'): ");
		discount = sc.nextDouble()/100;
		
		//Calculating total charges
		totalCharges = Math.round(((roomCharges+roomServices)*(1-discount)*(1+tax))*100.0)/100.0;
		
		//need to add billing info and payment method
		//create payment object and add to payment array
		//print receipt
		
		
	}
	
	//Any checkout after the required checkout time of 2pm is charged an extra day
	public int calcNumberOfNights(Calendar checkInDate) {
		
		float numberOfSeconds = ChronoUnit.SECONDS.between(checkInDate.getTime().toInstant(), Calendar.getInstance().toInstant());
    	//covertion from seconds to days
    	int numberOfNights = (int)Math.ceil((numberOfSeconds/(60*60*24)));
    	return numberOfNights;
	}
	
	
	public double calcRoomServices(ArrayList<Order> orderThisRoom) {
		double RoomServices = 0;
		if (orderThisRoom.isEmpty())
			return 0;
		for(Order o:orderThisRoom) {
			RoomServices += o.getTotalPrice();
		}
		return RoomServices;
	}
	
	public void printReceipt() {
		
	}
	
}
