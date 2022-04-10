package ui;


import java.util.Calendar;
import java.util.Scanner;

import Initialiser.Initialise;
import classes.Reservation;
import classes.ReservationManager;

// This can be the UI for room-service in general
public class OrderUI {

		
		    private static Scanner sc = new Scanner(System.in);

		  
		    public static void orderOptions() {
		        int choice;
		        do {
		            System.out.println("========================================");
		            System.out.println("Select choice: ");
		            System.out.println("(1) Create Room Service Order");
		            System.out.println("(2) View Room Service Order");
		            System.out.println("(3) Add Item to Order");
		            System.out.println("(4) Show All Orders");
		            System.out.println("(5) Change Order Status");
		            System.out.println("(6) Go Back To Main Menu");
		            System.out.println("========================================");

		            choice = sc.nextInt();
		            sc.nextLine();

		            switch (choice) {
		                case 1:
		                  Initialise.om.createOrderUI();
		                    break;
		                case 2:
		                    Initialise.om.viewOrderUI();
		                    break;
		                case 3:
		                   // addItemToOrderUI();
		                    break;
		                case 4:
		                	Initialise.om.showAllOrders();
		                  //  removeItemFromOrderUI();
		                    break;
		                case 5:
		                   Initialise.om.ChangeStatusofOrder();
		                    break;
		                case 6:

		            }
		        } while (choice < 6);
		    }


		    /**
		     * creates the order
		  
		    /**
		     * views the order created
//		     */
//		    public static void viewOrderUI(){
//		        System.out.println("--------------------------------------------------------------------------------");
//		        System.out.println("Enter Table ID to view table order.");
//		        int table =0;
//		        do{
//		            System.out.println("Enter Table ID (1-10) : ");
//		            table = sc.nextInt();
//		            sc.nextLine();} while(table<1 | table>10);
//		        if(!Restaurant.tableManager.checkAvailability(table)){
//		            System.out.println("Table is not occupied.");
//		            return;
//		        }
//		        if(!Restaurant.allOrders.checkPendingOrder(table)){
//		            System.out.println("There are no existing orders for table "+table);
//		            return;
//		        }
//
//
//		        try{
//		        Order order = Restaurant.allOrders.findOrder(table);
//		            System.out.println("============================= CURRENT TABLE ORDER =================================");
//
//		            order.viewOrder();}
//		        catch(NullPointerException e){
//		            System.out.println("No order"+e);
//		        }
//
//		    }
//
//		    /**
//		     * adds an item to order
//		     */
//		    public static void addItemToOrderUI(){
//		        System.out.println("----------------------------------------");
//		        System.out.println("Enter table ID: ");
//		        int tableID = sc.nextInt();
//		        if(tableID>11){
//		            System.out.println("Enter Table ID:");
//		            tableID = sc.nextInt();
//		        }
//		        sc.nextLine();
//		        addItemOptions(tableID);
//		    }
//
//		    /**
//		     * let user input choice of item to add to order
//		     * @param tableID of customer making order
//		     */
//		    public static void addItemOptions(int tableID){
//		        int choice;
//		        do {
//		            System.out.println("========================================");
//		            System.out.println("Select choice: ");
//		            System.out.println("(1) Add A-la Carte Item");
//		            System.out.println("(2) Add Promotion Set Package Item");
//		            System.out.println("(3) Back To Main Menu");
//		            System.out.println("========================================");
//
//		            choice = sc.nextInt();
//		            sc.nextLine();
//
//		            switch (choice) {
//		                case 1:
//		                    addFoodToOrder(tableID);
//		                    break;
//		                case 2:
//		                    addPromoToOrder(tableID);
//		                    break;
//		                case 3:
//		                    break;
//		            }
//		        } while (choice < 3);
//
//		    }

