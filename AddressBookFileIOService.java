package com.capgemini.training.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class AddressBookFileIOService {

	private static String ADDRESSBOOK_FILE_NAME = "src/addressbook-file.txt";

	public void writeData(List<Contact> employeePayrollList) {
		StringBuffer employeeBuffer = new StringBuffer();
		employeePayrollList.forEach(employee -> {
			String employeeDataString = employee.toString().concat("\n");
			employeeBuffer.append(employeeDataString);
		});
		try {
			Files.write(Paths.get(ADDRESSBOOK_FILE_NAME), employeeBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Contact> readData() {
		List<Contact> employeePayrollList = new ArrayList<>();
		try {
			Files.lines(new File(ADDRESSBOOK_FILE_NAME).toPath()).map(line -> line.trim())
					.forEach(line -> System.out.println(line));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employeePayrollList;
	}

}
