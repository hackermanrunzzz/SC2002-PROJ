package classmgr;
/**
 * @author seth lee
 * @version 1.0
 * @since 9th November 2021
 */

import classes.Menu;
import classes.Order;
import initialize.Restaurant;

import java.util.ArrayList;

/**
 * create order manager class
 */
public class OrderManager {
    /**
     * create an array of pending orders
     */
    private ArrayList<Order> pendingOrders = new ArrayList<Order>();
    /**
     * create an array of paid orders
     */
    private ArrayList<Order> paidOrders = new ArrayList<Order>();

    /**
     * constructor for order manager
     * @param pendingOrders array of pending orders
     * @param paidOrders array of paid orders
     */
    public OrderManager(ArrayList<Order> pendingOrders,ArrayList<Order> paidOrders) {
        this.pendingOrders = pendingOrders;
        this.paidOrders = paidOrders;
    }

    /**
     * get the pending order for the table
     * @param tableID table belonging to the pending order
     * @return order
     */
    public Order getPendingOrder(int tableID){
        for(Order o: pendingOrders){
            if(o.getTableId() == tableID) return o;
        }
        return new Order();
    }

    /**
     * check if the order is pending
     * @param tableID table belonging to the order
     * @return boolean value
     */
    public boolean checkPendingOrder(int tableID){
        for(Order o: pendingOrders){
            if(o.getTableId() == tableID) return true;
        }
        return false;
    }

    /**
     * create an order
     * @param staffID to attend to order
     * @param tableID table at which order is made
     * @param menu menu to order from
     */
    public void createOrder(int staffID, int tableID, Menu menu) {
        Order order = new Order(staffID,tableID, menu);
        order.createOrder(order);
        pendingOrders.add(order);
    }

    /**
     * find the order for a table
     * @param TableID at which order is being placed
     * @return the order id
     */
    public String findOrderID(int TableID) {
        for (Order o : pendingOrders) {
            if (o.getTableId() == TableID) return o.getOrderId();
        }
        System.out.println("No existing order for this table");
        return null;
    }

    /**
     * find the order for a table
     * @param TableID at which order is being placed
     * @return the order
     */
    public Order findOrder(int TableID) {
        String id = findOrderID(TableID);
        Order order = new Order();
        for (Order o : Restaurant.pendingOrders) {
            if (id == o.getOrderId()) return o;
        }
        return order;
    }

}






