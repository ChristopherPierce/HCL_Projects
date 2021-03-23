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
import com.example.HandlingUserAuthentication.exceptions.PasswordMismatchException;
import com.example.HandlingUserAuthentication.exceptions.PasswordRequirementsNotMetException;
import com.example.HandlingUserAuthentication.exceptions.UserAlreadyExistsException;
import com.example.HandlingUserAuthentication.services.UserService;

@Controller
public class RegisterController {
	@Autowired
	private UserService userService;
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@GetMapping("/register")
	public String showRegister(ModelMap map) {
		return "register";
	}

	@PostMapping("/register")
	public String submitRegister(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("confirm_password") String password2) {
	    if(email.length()==0 || password.length()==0 || password2.length()==0) {
		    if(email.length()==0) throw new EmptyFormFieldException();
		    if(password.length()==0) throw new EmptyFormFieldException();
		    if(password2.length()==0) throw new EmptyFormFieldException();
	    } else {
	    	if(password.length() < 8) throw new PasswordRequirementsNotMetException();
	    	if(!password.equals(password2)) throw new PasswordMismatchException();
	    	Optional<User> foundUser = userService.GetUserByEmail(email);
			if (foundUser.isPresent()) throw new UserAlreadyExistsException();
    		User user = new User();
    		user.setEmail(email);
    		user.setPassword(password);
    		userService.UpdateUser(user);
	    }
		return "redirect:/register/success";
	}
	
	@GetMapping(value = "/register/success")
	public ResponseEntity<Object> registerSuccess(ModelMap model) {
		String response = "";
		response += "<h2>You have successfully registered!</h2>";
		response += "<p>Click the link below to return to our home page.</p>";
		response += "<a href=\"/\">Return Home</a>";
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}