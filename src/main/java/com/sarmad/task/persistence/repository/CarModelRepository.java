package com.sarmad.task.persistence.repository;

import com.sarmad.task.persistence.entity.CarModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarModelRepository extends MongoRepository<CarModel, String> {
}
