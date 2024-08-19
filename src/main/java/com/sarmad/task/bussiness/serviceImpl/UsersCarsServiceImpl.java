package com.sarmad.task.bussiness.serviceImpl;

import com.sarmad.task.bussiness.dto.AppResponse;
import com.sarmad.task.bussiness.dto.CarModelDto;
import com.sarmad.task.bussiness.dto.UserCarsDto;
import com.sarmad.task.bussiness.dto.UserCarsSearchDto;
import com.sarmad.task.bussiness.service.CarModelService;
import com.sarmad.task.bussiness.service.UserCarsService;
import com.sarmad.task.exception.CustomException;
import com.sarmad.task.persistence.entity.User;
import com.sarmad.task.persistence.entity.UserCars;
import com.sarmad.task.persistence.repository.UserCarRepository;
import com.sarmad.task.persistence.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersCarsServiceImpl implements UserCarsService {

    @Autowired
    private UserCarRepository userCarRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CarModelService carModelService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AppResponse<List<UserCarsDto>> getSpecificUserCars(UserCarsSearchDto userCarsSearchDto) {

        String userId = getUserId(userCarsSearchDto.getFirstName(),userCarsSearchDto.getSecondName());

        List<UserCars> usercars = null;
        if (userCarsSearchDto.getCarPlateNumber() != null) {
            usercars = userCarRepository.findUserCarsByUserIdAndCarPlateNumber(userId, userCarsSearchDto.getCarPlateNumber());
        } else {
            usercars = userCarRepository.findUserCarsByUserId(userId);
        }
        List<UserCarsDto> userCarsDtos = new ArrayList<>();
        if(usercars != null || !usercars.isEmpty()){
            for (UserCars userCar : usercars) {
                userCarsDtos.add(mapUserCarsToDtos(userCar));
            }
        }
        
        return new AppResponse<List<UserCarsDto>>("Return Data Successfully",userCarsDtos);
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
    
    private UserCarsDto mapUserCarsToDtos(UserCars userCars){
        UserCarsDto userCarsDto = new UserCarsDto();
        userCarsDto.setColor(userCars.getColor());
        userCarsDto.setCarPlateNumber(userCars.getCarPlateNumber());
        mapCarModelData(userCars, userCarsDto);
        return userCarsDto;
    }
    
    private void mapCarModelData(UserCars userCars, UserCarsDto userCarsDto){
        CarModelDto carModelDto = new CarModelDto();
        if(carModelService.getCashedCarModelById(userCars.getCarModelId()).isPresent()){
            carModelDto = carModelService.getCashedCarModelById(userCars.getCarModelId()).get();
        }
        userCarsDto.setModelName(carModelDto.getModelName());
        userCarsDto.setType(carModelDto.getType());
        userCarsDto.setManufacturerYear(carModelDto.getManufacturerYear());
    }




}
