package com.sarmad.task.persistence.repository;

import com.sarmad.task.persistence.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByFirstName(String name);
    Optional<User> findUserByLoginID(String loginID);
}
