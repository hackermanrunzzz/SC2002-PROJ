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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCreditCardName() {
		return creditCardName;
	}


	public void setCreditCardName(String creditCardName) {
		this.creditCardName = creditCardName;
	}


	public String getCreditCardNumber() {
		return creditCardNumber;
	}


	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public String getIdentity() {
		return identity;
	}


	public void setIdentity(String identity) {
		this.identity = identity;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	


}
