package com.api.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.ecommerce.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	UserEntity findByUsername(String username);
}
