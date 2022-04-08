package ui;

import classes.MenuItem;
import classes.MenuManager;
//import classes.MenuApp;


import java.util.ArrayList;
import java.util.Scanner;
import ui.*;

import Initialiser.Initialise;


public class MenuItemUI {
	public static void menuOptions() {
		
//		ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
//		MenuManager mm = new MenuManager(menu);
		
		Scanner sc = new Scanner(System.in);
		int option;
	
	

		//each ui has to initialise their respective items!
//		Initialise.InitialiseMenu(); 
		

		do {
            System.out.println("========================================");
            System.out.println("Hi! Please select an option:");
            System.out.println("(1) View Menu");
            System.out.println("(2) Add Menu Item");
            System.out.println("(3) Remove Menu Item");
            System.out.println("(4) Update Menu Item");
            System.out.println("(5) Go Back To Main Menu");
            System.out.println("========================================");

            option = sc.nextInt();
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
            }
        } while (option<5);
    }
}
