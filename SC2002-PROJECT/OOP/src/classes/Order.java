package classes;
/**
 * @author seth lee
 * @version 1.0
 * @since 9th November 2021
 */

import initialize.Restaurant;

import java.util.Calendar;
import java.util.UUID;

/**
 * create order class
 */
public class Order {
    /**
     * possible status values of the order
     */
    public enum PaymentStatus {
        /**
         * order is paid
         */
        PAID,
        /**
         * order is yet to be paid
         */
        PENDING}

    ;
    /**
     * unique identifier of the order
     */
    private String orderId;
    /**
     * menu from which order is made
     */
    private Menu menu;
    /**
     * unique identifier of staff member taking order
     */
    private int staffID;
    /**
     * time order is made
     */
    private Calendar time;
    /**
     * table which customer is sitting at
     */
    private int tableId;
    /**
     * whether payment has been made
     */
    private PaymentStatus paymentStatus;
    /**
     * total amount of order
     */
    private double totalAmount;

    /**
     * create default constructor for order
     */
    public Order() {
        this.orderId = UUID.randomUUID().toString();
        this.staffID = 3;
        this.time = Calendar.getInstance();
        this.tableId = 4;
        this.paymentStatus = PaymentStatus.PAID;
        this.totalAmount = 0;// need to be calculated
        this.menu = new Menu();
    }

    /**
     * create constructor for order
     * @param staffID staff to attend to order
     * @param tableId table that is being occupied
     * @param menu menu
     */
    public Order(int staffID, int tableId, Menu menu) {
        this.orderId = UUID.randomUUID().toString();
        this.staffID = staffID;
        this.time = Calendar.getInstance();
        this.tableId = tableId;
        this.paymentStatus = PaymentStatus.PENDING;
        this.totalAmount = 0;// need to be calculated
        this.menu = menu;
    }

    /**
     * get the id of order
     * @return orderid
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * get the menu
     * @return menu
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * set the menu
     * @param menu set menu
     */
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    /**
     * get the id of staff member
     * @return id of staff member
     */
    public int getStaffID() {
        return staffID;
    }

    /**
     * get the table id
     * @return table id
     */
    public int getTableId() {
        return tableId;
    }

    /**
     * set the payment status of the order
     * @param paymentStatus of order
     */
    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    /**
     * get the total order amount
     * @return total order amount
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * set the total order amount
     * @param totalAmount set total amount
     */
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * calculate order amount
     * @return order amount
     */
    public double calculateAmount() {
        double amount = 0;
        for (int i = 0; i < this.getMenu().getFoods().size(); i++) {
            amount = amount + this.getMenu().getFoods().get(i).getPrice();
        }

        for (int i = 0; i < this.getMenu().getPromos().size(); i++) {
            amount = amount + this.getMenu().getPromos().get(i).getPrice();
        }
        setTotalAmount(amount);
        return amount;
    }

    /**
     * create an order
     * @param order to be created
     * @return order
     */
    public Order createOrder(Order order) {
        order.calculateAmount();
        return order;
    }

    /**
     * check if food exists in menu
     * @param food item being ordered
     * @return value if food is in menu
     */
    public int checkFood(Food food) {
        int exists = 0;
        for (Food f : this.menu.getFoods()) {
            if (f.getName().equals(food.getName())) return 1;
        }
        return 0;
    }

    /**
     * check if promo item exists in menu
     * @param promo item being ordered
     * @return value if promo is in menu
     */
    public int checkPromo(PromotionSet promo) {
        int exists = 0;
        for (PromotionSet p : this.menu.getPromos()) {
            if (p.getName().equals(promo.getName())) return 1;
        }
        return 0;
    }

    /**
     * add food item to order
     * @param order to add food item
     * @param food item to be added to order
     */
    public void addFoodOrder(Order order, Food food){
        order.menu.getFoods().add(food);
        calculateAmount();
    }

    /**
     * add promo item to order
     * @param order to add promo item
     * @param promo item to be added to order
     */
    public void addPromoOrder(Order order,PromotionSet promo){
        order.menu.getPromos().add(promo);
        calculateAmount();
    }

    /**
     * remove food item from order
     * @param food item to be removed
     */
    public void removeFoodOrder(Food food){
        if(checkFood(food)==0){
            System.out.println("Food item is not in the order. Cannot be removed.");
            return;
        }
        this.menu.getFoods().remove(food);
        calculateAmount();
    }

    /**
     * remove promo item from order
     * @param promo item to be removed
     */
    public void removePromoOrder(PromotionSet promo){
        if(checkPromo(promo)==0){
            System.out.println("Promotion Set Package item is not in the order. Cannot be removed.");
            return;
        }
        this.menu.getPromos().remove(promo);
        calculateAmount();
    }

    /**
     * view the order
     */
    public void viewOrder() {

        System.out.println("Order ID : "+ this.orderId);
        System.out.println("Table ID : " + this.tableId);
        System.out.println("Staff ID : " + this.staffID);
        System.out.println("=============================== A-LA CARTE ORDER ===================================");

        for (int j = 0; j < Restaurant.menu.getFoods().size(); j++) {
            int quantity = 0;
            for (int i = 0; i < this.menu.getFoods().size(); i++) {
                if (Restaurant.menu.getFoods().get(j).equals(this.menu.getFoods().get(i))) {
                    quantity++;
                }
            }
            if(quantity!=0){
                System.out.print((j + 1) + ". " + Restaurant.menu.getFoods().get(j).getName() +
                        "          Quantity : " + quantity);
                System.out.printf("          Total Price : $%.2f\n",((double)quantity * Restaurant.menu.getFoods().get(j).getPrice()));
            }
        }
        System.out.println("========================== PROMOTION SET PACKAGE ORDER =============================");

        for (int j = 0; j < Restaurant.menu.getPromos().size(); j++) {
            int quantity = 0;
            for (int i = 0; i < this.menu.getPromos().size(); i++) {
                if (Restaurant.menu.getPromos().get(j).equals(this.menu.getPromos().get(i))) {
                    quantity++;
                }
            }
            if(quantity != 0){
                System.out.print((j + 1) + ". " + Restaurant.menu.getPromos().get(j).getName() +
                        "          Quantity : " + quantity);
                System.out.printf("          Total Price : $%.2f\n",((double)quantity * Restaurant.menu.getFoods().get(j).getPrice()));
            }

        }
        System.out.println("====================================================================================");

         System.out.printf("                                                     Current Total Bill : $%.2f",this.totalAmount);
        System.out.println();

    }
}
