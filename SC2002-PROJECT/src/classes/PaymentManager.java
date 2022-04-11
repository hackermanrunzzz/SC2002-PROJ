package classes;

import java.util.*;


import Initialiser.Initialise;

public class PaymentManager {

    Scanner sc = new Scanner(System.in);
    
    private static ArrayList<Payment> payments;
	
    
	public PaymentManager(ArrayList<Payment> payments) {
		PaymentManager.payments = payments;
    }
	
	public void setPayments(ArrayList<Payment> payments) {
		PaymentManager.payments = payments;
		
	}

//    public void makePayment()
//    {
//        boolean condition = false;
//        while (!condition) // This loop can be changed to a try and except statement
//        {
//            System.out.println("Please enter your room-number: \n");
//            String roomNumber = sc.nextLine();
//            // The searching here need to decide if it's done by ResID or room-number
//            // Call the room object, then call payment
//            System.out.println("Please enter your preferred method of Payment, Cash or Card: \n");
//            String temp = sc.nextLine();
//            if (temp.toLowerCase() == "card")
//            {
//                // Use payment class to get the charges and print them separately
//                condition = true; // To break out of the while loop
//            }
//            else if (temp.toLowerCase() == "cash")
//            {
//                // Use payment class to get the charges and print them separately
//                condition = true; // To break out of the while loop
//            }
//            else
//            {
//                System.out.println("Please enter a valid method of Payment!\n");
//            }
//        }
//        System.out.println("Payment made Successfully!\n");
//    }
	
	public void MakePayment() {
		
	}
	
	
	public void calcNumberOfDays() {
		
	}
	
	
}
