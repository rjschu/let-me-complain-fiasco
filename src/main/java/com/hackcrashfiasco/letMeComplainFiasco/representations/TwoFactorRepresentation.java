package com.hackcrashfiasco.letMeComplainFiasco.representations;

public class TwoFactorRepresentation {

    private long telephoneNumber;
    private String code;
    private String emailAddress;

    public long getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getCode() {
        return code;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
