package Day27AddressBook;

public class JavaFile {
	/**
	 * private variables can only be accessed within the same class (an outside
	 * class has no access to it) private = restricted access However, it is
	 * possible to access them if we provide public get and set methods.
	 */
	static int id = JavaFileMain.people.size();
	private String Firstname;
	private String Lastname;
	private String phoneNumber;
	private String email;
	private String address;

	/**
	 * creating a parameterized constructor of ContactDetails by passing parameters
	 * with no return type
	 * 
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param phonenumber
	 * @param email
	 * 
	 */
	JavaFile(String name, String surname, String phoneNumber, String email, String address) {
		this.Firstname = Firstname;
		this.Lastname = Lastname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		id++;
	}

	/*
	 * Getters and Setters
	 * 
	 */

	String getFirstName() {
		return Firstname;
	}

	String getLastName() {
		return Lastname;
	}

	String getPhoneNumber() {
		return phoneNumber;
	}

	String getEmail() {
		return email;
	}

	String getAddress() {
		return address;
	}

	/*
	 * To string for the dispaly pattern
	 * 
	 */
	@Override
	public String toString() {
		return "\n\nfirstName: " + getFirstName() + "\nlastname: " + getLastName() + "\nPhone number: "
				+ getPhoneNumber() + "\nEmail: " + getEmail() + "\nAddress: " + getAddress();
	}

}