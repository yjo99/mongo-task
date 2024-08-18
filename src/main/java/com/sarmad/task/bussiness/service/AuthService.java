package com.sarmad.task.bussiness.service;

import com.sarmad.task.bussiness.dto.AppResponse;
import com.sarmad.task.bussiness.dto.LoginDto;
import com.sarmad.task.bussiness.dto.LoginResponseDto;
import com.sarmad.task.bussiness.dto.RegistrationDto;

public interface AuthService {

    AppResponse<Object> registerUser(RegistrationDto registrationDto);
    AppResponse<LoginResponseDto> loginUser(LoginDto loginDto);


}
