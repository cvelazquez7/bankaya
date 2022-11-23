package com.bankaya.challenge.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateClient {

    /**
     * Creates a single instance of rest template to be injected into any other component
     *
     * @param builder Builder that can be used to configure and create a RestTemplate
     * @return RestTemplate Bean
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}