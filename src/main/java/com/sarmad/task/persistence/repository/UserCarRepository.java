package com.sarmad.task.persistence.repository;

import com.sarmad.task.persistence.entity.UserCars;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCarRepository extends MongoRepository<UserCars, String> {
    List<UserCars> findUserCarsByUserIdAndCarPlateNumber(String userId,String carPlateNumber);
    List<UserCars> findUserCarsByUserId(String userId);

}
