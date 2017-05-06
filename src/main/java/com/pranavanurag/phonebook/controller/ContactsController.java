package com.pranavanurag.phonebook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.pranavanurag.phonebook.model.Contact;

@RestController
public class ContactsController {

    @RequestMapping("/contacts.json")
    public String servePhonebookJSON() {
        List <Contact> contacts = new ArrayList<Contact>();         
        
        contacts.add(new Contact("NGolo Kante", 7777777777L));
        contacts.add(new Contact("Eden Hazard", 1010101010L));
        contacts.add(new Contact("David Luiz", 3030303030L));
        contacts.add(new Contact("Cesc Fabregas", 4444444444L));
        contacts.add(new Contact("Deigo Costa", 1919191919L));
        
        String JSONData = new Gson().toJson(contacts);
        
        return JSONData;
    }
}