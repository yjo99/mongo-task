package com.sarmad.task.controller;

import com.sarmad.task.bussiness.service.UserService;
import com.sarmad.task.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public void generateData() {
        User user = new User();
        user.setFirstName("joe");
        user.setSecondName("Sayed");
        user.setLoginID("jo99");
        user.setPassword("jo99");
        userService.createUser(user);
    }

    @GetMapping("/test/{name}")
    public List<User> generateData(@PathVariable String name) {

        return userService.getUserByFirstName(name);
    }
}
