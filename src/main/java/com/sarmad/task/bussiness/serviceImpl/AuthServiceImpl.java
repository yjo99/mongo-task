package com.sarmad.task.bussiness.serviceImpl;

import com.sarmad.task.bussiness.dto.AppResponse;
import com.sarmad.task.bussiness.dto.LoginDto;
import com.sarmad.task.bussiness.dto.LoginResponseDto;
import com.sarmad.task.bussiness.dto.RegistrationDto;
import com.sarmad.task.bussiness.service.AuthService;
import com.sarmad.task.exception.CustomException;
import com.sarmad.task.persistence.entity.User;
import com.sarmad.task.persistence.repository.UserRepository;
import com.sarmad.task.security.service.JwtService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtService jwtService;

    @Override
    public AppResponse<Object> registerUser(RegistrationDto registrationDto) {
        //check if user exist
        if(UserExist(registrationDto.getLoginID())){
            throw new CustomException("User is Already Exist");
        }

        //saving user
        User newUser = modelMapper.map(registrationDto, User.class);
        String hashingPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(hashingPassword);
        userRepository.save(newUser);

        //return success response
        return new AppResponse<>("User Saved Successfully",null);
    }

    @Override
    public AppResponse<LoginResponseDto> loginUser(LoginDto loginDto) {
        //check if user not exist
        if(!UserExist(loginDto.getLoginID())){
            throw new CustomException("User is Not Exist");
        }

        // check and validate user data
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getLoginID(),
                        loginDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateJwtToken(authentication);

        //prepare response
        return new AppResponse<>("User login Successfully",new LoginResponseDto(jwt));
    }

    private Boolean UserExist(String loginID){
        return userRepository.findUserByLoginID(loginID).isPresent();
    }
}
