package com.sarmad.task.persistence.repository;

import com.sarmad.task.persistence.entity.UserCars;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserCarRepository extends MongoRepository<UserCars, String> {
}
