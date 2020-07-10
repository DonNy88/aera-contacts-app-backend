package com.aera.contacts.service;

import com.aera.contacts.model.Contact;

public interface ContactService {

    Iterable<Contact> getAllContancts();
    Contact saveOrUpdateContact(Contact contact);
    void removeContact(String id);
}
