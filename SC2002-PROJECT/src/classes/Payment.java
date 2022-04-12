package classes;

import java.util.ArrayList;

public class Payment {
	public enum methodOfPayment{CASH, CARD}
	
	public int paymentID;
	public double roomCharges;
	public double tax;
	public double roomServices;
	public double discount;
	public double totalCharges;
	public methodOfPayment paymentMethod;
	public ArrayList<Order> orderThisRoom;
	public int numberOfNights;
	public String CreditCardName;
	public String billingAddress;
	public String billingCardNumber;
	
	
	
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



	public int getPaymentID() {
		return paymentID;
	}



	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}



	public double getRoomCharges() {
		return roomCharges;
	}



	public void setRoomCharges(double roomCharges) {
		this.roomCharges = roomCharges;
	}



	public double getTax() {
		return tax;
	}



	public void setTax(double tax) {
		this.tax = tax;
	}



	public double getRoomServices() {
		return roomServices;
	}



	public void setRoomServices(double roomServices) {
		this.roomServices = roomServices;
	}



	public double getDiscount() {
		return discount;
	}



	public void setDiscount(double discount) {
		this.discount = discount;
	}



	public double getTotalCharges() {
		return totalCharges;
	}



	public void setTotalCharges(double totalCharges) {
		this.totalCharges = totalCharges;
	}



	public methodOfPayment getPaymentMethod() {
		return paymentMethod;
	}



	public void setPaymentMethod(methodOfPayment paymentMethod) {
		this.paymentMethod = paymentMethod;
	}



	public ArrayList<Order> getOrderThisRoom() {
		return orderThisRoom;
	}



	public void setOrderThisRoom(ArrayList<Order> orderThisRoom) {
		this.orderThisRoom = orderThisRoom;
	}



	public int getNumberOfNights() {
		return numberOfNights;
	}



	public void setNumberOfNights(int numberOfNights) {
		this.numberOfNights = numberOfNights;
	}



	public String getCreditCardName() {
		return CreditCardName;
	}



	public void setCreditCardName(String creditCardName) {
		CreditCardName = creditCardName;
	}



	public String getBillingAddress() {
		return billingAddress;
	}



	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}



	public String getBillingCardNumber() {
		return billingCardNumber;
	}



	public void setBillingCardNumber(String billingCardNumber) {
		this.billingCardNumber = billingCardNumber;
	}
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	