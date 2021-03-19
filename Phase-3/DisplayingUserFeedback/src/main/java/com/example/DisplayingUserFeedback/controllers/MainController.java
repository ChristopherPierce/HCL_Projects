package com.example.DisplayingUserFeedback.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping(value = "/")
	public ResponseEntity<Object> getIndexPage(ModelMap model) {
		String response = "";
		response += "<h2>We would like your feedback!</h2>";
		response += "<p>Click the links below to navigate to our feedback pages.</p>";
		response += "<a href=\"/send_feedback\">Send Feedback</a><br>";
		response += "<a href=\"/view_feedback\">View Feedback</a>";
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}