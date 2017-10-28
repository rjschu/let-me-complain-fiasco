package com.hackcrashfiasco.letMeComplainFiasco.domain;

import com.hackcrashfiasco.letMeComplainFiasco.enums.Gender;
import com.hackcrashfiasco.letMeComplainFiasco.representations.UserRepresentation;

import java.time.LocalDate;
import java.util.Optional;

public class User {

    private String id;
    private String firstName;
    private String surname;
    private int age;
    private LocalDate dateOfBirth;
    private Gender gender;
    private long telephoneNumber;
    private String emailAddress;

    public User() {

    }


    public User(UserRepresentation userToCreate) {
        firstName = userToCreate.getFirstName();
        surname = userToCreate.getSurname();
        age = userToCreate.getAge();
        dateOfBirth = userToCreate.getDateOfBirth();
        gender = Gender.valueOf(userToCreate.getGender());
        telephoneNumber = userToCreate.getTelephoneNumber();
        emailAddress = userToCreate.getEmailAddress();
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public long getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
