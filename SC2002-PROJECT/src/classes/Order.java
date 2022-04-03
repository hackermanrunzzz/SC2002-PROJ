package classes;

import java.util.Calendar;

public class Order {
	private enum StatusOfOrder{CONFIRMED, PREPARING, DELIVERED}
	
	private String OrderID;
	private Calendar time;
	private String remarks;
	private StatusOfOrder orderStatus;
	private double totalPrice;
	private Room room;
	

	

	public Order(int orderID, Calendar time, String remarks, StatusOfOrder orderStatus, double totalPrice) {
		this.OrderID = room.getRoomNumber();
		this.time = time;
		this.remarks = remarks;
		this.orderStatus = orderStatus;
		this.totalPrice = totalPrice;
	}

	public Calendar getTime() {
		return time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public StatusOfOrder getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(StatusOfOrder orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	

	
	

}
