package com.api.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.ecommerce.entity.UserEntity;
import com.api.ecommerce.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> user = userRepository.findByUsername(username);
		if (user.isPresent()) {
			var userObj = user.get();
			String[] roles = new String[] {userObj.getRoles()};
			return User.builder()
					.username(userObj.getUsername())
					.password(userObj.getPassword())
					.roles(roles)
					.build();
		} else {
		    throw new UsernameNotFoundException("User not found");
		}	
	}
}
