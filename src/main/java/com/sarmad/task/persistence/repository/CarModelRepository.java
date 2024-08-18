package com.sarmad.task.persistence.repository;

import com.sarmad.task.persistence.entity.CarModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarModelRepository extends MongoRepository<CarModel, String> {
}
