package com.se101.microservice.authservice.config;

import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;

@Configuration
public class RegisteredClientConfig {
    @Bean
    public RegisteredClientRepository registeredClientRepository() {
        RegisteredClient blogClient = RegisteredClient.withId(UUID.randomUUID().toString())
            .clientId("blog-client")
            .clientSecret("{noop}blog-secret")              
            .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
            .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
            .scope("blog.read")
            .build();

        return new InMemoryRegisteredClientRepository(blogClient);
    }
}