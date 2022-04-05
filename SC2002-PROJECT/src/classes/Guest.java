package classes;


public class Guest {
	
	private String name;
	private String creditCardName; 
	private String creditCardNumber;
	private String address;
	private String country;
	private char gender;
	private String identity;
	private String nationality;
	private String contact; // Needs to have country code
	
	
	public Guest(String name, String creditCardName, String creditCardNumber, String address, String country, char gender, String identity, String nationality, String contact)
	{
		this.name = name;
		this.creditCardName = creditCardName;
		this.creditCardNumber = creditCardNumber;
		this.address = address;
		this.country = country;
		this.gender = gender;
		this.identity = identity;
		this.nationality = nationality;
		this.contact = contact;
	}


	public String getName()
	{
		return name;
	}


	public String getCreditCardName()
	{
		return creditCardName;
	}


	public String getCreditCardNumber()
	{
		return creditCardNumber;
	}


	public String getAddress()
	{
		return address;
	}


	public String getCountry()
	{
		return country;
	}


	public char getGender()
	{
		return gender;
	}


	public String getIdentity()
	{
		return identity;
	}


	public String getNationality()
	{
		return nationality;
	}


	public String getContact()
	{
		return contact;
	}
	
	

	
	
	
	
	

}
