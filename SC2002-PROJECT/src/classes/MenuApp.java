package classes;
import java.util.ArrayList;

import classes.MenuItem.TypeOfMenuItem;

public class MenuApp {
	public static void main(String [] args) {
		
		ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
		MenuManager mm = new MenuManager(menu);
		
		//Breakfast
//			MenuItem one = new MenuItem("Buttermilk Pancakes", "Plain, Blueberry, with Maple Syrup", TypeOfMenuItem.MAIN , 12.99);
//			menu.add(0,one);
//
//			MenuItem two = new MenuItem("Signature Bun", "Puff Roll with Cinnamon, Citrus Zest and Organic Brown Sugar", TypeOfMenuItem.MAIN, 7.99);
//			menu.add(1,two);
//
//			MenuItem three = new MenuItem( "Cereals", "Special K, Corn Flakes, Frosted Flakes, Raisin Bran, Granola, Oatmeal, Grits", "None Available", 6.99, 2);
//			menu.add(2,three);
//
//			MenuItem four = new MenuItem( "Assorted Jams and Spreads", "Strawberry Jam, Grape Jam, Orange Marmalade, HoneyCream Cheese, Butter, Margarine", "None Available", 4.99, 3);
//			menu.add(3,four);
//
//			MenuItem five = new MenuItem( "Baked Pastries",  "Croissant, Blueberry Muffin, Cheese Danish", "None Available", 7.99, 4);
//			menu.add(4,five);

		//Lunch

			MenuItem six = new MenuItem("Seafood Nasi Goreng",  "Sambal Fried Fish, Prawn Satay, Fried Egg, FIsh Cracker and Pickled Achar", TypeOfMenuItem.MAIN , 20.00);
			menu.add(six);

			MenuItem seven = new MenuItem("Grass-Fed Angus Sirloin - 250gm", "Toasted Fresh Harvest Vegetable and Roasted Potato", TypeOfMenuItem.MAIN , 42.00);
			menu.add(seven);

			MenuItem eight = new MenuItem("Seared Chicken - Half",  "Roasted Fresh Harvest Vegetable with Tarragon Sauce", TypeOfMenuItem.MAIN , 28.00);
			menu.add(eight);

			MenuItem nine = new MenuItem("Assorted Butcher's Platter" , "Four Kinds of Homemade Sausages", TypeOfMenuItem.MAIN , 28.00);
			menu.add(nine);

			MenuItem ten = new MenuItem("Tandoori Chicken Wrap", "Lime Yogurt Dip and Raita Salad", TypeOfMenuItem.MAIN , 18.00);
			menu.add(ten);

		//Dinner

			MenuItem eleven = new MenuItem("Vegetarian Bee Hoon: Stir-Fried Rice Vermicelli, Silver Sprouts, Kailan, Mushrooms and Carrot",  "More Spicy, Less Spicy", "Add Bee Hoon, Add Rice, Add Sprouts, Add Kailan, Add Mushrooms, Add Carrots", 27.99, 10);
			menu.add(10,eleven);

			MenuItem twelve = new MenuItem("Wok-Fried Kway Teow: Wok-Fried Flat Rice Noodles, Sweet Soya Sauce, Chinese Sausage, Fish Cake, Silver Sprouts, Choice of Prawn, Beef or Chicken",  "More Spicy, Less Spicy", "Add Noodles, Add Soya Sauce, Add Sausage, Add Fish Cake, Add Sprouts, Add Prawn, Beef/Chicken", 34.99, 11);
			menu.add(11,twelve);

			MenuItem thirteen = new MenuItem("Pasta Bolognese: With Grated Parmesean Cheese", "Less Salt", "Add Cheese", 19.99, 12);
			menu.add(12,thirteen);

			MenuItem fourteen = new MenuItem("Signature Maine Lobster Laksa: Thick RIce Vermicelli, Asian Spiced Coconut infused half Maine Lobster, Fish Cake, Silver Sprouts, Beancurd Puff", "Less Spicy, More Spicy", "Add Rice, Add Lobster, Add Fish Cake, Add Sprouts, Add Puff", 29.99, 13);
			menu.add(13,fourteen);

			MenuItem fifteen = new MenuItem("Garden Salad: Assorted Mixed Greens, Tomato, Avocado, Cucumber, Extra Virgin Olive Oil and Balsamic Dressing", "Less Olive Oil, Less Salt", "Add Greens, Add Tomato, Add Avocado, Add Cucumber, Add Olive Oil, Add Dressing", 25.99, 14);
			menu.add(14,fifteen);

		//Sides

			MenuItem sixteen = new MenuItem("French Fries: Slightly Salted", "Less Salt", "None Available", 10.00, 15);
			menu.add(15,sixteen);

			MenuItem seventeen = new MenuItem("Sorbet Selection: Single Scoop of Passion Fruit, Lemongrass or Raspberry Sorbet, Served With Berries", "None Available", "Add Passion Fruit, Add Berries", 8.99, 16);
			menu.add(16,seventeen);

			MenuItem eighteen = new MenuItem("Ice Cream: Single Scoop of Vanilla, Strawberry, Maple Walnut, or Mango", "None Available", "Add Scoop", 9.99, 17);
			menu.add(17,eighteen);

			MenuItem nineteen = new MenuItem("Classic Espresso: Vanilla Vodka, Espresso, Frangelico Chocolate", "Less Caffeine", "Add Vodka, Add Espresso Shots, Add Chocolate", 22.00, 18);
			menu.add(18,nineteen);

			MenuItem twenty = new MenuItem("Milkshakes: Vanilla, Strawberry, Chocolate, Coookies and Creamn, Lime and Honey",  "None Available",  "Add Caramel Drizzle", 12.00, 19);
			menu.add(19,twenty);
		// Initial ArrayList size is 20, with options available to add stuff to the menu or remove stuff from the menu
			
			mm.setMenu(menu);
			mm.displayMenu();
			
			mm.removeMenuItem();
			
			mm.displayMenu();
			
	}
	
	

}
