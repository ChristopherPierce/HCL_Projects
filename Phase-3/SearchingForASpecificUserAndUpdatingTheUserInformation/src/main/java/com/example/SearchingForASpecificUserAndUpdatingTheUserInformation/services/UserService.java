package com.example.SearchingForASpecificUserAndUpdatingTheUserInformation.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SearchingForASpecificUserAndUpdatingTheUserInformation.entities.User;
import com.example.SearchingForASpecificUserAndUpdatingTheUserInformation.exceptions.UserNotFoundException;
import com.example.SearchingForASpecificUserAndUpdatingTheUserInformation.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Iterable<User> GetAllUsers() {
		return userRepository.findAll();
	}

	public User GetUserById(int id) {
		Optional<User> foundUser = Optional.ofNullable(userRepository.findById(id));

		if (!foundUser.isPresent()) {
			throw new UserNotFoundException();
		}

		return (foundUser.get());
	}

	public void UpdateUser(User usertoUpdate) {
		userRepository.save(usertoUpdate);
	}

}