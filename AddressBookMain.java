/**
 * 
 */
package com.capgemini.training.model;

import java.util.*;
import java.util.stream.*;

/**
 * @author saideeksha
 *
 */
public class AddressBookMain {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Address Book program in AddressBookMain class on Master branch");

		try (Scanner sc = new Scanner(System.in)) {
			AddressBookDictionary abd = new AddressBookDictionary();
			while (true) {
				System.out.println(
						"Menu :\n1.Add Address Book\n2.Search Persons and their count in a City\n3.Search Persons and their count in a State\n4.View persons by City\n5.View persons by State\n6.List sort by name\n7.List sort by city\n8.List sort by state\n9.List sort by zip\n10.Exit");
				System.out.println("Enter your choice : ");
				int ch1 = sc.nextInt();
				if (ch1 == 1) {
					System.out.println("Enter the Address Book Name : ");
					sc.nextLine();
					String abn = sc.nextLine();

					AddressBook ab = new AddressBook();

					abd.addAddressBook(abn, ab);
					while (true) {
						System.out.println("Menu :\n1.Add Contact\n2.Update Contact\n3.Delete Contact\n4.Exit");
						System.out.println("Enter your choice : ");
						int ch = sc.nextInt();
						if (ch == 1) {
							System.out.println("Add Contact in Address Book : ");
							sc.nextLine();
							System.out.println("First Name : ");
							String fn = sc.nextLine();
							System.out.println("Last Name : ");
							String ln = sc.nextLine();
							System.out.println("Address : ");
							String add = sc.nextLine();
							System.out.println("City : ");
							String city = sc.nextLine();
							System.out.println("State : ");
							String state = sc.nextLine();
							System.out.println("Zip : ");
							int zip = sc.nextInt();
							System.out.println("Phone Number : ");
							long ph = sc.nextLong();
							System.out.println("Email : ");
							String email = sc.nextLine();
							sc.nextLine();
							boolean duplicateCheck = (ab.getAddress()).stream().noneMatch(
									Contact -> Contact.getFirstName().equals(fn) && Contact.getLastName().equals(ln));

							if (duplicateCheck) {
								// Instantiation of Contact Class
								Contact contact = new Contact(fn, ln, add, city, state, zip, ph, email);

								// Add New Contact into Address Book
								ab.addContact(contact);
							}
						} else if (ch == 2) {
							System.out.println("Enter the First Name to update : ");
							String fn = sc.nextLine();
							sc.nextLine();
							System.out.println("Enter the Last Name to update : ");
							String ln = sc.nextLine();
							Contact all = ab.updateDetails(fn, ln);
							if (all == null)
								System.out.println("The list is empty");
							else {
								System.out.println("Select the detail to be updated : ");
								System.out.println(
										"1.First Name\n2.Last Name\n3.Address\n4.City\n5.State\n6.Zip\n7.Phone Number\n8.Email");
								int c = sc.nextInt();
								switch (c) {
								case 1:
									String fn1 = sc.nextLine();
									sc.nextLine();
									all.setFirstName(fn1);
									break;
								case 2:
									String ln1 = sc.nextLine();
									sc.nextLine();
									all.setLastName(ln1);
									break;
								case 3:
									String add1 = sc.nextLine();
									sc.nextLine();
									all.setAddress(add1);
									break;
								case 4:
									String city1 = sc.nextLine();
									sc.nextLine();
									all.setCity(city1);
									break;
								case 5:
									String state1 = sc.nextLine();
									sc.nextLine();
									all.setState(state1);
									break;
								case 6:
									int zip1 = sc.nextInt();
									all.setZip(zip1);
									break;
								case 7:
									long ph1 = sc.nextLong();
									all.setPhone(ph1);
									break;
								case 8:
									String email1 = sc.nextLine();
									sc.nextLine();
									all.setEmail(email1);
									break;
								}
							}
						} else if (ch == 3) {
							System.out.println("Enter the Contact First Name to delete : ");
							String em = sc.nextLine();
							sc.nextLine();
							if (ab.removeContact(em))
								System.out.println("The contact is successfully deleted.");
							else {
								System.out.println("No contact on the list");
							}
						} else if (ch == 4) {
							System.out.println("Enter the city name : ");
							String city = sc.nextLine();
							List<Contact> personsByCity = new ArrayList<Contact>();
							personsByCity = (ab.getAddress()).stream().filter(Contact -> Contact.getCity().equals(city))
									.collect(Collectors.toList());
							for (Contact person : personsByCity) {
								System.out.println(person.getFirstName() + " " + person.getLastName());
							}
						} else if (ch == 5) {
							System.out.println("Enter the state name : ");
							String state = sc.nextLine();
							List<Contact> personsByState = new ArrayList<Contact>();
							personsByState = (ab.getAddress()).stream()
									.filter(Contact -> Contact.getState().equals(state)).collect(Collectors.toList());
							for (Contact person : personsByState) {
								System.out.println(person.getFirstName() + " " + person.getLastName());
							}
						} else if (ch == 6) {
							List<String> sortedByName = new ArrayList<String>();
							sortedByName = (ab.getAddress()).stream().map(Contact -> Contact.toString()).sorted()
									.collect(Collectors.toList());
							for (String name : sortedByName)
								System.out.println(name);
						} else if (ch == 7) {
							List<String> sortedByCity = new ArrayList<String>();
							sortedByCity = (ab.getAddress()).stream().map(Contact -> Contact.getCity()).sorted()
									.collect(Collectors.toList());
							for (String city : sortedByCity)
								System.out.println(city);
						} else if (ch == 8) {
							List<String> sortedByState = new ArrayList<String>();
							sortedByState = (ab.getAddress()).stream().map(Contact -> Contact.getState()).sorted()
									.collect(Collectors.toList());
							for (String state : sortedByState)
								System.out.println(state);
						} else if (ch == 9) {
							List<Integer> sortedByZip = new ArrayList<Integer>();
							sortedByZip = (ab.getAddress()).stream().map(Contact -> Contact.getZip()).sorted()
									.collect(Collectors.toList());
							for (Integer zip : sortedByZip)
								System.out.println(zip);
						} else if (ch == 10) {
							break;
						}
					}
				} else if (ch1 == 2) {
					System.out.println("Enter the City Name to Search for Persons :");
					sc.nextLine();
					String citySearch = sc.nextLine();
					long countByCity = 0;
					List<Contact> contactList = new ArrayList<>();
					for (AddressBook book : (abd.getAddressBookDictionary().values())) {
						contactList = (book.getAddress()).stream()
								.filter(Contact -> (Contact.getCity()).equalsIgnoreCase(citySearch))
								.collect(Collectors.toList());
						countByCity = contactList.stream().count();
					}
					for (Contact c : contactList)
						System.out.println(c + " " + countByCity);
				} else if (ch1 == 3) {
					System.out.println("Enter the State Name to Search for Persons :");
					sc.nextLine();
					String stateSearch = sc.nextLine();
					long countByState = 0;
					List<Contact> contactList = new ArrayList<>();
					for (AddressBook book : (abd.getAddressBookDictionary().values())) {
						contactList.addAll((book.getAddress()).stream()
								.filter(Contact -> (Contact.getState()).equalsIgnoreCase(stateSearch))
								.collect(Collectors.toList()));
						countByState = contactList.stream().count();
					}
					for (Contact c : contactList) {
						System.out.println(c + " " + countByState);
					}
				} else if (ch1 == 4) {
					break;
				}
			}

		}
	}
}