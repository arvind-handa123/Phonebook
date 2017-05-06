package com.pranavanurag.phonebook.model;

public class Contact {
    private String name;
    private Long phoneNumber;

    public Contact(String name, long phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}