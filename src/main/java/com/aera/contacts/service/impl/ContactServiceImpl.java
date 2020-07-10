package com.aera.contacts.service.impl;

import com.aera.contacts.model.Contact;
import com.aera.contacts.repository.ElasticSearchContactRepository;
import com.aera.contacts.service.ContactService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ContactServiceImpl implements ContactService {

    private static Logger log = LogManager.getLogger(ContactServiceImpl.class);

    final ElasticSearchContactRepository repository;
    final ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    public ContactServiceImpl(ElasticSearchContactRepository repository,
                              ElasticsearchRestTemplate elasticsearchRestTemplate) {
        this.repository = repository;
        this.elasticsearchRestTemplate = elasticsearchRestTemplate;
    }

    @Override
    public List<Contact> getAllContacts() {
        List<Contact> result = new ArrayList<>();

        repository.findAll().forEach(contact -> result.add(contact));

        return result;
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
    public Set<Contact> search(String text, String phoneNumber) {
        Set<Contact> fullTextQueryResult = fullTextQuery(text)
                .getSearchHits()
                .stream().map(elem -> elem.getContent())
                .collect(Collectors.toSet());
        log.debug("search by fulltext search: " + fullTextQueryResult);

        Set<Contact> phoneNumberMetchSearchResult = repository.findByPhoneNumber(phoneNumber);
        log.debug("search by phoneNumber match: " + phoneNumberMetchSearchResult);

        Set<Contact> mergeResult = Stream.of(fullTextQueryResult, phoneNumberMetchSearchResult)
                .flatMap(elem -> elem.stream())
                .collect(Collectors.toSet());

        log.debug("search result: " + mergeResult);
        return mergeResult;
    }

    private SearchHits<Contact> fullTextQuery(String text) {
        Query query = new NativeSearchQueryBuilder().withQuery(QueryBuilders.multiMatchQuery(text)
                .field("name")
                .field("surname")
                .field("email")
                .field("address")
                .field("otherInfo")
                .type(MultiMatchQueryBuilder.Type.BEST_FIELDS)).build();

        return elasticsearchRestTemplate.search(query, Contact.class);
    }
}
