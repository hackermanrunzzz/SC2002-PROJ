package main;

import ui.*;
import java.util.Scanner;

public class HotelMain {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int option;
		
		 System.out.println("================================================================================");
	     System.out.println("                 Welcome To NTU Hotel");
	     System.out.println("================================================================================");
		
        do{
            System.out.println("========================================");
            System.out.println("Hello! Please select an option:");
            System.out.println("(1) Menu");
            System.out.println("(2) Reservations");
            System.out.println("(3) Room Service");
            System.out.println("(4) Payment");
            System.out.println("(5) Exit Program");
            System.out.println("========================================");


            option = sc.nextInt();
            sc.nextLine();

            switch(option){
                case 1 :
                	MenuItemUI.menuOptions();
                    break;
                case 2 :
                    break;
                case 3 : 
                    break;
                case 4 :
                     break;
                default :
                      break;

            }
        } while (option<5);
	}

	

}