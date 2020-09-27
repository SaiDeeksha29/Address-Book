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
			System.out.println("Menu : \n1.Add Contact\n2.Exit");
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
				break;
			}
		}
	}
}