package com.hackcrashfiasco.letMeComplainFiasco.representations;

import com.hackcrashfiasco.letMeComplainFiasco.domain.User;

import java.time.LocalDate;

public class AuthorisationToken implements Token {


    private final String firstName;
    private final String surname;
    private final int age;
    private final LocalDate dateOfBirth;
    private final String emailAddress;
    private final long telephoneNumber;

    public AuthorisationToken(User user) {
        firstName = user.getFirstName();
        surname = user.getSurname();
        age = user.getAge();
        dateOfBirth = user.getDateOfBirth();
        emailAddress = user.getEmailAddress();
        telephoneNumber = user.getTelephoneNumber();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public long getTelephoneNumber() {
        return telephoneNumber;
    }

}
