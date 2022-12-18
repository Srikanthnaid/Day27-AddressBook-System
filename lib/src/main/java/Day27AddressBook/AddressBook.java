package Day27AddressBook;

public class AddressBook {

	public void createContact() {
		// created a object of contactperson class by invoke the getter and setter
		// methods
		ContactPerson person = new ContactPerson("Srikanth", "Naidu", "Alampur", "Hyderabad", "Telangana",
				"ksru044@gmail.com", 5214, "6301663090");
		System.out.println("First Name: " + person.getFirstName());
		System.out.println("Last Name: " + person.getLastName());
		System.out.println("Address: " + person.getAddress());
		System.out.println("City: " + person.getCity());
		System.out.println("State: " + person.getState());
		System.out.println("Email: " + person.getEmail());
		System.out.println("Zip Code: " + person.getZipCode());
		System.out.println("Phone Number: " + person.getPhoneNumber());
		System.out.println("Contact created successfully.....");
	}

	/*
	 * main method
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book program");
		System.out.println("--------------------------");
		System.out.println("Contact created in address book is: ");
		AddressBook addressBook = new AddressBook();
		addressBook.createContact();// call the method by using reference of object
	}
}