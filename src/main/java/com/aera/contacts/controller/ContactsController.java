package com.aera.contacts.controller;

import com.aera.contacts.model.Contact;
import com.aera.contacts.service.ContactService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactsController {

    private static Logger log = LogManager.getLogger(ContactsController.class);

    @Autowired
    ContactService service;

    @GetMapping("/contact")
    public Iterable<Contact> getAllContacts() {
        Iterable<Contact> contacts = service.getAllContancts();
        log.info("contants retrived: " + contacts);
        return contacts;
    }

    @PostMapping("/contact")
    @ResponseStatus(HttpStatus.CREATED)
    public Object addContact(@RequestBody Contact contact) {
        // TODO: input validation
        return service.saveOrUpdateContact(contact);
    }

    @PutMapping("/contact")
    public Object updateContact(@RequestBody Contact contact) {
        // TODO: input validation
        return service.saveOrUpdateContact(contact);
    }

    @DeleteMapping("/contact")
    public void deleteContact(@RequestParam String id) {
        service.removeContact(id);
    }
}
