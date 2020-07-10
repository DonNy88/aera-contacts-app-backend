package com.aera.contacts.service.impl;

import com.aera.contacts.controller.ContactsController;
import com.aera.contacts.model.Contact;
import com.aera.contacts.repository.ElasticSearchContactRepository;
import com.aera.contacts.service.ContactService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private static Logger log = LogManager.getLogger(ContactServiceImpl.class);

    @Autowired
    ElasticSearchContactRepository repository;

    @Override
    public Iterable<Contact> getAllContancts() {
        return repository.findAll();
    }

    @Override
    public Contact saveOrUpdateContact(Contact contact) {
        return repository.save(contact);
    }

    @Override
    public void removeContact(String id) {
        repository.deleteById(id);
    }
}
