package com.api.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.ecommerce.entity.RegisterForm;
import com.api.ecommerce.entity.UserEntity;
import com.api.ecommerce.repository.UserRepository;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
	UserEntity createUser(@RequestBody RegisterForm form) {
		UserEntity user = new UserEntity();
		user.setUsername(form.username());
		user.setEmail(form.email());
		user.setPassword(passwordEncoder.encode(form.password()));	
		return userRepository.save(user);
	}
}