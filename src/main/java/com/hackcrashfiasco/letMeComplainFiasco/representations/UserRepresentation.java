package com.hackcrashfiasco.letMeComplainFiasco.representations;

import com.hackcrashfiasco.letMeComplainFiasco.domain.User;
import com.hackcrashfiasco.letMeComplainFiasco.enums.Gender;

import java.time.LocalDate;

public class UserRepresentation {

    private String id;
    private String firstName;
    private String surname;
    private int age;
    private LocalDate dateOfBirth;
    private Gender gender;
    private long telephoneNumber;
    private String emailAddress;

    public UserRepresentation() {
    }

    public UserRepresentation(User user) {
        id = user.getId().orElse("");
        firstName = user.getFirstName();
        surname = user.getSurname();
        age = user.getAge();
        dateOfBirth = user.getDateOfBirth();
        gender = user.getGender();
        telephoneNumber = user.getTelephoneNumber();
        emailAddress = user.getEmailAddress();
    }

    public String getId() {
        return id;
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

    public String getGender() {
        return gender.toString().toLowerCase();
    }

    public long getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
