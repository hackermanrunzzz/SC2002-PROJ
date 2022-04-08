package ui;

import java.util.Scanner;


public class GuestUI {
	public static void guestOptions() {
		
//		ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
//		MenuManager mm = new MenuManager(menu);
		
		Scanner sc = new Scanner(System.in);
		int option;
		
		//we will need to change this to initialise
//		MenuApp.menuapp(); 
	
		//each ui has to initialise their respective items!
		

		do {
			
			//have to implement method to find the guest name first, before jumping to the below menu
			
			
            System.out.println("========================================");
            System.out.println("Hi! Please select an option:");
            System.out.println("(1) Update guest's name");
            System.out.println("(2) Update guest's card name");
            System.out.println("(3) Update guest's card number");
            System.out.println("(4) Update guest's address");
            System.out.println("(5) Update guest's country");
            System.out.println("(6) Update guest's gender");
            System.out.println("(7) Update guest's identity");
            System.out.println("(8) Update guest's nationality");
            System.out.println("(9) Update guest's contact");
            System.out.println("(10) Go Back To Main Menu");
            System.out.println("========================================");

            option = sc.nextInt();
            sc.nextLine();

            switch(option) {
                case 1:
                	
                    break;
                case 2:
                	
                    break;
                case 3:
                	
                    break;
                case 4:
                	
                    break;
            }
        } while (option<10);
    }
	

}
