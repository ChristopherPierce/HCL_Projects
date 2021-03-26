package com.example.ImplementSpringSecurityWithAuthentication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
	
    @GetMapping("/")
    public String Default() {
    	return "index";
    }
    
    @GetMapping("/index")
    public String Index() {
    	return "redirect:/";
    }
    
    @GetMapping("/home")
    public String Home() {
    	return "home";
    }
    
    @GetMapping("/error")
    public String Error() {
    	return "error";
    }
}