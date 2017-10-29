package com.hackcrashfiasco.letMeComplainFiasco.repository;

import com.hackcrashfiasco.letMeComplainFiasco.entity.ComplaintEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComplaintRepository extends MongoRepository<ComplaintEntity, String> {
}
