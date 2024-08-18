package com.sarmad.task.persistence.repository;

import com.sarmad.task.persistence.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
