enum StatusOfOrder{
	Confirmed,
	Preparing,
	Delivered
}
public class Order {
	public String date;
	public int time;
	public String remarks;
	public StatusOfOrder orderStatus;
	public OrderItem[] orderItems;
	public double totalPrice;
	

}
