package com.example.DisplayingUserFeedback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DisplayingUserFeedback.entities.Feedback;
import com.example.DisplayingUserFeedback.services.FeedbackService;

@RestController
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackService;
	
	@GetMapping("/feedback")
	public @ResponseBody Iterable<Feedback> getAllFeedbacks() {
        return feedbackService.GetAllFeedback();
    }
	
	@PostMapping("/feedback")
	public Feedback addNewFeedback(@RequestBody Feedback newFeedback) {
		return feedbackService.SaveFeedback(newFeedback);
	}
	
}