package com.sarmad.task.bussiness.service;

import com.sarmad.task.bussiness.dto.AppResponse;
import com.sarmad.task.bussiness.dto.UserCarsDto;
import com.sarmad.task.bussiness.dto.UserCarsSearchDto;
import com.sarmad.task.persistence.entity.UserCars;

import java.util.List;

public interface UserCarsService {

    public AppResponse< List<UserCarsDto>> searchUserCars(UserCarsSearchDto userCarsSearchDto);
}
