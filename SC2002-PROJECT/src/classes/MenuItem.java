package classes;


import java.util.*;

public class MenuItem {
	public enum TypeOfMenuItem {MAIN, DESSERT,BEVERAGE};
	
	private String name;
    private double price;
    private String description;
	private TypeOfMenuItem foodType;

   
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public TypeOfMenuItem getFoodType() {
		return foodType;
	}


	public void setFoodType(TypeOfMenuItem foodType) {
		this.foodType = foodType;
	}

    
  
}
