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
public class LookupController {

	@Autowired
	private UserService userService;

	Logger logger = LoggerFactory.getLogger(LookupController.class);
	
	@PostMapping(value = "/lookup")
	public String lookupUser(@ModelAttribute User user, ModelMap model) {
		if(user.getId()==null) return "redirect:/";
		
		logger.info("Getting user by ID");
		user = userService.GetUserById(user.getId());
		
		logger.info("Passing user to view");
		model.addAttribute("user", user);

		return "lookup";
	}

}