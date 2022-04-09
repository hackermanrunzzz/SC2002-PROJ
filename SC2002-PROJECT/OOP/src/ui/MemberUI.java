package ui;
/**
 * @author seth lee
 * @version 1.0
 * @since 9th November 2021
 */

import initialize.Restaurant;


import java.util.Scanner;

/**
 * create memberUI class
 */
public class MemberUI {
    /**
     * create scanner object to receive input
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     * let user input choice to view/add/remove member or return to main menu
     */
    public static void memberOptions() {
        int choice;
        do {
            System.out.println("========================================");
            System.out.println("Select choice: ");
            System.out.println("(1) View Members");
            System.out.println("(2) Add Member");
            System.out.println("(3) Remove Member");
            System.out.println("(4) Go Back To Main Menu");
            System.out.println("========================================");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("=============== MEMBERS ================");
                    Restaurant.memberManager.viewMembers();
                    break;
                case 2:
                    Restaurant.memberManager.addMember();
                    break;
                case 3:
                    Restaurant.memberManager.removeMember();
                    break;

            }
        } while (choice < 4);
    }


}
