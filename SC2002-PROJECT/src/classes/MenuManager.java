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
    public boolean addMenu(MenuItem menuItem){
        if(findFood(menuItem.getName())>=0){
            System.out.println("This food is already on the menu!");
            return false;
        }
        this.menu.add(menuItem);
        return true;
    }
    
    public boolean removeMenu(int i){
        this.menu.remove(i-1);
        return true;
    }
    
    public int findFood(String menuItemName) {
        for(int i=0; i<this.menu.size(); i++) {
        	MenuItem menuItem = this.menu.get(i);
            if(menuItem.getName().equals(menuItemName)) {
                return i;
            }
        }
        return -1;
    }

    
    
    public void printShortFoodMenu() {
        System.out.println("================================================================================");
        System.out.println("                          4 Guys Restaurant Menu");
        System.out.println("================================= FOOD MENU ====================================");
        for (int i = 0; i < this.menu.size(); i++) {
            System.out.println((i + 1) + "." +
                    this.menu.get(i).getName());


        }
        System.out.println("================================================================================");
    }
    public void printShortMenu() {
        System.out.println("================================================================================");
        System.out.println("                          4 Guys Restaurant Menu");
        System.out.println("================================= FOOD MENU ====================================");
        for (int i = 0; i < this.menu.size(); i++) {
            System.out.println((i + 1) + ". " +
                    this.menu.get(i).getName() + "  " + this.menu.get(i).getPrice());

        }
    }

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
        for (int i = 0; i < this.menu.size(); i++) {
            if (this.menu.get(i).getFoodType().equals(TypeOfMenuItem.MAIN)) {
                System.out.print((i + 1) + ". ");
                printMenuItem(i);
                System.out.println("--------------------------------------------------------------------------------");
            }
        }
    }

    public void printBeverage() {
        System.out.println("================================== BEVERAGE ====================================");
        for (int i = 0; i < this.menu.size(); i++) {
        	if (this.menu.get(i).getFoodType().equals(TypeOfMenuItem.BEVERAGE)) {
                System.out.print((i + 1) + ". ");
                printMenuItem(i);
                System.out.println("--------------------------------------------------------------------------------");
            }
        }
    }

    public void printDessert() {
        System.out.println("=================================== DESSERT ====================================");
        for (int i = 0; i < this.menu.size(); i++) {
        	if (this.menu.get(i).getFoodType().equals(TypeOfMenuItem.DESSERT)) {
                System.out.print((i + 1) + ". ");
                printMenuItem(i);
                System.out.println("--------------------------------------------------------------------------------");
            }
        }
    }



}