		    /**
		     * This gets the table ID to add orders
		     * @param tableID of order
		     */
//		    public static void addFoodToOrder(int tableID){
//		        int foodIndex;
//		        Restaurant.menu.printShortFoodMenu();
//		        do {
//
//		            Order order = Restaurant.allOrders.getPendingOrder(tableID);
//		            System.out.println("Enter index of a-la carte menu item to be added : (Enter -1 to exit) ");
//		            foodIndex = sc.nextInt();
//		            sc.nextLine();
//		            if(foodIndex==-1) addItemOptions(tableID);
//		            try {
//		                System.out.println("Adding A-la Carte Menu Item");
//		                System.out.println("--------------------------------------------------------------------------------");
//		                System.out.print(foodIndex+". ");
//		                Restaurant.menu.getFoods().get(foodIndex - 1).printFood();
//		                // need to ensure the table has an existing order already
//		                order.addFoodOrder(order,Restaurant.menu.getFoods().get(foodIndex - 1));
//		                System.out.print("[ADDED] ");
//
//		                System.out.println( Restaurant.menu.getFoods().get(foodIndex - 1).getName() + " added successfully");
//		                System.out.println("--------------------------------------------------------------------------------");
//		            } catch (IndexOutOfBoundsException e) {
//		                System.out.println("Index enter is not valid.");
//		            }
//		            catch(NullPointerException e){
//		                System.out.println("No valid order for this table thus Item cannot be added");
//		            }
//		        }while(foodIndex != -1);
//		    }
//
//		    /**
//		     * adds promotion set to order
//		     * @param tableID of order
//		     */
//		    public static void addPromoToOrder(int tableID) {
//		        int promoIndex;
//		        Restaurant.menu.printShortPromoMenu();
//		        do {
//		            Order order = Restaurant.allOrders.getPendingOrder(tableID);
//		            System.out.println("Enter index of Promotion Set Package item to be added : (Enter -1 to exit) ");
//		            promoIndex = sc.nextInt();
//		            sc.nextLine();
//		            if (promoIndex == -1) addItemOptions(tableID);
//		            try {
//		                System.out.println("Adding Promotion Set Item");
//		                System.out.println("--------------------------------------------------------------------------------");
//		                System.out.print(promoIndex+". ");
//		                Restaurant.menu.getPromos().get(promoIndex - 1).printPromo();
//		                order.addPromoOrder(order,Restaurant.menu.getPromos().get(promoIndex - 1));
//		                System.out.print("[ADDED] ");
//		                System.out.println( Restaurant.menu.getPromos().get(promoIndex - 1).getName() + " added successfully");
//		                System.out.println("--------------------------------------------------------------------------------");
//		            } catch (IndexOutOfBoundsException e) {
//		                System.out.println("Index enter is not valid.");
//		            }
//		            catch(NullPointerException e){
//		                System.out.println("No valid order for this table thus Promotion Set Item cannot be added ");
//		            }
//		        } while (promoIndex != -1);
//
//
//		    }
//
//		    /**
//		     * removes item from order
//		     */
//		    public static void removeItemFromOrderUI(){
//		        System.out.println("----------------------------------------");
//		        System.out.println("Enter table ID: ");
//		        int tableID = sc.nextInt();
//		        if(tableID>10){
//		            System.out.println("Enter Table ID:");
//		            tableID = sc.nextInt();
//		        }
//		        sc.nextLine();
//		        Order order = Restaurant.allOrders.getPendingOrder(tableID);
//		        removeItemOptions(tableID);
//		    }
//
//		    /**
//		     * lets user input option to choice what type of item to remove
//		     * @param tableID of order
//		     */
//		    public static void removeItemOptions(int tableID){
//		        int choice;
//		        do {
//		            System.out.println("========================================");
//		            System.out.println("Select choice: ");
//		            System.out.println("(1) Remove A-la Carte Item");
//		            System.out.println("(2) Remove Promotion Set Package Item");
//		            System.out.println("(3) Go Back to Main Menu");
//		            System.out.println("========================================");
//
//		            choice = sc.nextInt();
//		            sc.nextLine();
//
//		            switch (choice) {
//		                case 1:
//		                    removeFoodFromOrder(tableID);
//		                    break;
//		                case 2:
//		                    removePromoFromOrder(tableID);
//		                    break;
//
//		            }
//		        } while (choice < 3);
//
//		    }
//
//		    /**
//		     * removes food from order
//		     * @param tableID of order
//		     */
//		    public static void removeFoodFromOrder(int tableID){
//		        int foodIndex;
//		        Restaurant.menu.printShortFoodMenu();
//		        do {
//		            Order order = Restaurant.allOrders.getPendingOrder(tableID);
//		            System.out.println("Enter index of a-la carte menu item to be removed : (Enter -1 to exit) ");
//		            foodIndex = sc.nextInt();
//		            sc.nextLine();
//		            if(foodIndex==-1) return;
//		            try {
//		                if(order.checkFood(Restaurant.menu.getFoods().get(foodIndex - 1))==0){
//		                    System.out.println("Food item is not in the order. Cannot be removed.");
//		                }
//		                else{
//		                    System.out.println("Removing A-la Carte Menu Item");
//		                    System.out.println("--------------------------------------------------------------------------------");
//		                    System.out.print(foodIndex+". ");
//		                    Restaurant.menu.getFoods().get(foodIndex - 1).printFood();
//		                    order.removeFoodOrder(Restaurant.menu.getFoods().get(foodIndex - 1));
//		                    System.out.print("[REMOVE] ");
//		                    System.out.println( Restaurant.menu.getFoods().get(foodIndex - 1).getName() + " removed successfully");
//		                }
//		                System.out.println("--------------------------------------------------------------------------------");
//		            } catch (IndexOutOfBoundsException e) {
//		                System.out.println("Index enter is not valid.");
//		            }
//		            catch(NullPointerException e){
//		                System.out.println("No valid order for this table thus Item cannot be remove");
//		            }
//		        }while(foodIndex != -1);
//		    }
//
//		    /**
//		     * removes promotion item from order
//		     * @param tableID of order
//		     */
//		    public static void removePromoFromOrder(int tableID){
//		        int promoIndex;
//		        Restaurant.menu.printShortPromoMenu();
//		        do {
//		            Order order = Restaurant.allOrders.getPendingOrder(tableID);
//		            System.out.println("Enter index of Promotion Set Package item to be removed : (Enter -1 to exit) ");
//		            promoIndex = sc.nextInt();
//		            sc.nextLine();
//		            if(promoIndex==-1) return;
//		            try {
//		                if(order.checkPromo(Restaurant.menu.getPromos().get(promoIndex - 1))==0){
//		                    System.out.println("Promotion Set Package item is not in the order. Cannot be removed.");
//		                }
//		                else{
//		                    System.out.println("Removing Promotion Set Item");
//		                    System.out.println("--------------------------------------------------------------------------------");
//		                    System.out.print(promoIndex+". ");
//		                    Restaurant.menu.getPromos().get(promoIndex - 1).printPromo();
//		                    order.removePromoOrder(Restaurant.menu.getPromos().get(promoIndex - 1));
//		                    System.out.print("[REMOVE] ");
//		                    System.out.println( Restaurant.menu.getPromos().get(promoIndex - 1).getName() + " removed successfully");;}
//		                System.out.println("--------------------------------------------------------------------------------");
//		            } catch (IndexOutOfBoundsException e) {
//		                System.out.println("Index enter is not valid.");
//		            }
//		            catch(NullPointerException e){
//		                System.out.println("No valid order for this table thus Promotion Set Item cannot be remove ");
//		            }
//		        }while(promoIndex != -1);
//		    }
//
//		    /**
//		     * print the order invoice
//		     */
//		    public static void printOrderInvoiceUI(){
//		        Calendar now = Calendar.getInstance();
////		        SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
//		        System.out.println("Enter Table ID to print Invoice : ");
//		        int table = sc.nextInt();
//		        sc.nextLine();
//		        int yes = 0;
//		        for(Order o: Restaurant.pendingOrders){
//		            if(o.getTableId()==table) yes=1;
//		        }
//		        if(yes==0){
//		            System.out.println("Table does not have an existing order.");
//		            return;
//		        }
//		        Order order = Restaurant.allOrders.getPendingOrder(table);
//		        Restaurant.tableManager.leaveTable(table);
//		        System.out.println(("Are you are member? Enter 1 : Yes , 0 : No" ));
//		        int member = sc.nextInt();
//		        sc.nextLine();
//		        if(member ==1 ){
//		            String custNumber = null;
//		            do{
//		                System.out.print("Enter customer phone number: ");
//		                custNumber = sc.next();
//		            }while(!ReservationUI.isValidMobileNo(custNumber));
//		            if(Restaurant.memberManager.isMember(custNumber)){
//		                Invoice invoice = new Invoice(order.getStaffID(),custNumber, table, order,now);
//		                Invoice invoiceCalculated = invoice.createInvoice(invoice);
//		                invoiceCalculated.printOrderInvoice();
//		                System.out.println("Thanks for being a member! Enjoy your 10% Discount");
//		                Restaurant.report.getInvoices().add(invoiceCalculated);
//		                return;
//		            }
//		            else{
//		                System.out.println("Sorry you are not a member.");
//		                Invoice invoice = new Invoice(order.getStaffID(),table ,order,now);
//		                Invoice invoiceCalculated = invoice.createInvoice(invoice);
//		                invoiceCalculated.printOrderInvoice();
//		                Restaurant.report.getInvoices().add(invoiceCalculated);
//		                return;
//		            }
//		        }
//		        else{ Invoice invoice = new Invoice(order.getStaffID(),table ,order,now);
//		            Invoice invoiceCalculated = invoice.createInvoice(invoice);
//		            invoiceCalculated.printOrderInvoice();
//		            Restaurant.report.getInvoices().add(invoiceCalculated);
//		            return;}
//		    }
//
//	}
//
//
//


	    }
