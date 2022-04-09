 /**
 * @author seth lee
 * @version 1.0
 * @since 9th November 2021
 */

import initialize.Restaurant;

import java.util.Scanner;

import static ui.MenuUI.menuOptions;
import static ui.OrderUI.orderOptions;
import static ui.ReservationUI.showReservationOptions;
import static ui.MemberUI.memberOptions;
import static ui.ReportUI.reportOptions;

/**
 * create application class
 */
public class application {
    /**
     * create scanner object to receive input
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     * the main function
     * @param args string
     */
    public static void main(String args[]) {
        Restaurant.initialiseRestaurant();
        System.out.println("================================================================================");
        System.out.println("                 Welcome To Gabby FC Restaurant!");
        System.out.println("================================================================================");
        Restaurant.staffManager.printStaffs();
        System.out.println("================================================================================");
        System.out.print("Please enter your staff ID: ");
        int staff = sc.nextInt();
        if(staff > Restaurant.staffManager.getStaffs().size()){
            System.out.print("Please enter your staff ID less than " + Restaurant.staffManager.getStaffs().size()+": ");
            staff = sc.nextInt();
        }
        sc.nextLine();
        System.out.println("========================================");
        Restaurant.staffManager.updateStatus(staff);
        restaurantOptions();


    }

    /**
     * lets user input option to interact with the program
     */
    public static void restaurantOptions(){
        int option;
        do{
            System.out.println("========================================");
            System.out.println("Hello! Please select an option:");
            System.out.println("(1) Menu");
            System.out.println("(2) Orders");
            System.out.println("(3) Reservations");
            System.out.println("(4) Members");
            System.out.println("(5) Sales Reports");
            System.out.println("(6) Exit Program");
            System.out.println("========================================");


            option = sc.nextInt();
            sc.nextLine();

            switch(option){
                case 1 :
                    menuOptions();
                    break;
                case 2 :
                    orderOptions();
                    break;
                case 3 : showReservationOptions();
                    break;
                case 4 : memberOptions();
                     break;
                case 5 : reportOptions();
                      break;

            }
        } while (option<6);

        Restaurant.staffManager.signOut();

    }
}
