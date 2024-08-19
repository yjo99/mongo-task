package com.sarmad.task.bussiness.service;

import com.sarmad.task.bussiness.dto.CarModelDto;

import java.util.Optional;

public interface CarModelService {

    public Optional<CarModelDto> getCashedCarModel(String id);
}
