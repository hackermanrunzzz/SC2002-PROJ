package classes;

public class MenuItem {
	public String name;
	public String preparation; // This is gonna be hard to do for a lot of menu items, so i'm just gonna ignore it first//
	public double price;

	// I'm gonna initialise 15 Menu Items, 5 for breakfast, 5 for lunch, 5 for Dinner, and 5 Sides which can be ordered at any time

	MenuItem[] temp = new MenuItem[20];
	
	public MenuItem()
	{
		for (int i = 0; i < 20; i++)
		{
			temp[i].price = 0.0;
			temp[i].name = "PlaceHolder";
		} // Initialising everything first, to avoid errors
		
		//The following initialising can move to the initialsing class if needed

		//Breakfast
		temp[0].name = "Buttermilk Pancakes\nPlain, Blueberry, with Maple Syrup, or with No Sugar\nAdded Maple Syrup\n\n";
		temp[0].price = 12.99;
		temp[1].name = "Signature Bun\nPuff Roll with Cinnamon, Citrus Zest and Organic Brown Sugar\n\n";
		temp[1].price = 7.99;
		temp[2].name = "Cereals\nSpecial K, Corn Flakes, Frosted Flakes, Raisin Bran\nGranola, Oatmeal, Grits\n\n";
		temp[2].price = 6.99;
		temp[3].name = "Assorted Jams and Spreads\nStrawberry Jam, Grape Jam, Orange Marmalade, Honey\nCream Cheese, Butter, Margarine\n\n";
		temp[3].price = 14.99;
		temp[4].name = "Baked Pastries\nCroissant, Blueberry Muffin, Cheese Danish\n\n";
		temp[4].price = 7.99;

		//Lunch

		temp[5].name = "Seafood Nasi Goreng\nSambal Fried Fish, Prawn Satay, Fried Egg\nFIsh Cracker and Pickled Achar\n\n";
		temp[5].price = 20.00;
		temp[6].name = "Grass-Fed Angus Sirloin - 250gm\nToasted Fresh Harvest Vegetable and Roasted Potato\n\n";
		temp[6].price = 42.00;
		temp[7].name = "Seared Chicken - Half\nRoasted Fresh Harvest Vegetable with Tarragon Sauce\n\n";
		temp[7].price = 28.00;
		temp[8].name = "Assorted Butcher's Platter\nFour Kinds of Homemade Sausages\n\n";
		temp[8].price = 28.00;
		temp[9].name = "Tandoori Chicken Wrap\nLime Yogurt Dip and Raita Salad\n\n";
		temp[9].price = 18.00;

		//Dinner

		temp[10].name = "Vegetarian Bee Hoon\nStir-Fried Rice Vermicellio, Silver Sprouts, Kailan, Mushrooms and Carrot\n\n";
		temp[10].price = 27.99;
		temp[11].name = "Wok-Fried Kway Teow\nWok-Fried Flat Rice Noodles, Sweet Soya Sauce, Chinese Sausage\nFish Cake, Silver Sprouts, Choice of Prawn, Beef or Chicken\n\n";
		temp[11].price = 34.99;
		temp[12].name = "Pasta Bolognese\nWith Grated Parmesean Cheese\n\n";
		temp[12].price = 19.99;
		temp[13].name = "Signature Maine Lobster Laksa\nThick RIce Vermicelli, Asian Spiced Coconut infused half Maine Lobster\nFish Cake, Silver Sprouts, Beancurd Puff\n\n";
		temp[13].price = 29.99;
		temp[14].name = "Garden Salad\nAssorted Mixed Greens, Tomato, Avocado, Cucumber\nExtra Virgin Olive Oil and Balsamic Dressing\n\n";
		temp[14].price = 25.99;

		//Sides

		temp[15].name = "French Fries\nSlightly Salted\n\n";
		temp[15].price = 10.00;
		temp[16].name = "Sorbet Selection\nSingle Scoop of Passion Fruit, Lemongrass or Raspberry Sorbet, Served With Berries\n\n";
		temp[16].price = 8.99;
		temp[17].name = "Ice Cream\n Single Scoop of Vanilla, Strawberry, Maple Walnut, or Mango\n\n";
		temp[17].price = 9.99;
		temp[18].name = "Classic Espresso\nVanilla Vodka, Espresso, Frangelico Chocolate\n\n";
		temp[18].price= 22.00;
		temp[19].name = "Milkshakes\nVanilla, Strawberry, Chocolate, Coookies and Creamn, Lime and Honey\n\n";
		temp[19].price = 12.00;
	}

	public void displayMenu()
	{
		System.out.println("----------Breakfast Menu----------");
		for (int i = 0; i < 5; i++)
		{
			System.out.println(temp[i].name + " - " + temp[i].price);
		}
		System.out.print("\n\n");

		System.out.println("----------Lunch Menu----------");
		for (int i = 5; i < 10; i++)
		{
			System.out.println(temp[i].name + " - " + temp[i].price);
		}
		System.out.print("\n\n");

		System.out.println("----------Dinner Menu----------");
		for (int i = 10; i < 15; i++)
		{
			System.out.println(temp[i].name + " - " + temp[i].price);
		}
		System.out.print("\n\n");

		System.out.println("----------Sides----------");
		for (int i = 15; i < 20; i++)
		{
			System.out.println(temp[i].name + " - " + temp[i].price);
		}
		System.out.print("\n\n");
		return;
	}



}
