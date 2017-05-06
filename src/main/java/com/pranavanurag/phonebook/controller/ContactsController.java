package com.pranavanurag.phonebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.pranavanurag.phonebook.model.Contact;
import com.pranavanurag.phonebook.service.ContactService;

@RestController
public class ContactsController {

	@Autowired
    private ContactService contactService;
	
    @RequestMapping("/contacts.json")
    public String servePhonebookJSON() {
        List <Contact> contacts = contactService.getAllContacts();
        String JSONData = new Gson().toJson(contacts);
        return JSONData;
    }

    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public @ResponseBody void addContact(@RequestBody Contact contact) {
        contactService.addContact(contact);
    }
    
    @RequestMapping(value = "/deleteAllContacts", method = RequestMethod.DELETE)
    public @ResponseBody void deleteAllContacts() {
        contactService.deleteAll();
    }
    
    @RequestMapping(value = "/deleteContact/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void removeContact(@PathVariable("id") int id) {
        contactService.deleteContactById(id);
    }
}