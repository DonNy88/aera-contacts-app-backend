package com.aera.contacts.service;

import com.aera.contacts.model.Contact;

import java.util.List;
import java.util.Set;

public interface ContactService {

    /**
     * Get all contacts saved on DB
     *
     */
    List<Contact> getAllContacts();

    /**
     * Save or update a contact on DB. If the input has the id field
     * and that id is already present on the DB will be update, otherwise it will be saved.
     *
     */
    Contact saveOrUpdateContact(Contact contact);

    /**
     * Remove a contact by id
     *
     */
    void removeContact(String id);

    /**
     * Performed a search for matche in the phoneNumber field and/or
     * for full text in the other fields
     *
     */
    Set<Contact> search(String text, String phoneNumber);
}
