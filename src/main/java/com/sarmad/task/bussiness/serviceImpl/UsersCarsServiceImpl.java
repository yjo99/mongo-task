package com.sarmad.task.bussiness.serviceImpl;

import com.sarmad.task.bussiness.dto.AppResponse;
import com.sarmad.task.bussiness.dto.UserCarsDto;
import com.sarmad.task.bussiness.dto.UserCarsSearchDto;
import com.sarmad.task.bussiness.service.UserCarsService;
import com.sarmad.task.exception.CustomException;
import com.sarmad.task.persistence.entity.User;
import com.sarmad.task.persistence.entity.UserCars;
import com.sarmad.task.persistence.repository.CarModelRepository;
import com.sarmad.task.persistence.repository.UserCarRepository;
import com.sarmad.task.persistence.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersCarsServiceImpl implements UserCarsService {

    @Autowired
    private UserCarRepository userCarRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Cacheable(value = "userCars", key = "#userCarsSearchDto.firstName + '-' + #userCarsSearchDto.secondName + '-' + #userCarsSearchDto.carPlateNumber")
    public List<UserCars> getSpecificUserCars(UserCarsSearchDto userCarsSearchDto) {

        String userId = getUserId(userCarsSearchDto.getFirstName(),userCarsSearchDto.getSecondName());

        if (userCarsSearchDto.getCarPlateNumber() != null) {
            return userCarRepository.findUserCarsByUserIdAndCarPlateNumber(userId, userCarsSearchDto.getCarPlateNumber());
        } else {
            return userCarRepository.findUserCarsByUserId(userId);
        }
    }

    @Override
    public AppResponse< List<UserCarsDto>> searchUserCars(UserCarsSearchDto userCarsSearchDto) {
        List<UserCars> userCars = getSpecificUserCars(userCarsSearchDto);
        List<UserCarsDto> userCarsDtos =mapUserCarsToDtos(userCars);
        return new AppResponse<>("Return Data Successfully",userCarsDtos);
    }

    private String getUserId(String firstName, String secondName){
        List<User> users;
        if (firstName != null && secondName != null) {
            users = userRepository.findUserByFirstNameAndSecondName(firstName, secondName);
        }else{
            users = userRepository.findByFirstName(firstName);
        }
        if(users.isEmpty()){
            throw new CustomException("User Not Exist");
        }
        return users.get(0).getUser_id();
    }

    private List<UserCarsDto> mapUserCarsToDtos(List<UserCars> userCars) {
        return userCars.stream()
                .map(userCar -> modelMapper.map(userCar, UserCarsDto.class))
                .collect(Collectors.toList());
    }
}
