package com.api.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.ecommerce.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	Optional<UserEntity> findByUsername(String username);
}
