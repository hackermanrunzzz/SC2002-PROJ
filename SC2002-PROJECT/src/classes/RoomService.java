package classes;

import java.util.ArrayList;

import Initialiser.Initialise;

public class RoomService{
	private static ArrayList<Order> order = new ArrayList<Order>();
	private double totalPrice;




	public RoomService()
	{
		// Empty Constructor here, initialising the ArrayList
		
	}

	public RoomService(double price)
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

	public void displayMenu()
	{
		for (int i = 0; i < Initialise.menu.size(); i++)
		{
			System.out.println(Initialise.menu.get(i)); // Prints out all the Menu-Items
		}
	}

	public double getTotalPrice()
	{
		return totalPrice;
	}
	

}
