package classes;


import java.util.*;

import org.w3c.dom.NameList;

public class MenuItem {
	private String name;
	private String options; // These change from like types of food to spiciness level and stuff
	private String addOns; 
	private double price;
	private int menuItemID; //Left this public cos if u make it private got problems


	public MenuItem(String name, String options, String addOns, double price, int menuItemID) {
		this.name = name;
		this.options = options;
		this.addOns = addOns;
		this.price = price;
		this.setMenuItemID(menuItemID);
	}

	public int getMenuItemID() {
		return menuItemID;
	}


	public void setMenuItemID(int menuItemID) {
		this.menuItemID = menuItemID;
	}

	Scanner sc = new Scanner(System.in);

	// I'm gonna initialise 15 Menu Items, 5 for breakfast, 5 for lunch, 5 for Dinner, and 5 Sides which can be ordered at any time

	//Just a heads-up, the class is kinda complicated now and got a lot of shit we might need to implement, so we can cut some down anytime if y'all want

	List<MenuItem> temp = new ArrayList<MenuItem>();

	//The following initialising can move to the initialsing class if needed
	public void initialiser()
	{
		
	//Breakfast
		MenuItem one = new MenuItem("Buttermilk Pancakes", "Plain, Blueberry, with Maple Syrup", "Add Maple Syrup, No Sugar", 12.99, 0);
		temp.add(0,one);

		MenuItem two = new MenuItem("Signature Bun", "Puff Roll with Cinnamon, Citrus Zest and Organic Brown Sugar", "Add Cinnamon, Add Citruz Zest, Add Organic Borwn Sugar", 7.99, 1);
		temp.add(1,two);

		MenuItem three = new MenuItem( "Cereals", "Special K, Corn Flakes, Frosted Flakes, Raisin Bran, Granola, Oatmeal, Grits", "None Available", 6.99, 2);
		temp.add(2,three);

		MenuItem four = new MenuItem( "Assorted Jams and Spreads", "Strawberry Jam, Grape Jam, Orange Marmalade, HoneyCream Cheese, Butter, Margarine", "None Available", 4.99, 3);
		temp.add(3,four);

		MenuItem five = new MenuItem( "Baked Pastries",  "Croissant, Blueberry Muffin, Cheese Danish", "None Available", 7.99, 4);
		temp.add(4,five);

	//Lunch

		MenuItem six = new MenuItem("Seafood Nasi Goreng: Sambal Fried Fish, Prawn Satay, Fried Egg, FIsh Cracker and Pickled Achar", "Less Salt, Less Pepper, Less Spicy",  "Add Fish, Add Prawn Satay, Add Fried Egg, Add Fish Cracker, Add Picked Achar", 20.00, 5);
		temp.add(5,six);

		MenuItem seven = new MenuItem("Grass-Fed Angus Sirloin - 250gm: Toasted Fresh Harvest Vegetable and Roasted Potato", "Less Salt, Less Pepper", "Add Vegetables, Add Roasted Potato", 42.00, 6);
		temp.add(6,seven);

		MenuItem eight = new MenuItem("Seared Chicken - Half: Roasted Fresh Harvest Vegetable with Tarragon Sauce", "Less Salt", "Add Vegetables, Add Tarragon Sauce", 28.00, 7);
		temp.add(7,eight);

		MenuItem nine = new MenuItem("Assorted Butcher's Platter: Four Kinds of Homemade Sausages", "Less Salt", "None Available", 28.00, 8);
		temp.add(8,nine);

		MenuItem ten = new MenuItem("Tandoori Chicken Wrap: Lime Yogurt Dip and Raita Salad", "Less Spicy", "Add Yogurt Dip, Add Raita Salad", 18.00, 9);
		temp.add(9,ten);

	//Dinner

		MenuItem eleven = new MenuItem("Vegetarian Bee Hoon: Stir-Fried Rice Vermicellio, Silver Sprouts, Kailan, Mushrooms and Carrot",  "More Spicy, Less Spicy", "Add Bee Hoon, Add Rice, Add Sprouts, Add Kailan, Add Mushrooms, Add Carrots", 27.99, 10);
		temp.add(10,eleven);

		MenuItem twelve = new MenuItem("Wok-Fried Kway Teow: Wok-Fried Flat Rice Noodles, Sweet Soya Sauce, Chinese Sausage, Fish Cake, Silver Sprouts, Choice of Prawn, Beef or Chicken",  "More Spicy, Less Spicy", "Add Noodles, Add Soya Sauce, Add Sausage, Add Fish Cake, Add Sprouts, Add Prawn, Beef/Chicken", 34.99, 11);
		temp.add(11,twelve);

		MenuItem thirteen = new MenuItem("Pasta Bolognese: With Grated Parmesean Cheese", "Less Salt", "Add Cheese", 19.99, 12);
		temp.add(12,thirteen);

		MenuItem fourteen = new MenuItem("Signature Maine Lobster Laksa: Thick RIce Vermicelli, Asian Spiced Coconut infused half Maine Lobster, Fish Cake, Silver Sprouts, Beancurd Puff", "Less Spicy, More Spicy", "Add Rice, Add Lobster, Add Fish Cake, Add Sprouts, Add Puff", 29.99, 13);
		temp.add(13,fourteen);

		MenuItem fifteen = new MenuItem("Garden Salad: Assorted Mixed Greens, Tomato, Avocado, Cucumber, Extra Virgin Olive Oil and Balsamic Dressing", "Less Olive Oil, Less Salt", "Add Greens, Add Tomato, Add Avocado, Add Cucumber, Add Olive Oil, Add Dressing", 25.99, 14);
		temp.add(14,fifteen);

	//Sides

		MenuItem sixteen = new MenuItem("French Fries: Slightly Salted", "Less Salt", "None Available", 10.00, 15);
		temp.add(15,sixteen);

		MenuItem seventeen = new MenuItem("Sorbet Selection: Single Scoop of Passion Fruit, Lemongrass or Raspberry Sorbet, Served With Berries", "None Available", "Add Passion Fruit, Add Berries", 8.99, 16);
		temp.add(16,seventeen);

		MenuItem eighteen = new MenuItem("Ice Cream: Single Scoop of Vanilla, Strawberry, Maple Walnut, or Mango", "None Available", "Add Scoop", 9.99, 17);
		temp.add(17,eighteen);

		MenuItem nineteen = new MenuItem("Classic Espresso: Vanilla Vodka, Espresso, Frangelico Chocolate", "Less Caffeine", "Add Vodka, Add Espresso Shots, Add Chocolate", 22.00, 18);
		temp.add(18,nineteen);

		MenuItem twenty = new MenuItem("Milkshakes: Vanilla, Strawberry, Chocolate, Coookies and Creamn, Lime and Honey",  "None Available",  "Add Caramel Drizzle", 12.00, 19);
		temp.add(19,twenty);
	// Initial ArrayList size is 20, with options available to add stuff to the menu or remove stuff from the menu
	}
	

