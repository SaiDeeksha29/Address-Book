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
		Scanner sc = new Scanner(System.in);
		AddressBook ab = new AddressBook();
		while (true) {
			System.out.println("Menu : \n1.Add Contact\n2.Update Contact\n3.Delete Contact\n4.Exit");
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
				ab.addContact(obj1);
			} else if (ch == 2) {
				ArrayList<Contact> all = new ArrayList<Contact>();
				if (all.isEmpty())
					System.out.println("The list is empty");
				else {
					System.out.println("Enter the First Name to update : ");
					String ema = sc.nextLine();
					sc.nextLine();
					all = ab.updateByFirstName(ema);
					System.out.println("Select the detail to be updated : ");
					System.out.println(
							"1.First Name\n2.Last Name\n3.Address\n4.City\n5.State\n6.Zip\n7.Phone Number\n8.Email");
					int c = sc.nextInt();
					for (Contact obj2 : all) {
						switch (c) {
						case 1:
							String fn1 = sc.nextLine();
							sc.nextLine();
							obj2.setFirstName(fn1);
							break;
						case 2:
							String ln1 = sc.nextLine();
							sc.nextLine();
							obj2.setLastName(ln1);
							break;
						case 3:
							String add1 = sc.nextLine();
							sc.nextLine();
							obj2.setAddress(add1);
							break;
						case 4:
							String city1 = sc.nextLine();
							sc.nextLine();
							obj2.setCity(city1);
							break;
						case 5:
							String state1 = sc.nextLine();
							sc.nextLine();
							obj2.setState(state1);
							break;
						case 6:
							int zip1 = sc.nextInt();
							obj2.setZip(zip1);
							break;
						case 7:
							long ph1 = sc.nextLong();
							obj2.setPhone(ph1);
							break;
						case 8:
							String email1 = sc.nextLine();
							sc.nextLine();
							obj2.setEmail(email1);
							break;
						}
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
	}
}