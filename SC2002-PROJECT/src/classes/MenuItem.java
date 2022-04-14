package classes;
import java.io.Serializable;
/**
 * 
 * @author Vijayanarayanan Sai Arunavan
 * @version 1.0
 * @since 14th April 2022
 */

public class MenuItem implements Serializable{
	/**
	 * possible types of menu item
	 */
	public enum TypeOfMenuItem {
		/**
		 * menu item is of a main food type
		 */
		MAIN, 
		/**
		 * menu item is of a dessert food type
		 */
		DESSERT,
		/**
		 * menu item is of a beverage food type
		 */
		BEVERAGE};
	/**
	* menuitem's name
	 */
	private String name;
	/**
	* menu item's price
	 */
    private double price;
	/**
	* description of menu item
	 */
    private String description;
	/**
	* whether menu item is a main, dessert, or a beverage
	 */
	private TypeOfMenuItem foodType;
	/**
	 * constructor for menu item class
	 * @param name name of menu item
	 * @param description description of menu item
	 * @param foodType type of menu item
	 * @param price prce of the menu item
	 */
    public MenuItem(String name, String description, TypeOfMenuItem foodType , double price) {
        this.price = price;
        if(name.length()!=25){
            int space = 25-name.length();
            for(int i=0; i<space;i++){
                name = name + " ";
            }
        }
        this.name = name;
        this.description = description;
        this.foodType = foodType;
    }
	/**
	 * gets the name of menu item
	 * @return name of menu item
	 */
	public String getName() {
		return name;
	}
	/**
	 * sets the name of menu item
	 * @param name of menu item
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * gets price of the menu item
	 * @return menu item's price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * sets price of the menu item
	 * @param price of menu item
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * gets the description of  menu item
	 * @return description of menu item
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * sets description of menu item
	 * @param description of menu item
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * gets the food type, which is an enumeration, of the menu item
	 * @return food type of menu item
	 */
	public TypeOfMenuItem getFoodType() {
		return foodType;
	}
	/**
	 * sets the food type, which is an enumeration, of the menu item
	 * @param foodType of menu item
	 */
	public void setFoodType(TypeOfMenuItem foodType) {
		this.foodType = foodType;
	}  
}
