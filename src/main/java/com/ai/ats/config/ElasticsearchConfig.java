
package com.ai.ats.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.List;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.ai.ats.repository")
public class ElasticsearchConfig extends ElasticsearchConfiguration {


    @Override
    public ClientConfiguration clientConfiguration() {

//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(List.of(MediaType.ALL));
//        headers.setContentType(MediaType.APPLICATION_JSON);


        return ClientConfiguration.builder()
                .connectedTo("localhost:9200")
//                .withDefaultHeaders(headers)
                .build();
    }
}

