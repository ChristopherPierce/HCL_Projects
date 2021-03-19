package com.example.DisplayingUserFeedback.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewFeedbackController {

	@GetMapping(value = "/view_feedback")
	public String displayFeedback(ModelMap model) {
		return "feedback_display";
	}

}