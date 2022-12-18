package Day27AddressBook;

public class ContactPerson {

	private String firstName, lastName, address, city, state, email;
	private int zipCode;
	private String phoneNumber;

	public ContactPerson(String firstName, String lastName, String address, String city, String state, String email,
			int zipCode, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;

	}

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

	public int getZipCode() {
		return zipCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}
}
