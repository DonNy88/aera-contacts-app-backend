package com.aera.contacts.config;

import com.aera.contacts.service.impl.ContactServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.aera.contacts")
public class ElasticSearchConfig {

    private static Logger log = LogManager.getLogger(ContactServiceImpl.class);

    @Value("${com.aera.contacts.elasticsearch.host}")
    private String elasticsearchHost;

    @Value("${com.aera.contacts.elasticsearch.port}")
    private String elasticsearchPort;

    @Bean
    public RestHighLevelClient client() {
        ClientConfiguration clientConfiguration = ClientConfiguration
                .builder()
                .connectedTo(elasticsearchHost + ":" + elasticsearchPort)
                .build();

        log.info(elasticsearchHost + ":" + elasticsearchPort);

        return RestClients.create(clientConfiguration).rest();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(client());
    }
}