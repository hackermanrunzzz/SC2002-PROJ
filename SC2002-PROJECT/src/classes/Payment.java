package classes;

public class Payment {
	public enum methodOfPayment{CASH, CARD} // Can add Debit and Credit separately later on if you guys want to
	public double roomCharges;
	public double tax;
	public double roomServices;
	public double discountedRoomCharges;
	public double discountedRoomServices;
	public double totalCharges;
	public methodOfPayment paymentMethod;
	
	
	public Payment(double charges, double tax, double roomServiceCost, double discountedRoomCharges, double discountedRoomServiceCost, double totalCharges, methodOfPayment paymentMethod)
	{
		this.roomCharges = charges;
		this.tax = tax;
		this.roomServices = roomServiceCost;
		this.discountedRoomCharges = discountedRoomCharges;
		this.discountedRoomServices = discountedRoomServiceCost;
		this.totalCharges = totalCharges;
		this.paymentMethod = paymentMethod;
	} // Constructor for Payment

	public void setRoomCharges(double roomCharges)
	{
		this.roomCharges = roomCharges;
	}

	public double getRoomCharges()
	{
		return roomCharges;
	}

	public void setTax(double tax)
	{
		this.tax = tax;
	}

	public double getTax()
	{
		return tax;
	}

	public void setRoomServiceCost(double roomServiceCost)
	{
		this.roomServices = roomServiceCost;
	}

	public double getRoomServiceCost()
	{
		return roomServices;
	}

	public void setDiscountedRoomCharges(double discountedRoomCharges)
	{
		this.discountedRoomCharges = discountedRoomCharges;
	}

	public double getDiscountedRoomCharges()
	{
		return discountedRoomCharges;
	}

	public void setDiscountedRoomServiceCost(double discountedRoomServiceCost)
	{
		this.discountedRoomServices = discountedRoomServiceCost;
	}

	public double getDiscountedRoomServiceCost()
	{
		return discountedRoomServices;
	}

	public void setTotalCharges(double totalCharges)
	{
		this.totalCharges = totalCharges;
	}

	public double getTotalCharges()
	{
		return totalCharges;
	}

	public void setPaymentMethod(methodOfPayment paymentMethod)
	{
		this.paymentMethod = paymentMethod;
	}

	public methodOfPayment getPaymentMethod()
	{
		return paymentMethod;
	}
	
}
