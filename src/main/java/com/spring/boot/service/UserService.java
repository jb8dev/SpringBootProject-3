package com.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.domain.User;
import com.spring.boot.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public User login(String username, String password) {
		User user = repository.findByUsernameAndPassword(username, password);
		return user;
	}
}
