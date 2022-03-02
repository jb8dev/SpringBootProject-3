package com.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.domain.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
User findByUsernameAndPassword(String username, String password);

}
