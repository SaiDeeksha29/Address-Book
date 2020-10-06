package com.capgemini.training.model;

import java.util.*;

public class AddressBookDictionary {

	private TreeMap<String, AddressBook> addressBookDictionary = new TreeMap<String, AddressBook>();

	public TreeMap<String, AddressBook> getAddressBookDictionary() {
		return addressBookDictionary;
	}

	public void setAddressBookDictionary(TreeMap<String, AddressBook> addressBookDictionary) {
		this.addressBookDictionary = addressBookDictionary;
	}

	public void addAddressBook(String AddressBookName, AddressBook aobj) {
		addressBookDictionary.put(AddressBookName, aobj);
	}

}
