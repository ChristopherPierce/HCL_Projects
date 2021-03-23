package com.example.HandlingUserAuthentication;

import com.example.HandlingUserAuthentication.entities.User;
import com.example.HandlingUserAuthentication.repositories.UserRepository;
import com.example.HandlingUserAuthentication.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserEntityTests {

	@Test
	public void WhenSetPassword_CheckGetPassword() {
		User testUser = new User();
		
		testUser.setPassword("mypassword");
		assertEquals(testUser.getPassword(),"mypassword");
	}
	
}