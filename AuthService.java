package com.studentManagementSystem.studentSystem.service;
import com.studentManagementSystem.studentSystem.dto.LoginRequest;
import com.studentManagementSystem.studentSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    // we don't need to make use of new keyword to create an obj , it automatically provides the beans(obj) into a class
    private UserRepository userRepo;
    // it takes login request from the controller
    public String login(LoginRequest request) {
        return userRepo.findByUserIdAndPassword(request.getUserId(), request.getPassword())
                .map(user -> "Login successful for user: " + user.getName())
                .orElse("Invalid credentials. Login failed.");
    }
}
