package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import classes.MenuItem.TypeOfMenuItem;

public class MenuManager {
	private static ArrayList<MenuItem> menu =new ArrayList<MenuItem>();
    
    
    
    public MenuManager(ArrayList<MenuItem> menu) {
    	MenuManager.menu = menu; // Made a change here cos the static reference wasn't accepted
    }
    
    public void setMenu(ArrayList<MenuItem> menu) {
        MenuManager.menu = menu;
    }
	
	
	Scanner sc = new Scanner(System.in);

	

	public void printMenuItem(int i)
    {
        System.out.println("Name: " + menu.get(i).getName() + " \n   Description: " +
                menu.get(i).getDescription() + "\n   Type: " +
               menu.get(i).getFoodType() + "          Price: $" +
              menu.get(i).getPrice());

    }
    public boolean addMenuBoolean(MenuItem menuItem){
        if(findFood(menuItem.getName())>=0){
            System.out.println("This food is already on the menu!");
            return false;
        }
        MenuManager.menu.add(menuItem);
        return true;
    }
    
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

    public void addMenuItem(MenuItem temp) // Overloaded Method, in-case you already created a MenuItem Object
    {
        menu.add(temp);
        return;
    }
    
    public boolean removeMenu(){
    	int i,j;
    	System.out.println("Enter the index of the food you want to remove: ");
    	i = sc.nextInt();
    	System.out.println("Are you sure you want to remove the following:");
    	printMenuItem(i-1);
    	
    	System.out.println("Press (1) to confirm, Press any other number to cancel");
    	j = sc.nextInt();
    	
    	if(j==1) {
    		MenuManager.menu.remove(i-1);
    	}
    	else {
    		return false;
    	}
        return true;
    }
    
    public int findFood(String menuItemName) {
        for(int i=0; i<MenuManager.menu.size(); i++) {
        	MenuItem menuItem = MenuManager.menu.get(i);
            if(menuItem.getName().equals(menuItemName)) {
                return i;
            }
        }
        return -1;
    }

    
    
//    public void printShortFoodMenu() {
//        System.out.println("================================================================================");
//        System.out.println("                          4 Guys Restaurant Menu");
//        System.out.println("================================= FOOD MENU ====================================");
//        for (int i = 0; i < this.menu.size(); i++) {
//            System.out.println((i + 1) + "." +
//                    this.menu.get(i).getName());
//
//
//        }
//        System.out.println("================================================================================");
//    }
//    public void printShortMenu() {
//        System.out.println("================================================================================");
//        System.out.println("                          4 Guys Restaurant Menu");
//        System.out.println("================================= FOOD MENU ====================================");
//        for (int i = 0; i < this.menu.size(); i++) {
//            System.out.println((i + 1) + ". " +
//                    this.menu.get(i).getName() + "  " + this.menu.get(i).getPrice());
//
//        }
//    }

    public void printMenu() {
        System.out.println("================================================================================");
        System.out.println("                         4 Guys Restaurant Menu");
        System.out.println("==================================FOOD MENU=====================================");
        printMain();
        printBeverage();
        printDessert();
    }

    
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
    
    public void updateMenuItemName(MenuItem menuItem) {
    	
    	System.out.println("[Update Name]");
        String current =menuItem.getName();
        System.out.println("Current Name : " + current);
        System.out.print("Insert New Name : ");
        String name = sc.nextLine();
        
        ////condition if the change is the same ask for change again////
        if(current.equals(name)){
            System.out.println("No change in name, please key in again");
            System.out.print("Insert New Name : ");
            name = sc.nextLine();
        }
        menuItem.setName(name);
    }
    
    
    public void updateMenuItemDescription(MenuItem menuItem) {
    	System.out.println("[Update Description]" );
        System.out.println("Current Description : " + menuItem.getDescription());
        System.out.print("Insert New Description : ");
        String description = sc.nextLine();
        menuItem.setDescription(description);
    }
    
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
    
    public void updateMenuItemPrice(MenuItem menuItem) {
    	System.out.println("[Update Price] ");
        System.out.println("Current Price : " + menuItem.getPrice());
        System.out.print("Insert New Price : ");
        double price ;
        //condition to update the correct price////
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
}
