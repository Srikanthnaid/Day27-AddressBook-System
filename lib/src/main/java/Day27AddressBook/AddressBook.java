package Day27AddressBook;

import java.util.*;
import java.util.Scanner;

public class AddressBook {

	static Scanner sc = new Scanner(System.in);
	static HashMap<String, ArrayList<ContactPerson>> addressBookList = new HashMap<>();// create an object of hashmap
	static ArrayList<ContactPerson> currentAddressBook;// declare variable
	static String currentAddressBookName;// declare variable

	public ContactPerson createContact() {
		ContactPerson person = new ContactPerson();// creating object of ContactPerson class
		System.out.print("Enter First Name: ");
		person.setFirstName(sc.next());// using object reference calling setFirstName method to set first name
		System.out.print("Enter Last Name: ");
		person.setLastName(sc.next());
		System.out.print("Enter Address: ");
		person.setAddress(sc.next());
		System.out.print("Enter City: ");
		person.setCity(sc.next());
		System.out.print("Enter State: ");
		person.setState(sc.next());
		System.out.print("Enter email: ");
		person.setEmail(sc.next());
		System.out.print("Enter ZipCode: ");
		person.setZipCode(sc.nextInt());
		System.out.print("Enter Phone Number: ");
		person.setPhoneNumber(sc.nextLong());
		System.out.println("created new contact");
		return person;
	}

	/*
	 * if duplicate contact found then display message as contact name already
	 * exists Add new contacts to address book if there is no duplicate contact
	 */
	void addContact(ContactPerson person) {
		boolean isDuplicate = checkDuplicateContact(person);
		if (isDuplicate) {
			System.out.println("Contact name already exists");
		} else {
			currentAddressBook.add(person);
			System.out.println("contact added to AddressBook " + currentAddressBookName);
			System.out.println(person);
		}
	}

	// check duplicate contact using their name
	boolean checkDuplicateContact(ContactPerson newPerson) {
		return currentAddressBook.stream().anyMatch((person) -> person.getFirstName().equals(newPerson.getFirstName()));
	}

	/*
	 * Edit existing contact using person`s name if contact found then edit
	 * otherwise no contact found message will be display
	 */
	public void editContact() {
		boolean isContactFound = false;
		System.out.println("Enter Name to edit Contact");
		String name = sc.next();

		for (ContactPerson contactPerson : currentAddressBook) { // iterate over the arraylist
			if (name.equalsIgnoreCase(contactPerson.getFirstName())) {
				isContactFound = true;
				System.out.print("Enter First Name :");
				contactPerson.setFirstName(sc.next());
				System.out.print("Enter Last Name :");
				contactPerson.setLastName(sc.next());
				System.out.print("Enter Address :");
				contactPerson.setAddress(sc.next());
				System.out.print("Enter City :");
				contactPerson.setCity(sc.next());
				System.out.print("Enter State :");
				contactPerson.setState(sc.next());
				System.out.print("Enter email :");
				contactPerson.setEmail(sc.next());
				System.out.print("Enter ZipCode :");
				contactPerson.setZipCode(sc.nextInt());
				System.out.print("Enter Phone Number :");
				contactPerson.setPhoneNumber(sc.nextLong());
				System.out.println(contactPerson);
				break;
			}
		}
		if (isContactFound) {
			System.out.println("Contact Updated Successfully..");
		} else {
			System.out.println("Oops...Contact not found");
		}
	}

	/*
	 * Delete contact using person`s name if contact found then delete that contact
	 * if no contact found then message will be display as oops....contact not found
	 */
	public void deleteContact() {
		boolean isContactFound = false;
		System.out.println("enter name to delete contact");
		String name = sc.next();
		for (ContactPerson contactPerson : currentAddressBook) {
			if (contactPerson.getFirstName().equalsIgnoreCase(name)) {
				System.out.println("contact found:");
				isContactFound = true;
				System.out.println(contactPerson);
				System.out.println("confirm to delete (y/n)");
				if (sc.next().equalsIgnoreCase("y")) {
					currentAddressBook.remove(contactPerson);
					System.out.println("contact deleted");
				}
				break;
			}
		}
		if (!isContactFound) {
			System.out.println("Opps... contact not found");
		}
	}

