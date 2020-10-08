package com.capgemini.training.model;

import java.util.Comparator;

public class SortByZip implements Comparator<Contact> {
	@Override
	public int compare(Contact c1, Contact c2) {
		if (c1.getZip() == c2.getZip())
			return 0;
		else if (c1.getZip() > c2.getZip())
			return 1;
		else
			return -1;
	}

}
