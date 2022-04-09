package ui;

import java.util.*;

import Initialiser.Initialise;
import classes.Order;
import classes.OrderManager;

public class RoomServiceUI {

    public static void showRoomServiceOptions(){

        Scanner sc = new Scanner(System.in);

        int option = 0;
        
        do{
            System.out.println("========================================");
            System.out.println("Select choice: ");
            System.out.println("(1) Request for Room Service");
            System.out.println("(2) Request for Update on Order");
            System.out.println("(3) Show all Orders made"); 
            System.out.println("(4) Search individual Order"); // Based on timing or smth liddat
            System.out.println("(5) Show Orders via time made");
            System.out.println("(6) Show Orders via status");
            System.out.println("(7) Go Back To Main Menu");
            System.out.println("========================================");

            option = sc.nextInt();
            switch(option)
            {
                case 1:
                    // Basically greets guest and asks them for their order
                    break;
                case 2:
                    System.out.println("Please enter your room Number: ");
                    String room_number = sc.nextLine();
                    int resId = 0;//Need to call some function to get the reservation ID here
                    Order temp = OrderManager.findOrder(resId, room_number);
                    System.out.println("The current status of your order is: " + temp.getOrderStatus());
                    break;
                case 3:
                    System.out.println("Please enter your room Number: ");

            }



        }while (option < 8);




    
}
