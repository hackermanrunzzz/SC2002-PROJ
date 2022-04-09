package classes;

/**
 * @author seth lee
 * @version 1.0
 * @since 9th November 2021
 */
public class Food {
    /**
     * name of food
     */
    private String name;
    /**
     * price of food
     */
    private double price;
    /**
     * description of food
     */
    private String description;
    /**
     * indicates what type of food item this is
     */
    private String type;// Main, Dessert, Beverage, Promo

    /**
     * constructor of food
     * @param name name of the food item
     * @param description description of the food item
     * @param type indicates what type the food is
     * @param price how much the food costs
     */
    public Food(String name, String description, String type, double price) {
        this.price = price;
        if(name.length()!=25){
            int space = 25-name.length();
            for(int i=0; i<space;i++){
                name = name + " ";
            }
        }
        this.name = name;
        this.description = description;
        this.type = type;
    }

    /**
     * prints the details of the food
     */
    public void printFood()
    { //used in the menu's search method to find item based on key word
        System.out.println("Name: " + getName() + " \n   Description: " +
                getDescription() + "\n   Type: " +
               getType() + "          Price: $" +
              getPrice());

    }

    /**
     * gets the name of food
     * @return name of food
     */
    public String getName() {
        return name;
    }

    /**
     * sets name of food
     * @param name of food
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets price of food
     * @return price of food
     */
    public double getPrice() {
        return price;
    }

    /**
     * sets price of food
     * @param price of food
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * gets description of food
     * @return description of food
     */
    public String getDescription() {
        return description;
    }

    /**
     * sets description of food
     * @param description of food
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * gets type of food
     * @return type of food
     */
    public String getType() {
        return type;
    }

    /**
     * sets type of food
     * @param type of food
     */
    public void setType(String type) {
        this.type = type;
    }
}
