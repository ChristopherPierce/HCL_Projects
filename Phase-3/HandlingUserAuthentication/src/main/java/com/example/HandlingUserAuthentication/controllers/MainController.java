package com.example.HandlingUserAuthentication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

	@GetMapping(value = "/")
	public String showIndex(ModelMap model) {
		return "index";
	}

}
