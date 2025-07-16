package com.studentManagementSystem.studentSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) // Disables Spring Security
public class StudentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentSystemApplication.class, args);
	}

}

