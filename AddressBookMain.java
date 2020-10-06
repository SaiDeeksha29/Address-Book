/**
 * 
 */
package com.capgemini.training.model;

import java.util.*;

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
				System.out.println("Menu : 1.Add Address Book\n2.Exit");
				System.out.println("Enter your choice : ");
				int ch1 = sc.nextInt();
				if (ch1 == 1) {
					System.out.println("Enter the Address Book Name : ");
					sc.nextLine();
					String abn = sc.nextLine();

					AddressBook ab = new AddressBook();

					abd.addAddressBook(abn, ab);
					while (true) {
						System.out.println(
								"Menu : \n1.Add Contact\n2.Update Contact\n3.Delete Contact\n4.Exit");
						System.out.println("Enter your choice : ");
						int ch = sc.nextInt();
						if (ch == 1) {
							System.out.println("Add Contact in Address Book : ");
							System.out.println("First Name : ");
							String fn = sc.nextLine();
							sc.nextLine();
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
							Contact obj1 = new Contact(fn, ln, add, city, state, zip, ph, email);
							if (ab.duplicateCheck(fn, ln) == true) {
								System.out.println("The name exists already");
								System.out.println("First Name : ");
								fn = sc.nextLine();
								System.out.println("Last Name : ");
								ln = sc.nextLine();
								System.out.println("Address : ");
								add = sc.nextLine();
								System.out.println("City : ");
								city = sc.nextLine();
								System.out.println("State : ");
								state = sc.nextLine();
								System.out.println("Zip : ");
								zip = sc.nextInt();
								System.out.println("Phone Number : ");
								ph = sc.nextLong();
								System.out.println("Email : ");
								email = sc.nextLine();
								sc.nextLine();
								Contact obj2 = new Contact(fn, ln, add, city, state, zip, ph, email);
								ab.addContact(obj2);
								System.out.println("Contact added successfully");
							} else {
								ab.addContact(obj1);
								System.out.println("Contact added successfully");
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
							break;
						}
					}
				} else if (ch1 == 2) {
					break;
				}
			}

		}
	}
}
