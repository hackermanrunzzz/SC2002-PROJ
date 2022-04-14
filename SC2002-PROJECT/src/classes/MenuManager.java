package classes;


import java.util.ArrayList;

import java.util.Scanner;

import classes.MenuItem.TypeOfMenuItem;

/**
 * @author Vijayanarayanan Sai Arunavan
 * @version 1.0
 * @since 14th April 2022
 */
public class MenuManager {
    /**
     * create an array of menu items
     */
	private static ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
    /**
     * constructor for menu manager class
     * @param menu array of menu items
     */
    public MenuManager(ArrayList<MenuItem> menu) {
    	MenuManager.menu = menu;
    }
    /**
     * sets array of menu items
     * @param menu array of menu items
     */
    public void setMenu(ArrayList<MenuItem> menu) {
        MenuManager.menu = menu;
    }
    /**
     * scans input from user
     */
	Scanner sc = new Scanner(System.in);
    /**
     * prints a certain menu item, depending on the index input as the argument
     * @param i index of the menu item to be accessed
     */
	public void printMenuItem(int i)
    {
        System.out.println("Name: " + menu.get(i).getName() + " \n   Description: " +
                menu.get(i).getDescription() + "\n   Type: " +
               menu.get(i).getFoodType() + "          Price: $" +
              menu.get(i).getPrice());

    }
    /**
     * adds a menu item into the array of menu items
     * if menu item to be added is already present in the array of menu items, operation is terminated
     * @param menuItem menu item object
     * @return true if menu item is not already present in the array of menu items, false if otherwise
     */
    public boolean addMenuBoolean(MenuItem menuItem){
        if(findFood(menuItem.getName())>=0){
            System.out.println("This food is already on the menu!");
            return false;
        }
        MenuManager.menu.add(menuItem);
        return true;
    }
    /**
     * asks for input for each field of the menu item, name, description, food type, and price
     * calls addMenuBoolean function
     * if boolean returned is false, menu item is not added into the array
     * else menu item is added into the array and confirmation message is printed onto the screen
     */
	public void addMenuItem() {
			
		Scanner sc = new Scanner(System.in);
		MenuItem menuItem = new MenuItem("dummy", "dummy",TypeOfMenuItem.MAIN, 0);
		boolean i;
		
        System.out.println("========================================");
        System.out.println("Enter name of new menu item :");
        String name = sc.nextLine();

        System.out.println("Enter description of new menu item : ");
        String description = sc.nextLine();
        System.out.println("Enter type of new menu item (MAIN/ BEVERAGE / DESSERT) :");
        
        String type = sc.nextLine();
        while(!type.equals("MAIN") && !type.equals("BEVERAGE") && !type.equals("DESSERT")  ){
            System.out.println("Insert New Type (MAIN/ BEVERAGE/ DESSERT) :");
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
        
        menuItem.setName(name);
        menuItem.setDescription(description);
        menuItem.setPrice(price);
        
        if(type.equals("MAIN")) {
        	menuItem.setFoodType(MenuItem.TypeOfMenuItem.MAIN);
        }
        else if(type.equals("BEVERAGE")) {
        	menuItem.setFoodType(MenuItem.TypeOfMenuItem.BEVERAGE);
        }
        else if(type.equals("DESSERT")) {
        	menuItem.setFoodType(MenuItem.TypeOfMenuItem.DESSERT);
        }
       
        
        i = addMenuBoolean(menuItem);
        if(i){
            System.out.println("----------------------------------------");
            System.out.println("Menu item added successfully.");}
        else  return;
	}
    /**
     * overloaded addMenuItem method
     * to be used in the case where a menu item object has already been created and is to be added into the array
     * @param temp menu item object which has already been created
     */
    public void addMenuItem(MenuItem temp) 
    {
        menu.add(temp);
        return;
    }
    /**
     * removes menu item from array of menu items
     * @return true if menu item was removed, false if otherwise
     */
    
    public boolean removeMenuItem(){
    	int i,j;
    	System.out.println("Enter the index of the food you want to remove: ");
    	i = sc.nextInt();
    	
    	try{
            menu.get(i-1);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Menu Item index is not valid.");
            return false;
        }
    	
    	System.out.println("Are you sure you want to remove the following:");
    	printMenuItem(i-1);
    	
    	
    	System.out.println("Press (1) to confirm, Press any other number to cancel");
    	j = sc.nextInt();
    	
    	if(j==1) {
    		MenuManager.menu.remove(i-1);
    		System.out.println("Food successfully removed.");
    	}
    	else {
    		return false;
    	}
        return true;
    }
    
    /**
     * 
     * @param menuItemName menu item name
     * @return index of menu item
     */
    public int findFood(String menuItemName) {
        for(int i=0; i<MenuManager.menu.size(); i++) {
        	MenuItem menuItem = MenuManager.menu.get(i);
            if(menuItem.getName().equals(menuItemName)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * prints menu by accessing printMain(), printBeverage(), and printDesert()
     */
    public void printMenu() {
        System.out.println("================================================================================");
        System.out.println("                         4 Guys Restaurant Menu");
        System.out.println("==================================FOOD MENU=====================================");
        printMain();
        printBeverage();
        printDessert();
    }
    /**
     * prints menu items of foodtype main by accessing the menu item array
     */
    public void printMain() {
        System.out.println("==================================== MAIN ======================================");
        for (int i = 0; i < MenuManager.menu.size(); i++) {
            if (MenuManager.menu.get(i).getFoodType().equals(TypeOfMenuItem.MAIN)) {
                System.out.print((i + 1) + ". ");
                printMenuItem(i);
                System.out.println("--------------------------------------------------------------------------------");
            }
        }
    }
    /**
     * prints menu items of foodtype beverage by accessing the menu item array
     */
    public void printBeverage() {
        System.out.println("================================== BEVERAGE ====================================");
        for (int i = 0; i < MenuManager.menu.size(); i++) {
        	if (MenuManager.menu.get(i).getFoodType().equals(TypeOfMenuItem.BEVERAGE)) {
                System.out.print((i + 1) + ". ");
                printMenuItem(i);
                System.out.println("--------------------------------------------------------------------------------");
            }
        }
    }
    /**
     * prints menu items of foodtype dessert by accessing the menu item array
     */
    public void printDessert() {
        System.out.println("=================================== DESSERT ====================================");
        for (int i = 0; i < MenuManager.menu.size(); i++) {
        	if (MenuManager.menu.get(i).getFoodType().equals(TypeOfMenuItem.DESSERT)) {
                System.out.print((i + 1) + ". ");
                printMenuItem(i);
                System.out.println("--------------------------------------------------------------------------------");
            }
        }
    }
    /**
     * updates the name of a menu item object in the menu item array
     * @param menuItem menu item object
     */
    public void updateMenuItemName(MenuItem menuItem) {
    	
    	System.out.println("[Update Name]");
        String current =menuItem.getName();
        System.out.println("Current Name : " + current);
        System.out.print("Insert New Name : ");
        String name = sc.nextLine();
        if(current.equals(name)){
            System.out.println("No change in name, please key in again");
            System.out.print("Insert New Name : ");
            name = sc.nextLine();
        }
        menuItem.setName(name);
    }
    /**
     * updates description of a menu item object in the menu item array
     * @param menuItem menu item object
     */
    public void updateMenuItemDescription(MenuItem menuItem) {
    	System.out.println("[Update Description]" );
        System.out.println("Current Description : " + menuItem.getDescription());
        System.out.print("Insert New Description : ");
        String description = sc.nextLine();
        menuItem.setDescription(description);
    }
    /**
     * updates the type of a menu item object in the menu item array
     * @param menuItem menu item object
     */
    public void updateMenuItemType(MenuItem menuItem) {
    	System.out.println("[Update Type]");
        System.out.println("Current Type : " + menuItem.getFoodType());
        System.out.print("Insert New Type (MAIN/BEVERAGE/DESSERT) : ");
        String type = sc.nextLine();
        while(!type.equals("MAIN") && !type.equals("BEVERAGE") && !type.equals("DESSERT")  ){
            System.out.println("Insert New Type (Main/ Beverage/ Dessert) :");
            type=sc.next();
        }
        if(type.equals("MAIN")) {
        	menuItem.setFoodType(MenuItem.TypeOfMenuItem.MAIN);
        }
        else if(type.equals("BEVERAGE")) {
        	menuItem.setFoodType(MenuItem.TypeOfMenuItem.BEVERAGE);
        }
        else if(type.equals("DESSERT")) {
        	menuItem.setFoodType(MenuItem.TypeOfMenuItem.DESSERT);
        }
    }
    /**
     * updates price of a menu item from the menu item array
     * @param menuItem menu item object
     */
    
    public void updateMenuItemPrice(MenuItem menuItem) {
    	System.out.println("[Update Price] ");
        System.out.println("Current Price : " + menuItem.getPrice());
        System.out.print("Insert New Price : ");
        double price ;
        do {
            System.out.println("Please enter a new positive number!");
            while (!sc.hasNextDouble()) {
                System.out.println("That's not a number!");
                sc.next();
            }
            price = sc.nextDouble();
        } while (price <= 0 || price== menuItem.getPrice());
        sc.nextLine();
        menuItem.setPrice(price);
    }
    /**
     * user interface for updating menu items in the menu item array
     */
    public void updateMenuItemUI() {
    	 System.out.println("========================================");
         System.out.println("Enter menu item index to be updated :");
         int index = sc.nextInt();
         sc.nextLine();
         if(index==-1) return;
         try{
             menu.get(index-1);
         }
         catch (IndexOutOfBoundsException e) {
             System.out.println("Menu Item index is not valid.");
             return;
         }

         int option;
         do{
             System.out.println("========================================");
             System.out.println("Updating Menu Item :");
             printMenuItem(index - 1);
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
                 case 1:
                	 updateMenuItemName(menu.get(index-1));
                     break;
                 case 2:
                	 updateMenuItemDescription(menu.get(index-1));
                     break;
                 case 3:
                	 updateMenuItemType(menu.get(index-1));
                     break;
                 case 4:
                	 updateMenuItemPrice(menu.get(index-1));
                     break;
             }
         } while (option<5);
    }
    /**
     * gets the array of menu items
     * @return array of menu items
     */
    public ArrayList<MenuItem> getFoods() {
        return menu;
    }
}


