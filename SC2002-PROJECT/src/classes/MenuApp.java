package classes;
import java.util.ArrayList;

import classes.MenuItem.TypeOfMenuItem;

public class MenuApp {
	public static void menuapp() {
		
		ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
		MenuManager mm = new MenuManager(menu);
	
		//Main

			MenuItem food1 = new MenuItem("Seafood Nasi Goreng",  "Sambal Fried Fish, Prawn Satay, Fried Egg, Fish Cracker and Pickled Achar", TypeOfMenuItem.MAIN , 20.00);
			menu.add(food1);

			MenuItem food2 = new MenuItem("Grass-Fed Angus Sirloin - 250gm", "Toasted Fresh Harvest Vegetable and Roasted Potato", TypeOfMenuItem.MAIN , 42.00);
			menu.add(food2);

			MenuItem food3 = new MenuItem("Seared Chicken - Half",  "Roasted Fresh Harvest Vegetable with Tarragon Sauce", TypeOfMenuItem.MAIN , 28.00);
			menu.add(food3);

			MenuItem food4 = new MenuItem("Assorted Butcher's Platter" , "Four Kinds of Homemade Sausages", TypeOfMenuItem.MAIN , 28.00);
			menu.add(food4);

			MenuItem food5 = new MenuItem("Tandoori Chicken Wrap", "Lime Yogurt Dip and Raita Salad", TypeOfMenuItem.MAIN , 18.00);
			menu.add(food5);

		//Beverage
			MenuItem food6 = new MenuItem("Plain Water", "test", TypeOfMenuItem.BEVERAGE , 2.99);
			menu.add(food6);



		//Desserts

//			MenuItem sixteen = new MenuItem("French Fries: Slightly Salted", "Less Salt", "None Available", 10.00, 15);
//			menu.add(15,sixteen);
//
//			MenuItem seventeen = new MenuItem("Sorbet Selection: Single Scoop of Passion Fruit, Lemongrass or Raspberry Sorbet, Served With Berries", "None Available", "Add Passion Fruit, Add Berries", 8.99, 16);
//			menu.add(16,seventeen);
//
//			MenuItem eighteen = new MenuItem("Ice Cream: Single Scoop of Vanilla, Strawberry, Maple Walnut, or Mango", "None Available", "Add Scoop", 9.99, 17);
//			menu.add(17,eighteen);
//
//			MenuItem nineteen = new MenuItem("Classic Espresso: Vanilla Vodka, Espresso, Frangelico Chocolate", "Less Caffeine", "Add Vodka, Add Espresso Shots, Add Chocolate", 22.00, 18);
//			menu.add(18,nineteen);
//
//			MenuItem twenty = new MenuItem("Milkshakes: Vanilla, Strawberry, Chocolate, Coookies and Creamn, Lime and Honey",  "None Available",  "Add Caramel Drizzle", 12.00, 19);
//			menu.add(19,twenty);
		// Initial ArrayList size is 20, with options available to add stuff to the menu or remove stuff from the menu
			
			
			
//			MenuItem foodadd = new MenuItem("coke", "test", TypeOfMenuItem.BEVERAGE , 2.99);
//			
//			mm.setMenu(menu);
//			mm.addMenu(foodadd);
//			
//			mm.printMenu();
			
	}
	
	

}
