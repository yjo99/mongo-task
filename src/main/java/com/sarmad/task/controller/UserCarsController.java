package com.sarmad.task.controller;

import com.sarmad.task.bussiness.dto.AppResponse;
import com.sarmad.task.bussiness.dto.UserCarsDto;
import com.sarmad.task.bussiness.dto.UserCarsSearchDto;
import com.sarmad.task.bussiness.service.CarModelService;
import com.sarmad.task.bussiness.service.UserCarsService;
import com.sarmad.task.bussiness.serviceImpl.UsersCarsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user-cars")
@CrossOrigin
public class UserCarsController {

    @Autowired
    private UserCarsService userCarsService;
    @Autowired
    private CarModelService carModelService;

    @PostMapping("/search")
    public AppResponse<List<UserCarsDto>> searchUserCars(@Valid @RequestBody UserCarsSearchDto dto) {
        carModelService.getCashedCarModel("1");
        return userCarsService.searchUserCars(dto);
    }
}
