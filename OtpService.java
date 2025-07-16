package com.studentManagementSystem.studentSystem.service;
import com.studentManagementSystem.studentSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class OtpService {
    // we cannot use autowired here bcz map is a java obj not a spring bean meaning spring bean like service, repo , etc so spring does not manage this
    private final Map<String, String> otpStore = new HashMap<>();

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserRepository userRepository;

    public String sendOtp(String email) {
        // Check if email already registered
        if (userRepository.existsByEmail(email)) {
            return "Email already registered. Please login instead.";
        }

        // Generate 6-digit OTP
        String otp = String.format("%06d", new Random().nextInt(999999));
        // otpStore is a hash map
        otpStore.put(email, otp);

        // Send Email
        SimpleMailMessage message = new SimpleMailMessage(); // starting an email
        message.setTo(email); // setting on which email to send the mail
        message.setSubject("Your OTP for Student Management System"); // sub of the mail
        message.setText("Your OTP is: " + otp + "\nIt is valid for 5 minutes."); // content of the mail
        mailSender.send(message); // mail sent

        return "OTP sent to " + email;
    }
    // verification of the otp
    public boolean verifyOtp(String email, String enteredOtp) {
        String storedOtp = otpStore.get(email);
        return storedOtp != null && storedOtp.equals(enteredOtp);
    }
}
