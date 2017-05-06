package com.pranavanurag.phonebook.service;

import java.util.List;

import com.pranavanurag.phonebook.model.Contact;

public interface ContactService {
    public List<Contact> getAllContacts();

    public Contact getContactById(int id);

    public void addContact(Contact contact);

    public void deleteContactById(int id);

    public void deleteAll();

    public void updateContact(Contact contact);
}
