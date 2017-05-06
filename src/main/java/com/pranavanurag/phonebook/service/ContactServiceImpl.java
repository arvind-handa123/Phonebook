package com.pranavanurag.phonebook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pranavanurag.phonebook.model.Contact;

@Service("contactService")
public class ContactServiceImpl implements ContactService {
    private static List<Contact> contactList = new ArrayList<Contact>();
    private static int id = 0;	

    @Override
    public List<Contact> getAllContacts() {
        return contactList;
    }

    @Override
    public Contact getContactById(int id) {
        return findContactById(id);
    }

    @Override
    public void addContact(Contact contact) {
        contact.setId(++id);
        contactList.add(contact);
    }

    @Override
    public void deleteContactById(int id) {
        Contact foundContact = findContactById(id);
        if (foundContact != null) {
            contactList.remove(foundContact);
            id--;
        }
    }

    @Override
    public void deleteAll() {
        contactList.clear();
        id = 0;
    }

    @Override
    public void updateContact(Contact contact) {
        Contact foundContact = findContactById(contact.getId());
        if (foundContact != null) {
            contactList.remove(foundContact);
            contactList.add(contact);
        }
    }

    private Contact findContactById(int id) {
        for (Contact contact : contactList) {
            if (contact.getId() == id) {
                return contact;
            }
        }

        return null;
    }
}
