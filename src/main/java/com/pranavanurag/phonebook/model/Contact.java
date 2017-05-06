package com.pranavanurag.phonebook.model;

public class Contact {
	private int id;
    private String name;
    private Long phoneNumber;

    public Contact(int id, String name, long phoneNumber) {
		this.setId(id);
    	this.name = name;
		this.phoneNumber = phoneNumber;
	}
    
    public Contact() {
    	
    }
    
    public Contact(Contact otherContact) {
    	this.id = otherContact.id;
    	this.name = otherContact.name;
    	this.phoneNumber = otherContact.phoneNumber;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}