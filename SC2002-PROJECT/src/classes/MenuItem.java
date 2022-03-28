package classes;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
	public String name; 
	public double price;

	// I'm gonna initialise 15 Menu Items, 5 for breakfast, 5 for lunch, 5 for Dinner, and 5 Sides which can be ordered at any time

	List<MenuItem> temp = new ArrayList<MenuItem>();
	
	public MenuItem()
	{
		//The following initialising can move to the initialsing class if needed
		MenuItem something = new MenuItem();
		//Breakfast
		something.name = "Buttermilk Pancakes\nPlain, Blueberry, with Maple Syrup, or with No Sugar\nAdded Maple Syrup\n\n";
		something.price = 12.99;
		temp.add(0, something);
		something.name = "Signature Bun\nPuff Roll with Cinnamon, Citrus Zest and Organic Brown Sugar\n\n";
		something.price = 7.99;
		temp.add(1,something);
		something.name = "Cereals\nSpecial K, Corn Flakes, Frosted Flakes, Raisin Bran\nGranola, Oatmeal, Grits\n\n";
		something.price = 6.99;
		temp.add(2,something);
		something.name = "Assorted Jams and Spreads\nStrawberry Jam, Grape Jam, Orange Marmalade, Honey\nCream Cheese, Butter, Margarine\n\n";
		something.price = 14.99;
		temp.add(3,something);
		something.name = "Baked Pastries\nCroissant, Blueberry Muffin, Cheese Danish\n\n";
		something.price = 7.99;
		temp.add(4,something);

		//Lunch

		something.name = "Seafood Nasi Goreng\nSambal Fried Fish, Prawn Satay, Fried Egg\nFIsh Cracker and Pickled Achar\n\n";
		something.price = 20.00;
		temp.add(5,something);
		something.name = "Grass-Fed Angus Sirloin - 250gm\nToasted Fresh Harvest Vegetable and Roasted Potato\n\n";
		something.price = 42.00;
		temp.add(6,something);
		something.name = "Seared Chicken - Half\nRoasted Fresh Harvest Vegetable with Tarragon Sauce\n\n";
		something.price = 28.00;
		temp.add(7,something);
		something.name = "Assorted Butcher's Platter\nFour Kinds of Homemade Sausages\n\n";
		something.price = 28.00;
		temp.add(8,something);
		something.name = "Tandoori Chicken Wrap\nLime Yogurt Dip and Raita Salad\n\n";
		something.price = 18.00;
		temp.add(9,something);

		//Dinner

		something.name = "Vegetarian Bee Hoon\nStir-Fried Rice Vermicellio, Silver Sprouts, Kailan, Mushrooms and Carrot\n\n";
		something.price = 27.99;
		temp.add(10,something);
		something.name = "Wok-Fried Kway Teow\nWok-Fried Flat Rice Noodles, Sweet Soya Sauce, Chinese Sausage\nFish Cake, Silver Sprouts, Choice of Prawn, Beef or Chicken\n\n";
		something.price = 34.99;
		temp.add(11,something);
		something.name = "Pasta Bolognese\nWith Grated Parmesean Cheese\n\n";
		something.price = 19.99;
		temp.add(12,something);
		something.name = "Signature Maine Lobster Laksa\nThick RIce Vermicelli, Asian Spiced Coconut infused half Maine Lobster\nFish Cake, Silver Sprouts, Beancurd Puff\n\n";
		something.price = 29.99;
		temp.add(13,something);
		something.name = "Garden Salad\nAssorted Mixed Greens, Tomato, Avocado, Cucumber\nExtra Virgin Olive Oil and Balsamic Dressing\n\n";
		something.price = 25.99;
		temp.add(14,something);

		//Sides

		something.name = "French Fries\nSlightly Salted\n\n";
		something.price = 10.00;
		temp.add(15,something);
		something.name = "Sorbet Selection\nSingle Scoop of Passion Fruit, Lemongrass or Raspberry Sorbet, Served With Berries\n\n";
		something.price = 8.99;
		temp.add(16,something);
		something.name = "Ice Cream\n Single Scoop of Vanilla, Strawberry, Maple Walnut, or Mango\n\n";
		something.price = 9.99;
		temp.add(17,something);
		something.name = "Classic Espresso\nVanilla Vodka, Espresso, Frangelico Chocolate\n\n";
		something.price= 22.00;
		temp.add(18,something);
		something.name = "Milkshakes\nVanilla, Strawberry, Chocolate, Coookies and Creamn, Lime and Honey\n\n";
		something.price = 12.00;
		temp.add(19,something);
	}

	public void displayMenu()
	{
		System.out.println("----------Breakfast Menu----------");
		for (int i = 0; i < 5; i++)
		{
			System.out.println(temp.get(i).name + " - " + temp.get(i).price);
		}
		System.out.print("\n\n");

		System.out.println("----------Lunch Menu----------");
		for (int i = 5; i < 10; i++)
		{
			System.out.println(temp.get(i).name + " - " + temp.get(i).price);
		}
		System.out.print("\n\n");

		System.out.println("----------Dinner Menu----------");
		for (int i = 10; i < 15; i++)
		{
			System.out.println(temp.get(i).name + " - " + temp.get(i).price);
		}
		System.out.print("\n\n");

		System.out.println("----------Sides----------");
		for (int i = 15; i < 20; i++)
		{
			System.out.println(temp.get(i).name + " - " + temp.get(i).price);
		}
		System.out.print("\n\n");
		return;
	}



}
