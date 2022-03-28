package classes;

public class Order {
	public enum StatusOfOrder{CONFIRMED, PREPARING, DELIVERED}
	public String date;
	public int time;
	public String remarks;
	public StatusOfOrder orderStatus;
	public OrderItem[] orderItems;
	public double totalPrice;

	
	

}
