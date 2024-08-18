package com.sarmad.task.bussiness.service;

import com.sarmad.task.persistence.entity.User;

import java.util.List;

public interface UserService {

    public User createUser(User user);
    public User getUserById(String id);
    public List<User> getUserByFirstName(String name);
}
