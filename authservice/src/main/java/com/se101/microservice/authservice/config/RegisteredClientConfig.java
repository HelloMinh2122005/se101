package com.se101.microservice.authservice.config;

import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

@Configuration
public class RegisteredClientConfig {
    @Bean
    public RegisteredClientRepository registeredClientRepository() {
        RegisteredClient blogClient = RegisteredClient.withId(UUID.randomUUID().toString())
            .clientId("blog-client")
            .clientSecret("{noop}blog-secret")              
            .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
            .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
            .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
            .redirectUri("http://localhost:8093/login/oauth2/code/blog-client")
            .scope("blog.read")
            .tokenSettings(TokenSettings.builder()
                .accessTokenTimeToLive(java.time.Duration.ofHours(1)) // Thời gian sống của access token
                .build())
            .build();

        return new InMemoryRegisteredClientRepository(blogClient);
    }
}