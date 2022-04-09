package classes;
/**
 * @author seth lee
 * @version 1.0
 * @since 9th November 2021
 */

import initialize.Restaurant;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * create report class
 */
public class Report {
    /**
     * array of invoices
     */
    private ArrayList<Invoice> invoices;
    /**
     * year of report to generate
     */
    private int year;
    /**
     * month of report to generate
     */
    private int month;
    /**
     * day of report to generate
     */
    private int day;
    /**
     * total gst amount in the report
     */
    private double totalGSTAmount;
    /**
     * total service charge amount in the report
     */
    private double totalServiceChargeAmount;
    /**
     * total revenue obtained from the report
     */
    private double totalRevenue;
    /**
     * total discount amount in the report
     */
    private double totalDiscounts;

    /**
     * constructor for report
     */
    public Report(){
        this.invoices = new ArrayList<Invoice>();
    }

    /**
     * get array of invoices in report
     * @return array of invoices
     */
    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    /**
     * set the array of invoices in report
     * @param invoices array of invoices to be set in report
     */
    public void setInvoices(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    /**
     * get year of report
     * @return year of report
     */
    public int getYear() {
        return year;
    }

    /**
     * get day of report
     * @return day of report
     */
    public int getDay() {
        return day;
    }

    /**
     * get month of report
     * @return month of report
     */
    public int getMonth() {
        return month;
    }

    /**
     * constructor of yearly report
     * @param year set year of report
     */
    public Report(int year) {
        this.invoices = new ArrayList<Invoice>();
        this.year = year;
        this.month = -1;
        this.day = 0;
        this.totalGSTAmount = 0;
        this.totalServiceChargeAmount = 0;
        this.totalRevenue = 0;
        this.totalDiscounts = 0;
    }

    /**
     * constructor of monthly report
     * @param year of report
     * @param month of report
     */
    public Report(int year,int month) {
        this.invoices = new ArrayList<Invoice>();
        this.year = year;
        this.month = month;
        this.day = 0;
        this.totalGSTAmount = 0;
        this.totalServiceChargeAmount = 0;
        this.totalRevenue = 0;
        this.totalDiscounts = 0;
    }

    /**
     * constructor of daily report
     * @param year of report
     * @param month of report
     * @param day of report
     */
    public Report(int year,int month,int day) {
        this.invoices = new ArrayList<Invoice>();
        this.year = year;
        this.month = month;
        this.day = day;
        this.totalGSTAmount = 0;
        this.totalServiceChargeAmount = 0;
        this.totalRevenue = 0;
        this.totalDiscounts = 0;
    }

    /**
     * subset the array of invoices depending on the period of report to be generated
     * @return the subset array of invoices
     */
    public ArrayList<Invoice> subsetInvoices(){
        ArrayList<Invoice> subsetted = new ArrayList<Invoice>();
        for (Invoice i : Restaurant.report.getInvoices()){

            if (getYear() == i.getPaidTimestamp().get(Calendar.YEAR)){
                if (getMonth() == (i.getPaidTimestamp().get(Calendar.MONTH)+1)){
                    if (getDay() == 0){
                        subsetted.add(i);
                    }
                    else if (getDay() == i.getPaidTimestamp().get(Calendar.DATE)){
                        subsetted.add(i);
                    }
                }
                else if(getMonth() == -1){
                    subsetted.add(i);
                }
            }
        }
        return subsetted;
    }

    /**
     * set the total gst amount in the report
     * @param totalGSTAmount to be set in report
     */
    public void setTotalGSTAmount(double totalGSTAmount) {
        this.totalGSTAmount = totalGSTAmount;
    }

    /**
     * set the total service charge amount in the report
     * @param totalServiceChargeAmount to be set in the report
     */
    public void setTotalServiceChargeAmount(double totalServiceChargeAmount) {
        this.totalServiceChargeAmount = totalServiceChargeAmount;
    }

    /**
     * set the total revenue amount in the report
     * @param totalRevenue amount in the report
     */
    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    /**
     * set the total discounts in the report
     * @param totalDiscounts amount in the report
     */
    public void setTotalDiscounts(double totalDiscounts) {
        this.totalDiscounts = totalDiscounts;
    }

    /**
     * calculate the total gst amount in the report
     * @return total gst amount in the report
     */
    public double calculateTotalGSTAmount() {
        double gst = 0;
        for (Invoice i : invoices) {
            gst += i.getGstAmount();
        }
        return gst;
    }

    /**
     * calculate the total service charge amount in the report
     * @return total service charge amount in the report
     */
    public double calculateTotalServiceChargeAmount(){
        double serviceCharge = 0;
        for(Invoice i: invoices){
            serviceCharge += i.getServiceChargeAmount();
        }
        return serviceCharge;
    }

    /**
     * calculate total discount amount in the report
     * @return total discount amount in the report
     */
    public double calculateTotalDiscounts(){
        double discount = 0;
        for(Invoice i: invoices){
            discount += i.getDiscountAmount();
        }
        return discount;
    }

    /**
     * calculate the total revenue generated in the period
     * @return total revenue generated in the period
     */
    public double calculateTotalPeriodRevenue(){
        double amount = 0;
        for(Invoice i: invoices){
            amount += i.getTotalRevenue();
        }
        return amount;
    }

    /**
     * set the report
     */
    public void calculateReport(){
        setTotalGSTAmount(calculateTotalGSTAmount());
        setTotalServiceChargeAmount(calculateTotalServiceChargeAmount());
        setTotalDiscounts(calculateTotalDiscounts());
        setTotalRevenue(calculateTotalPeriodRevenue());
    }

    /**
     * print out report
     */
    public void printReport(){
        calculateReport();

        printItemSales();
        System.out.println("================================================================================");
        System.out.printf("                                               Total Service Charge: $%.2f" ,totalServiceChargeAmount);
        System.out.printf("\n                                                   Total GST Amount: $%.2f",totalGSTAmount);
        System.out.printf("\n                                             Total Discount Amount : ($%.2f",totalDiscounts);
        System.out.printf(")\n");
        System.out.println("================================================================================");
        System.out.printf("                                                              Total: $%.2f\n",calculateTotalPeriodRevenue());
        System.out.println("================================================================================");
        System.out.println("                     Thank you and have a nice day!");
        return;
    }

    /**
     * print sales items in the report
     */
    public void printItemSales(){
        allPreviousMenu();
        System.out.println("No. Menu Item Name                       Quantity Sold          Total Amount");
        int in =1;
        for(Food food: Restaurant.allMenu.getFoods()){
            int amount = 0;
            for(Invoice i: invoices){
                for(Food f : i.getOrder().getMenu().getFoods()){
                    if(food.getName().equals(f.getName())){
                        amount+=1;
                    }
                }
            }
            System.out.printf("%d. %s                  %d                   $%.2f\n" ,in,food.getName(), amount,((double)amount* food.getPrice()));
            in++;
        }
        System.out.println("\nNo. Promotion Set Package Name           Quantity Sold          Total Amount");
        int j =1;
        for(PromotionSet promo: Restaurant.allMenu.getPromos()){
            int amount = 0;
            for(Invoice i: invoices){
                for(PromotionSet p: i.getOrder().getMenu().getPromos()){
                    if(promo.getName().equals(p.getName())){
                        amount+=1;
                    }
                }
            }
            System.out.printf("%d. %s                  %d                   $%.2f\n" ,j,promo.getName(), amount,((double)amount* promo.getPrice()));
            j++;
        }
    }

    /**
     * collection of old menus
     */
    public void allPreviousMenu(){

        int num =1;
        for(Food oldFood: Restaurant.oldMenu.getFoods()){
            num = 1;
            for(Food food: Restaurant.allMenu.getFoods()){
                if(oldFood.getName().equals(food.getName())) num =0;
            }
            if(num==0) Restaurant.allMenu.getFoods().add(oldFood);
        }

        for(PromotionSet oldPromo: Restaurant.oldMenu.getPromos()){
            num =1;
            for(PromotionSet promo: Restaurant.allMenu.getPromos()){
                if(oldPromo.getName().equals(promo.getName())) num =0;
            }
            if(num==0) Restaurant.allMenu.getPromos().add(oldPromo);
        }
    }


}
