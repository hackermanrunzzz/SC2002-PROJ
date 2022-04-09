package ui;
/**
 * @author seth lee
 * @version 1.0
 * @since 9th November 2021
 */

import classes.Food;
import classes.PromotionSet;
import initialize.Restaurant;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * create menu ui class
 */
public class MenuUI {
    /**
     * create scanner object to receive input
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     * let the user input choice to interact with menu
     */
    public static void menuOptions(){
        int option;
        do {
            System.out.println("========================================");
            System.out.println("Hello! Please select an option:");
            System.out.println("(1) View Menu");
            System.out.println("(2) Add Menu Item");
            System.out.println("(3) Remove Menu Item");
            System.out.println("(4) Update Menu Item");
            System.out.println("(5) Add Promotion Set Package");
            System.out.println("(6) Remove Promotion Set Package");
            System.out.println("(7) Update Promotion Set Package");
            System.out.println("(8) Go Back To Main Menu");
            System.out.println("========================================");

            option = sc.nextInt();
            sc.nextLine();

            switch(option) {
                case 1:
                    Restaurant.menu.printMenu();
                    break;
                case 2:
                    addFoodMenuUI();
                    break;
                case 3:
                    removeFoodMenuUI();
                    break;
                case 4:
                    updateFoodMenuUI();
                    break;
                case 5:
                    addPromoMenuUI();
                    break;
                case 6:
                    removePromoMenuUI();
                    break;
                case 7:
                    updatePromoMenuUI();
                    break;

            }
        } while (option<8);
    }


    /**
     * adds food item to menu
     */
    public static void addFoodMenuUI() {
        System.out.println("========================================");
        System.out.println("Enter name of new menu item :");
        String name = sc.nextLine();

        System.out.println("Enter description of new menu item : ");
        String description = sc.nextLine();
        System.out.println("Enter type of new menu item (Main/ Beverage/ Dessert) :");
        String type=sc.next();
        while(!type.equals("Main") && !type.equals("Beverage") && !type.equals("Dessert")  ){
            System.out.println("Enter type of new menu item (Main/ Beverage/ Dessert) :");
            type=sc.next();
        }


        System.out.println("Enter price of new menu item :");
        double price;
        do {
            System.out.println("Please enter a positive number!");
            while (!sc.hasNextDouble()) {
                System.out.println("That's not a number!");
                sc.next(); // this is important!
            }
            price = sc.nextDouble();
        } while (price <= 0);


        sc.nextLine();
        Food food = new Food(name, description, type, price);
        boolean i=Restaurant.menu.addMenu(food);
        if(i){
            System.out.println("----------------------------------------");
            System.out.println("Menu item added successfully.");}
        else  return;

    }

    /**
     * adds promotion item to menu
     */
    public static void addPromoMenuUI() {
        System.out.println("========================================");
        System.out.println("Enter name of new promotion set package : (Enter -1 to exit)");
        String name = sc.nextLine();
        if(name.equals("-1")) return;
        System.out.println("Enter description of new promotion set package :");
        String description = sc.nextLine();
        System.out.println("Enter price of new menu item :");
        double price ;
        do {
            System.out.println("Please enter a positive number!");
            while (!sc.hasNextDouble()) {
                System.out.println("That's not a number!");
                sc.next(); // this is important!
            }
            price = sc.nextDouble();
        } while (price <= 0);

        sc.nextLine();
        PromotionSet promo = new PromotionSet(name, description, price);

        int i=0;
        Restaurant.menu.printShortFoodMenu();
        do{

            System.out.println("Insert Index of Promotion Set Package: (Enter -1 if no more menu items to be added)");
            while (!sc.hasNextInt()) {
                System.out.println("That's not a number!");
                sc.next(); // this is important!
            }
            i = sc.nextInt();

            sc.nextLine();
            if(i==-1){
                boolean k= Restaurant.menu.addMenu(promo);
                if(k){
                    System.out.println("----------------------------------------");
                    System.out.println("Promotion set package added successfully.");
                    return;}
                else return;
            }
            try{
                Food food = Restaurant.menu.getFoods().get(i-1);
                promo.addFoodToSet(food);
                System.out.println("Menu Items in Promotion Set Package :" + promo.getName() );
                for(int j=0; j<promo.getPackageItems().size(); j++){
                    System.out.print((j+1) + "." + promo.getPackageItems().get(j).getName() +" ");
                }
                System.out.println();
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("Menu Item index is not valid.");
                return;
            }
        }while(i !=-1);

    }

