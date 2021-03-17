package com.example.SearchingForASpecificUserAndUpdatingTheUserInformation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.example.SearchingForASpecificUserAndUpdatingTheUserInformation.entities.User;
import com.example.SearchingForASpecificUserAndUpdatingTheUserInformation.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class UpdateController {

	@Autowired
	private UserService userService;

	Logger logger = LoggerFactory.getLogger(LookupController.class);
	
	@PostMapping(value = "/update")
	public String updateUser(@ModelAttribute User user, ModelMap model) {
		userService.UpdateUser(user);
		logger.info("Saving the changes made to user:" + user.getId());
		model.addAttribute("user", userService.GetUserById(user.getId()));
		return "update";
	}

}