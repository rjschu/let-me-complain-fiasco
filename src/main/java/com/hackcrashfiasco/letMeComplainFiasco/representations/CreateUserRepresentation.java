package com.hackcrashfiasco.letMeComplainFiasco.representations;

import com.hackcrashfiasco.letMeComplainFiasco.domain.User;
import sun.misc.MessageUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CreateUserRepresentation extends UserRepresentation{

    private String password;

    public CreateUserRepresentation(){

    }

    public CreateUserRepresentation(User user){
        super(user);
        this.password = user.getPassword();
    }

    public String getPassword() {
        try {
            return new String(MessageDigest.getInstance("MD5").digest(password.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
