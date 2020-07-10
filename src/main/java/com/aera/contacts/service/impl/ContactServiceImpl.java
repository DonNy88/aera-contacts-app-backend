package com.aera.contacts.service.impl;

import com.aera.contacts.model.Contact;
import com.aera.contacts.repository.ElasticSearchContactRepository;
import com.aera.contacts.service.ContactService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ContactServiceImpl implements ContactService {

    private static Logger log = LogManager.getLogger(ContactServiceImpl.class);

    @Autowired
    ElasticSearchContactRepository repository;

    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;

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

    @Override
    public Set<Contact> search(Contact contact) {
        return repository.findByPhoneNumber(contact.getPhoneNumber());
    }
}
