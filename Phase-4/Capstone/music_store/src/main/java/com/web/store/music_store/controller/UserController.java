package com.web.store.music_store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.store.music_store.model.User;
import com.web.store.music_store.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping(value="/very")
	public String verifyLogin(ModelMap model, String username, String password){
		User user = service.verify(username, password);
		if(user.equals(null)) {
			model.put("errorMessage", "Error, invalid credentials");
			return "index.jsp";
		} 
		if(user.getPrivilege().equals("user")) {
			model.put("message", "Welcome user");
			return "index.jsp";
		} else {
			model.put("message", "Welcome admin");
			return "index.jsp";
		}
	}
}
