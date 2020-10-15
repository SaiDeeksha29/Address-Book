package com.capgemini.training.model;

import java.util.List;

public class AddressBookFile {
	public enum IOService {
		FILE_IO
	}

	private List<Contact> personsList;

	public AddressBookFile() {
	}

	public AddressBookFile(List<Contact> personsList) {
		this.personsList = personsList;
	}

	public void writePersonsData(IOService ioService) {
		if (ioService.equals(IOService.FILE_IO))
			new AddressBookFileIOService().writeData(personsList);
	}

	public List<Contact> readPersonsData(IOService ioService) {
		if (ioService.equals(IOService.FILE_IO))
			this.personsList = new AddressBookFileIOService().readData();
		return personsList;
	}
}
