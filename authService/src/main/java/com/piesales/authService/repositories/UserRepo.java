package com.piesales.authService.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piesales.authService.entities.User;


public interface UserRepo extends JpaRepository<User, Integer>{
		
	
	Optional<User> findByEmail(String email);
}
