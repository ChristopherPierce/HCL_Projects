package com.web.store.music_store.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import com.web.store.music_store.model.User;
import com.web.store.music_store.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public String getRegisterPage(Model model) {
		return "register";
	}

	@PostMapping(path = "/register", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public String postRegisterPage(@RequestParam MultiValueMap<String,String> paramMap) throws UnsupportedEncodingException {
		String email = paramMap.getFirst("email");
		String password = paramMap.getFirst("password");
		String password2 = paramMap.getFirst("confirm_password");
		
		String notice = "";
		//check for empty input
		if (email.length() == 0) notice += "Error: missing email<br>";
		if (password.length() == 0) notice += "Error: missing password<br>";
		if (password2.length() == 0) notice += "Error: missing confirm password<br>";
		if (notice.length() > 0) {
			notice = notice.substring(0, notice.length() - 4);
			notice = Base64.getEncoder().encodeToString(notice.getBytes());
			notice = URLEncoder.encode(notice, "UTF-8");
			return "redirect:/register?error=" + notice;
		}
		
		//check if email is already in use
		Optional<User> foundUser = Optional.ofNullable(userService.findUserByUsername(email));
		if(foundUser.isPresent()) {
			notice = "Error: email already in use<br>";
			notice = notice.substring(0, notice.length() - 4);
			notice = Base64.getEncoder().encodeToString(notice.getBytes());
			notice = URLEncoder.encode(notice, "UTF-8");
			return "redirect:/register?error=" + notice;
		}
		
		//check for password mismatch
		if(!password.equals(password2)) {
			notice = "Error: your passwords do not match<br>";
			notice = notice.substring(0, notice.length() - 4);
			notice = Base64.getEncoder().encodeToString(notice.getBytes());
			notice = URLEncoder.encode(notice, "UTF-8");
			return "redirect:/register?error=" + notice;
		}
		
		User user = new User();
		user.setUsername(email);
		user.setPassword(password);
		userService.saveUser(user);
		return "register_success";
	}

}