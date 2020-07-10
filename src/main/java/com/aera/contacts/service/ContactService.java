package com.aera.contacts.service;

import com.aera.contacts.model.Contact;

import java.util.Set;

public interface ContactService {

    /**
     * Get all contants saved on DB
     *
     * @return an Iterable list of Contact
     */
    Iterable<Contact> getAllContancts();


    Contact saveOrUpdateContact(Contact contact);
    void removeContact(String id);
    Set<Contact> search(String text, String phoneNumber);
}
