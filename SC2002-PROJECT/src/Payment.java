
public class Payment {
	public enum methodOfPayment{Cash, Card} // Can add Debit and Credit separately later on if you guys want to
	public double roomCharges;
	public double tax;
	public double roomServices;
	public double discountedRoomCharges;
	public double discountedRoomServices;
	public double totalCharges;
	public methodOfPayment paymentMethod;
	
	
	public Payment()
	{
		
	}
	
}