	public void displayMenu()
	{
		System.out.println("----------Breakfast Menu----------");
		for (int i = 0; i < 5; i++)
		{
			System.out.println(temp.get(i).name + "\n" + temp.get(i).options + "\n" + temp.get(i).addOns + " - " + temp.get(i).price);
		}
		System.out.print("\n\n");

		System.out.println("----------Lunch Menu----------");
		for (int i = 5; i < 10; i++)
		{
			System.out.println(temp.get(i).name + "--" + temp.get(i).options + "--" + temp.get(i).addOns + " - " + temp.get(i).price);
		}
		System.out.print("\n\n");

		System.out.println("----------Dinner Menu----------");
		for (int i = 10; i < 15; i++)
		{
			System.out.println(temp.get(i).name + "--" + temp.get(i).options + "--" + temp.get(i).addOns + " - " + temp.get(i).price);
		}
		System.out.print("\n\n");

		System.out.println("----------Sides----------");
		for (int i = 15; i < 20; i++)
		{
			System.out.println(temp.get(i).name + "--" + temp.get(i).options + "--" + temp.get(i).addOns + " - " + temp.get(i).price);
		}
		System.out.print("\n\n");
		return;
	}

	public void removeMenuItem()
	{
		System.out.println("Please enter the ID of the Menu Item you would like to remove: \n");
		int j = sc.nextInt();
		temp.remove(j);
		System.out.println("The Menu Item was removed!\n");
		return;
	}

	public void addMenuItem() // We can make a loop inside to add more than one item
	{
		boolean y = true;
		System.out.println("Please enter the Name of the Menu Item you wish to add: ");
		String j = sc.nextLine();
		System.out.println("Please enter the Customisation options available for the dish: \n");
		String p = sc.nextLine();
		System.out.println("Please enter the Add-Ons available for the dish: \n");
		String q = sc.nextLine();
		System.out.println("Please enter the price of this dish: \n");
		double r = sc.nextDouble();
		System.out.println("Which category do u want this dish to be placed under?");
		System.out.println("1: Breakfast\n2: Lunch\n3: Dinner\n4: Sides\n");
		int x = sc.nextInt();
		while (y)
		{
			switch(x)
			{
				case 1:
					System.out.println("Enter the index for this menuitem\n");
					int temporary = sc.nextInt();
					MenuItem s = new MenuItem(j,p,q,r,temporary);
					temp.add(s);
					y = false;
					break;
				case 2:
					System.out.println("Enter the index for this menuitem\n");
					int temporary2 = sc.nextInt();
					MenuItem s1 = new MenuItem(j,p,q,r,temporary2);
					temp.add(s1);
					y = false;
					break;
				case 3:
					System.out.println("Enter the index for this menuitem\n");
					int temporary3 = sc.nextInt();
					MenuItem s2 = new MenuItem(j,p,q,r,temporary3);
					temp.add(s2);
					y = false;
					break;
				case 4:
					System.out.println("Enter the index for this menuitem\n");
					int temporary4 = sc.nextInt();
					MenuItem s3 = new MenuItem(j,p,q,r,temporary4);
					temp.add(s3);
					y = false;
					break;
				default:
					System.out.println("Please enter a valid choice!\n");
					y = true;
					break;
			}
		}
	return;
	}



}
