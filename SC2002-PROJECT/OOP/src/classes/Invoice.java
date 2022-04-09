package classes;

/**
 * @author seth lee
 * @version 1.0
 * @since 9th November 2021
 *
 */

import initialize.Restaurant;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.UUID;

/**
 * create the invoice class
 */
public class Invoice {
    /**
     * create scanner object to receive input
     */
    private static Scanner sc = new Scanner(System.in);
    /**
     * unique identifier of invoice
     */
    private String invoiceId;
    /**
     * unique identifier of staff member
     */
    private int staffID;
    /**
     * phoneNumber of customer
     */
    private String phoneNumber;
    /**
     * table at which order is made
     */
    private int tableId;
    /**
     * discount entitled if customer is a member
     */
    private double discount;
    /**
     * discount amount
     */
    private double discountAmount;
    /**
     * gst amount for the order
     */
    private double gstAmount;
    /**
     * service charge amount for the order
     */
    private double serviceChargeAmount;
    /**
     * total revenue for the order
     */
    private double totalRevenue;
    /**
     * date and time that order is paid
     */
    private Calendar paidTimestamp;
    /**
     * order object
     */
    private Order order;


    /**
     * constructor of invoice
     * @param staffID unique identifier of each staff
     * @param phoneNumber phoneNumber of customer
     * @param tableId unique identifier of table
     * @param order customer's order
     * @param calendar date invoice is generated
     */
    public Invoice(int staffID, String phoneNumber, int tableId, Order order, Calendar calendar){
        this.staffID = staffID;
        this.phoneNumber = phoneNumber;
        this.tableId = tableId;
        this.discount = 0.1;
        this.discountAmount = 0;
        this.gstAmount = 0;
        this.serviceChargeAmount = 0;
        this.totalRevenue = 0;
        this.paidTimestamp = calendar;
        this.invoiceId = UUID.randomUUID().toString();
        this.order = order;
    }

    /**
     * constructor of invoice
     * @param staffID unique identifier of each staff
     * @param tableId unique identifier of table
     * @param order customer's order
     * @param calendar date invoice is generated
     */
    public Invoice(int staffID, int tableId, Order order, Calendar calendar){
        this.staffID = staffID;
        this.phoneNumber = "";
        this.tableId = tableId;
        this.discount = 0;
        this.discountAmount = 0;
        this.gstAmount = 0;
        this.serviceChargeAmount = 0;
        this.totalRevenue = 0;
        this.paidTimestamp = calendar;
        this.invoiceId = UUID.randomUUID().toString();
        this.order = order;
    }

    /**
     * get the order
     * @return order
     */

    public Order getOrder() {
        return order;
    }

    /**
     * set the discount amount
     * @param discountAmount amount of discount given
     */
    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    /**
     * get the discount amount
     * @return discount amount
     */
    public double getDiscountAmount() {
        return discountAmount;
    }

    /**
     * get the gst amount
     * @return gst amount
     */
    public double getGstAmount() {
        return gstAmount;
    }

    /**
     * get the service charge amount
     * @return amount of service charge
     */
    public double getServiceChargeAmount() {
        return serviceChargeAmount;
    }

    /**
     * set the gst amount
     * @param gstAmount amount of gst
     */
    public void setGstAmount(double gstAmount) {
        this.gstAmount = gstAmount;
    }

    /**
     * set the service charge amount
     * @param serviceChargeAmount amount of service charge
     */
    public void setServiceChargeAmount(double serviceChargeAmount) {
        this.serviceChargeAmount = serviceChargeAmount;
    }

    /**
     * set the total revenue
     * @param totalRevenue amount of total revenue
     */
    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    /**
     * get the total revenue
     * @return total revenue
     */
    public double getTotalRevenue() {
        return totalRevenue;
    }

    /**
     * print the order invoice for the order
     */
    public void printOrderInvoice(){

                order.setPaymentStatus(Order.PaymentStatus.PAID);
                Restaurant.paidOrders.add(order);
                Restaurant.pendingOrders.remove(order);
                Calendar now = Calendar.getInstance();
                SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("==================================================================================");
                System.out.println("                          Gabby FC Order Invoice");
                System.out.println("==================================================================================");
                System.out.printf("Invoice ID : %s\n", invoiceId);
                System.out.println("Waiter: " + Restaurant.staffManager.getStaffs().get(staffID-1).getStaffName() + "                         Date: " + date_format.format(paidTimestamp.getTime()));
                order.viewOrder();
                System.out.printf("                                                          Service Charge: $%.2f" ,serviceChargeAmount);
                System.out.printf("\n                                                              GST Amount: $%.2f",gstAmount);
                System.out.printf("\n                                                        Discount Amount : ($%.2f",discountAmount);
                System.out.printf(")\n");
                System.out.println("====================================================================================");
                System.out.printf("                                                                   Total: $%.2f\n",calculateTotalRevenue());
                System.out.println("====================================================================================");
                System.out.println("                     Thank you and have a nice day!");
                return;



    }

    /**
     * create invoice for the order
     * @param invoice invoice of order
     * @return invoice
     */
    public Invoice createInvoice(Invoice invoice){
        invoice.setGstAmount(calculateGST());
        invoice.setServiceChargeAmount(calculateServiceCharge());
        invoice.setDiscountAmount(calculateDiscount());
        invoice.setTotalRevenue(calculateTotalRevenue());
        return invoice;
    }

    /**
     * calculate the service charge amount for the order
     * @return the service charge amount
     */
    public double calculateServiceCharge(){
        return this.order.getTotalAmount() * Restaurant.serviceCharge;
    }

    /**
     * calculate the GST amount for the order
     * @return GST amount
     */
    public double calculateGST(){
        double amount = this.order.getTotalAmount() + calculateServiceCharge();
        return amount * Restaurant.gstAmount;
    }

    /**
     * calculate the discount for the order
     * @return amount of discount for the order
     */
    public double calculateDiscount(){
        double amount = this.order.getTotalAmount() + calculateGST() + calculateServiceCharge();
        return amount * discount;
    }

    /**
     * calculate total revenue collected from the order
     * @return total revenue collected
     */
    public double calculateTotalRevenue() {
        return this.order.getTotalAmount() + calculateServiceCharge() +calculateGST() - calculateDiscount();
    }

    /**
     * get the date and time that order was paid for
     * @return date and time that order was paid for
     */
    public Calendar getPaidTimestamp(){
        return this.paidTimestamp;
    }

}
