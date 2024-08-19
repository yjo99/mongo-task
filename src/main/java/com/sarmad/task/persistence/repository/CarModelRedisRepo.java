package com.sarmad.task.persistence.repository;

import com.sarmad.task.bussiness.dto.CarModelDto;
import org.springframework.data.repository.CrudRepository;

public interface CarModelRedisRepo extends CrudRepository<CarModelDto, String> {

}