    /**
     * removes food item from menu
     */
    public static void removeFoodMenuUI(){
        System.out.println("========================================");
        System.out.println("Enter index of menu item to be removed : (Enter -1 to exit)");
        int index = sc.nextInt();
        sc.nextLine();
        if(index ==-1) return;
        try{
            System.out.println("----------------------------------------");
            System.out.println("Menu item to be removed:");
            Restaurant.menu.getFoods().get(index-1).printFood();
            Restaurant.oldMenu.addMenu(Restaurant.menu.getFoods().get(index-1));
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Menu item index is not valid. Please re-enter index.");
           return;
        }
        System.out.println("Insert (1) to confirm removal and (0) to cancel");
        System.out.println("----------------------------------------");
        int confirm = sc.nextInt();
        sc.nextLine();
        if(confirm ==1 ){
            Restaurant.menu.getFoods().remove(index-1);
            System.out.println("----------------------------------------");
            System.out.println("Menu item removed successfully.");}
        else return;

    }

    /**
     * removes promotion item from menu
     */
    public static void removePromoMenuUI(){
        System.out.println("========================================");
        System.out.println("Enter index of promotion set package to be removed : (Enter -1 to exit)");
        int index = sc.nextInt();
        sc.nextLine();
        if(index ==-1) return;
        try{
            System.out.println("========================================");
            System.out.println("Promotion set package to be removed:");
            Restaurant.menu.getPromos().get(index-1).printPromo();
            Restaurant.oldMenu.addMenu(Restaurant.menu.getPromos().get(index-1));
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Promotion set index is not valid. Please re-enter index.");
            return;
        }
        System.out.println("Insert (1) to confirm removal and (0) to cancel");
        System.out.println("----------------------------------------");
        int confirm = sc.nextInt();
        sc.nextLine();
        if(confirm ==1 ){
            Restaurant.menu.getPromos().remove(index-1);
            System.out.println("----------------------------------------");
            System.out.println("Promotion set package removed successfully.");
            return;
        }
        else return;
    }

    /**
     * updates the food item in menu
     */
    public static void updateFoodMenuUI(){
        System.out.println("========================================");
        System.out.println("Enter menu item index to be updated :");//index out of bounds error
        int index = sc.nextInt();
        sc.nextLine();
        if(index==-1) return;
        try{
            Restaurant.menu.getFoods().get(index-1);//get food being updated
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Menu Item index is not valid.");
            return;
        }
        ArrayList<Food> foods = Restaurant.menu.getFoods();
        Food food = foods.get(index-1);
        Restaurant.oldMenu.addMenu(food);

        int option;
        do{
            System.out.println("========================================");
            System.out.println("Updating Menu Item :");
            food.printFood();
            System.out.println("========================================");
            System.out.println("(1) Update Name");
            System.out.println("(2) Update Description");
            System.out.println("(3) Update Type");
            System.out.println("(4) Update Price");
            System.out.println(("(5) Exit"));
            System.out.println("========================================");

            option = sc.nextInt();
            sc.nextLine();

            switch(option){
                case 1: System.out.println("[Update Name]");
                    String current =food.getName();
                    System.out.println("Current Name : " + current);
                    System.out.print("Insert New Name : ");
                    String name = sc.nextLine();
                    ////condition if the change is the same ask for change again////
                    if(current.equals(name)){
                        System.out.println("No change in name, please key in again");
                        System.out.print("Insert New Name : ");
                        name = sc.nextLine();
                    }
                    food.setName(name);

                    break;
                case 2: System.out.println("[Update Description]" );
                    System.out.println("Current Description : " + food.getDescription());
                    System.out.print("Insert New Description : ");
                    String description = sc.nextLine();
                    food.setDescription(description);
                    break;
                case 3: System.out.println("[Update Type]");
                    System.out.println("Current Type : " + food.getType());
                    System.out.print("Insert New Type (Main/Beverage/Dessert) : ");
                    String type = sc.nextLine();
                    while(!type.equals("Main") && !type.equals("Beverage") && !type.equals("Dessert")  ){
                        System.out.println("Insert New Type (Main/ Beverage/ Dessert) :");
                        type=sc.next();
                    }
                    food.setType(type);
                    break;
                case 4: System.out.println("[Update Price] ");
                    System.out.println("Current Price : " + food.getPrice());
                    System.out.print("Insert New Price : ");
                    double price ;
                    //condition to update te correct price////
                    do {
                        System.out.println("Please enter a new positive number!");
                        while (!sc.hasNextDouble()) {
                            System.out.println("That's not a number!");
                            sc.next(); // this is important!
                        }
                        price = sc.nextDouble();
                    } while (price <= 0 || price== food.getPrice());
                    sc.nextLine();
                    food.setPrice(price);
                    break;
            }

        } while (option<5);


    }

