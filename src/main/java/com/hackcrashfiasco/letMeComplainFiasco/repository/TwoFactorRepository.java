package com.hackcrashfiasco.letMeComplainFiasco.repository;


import com.hackcrashfiasco.letMeComplainFiasco.entity.TwoFactorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TwoFactorRepository extends MongoRepository<TwoFactorEntity, Long>{

    Optional<TwoFactorEntity> findTwoFactorEntityByTelephoneNumber(long telephoneNumber);

}