	/*
	 * add multiple address book each address book has unique name
	 */
	void addNewAddressBook() {
		System.out.println("Enter name for AddressBook: ");
		String addressBookName = sc.next();
		ArrayList<ContactPerson> addressBook = new ArrayList();// creating object of arraylist
		// using object reference of hashmap calling put method and passing key as
		// addressBookName and value as addressBook
		addressBookList.put(addressBookName, addressBook);
		System.out.println("new AddressBook created");
		currentAddressBook = addressBookList.get(addressBookName);// retrieve addressBookName using get method
		currentAddressBookName = addressBookName;// addressBookName store in current addressBookName
	}

	/*
	 * select address book if we want to add more contact in existing address book
	 * then select that address book
	 */
	void selectAddressBook() {
		System.out.println(addressBookList.keySet());
		System.out.println("Enter name of address book:");
		String addressBookName = sc.next();

		for (String key : addressBookList.keySet()) {
			if (key.equalsIgnoreCase(addressBookName)) {
				currentAddressBook = addressBookList.get(key);
				currentAddressBookName = key;
			}
		}
		System.out.println("current AddressBook is: " + currentAddressBookName);
	}

	/*
	 * Display contact
	 */
	void displayContact(ArrayList addressBook) {
		System.out.println("Contacts: ");
		for (Object p : addressBook) {
			ContactPerson person = (ContactPerson) p;
			System.out.println(person);
		}
	}

	/*
	 * search contact by city and state
	 */
	void searchContact() {
		System.out.println("1.Search by City \n2.Search by State");
		int option = sc.nextInt();
		switch (option) {
		case 1:
			System.out.println("Enter city :");
			searchByCity(sc.next());
			break;
		case 2:
			System.out.println("Enter State :");
			searchByState(sc.next());
			break;
		default:
			searchContact();
			break;
		}
	}

	// search contact by city
	void searchByCity(String city) {
		System.out.println("Search Result: ");
		for (String addressBookName : addressBookList.keySet()) {// returns a set view of the keys contained in map
			// forEach iterate through every element of the stream
			addressBookList.get(addressBookName).stream().forEach((person) -> {
				if (person.getCity().equalsIgnoreCase(city))
					System.out.println(person);// we will get contacts whose city is same
			});
		}
	}

	// search contact by state
	void searchByState(String state) {
		System.out.println("Search Result: ");
		for (String addressBookName : addressBookList.keySet()) {// returns a set view of the keys contained in map
			// forEach iterate through every element of the stream
			addressBookList.get(addressBookName).stream().forEach((person) -> {
				if (person.getState().equalsIgnoreCase(state))
					System.out.println(person);// we will get contacts whose state is same
			});
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book program");// display welcome message
		AddressBook addressBook = new AddressBook();// creating object of address book
		Scanner sc = new Scanner(System.in);// create an object of scanner class

		boolean flag1 = true;
		while (flag1) {
			System.out.println("*************\n" + addressBook.addressBookList.keySet());
			System.out.println("current AddressBook Name: " + addressBook.currentAddressBookName);
			System.out.println(
					"************\nSelect Option :\n1.Add Contact\n2.Edit Contact\n3.Delete Contact\n4.Display contact\n5.Add New Address Book\n6.Select Address Book\n7.Search contact\n8.Exit");
			int option = sc.nextInt();
			switch (option) { // select option
			case 1:
				ContactPerson contactPerson = addressBook.createContact();
				addressBook.addContact(contactPerson);
				break;
			case 2:
				addressBook.editContact();
				break;
			case 3:
				addressBook.deleteContact();
				break;
			case 4:
				addressBook.displayContact(currentAddressBook);
				break;
			case 5:
				addressBook.addNewAddressBook();
				break;
			case 6:
				addressBook.selectAddressBook();
				break;
			case 7:
				addressBook.searchContact();
				break;
			case 8:
				flag1 = false;
				break;
			default:
				System.out.println(option + " is not valid option");
				break;
			}
		}
	}
}