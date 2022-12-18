package Day27AddressBook;

import java.util.Scanner;
import java.util.*;

public class AddressBook {

	Scanner sc = new Scanner(System.in);
	ArrayList<ContactPerson> addressBook1 = new ArrayList<>();
	ContactPerson person = new ContactPerson();

	public ContactPerson createContact() {

		System.out.print("Enter First Name: ");
		person.setFirstName(sc.next());
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

	// addContact method using to add contact to addressbook
	public void addContact() {
		ContactPerson contactPerson = createContact();
		addressBook1.add(contactPerson);
		System.out.println("Contact added successfully");
	}

	public void editContact() {
		// ContactPerson person = new ContactPerson();
		System.out.print("Enter First Name:");
		String editName = sc.next();
		boolean edited = false;
		boolean result = addressBook1.stream().anyMatch(a -> addressBook1.contains(editName) == equals(addressBook1));
		System.out.println(result);// true
		// Check name == editName.
		if (result == true) {
			System.out.println("Name is Match  \nnow Edit contact");
			System.out.println(
					"FirstName match  \n choose which one you want to change  \n Enter 1 to change firatName  \nEnter 2 to change LastName  \nEnter 3 to change address  \nEnter 4 to change city  \nEnter 5 to change state  \nEnter 6 to change ZipCode  \nEnter 7 to change MobNumber  \nEnter 8 to change E-Mail Address");
			int input = sc.nextInt();
			switch (input) {
			case 1 -> {
				System.out.print("Enter firstname: ");
				person.setFirstName(sc.next());
				break;
			}
			case 2 -> {
				System.out.print("Enter lastname: ");
				person.setLastName(sc.next());
				break;
			}
			case 3 -> {
				System.out.print("Enter Address: ");
				person.setAddress(sc.next());
				break;
			}
			case 4 -> {
				System.out.print("Enter City: ");
				person.setCity(sc.next());
				break;
			}
			case 5 -> {
				System.out.print("Enter State: ");
				person.setState(sc.next());
				break;
			}
			case 6 -> {
				System.out.print("Enter ZipCode: ");
				person.setZipCode(sc.nextInt());
				break;
			}
			case 7 -> {
				System.out.print("Enter PhoneNumber: ");
				person.setPhoneNumber(sc.nextLong());
				break;
			}
			case 8 -> {
				System.out.print("Enter E-Mail Address: ");
				person.setEmail(sc.next());
				break;
			}
			}

			edited = true;
		}

		if (!edited) {
			System.out.println("This name does not exist");
		}
		addressBook1.stream().forEach(a -> System.out.println(a));
	}

	public void deleteContact() {
		// ContactPerson person = new ContactPerson();
		System.out.print("Enter First Name:");
		String editName = sc.next();
		boolean result = addressBook1.stream().anyMatch(a -> addressBook1.contains(editName) == equals(addressBook1));
		System.out.println(result);// true
		if (result == true)
			addressBook1.remove(person);
		System.out.println("Delete Successfully!");
		System.out.println(addressBook1);
		if (!true)
			System.out.println("Name not existing in Addressbook");
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book program");
		AddressBook addressBook = new AddressBook();
		Scanner sc = new Scanner(System.in);

		boolean flag1 = true;
		while (flag1) {

			System.out.println("******************\nSelect Option :");
			System.out.println("1.Add Contact\n2.Edit Contact\n3.Delete Contact \n4.Exit");
			int option = sc.nextInt();
			switch (option) {
			case 1 -> addressBook.addContact();
			case 2 -> addressBook.editContact();
			case 3 -> addressBook.deleteContact();
			case 4 -> System.exit(0);
			default -> System.out.println("invalid input");
			}
		}
	}
}