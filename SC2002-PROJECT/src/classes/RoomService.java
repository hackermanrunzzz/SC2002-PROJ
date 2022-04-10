package classes;

import java.util.ArrayList;

import Initialiser.Initialise;

public class RoomService{
	private static ArrayList<Order> order = new ArrayList<Order>();
	private double totalPrice;


	public RoomService(double price)
	{
		this.totalPrice = price;
	}

	public double getTotalPrice()
	{
		return totalPrice;
	}

	public void setTotalPrice(double price)
	{
		this.totalPrice = price;
	}
	
	public static ArrayList<Order> getOrder()
	{
		return order;
	}

	public static void setOrder(ArrayList<Order> order)
	{
		RoomService.order = order;
	}
}
