package classes;

/**
 * @author Darren Choo
 * @version 1.0
 * @since 14th April 2022
 */

public class Guest {
	/**
     * guest's name
     */
	private String name;
	/**
     * guest's credit card name
     */
	private String creditCardName;
	/**
     * guest's credit card number
     */
	private String creditCardNumber;
	/**
     * guest's address
     */
	private String address;
	/**
     * guest's country
     */
	private String country;
	/**
     * guest's gender
     */
	private char gender;
	/**
     * guest's identitfication number
     */
	private String identity;
	/**
     * guest's nationality
     */
	private String nationality;
	/**
     * guest's contact number
     */
	private String contact;
	
	
	/**
     * constructor of guest
     * @param name name of guest
     * @param creditCardName guest's credit card name
     * @param creditCardNumber guest's credit card name
     * @param address guest's address
     * @param country guest's country
     * @param gender guest's gender
     * @param identity guest's identitfication number
     * @param nationality guest's nationality
     * @param contact guest's contact number
     */
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

	/**
     * gets the name of the guest
     * @return Name of guest
     */
	public String getName() {
		return name;
	}

	/**
	 * sets the name of the guest
	 * @param name name of the guest
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
     * gets the guest's credit card name
     * @return guest's credit card name
     */
	public String getCreditCardName() {
		return creditCardName;
	}

	/**
	 * sets guest's credit card name
	 * @param creditCardName guest's credit card name
	 */
	public void setCreditCardName(String creditCardName) {
		this.creditCardName = creditCardName;
	}

	/**
	 * get guest's credit card number
	 * @return guest's credit card number
	 */
	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	/**
	 * sets guest's credit card number
	 * @param creditCardNumber guest's credit card number
	 */
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	/**
	 * gets guest's address
	 * @return guest's address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * sets guest's address
	 * @param address guest's address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * gets guest's country
	 * @return guest's country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * sets guest's country
	 * @param country guest's country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * gets guest's gender
	 * @return guest's gender
	 */
	public char getGender() {
		return gender;
	}

	/**
	 * sets guest's gender
	 * @param gender guest's gender
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}

	/**
	 * gets guest's identity number
	 * @return guest's identity number
	 */
	public String getIdentity() {
		return identity;
	}

	/**
	 * sets guest's identity number
	 * @param identity guest's identity number
	 */
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	/**
	 * gets guest's nationality
	 * @return guest's nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * sets guest's nationality
	 * @param nationality guest's nationality
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * gets guest's contact number
	 * @return guest's contact number
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * sets guest's contact number
	 * @param contact guest's contact number
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}


	


}
