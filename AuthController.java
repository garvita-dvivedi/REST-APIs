package com.studentManagementSystem.studentSystem.controller;
import com.studentManagementSystem.studentSystem.dto.LoginRequest;
import com.studentManagementSystem.studentSystem.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    // It takes the JSON from the request body and puts it into a Java class object for you.
    public String login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
