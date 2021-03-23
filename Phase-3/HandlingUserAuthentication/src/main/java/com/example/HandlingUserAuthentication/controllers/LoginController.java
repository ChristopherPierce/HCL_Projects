package com.example.HandlingUserAuthentication.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.example.HandlingUserAuthentication.entities.User;
import com.example.HandlingUserAuthentication.exceptions.EmptyFormFieldException;
import com.example.HandlingUserAuthentication.exceptions.IncorrectPasswordException;
import com.example.HandlingUserAuthentication.exceptions.UserNotFoundException;
import com.example.HandlingUserAuthentication.services.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);

	@GetMapping("/login")
	public String showLogin(ModelMap map) {
		return "login";
	}

	@PostMapping("/login")
	public String submitLogin(@RequestParam String email, @RequestParam String password) {
		//logger.info("Email:" + email + ";Password:" + password);
	    if(email.length()==0 || password.length()==0) {
		    if(email.length()==0) throw new EmptyFormFieldException();
		    if(password.length()==0) throw new EmptyFormFieldException();
	    } else {
	    	//verify login
	    	Optional<User> foundUser = userService.GetUserByEmail(email);
			if (!foundUser.isPresent()) throw new UserNotFoundException();
			User user = foundUser.get();
	    	if(!user.getPassword().equals(password)) throw new IncorrectPasswordException();
	    }
		return "redirect:/login/success";

	}

	@GetMapping(value = "/login/success")
	public ResponseEntity<Object> loginSuccess(ModelMap model) {
		String response = "";
		response += "<h2>You have successfully logged in!</h2>";
		response += "<p>Click the link below to return to our home page.</p>";
		response += "<a href=\"/\">Return Home</a>";
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}