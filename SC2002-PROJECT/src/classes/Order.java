package classes;

public class Order {
	private enum StatusOfOrder{CONFIRMED, PREPARING, DELIVERED}
	private String date;
	private int time;
	private String remarks;
	private StatusOfOrder orderStatus;
	private OrderItem[] orderItems;
	private double totalPrice;

	public Order()
	{

	}

	public void setDate(String date)
	{
		this.date = date;
	}

	public String getDate()
	{
		return date;
	}

	public void setTime(int time)
	{
		this.time = time;
	}

	public int getTime()
	{
		return time;
	}

	public void setRemarks(String remarks)
	{
		this.remarks = remarks;
	}

	public String getRemarks()
	{
		return remarks;
	}

	

	public void setTotalPrice(double totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public double getTotalPrice()
	{
		return totalPrice;
	}


	

	
	

}
