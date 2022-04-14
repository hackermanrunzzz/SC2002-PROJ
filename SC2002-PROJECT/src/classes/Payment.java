package classes;

import java.util.ArrayList;

/**
 * @author Darren Choo
 * @version 1.0
 * @since 14th April 2022
 */
public class Payment {
	/**
	 * possible status values of payment
	 */
	public enum methodOfPayment{
		/**
		 * method of payment is cash
		 */
		CASH, 
		/**
		 * method of payment is card
		 */
		CARD}
	/**
	 * unique identifier of payment
	 */
	public int paymentID;
	/**
	 * room charges for all the nights
	 */
	public double roomCharges;
	/**
	 * tax on total charges
	 */
	public double tax;
	/**
	 * room service charges
	 */
	public double roomServices;
	/**
	 * discount available
	 */
	public double discount;
	/**
	 * total charges
	 */
	public double totalCharges;
	/**
	 * method of payment
	 */
	public methodOfPayment paymentMethod;
	/**
	 * array list of orders for a room
	 */
	public ArrayList<Order> orderThisRoom;
	/**
	 * number of nights stayed
	 */
	public int numberOfNights;
	/**
	 * guest's credit card name
	 */
	public String CreditCardName;
	/**
	 * guest's billing address
	 */
	public String billingAddress;
	/**
	 * guest's billing number
	 */
	public String billingCardNumber;
	
	
	/**
	 * 
	 * @param paymentID unique identifier of payment
	 * @param roomCharges room charges for all the nights
	 * @param tax tax on total charges
	 * @param roomServices room service charges
	 * @param discount discount available
	 * @param totalCharges total charges
	 * @param paymentMethod method of payment
	 * @param orderThisRoom array list of orders for a room
	 * @param numberOfNights number of nights stayed
	 * @param creditCardName guest's credit card name
	 * @param billingAddress guest's billing address
	 * @param billingCardNumber guest's billing number
	 */
	public Payment(int paymentID, double roomCharges, double tax, double roomServices, double discount,
			double totalCharges, methodOfPayment paymentMethod, ArrayList<Order> orderThisRoom, int numberOfNights,
			String creditCardName, String billingAddress, String billingCardNumber) {
		
		this.paymentID = paymentID;
		this.roomCharges = roomCharges;
		this.tax = tax;
		this.roomServices = roomServices;
		this.discount = discount;
		this.totalCharges = totalCharges;
		this.paymentMethod = paymentMethod;
		this.orderThisRoom = orderThisRoom;
		this.numberOfNights = numberOfNights;
		this.CreditCardName = creditCardName;
		this.billingAddress = billingAddress;
		this.billingCardNumber = billingCardNumber;
	}


	/**
	 * gets the unique identifier of payment
	 * @return unique identifier of payment
	 */
	public int getPaymentID() {
		return paymentID;
	}


	/**
	 * sets the unique identifier of payment
	 * @param paymentID unique identifier of payment
	 */
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}


	/**
	 * gets the room charges of the room
	 * @return room charges of the room
	 */
	public double getRoomCharges() {
		return roomCharges;
	}


	/**
	 * sets the room charges of the room
	 * @param roomCharges room charges of the room
	 */
	public void setRoomCharges(double roomCharges) {
		this.roomCharges = roomCharges;
	}


	/**
	 * gets the tax on total charges
	 * @return tax on total charges
	 */
	public double getTax() {
		return tax;
	}


	/**
	 * sets the tax on total charges
	 * @param tax tax on total charges
	 */
	public void setTax(double tax) {
		this.tax = tax;
	}


	/**
	 * gets the room service charges
	 * @return room service charges
	 */
	public double getRoomServices() {
		return roomServices;
	}


	/**
	 * sets room service charges
	 * @param roomServices room service charges
	 */
	public void setRoomServices(double roomServices) {
		this.roomServices = roomServices;
	}


	/**
	 * gets the discounts available
	 * @return discounts available
	 */
	public double getDiscount() {
		return discount;
	}


	/**
	 * sets the discounts available
	 * @param discount discounts available
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}


	/**
	 * gets the total charges
	 * @return total charges
	 */
	public double getTotalCharges() {
		return totalCharges;
	}


	/**
	 * sets the total charges
	 * @param totalCharges total charges
	 */
	public void setTotalCharges(double totalCharges) {
		this.totalCharges = totalCharges;
	}


	/**
	 * gets the method of payment
	 * @return method of payment
	 */
	public methodOfPayment getPaymentMethod() {
		return paymentMethod;
	}


	/**
	 * sets the method of payment
	 * @param paymentMethod method of payment
	 */
	public void setPaymentMethod(methodOfPayment paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	/**
	 * gets the array list of orders for a room
	 * @return array list of orders for a room
	 */
	public ArrayList<Order> getOrderThisRoom() {
		return orderThisRoom;
	}


	/**
	 * sets the array list of orders for a room
	 * @param orderThisRoom array list of orders for a room
	 */
	public void setOrderThisRoom(ArrayList<Order> orderThisRoom) {
		this.orderThisRoom = orderThisRoom;
	}


	/**
	 * gets the number of nights stayed
	 * @return number of nights stayed
	 */
	public int getNumberOfNights() {
		return numberOfNights;
	}


	/**
	 * sets the number of nights stayed
	 * @param numberOfNights number of nights stayed
	 */
	public void setNumberOfNights(int numberOfNights) {
		this.numberOfNights = numberOfNights;
	}


	/**
	 * gets the guest's credit card name
	 * @return guest's credit card name
	 */
	public String getCreditCardName() {
		return CreditCardName;
	}


	/**
	 * sets the guest's credit card name
	 * @param creditCardName guest's credit card name
	 */
	public void setCreditCardName(String creditCardName) {
		CreditCardName = creditCardName;
	}


	/**
	 * gets the guest's billing address
	 * @return guest's billing address
	 */
	public String getBillingAddress() {
		return billingAddress;
	}


	/**
	 * sets the guest's billing address
	 * @param billingAddress guest's billing address
	 */
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}


	/**
	 * gets the guest's billing card number
	 * @return guest's billing card number
	 */
	public String getBillingCardNumber() {
		return billingCardNumber;
	}


	/**
	 * sets the guest's billing card number
	 * @param billingCardNumber guest's billing card number
	 */
	public void setBillingCardNumber(String billingCardNumber) {
		this.billingCardNumber = billingCardNumber;
	}
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	