package classes;
/**just adding the se
 * @author seth lee
 * @version 1.0
 * @since 9th November 2021
 */

import java.util.ArrayList;

/**
 * create promotionset class
 */
public class PromotionSet{
    /**
     * name of promotion set
     */
    private String name;
    /**
     * array of food items in promotion set
     */
    private ArrayList<Food> packageItems;
    /**
     * price of promotion set
     */
    private double price;
    /**
     * type of promotion set which is promo
     */
    private static final String type ="Promo";//fix type
    /**
     * description of promotion set
     */
    private String description;

    /**
     * create constructor for promotionset
     * @param name of promotion set
     * @param description of promotion set
     * @param price of promotion set
     */
    public PromotionSet(String name,String description, double price) {
        if(name.length()!=25){
            int space = 25-name.length();
            for(int i=0; i<space;i++){
                name = name + " ";
            }
        }
        this.name = name;
        this.packageItems = new ArrayList<Food>();
        this.price = price;
        this.description = description;
    }

    /**
     * print details of promotion set
     */
    public void printPromo()
    { //used in the menu's search method to find item based on key word
        System.out.println("Name: " + getName() + " \n   Description: " +
                getDescription() + "\n   Type: Promo " +
                "          Price: $" +
                getPrice());

    }

    /**
     * get the name of promotion set
     * @return name of promotion set
     */
    public String getName() {
        return name;
    }

    /**
     * set the name of promotion set
     * @param name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the array of food items
     * @return array of food items
     */
    public ArrayList<Food> getPackageItems() {
        return packageItems;
    }

    /**
     * set the food items to be in promotion
     * @param packageItems food items to be in promotion
     */
    public void setPackageItems(ArrayList<Food> packageItems) {
        this.packageItems = packageItems;
    }

    /**
     * get the price of promotionset
     * @return price of promotionset
     */
    public double getPrice() {
        return price;
    }

    /**
     * set the price of promotionset
     * @param price of promotionset
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * get the description of promotionset
     * @return description of promotionset
     */
    public String getDescription() {
        return description;
    }

    /**
     * set the description of promotionset
     * @param description of promotionset
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * add food item to promotionset
     * @param food item to be added to promotionset
     */
    public void addFoodToSet(Food food){
        this.packageItems.add(food);
    }


}
