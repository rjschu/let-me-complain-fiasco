package com.hackcrashfiasco.letMeComplainFiasco.entity;


import com.hackcrashfiasco.letMeComplainFiasco.domain.User;
import com.hackcrashfiasco.letMeComplainFiasco.enums.Gender;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "users")
public class UserEntity {


    @Id
    private ObjectId id;

    private String firstName;
    private String surname;
    private int age;
    private LocalDate dateOfBirth;
    private Gender gender;
    private long telephoneNumber;
    @Indexed(unique = true)
    private String emailAddress;
    private String password;

    public UserEntity(){}


    public UserEntity(User user) {
        user.getId().ifPresent((id)->{
            this.id = new ObjectId(id);
        });
        firstName = user.getFirstName();
        surname = user.getSurname();
        age = user.getAge();
        dateOfBirth = user.getDateOfBirth();
        gender = user.getGender();
        telephoneNumber = user.getTelephoneNumber();
        emailAddress = user.getEmailAddress();
        password = user.getPassword();
    }

    public ObjectId getId() {
        return id;
    }

    public String getEmailAddress() {
        return emailAddress;
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

    public Gender getGender() {
        return gender;
    }

    public long getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public User toDomain() {
        if(this.id == null){
            return null;
        }

        User user = new User();
        user.setId(id.toHexString());
        user.setFirstName(firstName);
        user.setSurname(surname);
        user.setDateOfBirth(dateOfBirth);
        user.setAge(age);
        user.setGender(gender);
        user.setTelephoneNumber(telephoneNumber);
        user.setEmailAddress(emailAddress);
        user.setPassword(password);

        return user;
    }

}
