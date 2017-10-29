package com.hackcrashfiasco.letMeComplainFiasco.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackcrashfiasco.letMeComplainFiasco.configuration.AuthConfig;
import com.hackcrashfiasco.letMeComplainFiasco.domain.User;
import com.hackcrashfiasco.letMeComplainFiasco.filter.CurrentUserStorage;
import com.hackcrashfiasco.letMeComplainFiasco.representations.AuthorisationToken;
import com.hackcrashfiasco.letMeComplainFiasco.representations.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
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

    public String generateToken(Token payload) {
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

    public void setCurrentUser(String token) throws IOException {
        JWT jwt = JWT.decode(token);
        User user = objectMapper.readValue(jwt.getSubject(),User.class);
        CurrentUserStorage.setCurrentUser(user);
    }
}
