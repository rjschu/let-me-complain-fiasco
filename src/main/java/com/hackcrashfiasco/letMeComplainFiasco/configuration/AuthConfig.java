package com.hackcrashfiasco.letMeComplainFiasco.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConfig {
    private String secret;

    public String getSecret() {
        return secret;
    }
}
