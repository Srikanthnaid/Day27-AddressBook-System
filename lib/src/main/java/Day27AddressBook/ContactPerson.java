package Day27AddressBook;

public class ContactPerson {
	// variables
	private String firstName, lastName, address, city, state, email;
	private int zipCode;
	private long phoneNumber;

	// constructor
	public ContactPerson() {

	}

	/*
	 * create getter and setter getter method using to get the values of variables.
	 * setter method using to set the values of variables
	 */
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getEmail() {
		return email;
	}

	public int getZipCode() {
		return zipCode;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// toString method convert in to string object.
	@Override
	public String toString() {
		return "ContactPerson{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", address='"
				+ address + '\'' + ", city='" + city + '\'' + ", state='" + state + '\'' + ", email='" + email + '\''
				+ ", zipCode=" + zipCode + ", phoneNumber=" + phoneNumber + '}';
	}
}