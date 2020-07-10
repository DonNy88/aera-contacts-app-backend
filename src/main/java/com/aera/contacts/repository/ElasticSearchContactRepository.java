package com.aera.contacts.repository;

import com.aera.contacts.model.Contact;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ElasticSearchContactRepository extends ElasticsearchRepository<Contact, String> {

    Set<Contact> findByPhoneNumber(String phoneNumber);
}