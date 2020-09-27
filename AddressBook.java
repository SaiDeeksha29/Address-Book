package com.capgemini.training.model;

import java.util.ArrayList;

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

	public ArrayList<Contact> updateByFirstName(String first) {
		ArrayList<Contact> obj = new ArrayList<Contact>();
		for (int i = 0; i < address.size(); i++) {
			if (address.get(i).getFirstName().contains(first)) {
				obj.add(address.get(i));
			}
		}
		return obj;
	}

}
