package com.capgemini.training.model;

import java.util.Arrays;
import org.junit.Test;
import com.capgemini.training.model.AddressBookFile.IOService;

public class AddressBookMainTest {

	@Test
	public void writePayrollOnFile() {
		Contact[] arrayOfPersons = {
				new Contact("Monica", "Geller", "Manhattan", "NYC", "New York", 500001, 675341929, "monica@gmail.com"),
				new Contact("Joey", "Tribbiani", "Nationwide", "Dallas", "Texas", 200009, 678345216,
						"josephtribbiani@gmail.com") };
		AddressBookFile personsContact = new AddressBookFile();
		personsContact = new AddressBookFile(Arrays.asList(arrayOfPersons));
		personsContact.writePersonsData(IOService.FILE_IO);
	}

	@Test
	public void givenFileOnReadingFileShouldMatchEmployeeCount() {
		AddressBookFile personsContact = new AddressBookFile();
		personsContact.readPersonsData(IOService.FILE_IO);
	}
}
