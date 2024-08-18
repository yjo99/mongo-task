package com.sarmad.task.bussiness.serviceImpl;

import com.sarmad.task.bussiness.service.UserService;
import com.sarmad.task.persistence.entity.User;
import com.sarmad.task.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getUserByFirstName(String name) {
        return userRepository.findByFirstName(name);
    }
}
