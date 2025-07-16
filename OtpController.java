package com.studentManagementSystem.studentSystem.controller;

import com.studentManagementSystem.studentSystem.dto.OtpRequest;
import com.studentManagementSystem.studentSystem.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/send-otp")
    public String sendOtp(@RequestBody OtpRequest request) {
        return otpService.sendOtp(request.getEmail());
    }

    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestBody OtpRequest request) {
        boolean valid = otpService.verifyOtp(request.getEmail(), request.getOtp());
        return valid ? "OTP verified. You can now Sign Up." : "Invalid OTP. Try again.";
    }
}
