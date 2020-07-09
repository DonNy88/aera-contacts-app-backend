package com.aera.contacts.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactsController {

    private static Logger log = LogManager.getLogger(ContactsController.class);

    @GetMapping("/contacts")
    public Object getAllContacts() {
        log.error("HOLAAAAAAA");
        return null;
    }
}
