package com.hackcrashfiasco.letMeComplainFiasco.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackcrashfiasco.letMeComplainFiasco.configuration.AuthConfig;
import com.hackcrashfiasco.letMeComplainFiasco.representations.AuthorisationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class JWTService {

    private static final int TWENTY_FOUR_HOURS = 86400;
    private final ObjectMapper objectMapper;

    private String secret;
    private int expireTime = TWENTY_FOUR_HOURS;
    private Algorithm algorithm;

    @Autowired
    public JWTService(AuthConfig authConfig, ObjectMapper objectMapper){
        this.expireTime = TWENTY_FOUR_HOURS;
        this.secret = authConfig.getSecret();
        this.objectMapper = objectMapper;
        algorithm = Algorithm.HMAC256("secret".getBytes());
    }

    public String generateToken(AuthorisationToken payload) {
        Date date = Date.from(LocalDateTime.now().plusHours(1l).toInstant(ZoneOffset.UTC));
        try {
            String stringPayload = objectMapper.writeValueAsString(payload);
            return JWT.create().withSubject(stringPayload).withExpiresAt(date).sign(algorithm);
        } catch (JsonProcessingException e) {
           throw new RuntimeException();
        }
    }

    public void validateToken(String token) {
        JWTVerifier verifier = JWT.require(algorithm).build();
        verifier.verify(token);
    }

}
