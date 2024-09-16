package com.api.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.ecommerce.entity.UserEntity;
import com.api.ecommerce.repository.UserRepository;


@RestController
public class RegistrationController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/api/1.0/home")
	String getHome() {
		return "Hi";
	}

	@PostMapping("/api/1.0/signup")
	UserEntity createUser(@RequestBody UserEntity user) {
		return userRepository.save(user);
	}
}