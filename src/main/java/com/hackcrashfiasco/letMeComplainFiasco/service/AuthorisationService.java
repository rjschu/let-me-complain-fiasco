package com.hackcrashfiasco.letMeComplainFiasco.service;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.hackcrashfiasco.letMeComplainFiasco.controller.exceptions.NotAuthorisedException;
import com.hackcrashfiasco.letMeComplainFiasco.domain.User;
import com.hackcrashfiasco.letMeComplainFiasco.representations.AuthenticationRepresentation;
import com.hackcrashfiasco.letMeComplainFiasco.representations.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class AuthorisationService {

    private final JWTService jwtService;
    private final UserService userService;

    @Autowired
    public AuthorisationService(JWTService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    public User authenticateUser(AuthenticationRepresentation authenticationRepresentation) {
        User user = userService.findUserByEmailAddress(authenticationRepresentation.getEmailAddress());
        byte[] password = null;
        try {
            password = MessageDigest.getInstance("MD5").digest(authenticationRepresentation.getPassword().getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if(user.getPassword().equals(new String(password))){
            return user;
        }else{
            throw new NotAuthorisedException();
        }
    }

    public boolean isAuthorised(String token){
        try {
            jwtService.validateToken(token);
            return true;
        }catch (JWTVerificationException ex){
            return false;
        }
    }

    public String getToken(Token payload){
        return jwtService.generateToken(payload);
    }
}
