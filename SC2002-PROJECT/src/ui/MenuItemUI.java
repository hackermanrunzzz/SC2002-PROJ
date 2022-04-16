package ui;


import java.util.Scanner;

import initialiser.Initialise;

/**
 * @author Darren Wong
 * @version 1.0
 * @since 14th April 2022
 */


public class MenuItemUI {
	
	/**
	 * displaying options to update menu
	 */
	public static void menuOptions() {
		
		
		Scanner sc = new Scanner(System.in);
		int option = 0;
	
		

		do {
            System.out.println("========================================");
            System.out.println("Hi! Please select an option:");
            System.out.println("(1) View Menu");
            System.out.println("(2) Add Menu Item");
            System.out.println("(3) Remove Menu Item");
            System.out.println("(4) Update Menu Item");
            System.out.println("(5) Go Back To Main Menu");
            System.out.println("========================================");
            option = 0;
	        try {
	            option = sc.nextInt();
	            
	        }catch (Exception e) {
	        }
	        	sc.nextLine();

            switch(option) {
                case 1:
                	Initialise.mm.printMenu();
                    break;
                case 2:
                	Initialise.mm.addMenuItem();
                    break;
                case 3:
                	Initialise.mm.removeMenuItem();
                    break;
                case 4:
                	Initialise.mm.updateMenuItemUI();
                    break;
                case 5:
                	break;
            	default:
            		System.out.println("Invalid input!");
            		break;
            }
        } while (option != 5);
    }
}
