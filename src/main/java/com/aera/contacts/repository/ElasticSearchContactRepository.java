package com.aera.contacts.repository;

import com.aera.contacts.model.Contact;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElasticSearchContactRepository extends ElasticsearchRepository<Contact, String> {

    // List<Contact> findAll();
}