package com.sarmad.task.persistence.repository;

import com.sarmad.task.persistence.entity.UserCars;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCarRepository extends MongoRepository<UserCars, String> {
}
