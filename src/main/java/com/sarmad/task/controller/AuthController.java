package com.sarmad.task.controller;

import com.sarmad.task.bussiness.dto.AppResponse;
import com.sarmad.task.bussiness.dto.LoginDto;
import com.sarmad.task.bussiness.dto.LoginResponseDto;
import com.sarmad.task.bussiness.dto.RegistrationDto;
import com.sarmad.task.bussiness.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public AppResponse<Object> registerNewUser(@RequestBody RegistrationDto registrationDto) {
        return authService.registerUser(registrationDto);
    }

    @PostMapping("/login")
    public AppResponse<LoginResponseDto> loginUser(@RequestBody LoginDto loginDto) {
        return authService.loginUser(loginDto);
    }
}
