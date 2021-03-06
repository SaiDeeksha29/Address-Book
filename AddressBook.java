package com.capgemini.training.model;

import java.util.*;

/**
 * @author saideeksha
 *
 */
public class AddressBook {

	private ArrayList<Contact> address = new ArrayList<Contact>();

	public ArrayList<Contact> getAddress() {
		return address;
	}

	public void setAddress(ArrayList<Contact> address) {
		this.address = address;
	}

	public void addContact(Contact cobj) {
		address.add(cobj);
	}

	public Contact updateDetails(String firstName, String lastName) {
		Contact contact = null;
		for (Contact contactSearch : address)
			if (contactSearch.getFirstName().equals(firstName) && contactSearch.getLastName().equals(lastName)) {
				contact = contactSearch;
			}
		return contact;
	}

	public boolean removeContact(String firstName,String lastName) {
		int val = 0;
		for (Contact obj : getAddress()) {
			if (obj.getFirstName().equals(firstName) && obj.getLastName().equals(lastName)) {
				address.remove(obj);
			}
			val = 1;
			break;
		}
		if (val == 1)
			return true;
		else {
			return false;
		}
	}
}
