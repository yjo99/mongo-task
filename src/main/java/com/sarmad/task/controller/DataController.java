package com.sarmad.task.controller;

import com.sarmad.task.bussiness.dto.AppResponse;
import com.sarmad.task.bussiness.dto.RegistrationDto;
import com.sarmad.task.bussiness.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
@CrossOrigin
public class DataController {
    @Autowired
    public DataService dataService;

    @PostMapping("/generate/{number}")
    public AppResponse<Object> registerNewUser(@PathVariable int number) {
        dataService.generateAndInsertData(number);
        return new AppResponse<>("Data Generated",null);
    }
}
