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

		java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AddressBookMain.class.getName());

		logger.info("Welcome to Address Book program in AddressBookMain class on Master branch");

		try (Scanner sc = new Scanner(System.in)) {
			AddressBookDictionary abd = new AddressBookDictionary();
			while (true) {
				logger.info(
						"Menu :\n1.Add Address Book\n2.Search Persons and their count in a City\n3.Search Persons and their count in a State\n4.Exit");
				logger.info("Enter your choice : ");
				int ch1 = sc.nextInt();
				if (ch1 == 1) {
					logger.info("Enter the Address Book Name : ");
					sc.nextLine();
					String abn = sc.nextLine();

					AddressBook ab = new AddressBook();

					abd.addAddressBook(abn, ab);
					while (true) {
						logger.info(
								"Menu :\n1.Add Contact\n2.Update Contact\n3.Delete Contact\n4.View persons by City\n5.View persons by State\n6.List sort by name\n7.List sort by city\n8.List sort by state\n9.List sort by zip\n10.Exit");
						logger.info("Enter your choice : ");
						int ch = sc.nextInt();
						if (ch == 1) {
							logger.info("Add Contact in Address Book : ");
							sc.nextLine();
							logger.info("First Name : ");
							String fn = sc.nextLine();
							logger.info("Last Name : ");
							String ln = sc.nextLine();
							logger.info("Address : ");
							String add = sc.nextLine();
							logger.info("City : ");
							String city = sc.nextLine();
							logger.info("State : ");
							String state = sc.nextLine();
							logger.info("Zip : ");
							int zip = sc.nextInt();
							logger.info("Phone Number : ");
							long ph = sc.nextLong();
							logger.info("Email : ");
							String email = sc.nextLine();
							sc.nextLine();
							boolean duplicateCheck = (ab.getAddress()).stream().noneMatch(
									Contact -> Contact.getFirstName().equals(fn) && Contact.getLastName().equals(ln));

							if (duplicateCheck) {
								// Instantiation of Contact Class
								Contact contact = new Contact(fn, ln, add, city, state, zip, ph, email);
								System.out.println(contact);

								// Add New Contact into Address Book
								ab.addContact(new Contact(fn, ln, add, city, state, zip, ph, email));
							}
						} else if (ch == 2) {
							logger.info("Enter the First Name to update : ");
							String fn = sc.nextLine();
							sc.nextLine();
							logger.info("Enter the Last Name to update : ");
							String ln = sc.nextLine();
							Contact all = ab.updateDetails(fn, ln);
							if (all == null)
								logger.info("The list is empty");
							else {
								logger.info("Select the detail to be updated : ");
								logger.info(
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
							logger.info("Enter the Contact First Name to delete : ");
							String fn = sc.nextLine();
							sc.nextLine();
							logger.info("Enter the Contact Last Name to delete : ");
							String ln = sc.nextLine();
							if (ab.removeContact(fn, ln))
								logger.info("The contact is successfully deleted.");
							else {
								logger.info("No contact on the list");
							}
						} else if (ch == 4) {
							logger.info("Enter the city name : ");
							String city = sc.nextLine();
							List<Contact> personsByCity = new ArrayList<Contact>();
							personsByCity = (ab.getAddress()).stream().filter(Contact -> Contact.getCity().equals(city))
									.collect(Collectors.toList());
							for (Contact person : personsByCity) {
								logger.info(person.getFirstName() + " " + person.getLastName());
							}
						} else if (ch == 5) {
							logger.info("Enter the state name : ");
							String state = sc.nextLine();
							List<Contact> personsByState = new ArrayList<Contact>();
							personsByState = (ab.getAddress()).stream()
									.filter(Contact -> Contact.getState().equals(state)).collect(Collectors.toList());
							for (Contact person : personsByState) {
								logger.info(person.getFirstName() + " " + person.getLastName());
							}
						} else if (ch == 6) {
							List<String> sortedByName = new ArrayList<String>();
							sortedByName = (ab.getAddress()).stream().map(Contact -> Contact.toString()).sorted()
									.collect(Collectors.toList());
							for (String name : sortedByName)
								logger.info(name);
						} else if (ch == 7) {
							(ab.getAddress()).sort(new SortByCity());
							for (Contact city : ab.getAddress())
								System.out.println(city);
						} else if (ch == 8) {
							(ab.getAddress()).sort(new SortByState());
							for (Contact state : ab.getAddress())
								System.out.println(state);
						} else if (ch == 9) {
							(ab.getAddress()).sort(new SortByZip());
							for (Contact zip : ab.getAddress())
								System.out.println(zip);
						} else if (ch == 10) {
							break;
						}
					}
				} else if (ch1 == 2) {
					logger.info("Enter the City Name to Search for Persons :");
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
						logger.info(c + " " + countByCity);
				} else if (ch1 == 3) {
					logger.info("Enter the State Name to Search for Persons :");
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
						logger.info(c + " " + countByState);
					}
				} else if (ch1 == 4) {
					break;
				}
			}

		}
	}
}