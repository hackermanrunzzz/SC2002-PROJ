/**
 * @author Gladys Loh
 * @version 1.0
 * @since 9th November 2021
 */

package ui;

import classes.Table;
import initialize.Restaurant;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * create reservation ui class
 */
public class ReservationUI {
    /**
     * create scanner object to receive input
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     * This is to show the reservation menu where users can select their action
     */
    public static void showReservationOptions(){
        int choice;
        do{
            System.out.println("========================================");
            System.out.println("Select choice: ");
            System.out.println("(1) Make reservation");
            System.out.println("(2) Remove reservation");
            System.out.println("(3) Show reservation");
            System.out.println("(4) Show available tables");

            System.out.println("(5) Make Walk-in");

            System.out.println("(6) Show occupied tables");
            System.out.println("(7) Go Back To Main Menu");
            System.out.println("========================================");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    makeReservationUI();
                    break;
                case 2:
                    removeReservationUI();
                    break;
                case 3:
                    showReservationsUI();
                    break;
                case 4:
                    showTableAvailabilityUI();
                    break;
                case 5:
                    makeWalkIn();
                    break;
                case 6:
                    showTableOccupiedUI();
                    break;
            }
        } while (choice < 7);

    }

    /**
     * Function to make reservations on the spot
     */
    public static void makeWalkIn() {
        int pax = 0;
        String custContact = "";

        System.out.print("Enter amount of pax: ");
        pax = sc.nextInt();
        sc.nextLine();
        if (pax > 10) {
            System.out.println("Sorry, number of pax is not valid");
            return;
        }
        Calendar now = Calendar.getInstance();
        Table t = Restaurant.tableManager.checkAvailableTable(now, pax);
        int choice;
        if (t != null) {
            t.printTableInfo();
            System.out.println("Assign table to customer?\n(1) Yes \n(2) No");
            choice = sc.nextInt();
            sc.nextLine();
            if (choice != 1) return;

            Restaurant.tables.get(t.getTableID() - 1).setTableStatus(Table.TableStatus.OCCUPIED);
            System.out.println("Table " + t.getTableID() + " is now occupied!");
        }
    }

    /**
     * Display menu to view all reservations or search for specific reservation by ID
     */
    private static void showReservationsUI(){
        int choice;
        int resId;

        System.out.println("\nDo you want to view, ");
            System.out.println("(1) All Reservations");
            System.out.println("(2) Search Reservation");
            System.out.println("(3) Go back");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    Restaurant.reservationManager.showAllReservations();
                    break;
                case 2:
                    try {
                        int id = Restaurant.reservationManager.showReservationShort();
                        if(id==0)break;
                        System.out.print("Enter reservation id: ");
                        resId = sc.nextInt();
                        sc.nextLine();
                        Restaurant.reservationManager.searchReservation(resId);
                    } catch (InputMismatchException e){
                        System.out.println("Invalid reservation id.");
                    }
                    break;
            }
    }

    /**
     * Display all available tables
     */
    private static void showTableAvailabilityUI(){
        System.out.println("========================================");
        System.out.println("Tables that are available: ");
        Restaurant.tableManager.printTables();
    }
    /**
     * Display all occupied tables
     */
    private static void showTableOccupiedUI(){
        System.out.println("========================================");
        System.out.println("Tables that are occupied: ");
        Restaurant.tableManager.printOccupiedTables();
    }

    /**
     * Function to make reservation
     * Will first check if there are reservations made for all tables,
     * assuming that all tables will be occupied until reservation are removed
     *
     * if there is available reservation slot, a number of pax is required and if a table is found successfully,
     * contact number and name will be required.
     */
    private static void makeReservationUI(){
        int pax = 0;
        String custContact = "";

        if(Restaurant.reservationManager.getReservations().size() > 9 ){
            System.out.println("We are fully booked!");
            return;
        }

        System.out.print("Enter amount of pax: ");
        pax = sc.nextInt();
        sc.nextLine();
        if(pax > 10){
            System.out.println("Sorry, number of pax is not valid");
            return;
        }
            Calendar reservationDate = Restaurant.reservationManager.getValidReservationDateTime();
            int tableId = Restaurant.tableManager.findReservationTable(reservationDate, pax);
            if (tableId == -1){
                return;
            }else{
                System.out.print("Enter customer name: ");
                String custName = sc.nextLine();

                do{
                    System.out.print("Enter customer phone number: ");
                    custContact = sc.next();
                }while(!isValidMobileNo(custContact));

                Restaurant.reservationManager.makeReservation(custName, Integer.parseInt(custContact), pax,reservationDate, tableId);
            }

        return;
    }

    /**
     * Check if the mobile number 8 digits
     * @param str phone number in string format
     * @return true if it is valid, false if invalid
     */
    public static boolean isValidMobileNo(String str)
    {
        Pattern ptrn = Pattern.compile("^(\\+\\d{2}( )?)?\\d{4}[- .]?\\d{4}$");
        Matcher match = ptrn.matcher(str);
        return (match.find() && match.group().equals(str));
    }

    /**
     * display menu to remove reservation
     * First, it will display all reservations
     * then, reservation id should be entered
     * If the reservation exist, it will print success, else there is an error in the ID or Id is not found
     */
    public static void removeReservationUI(){
        int result;
        int resId;
        int resSize = Restaurant.reservationManager.showReservationShort();

        if(resSize > 0 ){
                System.out.println("Which reservation do you want to remove? ");
                resId = sc.nextInt();
                sc.nextLine();
                if(resId >= 10000) {
                    result = Restaurant.reservationManager.removeReservation(resId);

                    if (result >= 10000) {
                        System.out.println("Reservation ID: " + result + " is successfully removed");
                    }
                }else{
                    System.out.println("! ERROR : Invalid reservation ID");
            }
        }

    }


}
