package com.hackcrashfiasco.letMeComplainFiasco.service;

import com.hackcrashfiasco.letMeComplainFiasco.controller.exceptions.NotFoundException;
import com.hackcrashfiasco.letMeComplainFiasco.domain.User;
import com.hackcrashfiasco.letMeComplainFiasco.entity.UserEntity;
import com.hackcrashfiasco.letMeComplainFiasco.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public User createUser(User user){
        return userRepository.insert(new UserEntity(user)).toDomain();
    }

    public User findUserByEmailAddress(String emailAddress){
        return this.userRepository.findUserByEmailAddress(emailAddress)
                .map(UserEntity::toDomain)
                .orElseThrow(NotFoundException::new);
    }


    public User findUserByTelephoneNumber(long telephoneNumber) {
        return userRepository.findUserByTelephoneNumber(telephoneNumber).map(UserEntity::toDomain).orElseThrow(NotFoundException::new);
    }
}
