package classes;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
	public String name;
	public String options; // These change from like types of food to spiciness level and stuff
	public String addOns; 
	public double price;

	// I'm gonna initialise 15 Menu Items, 5 for breakfast, 5 for lunch, 5 for Dinner, and 5 Sides which can be ordered at any time

	//Just a heads-up, the class is kinda complicated now and got a lot of shit we might need to implement, so we can cut some down anytime if y'all want

	List<MenuItem> temp = new ArrayList<MenuItem>();
	
	public MenuItem()
	{
		//The following initialising can move to the initialsing class if needed
		MenuItem something = new MenuItem();
		//Breakfast
		something.name = "Buttermilk Pancakes";
		something.options = "Plain, Blueberry, with Maple Syrup, or with No Sugar";
		something.addOns = "Add Maple Syrup";
		something.price = 12.99;
		temp.add(0, something);
		something.name = "Signature Bun";
		something.options = "Puff Roll with Cinnamon, Citrus Zest and Organic Brown Sugar";
		something.addOns = "Add Cinnamon, Add Citruz Zest, Add Organic Borwn Sugar";
		something.price = 7.99;
		temp.add(1,something);
		something.name = "Cereals";
		something.options = "Special K, Corn Flakes, Frosted Flakes, Raisin Bran, Granola, Oatmeal, Grits";
		something.addOns = "None Available";
		something.price = 6.99;
		temp.add(2,something);
		something.name = "Assorted Jams and Spreads";
		something.options = "Strawberry Jam, Grape Jam, Orange Marmalade, HoneyCream Cheese, Butter, Margarine";
		something.addOns = "None Available";
		something.price = 14.99;
		temp.add(3,something);
		something.name = "Baked Pastries";
		something.options = "Croissant, Blueberry Muffin, Cheese Danish";
		something.addOns = "None Available";
		something.price = 7.99;
		temp.add(4,something);

		//Lunch

		something.name = "Seafood Nasi Goreng: Sambal Fried Fish, Prawn Satay, Fried Egg, FIsh Cracker and Pickled Achar";
		something.options = "Less Salt, Less Pepper, Less Spicy";
		something.addOns = "Add Fish, Add Prawn Satay, Add Fried Egg, Add Fish Cracker, Add Picked Achar";
		something.price = 20.00;
		temp.add(5,something);
		something.name = "Grass-Fed Angus Sirloin - 250gm: Toasted Fresh Harvest Vegetable and Roasted Potato";
		something.options = "Less Salt, Less Pepper";
		something.addOns = "Add Vegetables, Add Roasted Potato";
		something.price = 42.00;
		temp.add(6,something);
		something.name = "Seared Chicken - Half: Roasted Fresh Harvest Vegetable with Tarragon Sauce";
		something.options = "Less Salt";
		something.addOns = "Add Vegetables, Add Tarragon Sauce";
		something.price = 28.00;
		temp.add(7,something);
		something.name = "Assorted Butcher's Platter: Four Kinds of Homemade Sausages";
		something.options = "Less Salt";
		something.addOns = "None Available";
		something.price = 28.00;
		temp.add(8,something);
		something.name = "Tandoori Chicken Wrap: Lime Yogurt Dip and Raita Salad";
		something.options = "Less Spicy";
		something.addOns = "Add Yogurt Dip, Add Raita Salad";
		something.price = 18.00;
		temp.add(9,something);

		//Dinner

		something.name = "Vegetarian Bee Hoon: Stir-Fried Rice Vermicellio, Silver Sprouts, Kailan, Mushrooms and Carrot";
		something.options = "More Spicy, Less Spicy";
		something.addOns = "Add Bee Hoon, Add Rice, Add Sprouts, Add Kailan, Add Mushrooms, Add Carrots";
		something.price = 27.99;
		temp.add(10,something);
		something.name = "Wok-Fried Kway Teow: Wok-Fried Flat Rice Noodles, Sweet Soya Sauce, Chinese Sausage, Fish Cake, Silver Sprouts, Choice of Prawn, Beef or Chicken";
		something.options = "More Spicy, Less Spicy";
		something.addOns = "Add Noodles, Add Soya Sauce, Add Sausage, Add Fish Cake, Add Sprouts, Add Prawn, Add Beef/Chicken";
		something.price = 34.99;
		temp.add(11,something);
		something.name = "Pasta Bolognese: With Grated Parmesean Cheese";
		something.options = "Less Salt";
		something.addOns = "Add Cheese";
		something.price = 19.99;
		temp.add(12,something);
		something.name = "Signature Maine Lobster Laksa: Thick RIce Vermicelli, Asian Spiced Coconut infused half Maine Lobster, Fish Cake, Silver Sprouts, Beancurd Puff";
		something.options = "Less Spicy, More Spicy";
		something.addOns = "Add Rice, Add Lobster, Add Fish Cake, Add Sprouts, Add Puff";
		something.price = 29.99;
		temp.add(13,something);
		something.name = "Garden Salad: Assorted Mixed Greens, Tomato, Avocado, Cucumber, Extra Virgin Olive Oil and Balsamic Dressing";
		something.options = "Less Olive Oil, Less Salt";
		something.addOns = "Add Greens, Add Tomato, Add Avocado, Add Cucumber, Add Olive Oil, Add Dressing";
		something.price = 25.99;
		temp.add(14,something);

		//Sides

		something.name = "French Fries: Slightly Salted";
		something.options = "Less Salt";
		something.addOns = "None Available";
		something.price = 10.00;
		temp.add(15,something);
		something.name = "Sorbet Selection: Single Scoop of Passion Fruit, Lemongrass or Raspberry Sorbet, Served With Berries";
		something.options = "None Available";
		something.addOns = "Add Passion Fruit, Add Berries";
		something.price = 8.99;
		temp.add(16,something);
		something.name = "Ice Cream: Single Scoop of Vanilla, Strawberry, Maple Walnut, or Mango";
		something.options = "None Available";
		something.addOns = "Add Scoop";
		something.price = 9.99;
		temp.add(17,something);
		something.name = "Classic Espresso: Vanilla Vodka, Espresso, Frangelico Chocolate";
		something.options = "Less Caffeine";
		something.addOns = "Add Vodka, Add Espresso Shots, Add Chocolate";
		something.price= 22.00;
		temp.add(18,something);
		something.name = "Milkshakes: Vanilla, Strawberry, Chocolate, Coookies and Creamn, Lime and Honey";
		something.options = "None Available";
		something.addOns = "Add Caramel Drizzle";
		something.price = 12.00;
		temp.add(19,something);
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
			System.out.println(temp.get(i).name + "\n" + temp.get(i).options + "\n" + temp.get(i).addOns + " - " + temp.get(i).price);
		}
		System.out.print("\n\n");
		return;
	}



}
