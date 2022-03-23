
public class Order {
	public enum StatusOfOrder{Confirmed, Preparing, Delivered}
	public String date;
	public int time;
	public String remarks;
	public StatusOfOrder orderStatus;
	public OrderItem[] orderItems;
	public double totalPrice;
	

}
