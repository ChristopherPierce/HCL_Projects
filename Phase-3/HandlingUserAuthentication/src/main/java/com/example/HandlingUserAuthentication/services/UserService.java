package com.example.HandlingUserAuthentication.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HandlingUserAuthentication.entities.User;
import com.example.HandlingUserAuthentication.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Iterable<User> GetAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> GetUserByEmail(String email) {
		Optional<User> foundUser = Optional.ofNullable(userRepository.findByEmail(email));
		return foundUser;
	}

	public void UpdateUser(User usertoUpdate) {
		userRepository.save(usertoUpdate);
	}

}