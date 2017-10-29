package com.hackcrashfiasco.letMeComplainFiasco.repository;

import com.hackcrashfiasco.letMeComplainFiasco.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntity, String> {

    Optional<UserEntity> findUserByEmailAddress(String emailAddress);

    Optional<UserEntity> findUserByTelephoneNumber(long telephoneNumber);
}
