package com.capgemini.training.model;

import java.util.Comparator;

public class SortByState implements Comparator<Contact> {
	@Override
	public int compare(Contact o1, Contact o2) {
		// TODO Auto-generated method stub
		return o1.getState().compareTo(o2.getState());
	}

}
