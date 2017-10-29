package com.hackcrashfiasco.letMeComplainFiasco.domain;

import com.hackcrashfiasco.letMeComplainFiasco.representations.Token;

public class TwoFactor implements Token {

    private long telephoneNumber;
    private String code;
    private String emailAddress;

    public long getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