    /**
     * updates the promotion item in menu
     */
    public static void updatePromoMenuUI(){
        System.out.println("========================================");
        System.out.println("Enter promo item index to be updated : (Enter -1 to exit)");
        int index = sc.nextInt();
        sc.nextLine();
        if(index ==-1) return;
        try{
            Restaurant.menu.getPromos().get(index-1);//get food being updated

        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Promo Item index is not valid.");
            return;
        }
        ArrayList<PromotionSet> promos = Restaurant.menu.getPromos();
        ArrayList<Food> foods = new ArrayList<Food>();
        PromotionSet promo = promos.get(index-1);
        Restaurant.oldMenu.addMenu(promo);

        int option;
        do{
            System.out.println("========================================");
            System.out.println("Updating Promotion Set Package :");
            promo.printPromo();
            System.out.println("========================================");
            System.out.println("(1) Update Name");
            System.out.println("(2) Update Description");
            System.out.println("(3) Update Menu Items in Promotion Set Package");
            System.out.println("(4) Update Price");
            System.out.println(("(5) Exit"));
            System.out.println("========================================");

            option = sc.nextInt();
            sc.nextLine();

            switch(option){
                case 1: System.out.println("[Update Name]");
                    System.out.println("Current Name : " + promo.getName());
                    System.out.print("Insert New Name : ");
                    String name = sc.nextLine();
                    ////condition if the change is the same ask for change again////
                    if(promo.getName()==name){
                        System.out.println("No change in name, please key in again");
                        System.out.print("Insert New Name : ");
                        name = sc.nextLine();
                    }
                    promo.setName(name);

                    break;
                case 2: System.out.println("[Update Description]" );
                    System.out.println("Current Description : " + promo.getDescription());
                    System.out.print("Insert New Description : ");
                    String description = sc.nextLine();
                    promo.setDescription(description);
                    break;
                case 3: System.out.println("[Update Menu Items in Promotion Set Package]");
                    System.out.println("Current Menu Items : ");
                    for(int i=0; i<promo.getPackageItems().size(); i++){
                        System.out.println((i+1)+". "+ promo.getPackageItems().get(i).getName());
                    }

                    int i=0;
                    Restaurant.menu.printShortFoodMenu();
                    do{


                        System.out.println("Insert Index of New Menu Item in the Promotion Set Package: (Enter -1 if no more menu items to be added)");
                        i = sc.nextInt();
                        sc.nextLine();
                        System.out.println("--------------------------------------------------------------------------------");
                        if(i==-1){
                            System.out.println("New Promotional Set Package Menu Items updated successfully");
                            promo.setPackageItems(foods);
                            return;
                        }
                        try{
                            Food food = Restaurant.menu.getFoods().get(i-1);
                            foods.add(food);
                            System.out.println("Menu Items in Promotion Set Package :" + promo.getName() );
                            for(int j=0; j<foods.size(); j++){
                                System.out.print((j+1) + "." + foods.get(j).getName() +"    ");
                            }
                            System.out.println();
                            System.out.println("--------------------------------------------------------------------------------");
                        }
                        catch (IndexOutOfBoundsException e) {
                            System.out.println("Menu Item index is not valid.");
                            return;
                        }
                    }while(i !=-1);
                    promo.setPackageItems(foods);

                    break;
                case 4: System.out.println("[Update Price] ");
                    System.out.println("Current Price : " + promo.getPrice());
                    System.out.print("Insert New Price : ");
                    double price;
                    //condition to update te correct price////
                    do {
                        System.out.println("Please enter a positive number!");
                        while (!sc.hasNextDouble()) {
                            System.out.println("That's not a number!");
                            sc.next(); // this is important!
                        }
                        price = sc.nextDouble();
                        sc.nextLine();
                    } while (price <= 0 || price==promo.getPrice());
                    sc.nextLine();
                    promo.setPrice(price);
                    break;
            }
        } while (option<5);

    }

}
