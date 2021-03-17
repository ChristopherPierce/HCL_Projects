package com.example.SearchingForASpecificUserAndUpdatingTheUserInformation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.example.SearchingForASpecificUserAndUpdatingTheUserInformation.entities.User;

@Controller
public class MainController {

	@GetMapping(value = "/")
	public String showIndexPage(ModelMap model) {
		model.addAttribute("user", new User());
		return "index";
	}

}
