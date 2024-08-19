package com.sarmad.task.bussiness.serviceImpl;

import com.sarmad.task.bussiness.service.DataService;
import com.sarmad.task.persistence.entity.CarModel;
import com.sarmad.task.persistence.entity.User;
import com.sarmad.task.persistence.entity.UserCars;
import com.sarmad.task.persistence.repository.CarModelRepository;
import com.sarmad.task.persistence.repository.UserCarRepository;
import com.sarmad.task.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DataServiceImpl implements DataService {
    @Autowired
    private UserCarRepository userCarRepository;

    @Autowired
    private CarModelRepository carModelRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void generateAndInsertData(int x) {
        Random random = new Random();

        // Generate and insert car models
        List<CarModel> carModels = new ArrayList<>();
        for (int i = 1; i <= x; i++) {
            CarModel carModel = new CarModel();
            carModel.setCarModelId(String.valueOf(i));
            carModel.setModelName("Model" + i);
            carModel.setType("Type" + (i % 5));
            carModel.setManufacturer_year(String.valueOf(2000 + (i % 24)));
            carModels.add(carModel);
        }
        carModelRepository.saveAll(carModels);

        // Generate and insert users
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= x; i++) {
            User user = new User();
            user.setUser_id(String.valueOf(i));
            user.setFirstName("FirstName" + i);
            user.setSecondName("SecondName" + i);
            user.setLoginID("Login" + i);
            user.setPassword(passwordEncoder.encode("Login" + i));
            users.add(user);
        }
        userRepository.saveAll(users);

        // Generate and insert user cars
        List<UserCars> userCars = new ArrayList<>();
        for (int i = 1; i <= x; i++) {
            UserCars userCar = new UserCars();
            userCar.setUserId(String.valueOf(random.nextInt(x) + 1));
            userCar.setCarModelId(String.valueOf(random.nextInt(x) + 1));
            userCar.setCarPlateNumber("Plate" + i);
            userCar.setColor("Color" + (i % 10));
            userCars.add(userCar);
        }
        userCarRepository.saveAll(userCars);
    }
}
