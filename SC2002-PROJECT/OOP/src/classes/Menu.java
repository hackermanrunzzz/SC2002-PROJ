package classes;
/**
 * @author seth lee
 * @version 1.0
 * @since 9th November 2021
 */

import java.util.ArrayList;

/**
 * create menu class
 */
public class Menu {
    /**
     * an array of food items
     */
    private ArrayList<Food> foods;
    /**
     * an array of promotion set items
     */
    private ArrayList<PromotionSet> promos;

    /**
     * constructor for menu
     */
    public Menu() {
        this.foods = new ArrayList<Food>();
        this.promos = new ArrayList<PromotionSet>();
    }

    /**
     * add food item to menu
     * @param food food item to be added
     * @return boolean if food can be added
     */
    public boolean addMenu(Food food){
        if(findFood(food.getName())>=0){
            System.out.println("This food is already on the menu!");
            return false;
        }
        this.foods.add(food);
        return true;
    }

    /**
     * add promo item to menu
     * @param promo promo item to be added
     * @return boolean if promo item can be added
     */
    public boolean addMenu(PromotionSet promo){
        if(findPromotionSet(promo.getName())>=0){
            System.out.println("This Promotion Set Package is already on the menu!");
            return false;
        }
        this.promos.add(promo);
        return true;
    }

    /**
     * find the food item
     * @param foodName name of food to be found
     * @return value if food can be found
     */
    public int findFood(String foodName) {
        for(int i=0; i<this.foods.size(); i++) {
            Food food = this.foods.get(i);
            if(food.getName().equals(foodName)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * find the promo item
     * @param promoSetName name of promo item to be found
     * @return value if promo item can be found
     */
    public int findPromotionSet(String promoSetName) {
        for(int i=0; i<this.promos.size(); i++) {
            PromotionSet promo = this.promos.get(i);
            if(promo.getName().equals(promoSetName)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * print the food items in menu
     */
    public void printShortFoodMenu() {
        System.out.println("================================================================================");
        System.out.println("                          Gabby FC Restaurant Menu");
        System.out.println("================================= FOOD MENU ====================================");
        for (int i = 0; i < this.foods.size(); i++) {
            System.out.println((i + 1) + "." +
                    this.foods.get(i).getName());


        }
        System.out.println("================================================================================");
    }

    /**
     * print the promo items in menu
     */
    public void printShortPromoMenu() {
        System.out.println("================================================================================");
        System.out.println("                           Gabby FC Restaurant Menu");
        System.out.println("========================== PROMOTIONAL SET PACKAGES ============================");

        for (int i = 0; i < this.promos.size(); i++) {
            System.out.println((i + 1) + ". " +
                    this.promos.get(i).getName() +"  "+ this.promos.get(i).getPrice());
        }
    }

    /**
     * print food and promo items in the menu
     */
    public void printShortMenu() {
        System.out.println("================================================================================");
        System.out.println("                          Gabby FC Restaurant Menu");
        System.out.println("================================= FOOD MENU ====================================");
        for (int i = 0; i < this.foods.size(); i++) {
            System.out.println((i + 1) + ". " +
                    this.foods.get(i).getName() + "  " + this.foods.get(i).getPrice());

        }
        System.out.println("========================== PROMOTIONAL SET PACKAGES ============================");
        for (int i = 0; i < this.promos.size(); i++) {
            System.out.println((i + 1) + ". " +
                    this.promos.get(i).getName() +"  "+ this.promos.get(i).getPrice());
        }
    }

    /**
     * print the full menu including beverages and dessert
     */
    public void printMenu() {
        System.out.println("================================================================================");
        System.out.println("                         Gabby FC Restaurant Menu");
        System.out.println("==================================FOOD MENU=====================================");
        printMain();
        printBeverage();
        printDessert();
        System.out.println("========================== PROMOTIONAL SET PACKAGES ============================");
        for(int i=0; i<this.promos.size(); i++) {
            System.out.print((i+1) + ". ");
            this.promos.get(i).printPromo();
            System.out.println("--------------------------------------------------------------------------------");
        }
    }

    /**
     * print the main course items in the menu
     */
    public void printMain() {
        System.out.println("==================================== MAIN ======================================");
        for (int i = 0; i < this.foods.size(); i++) {
            if (this.foods.get(i).getType().equals("Main")) {
                System.out.print((i + 1) + ". ");
                this.foods.get(i).printFood();
                System.out.println("--------------------------------------------------------------------------------");
            }
        }
    }

    /**
     * print the beverages in the menu
     */
    public void printBeverage() {
        System.out.println("================================== BEVERAGE ====================================");
        for (int i = 0; i < this.foods.size(); i++) {
            if (this.foods.get(i).getType().equals("Beverage")) {
                System.out.print((i + 1) + ". ");
                this.foods.get(i).printFood();
                System.out.println("--------------------------------------------------------------------------------");
            }
        }
    }

    /**
     * print the desserts in the menu
     */
    public void printDessert() {
        System.out.println("=================================== DESSERT ====================================");
        for (int i = 0; i < this.foods.size(); i++) {
            if (this.foods.get(i).getType().equals("Dessert")) {
                System.out.print((i + 1) + ". ");
                this.foods.get(i).printFood();
                System.out.println("--------------------------------------------------------------------------------");
            }
        }
    }

    /**
     * get the array of food items
     * @return array of food items
     */
    public ArrayList<Food> getFoods() {
        return foods;
    }

    /**
     * get the array of promo items
     * @return the array of promo items
     */
    public ArrayList<PromotionSet> getPromos() {
        return promos;
    }
}
