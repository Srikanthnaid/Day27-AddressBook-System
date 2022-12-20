package Day27AddressBook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaFileMain {

	private static Scanner in = new Scanner(System.in);
	private static File file = new File("Addresses.txt");
	static List<JavaFile> people = new ArrayList<>();
	private static Object lastnameToFind;

	public static void main(String[] args) throws IOException {
		readPeopleFromFile();
		showMainMenu();
	}

	private static void findPerson() throws IOException {
		System.out.println("1. Find with name");
		System.out.println("2. Find with surname");

		String choice;
		do {
			choice = in.nextLine();
			switch (choice) {
			case "1":
				findByfirstName();
				break;
			case "2":
				findByLastname();
				break;
			default:
				System.out.print("Choose 1 or 2: ");
			}
		} while (!choice.equals("1") && !choice.equals("2"));
		System.out.println();
		showMainMenu();
	}

	private static void findByLastname() {
		System.out.print("Enter lastname: ");
		String surnameToFind = in.nextLine();
		int matches = 0;
		for (JavaFile J : people) {
			if (J.getLastName().equals(lastnameToFind)) {
				System.out.println(J);
				matches++;
			}
		}
		if (matches <= 0) {
			System.out.println("There is no person with this surname");
		}
	}

	private static void findByfirstName() {
		System.out.print("Enter first name: ");
		String nameToFind = in.nextLine();
		int matches = 0;
		for (JavaFile J : people) {
			if (J.getFirstName().equals(nameToFind)) {
				System.out.println(J);
				matches++;
			}
		}
		if (matches <= 0) {
			System.out.println("There is no person with this name ");
		}
	}

	private static void addPerson() throws IOException {

		System.out.println("Enter Firstname: ");
		String name = in.nextLine();
		System.out.println("Enter Lastname: ");
		String surname = in.nextLine();
		System.out.println("Enter phone number: ");
		String phoneNumber = in.nextLine();
		System.out.println("Enter email: ");
		String email = in.nextLine();
		System.out.println("Enter addres: ");
		String address = in.nextLine();

		JavaFile J = new JavaFile(name, surname, phoneNumber, email, address);
		addToFile(J);
		people.add(J);
		String id = null;
		System.out.println("Added person number: " + id + J);
		System.out.println();
		showMainMenu();
	}

	private static void addToFile(JavaFile J) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
			writer.write(J.getFirstName() + "\r\n" + J.getLastName() + "\r\n" + J.getPhoneNumber() + "\r\n"
					+ J.getEmail() + "\r\n" + J.getAddress() + "\r\n\r\n");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private static boolean readPeopleFromFile() throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String name = null;
			while ((name = reader.readLine()) != null) {
				JavaFile J = new JavaFile(name, reader.readLine(), reader.readLine(), reader.readLine(),
						reader.readLine());
				people.add(J); // adds person to the list
				reader.readLine();
			}
			return true;
		} catch (IOException e) {
			System.out.println(e);
		}
		return false;
	}

	private static void showMainMenu() throws IOException {
		System.out.println("1. Add person");
		System.out.println("2. Find person");
		System.out.println("3. Show all contacts");
		System.out.println("4. Close program");

		String choice;
		do {
			choice = in.nextLine();
			switch (choice) {
			case "1":
				addPerson();
				break;
			case "2":
				findPerson();
				break;
			case "3":
				System.out.println(people);
				System.out.println();
				showMainMenu();
				break;
			case "4":
				System.exit(0);
				break;
			default:
				System.out.println("Enter number from 1 to 4");
			}
		} while (!choice.equals("4"));
	}
}