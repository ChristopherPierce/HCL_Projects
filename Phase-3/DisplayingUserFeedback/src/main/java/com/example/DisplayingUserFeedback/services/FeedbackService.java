package com.example.DisplayingUserFeedback.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DisplayingUserFeedback.entities.Feedback;
import com.example.DisplayingUserFeedback.repositories.*;

@Service
public class FeedbackService {
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	public Iterable<Feedback> GetAllFeedback() {
		return feedbackRepository.findAll();
	}
	
	public Feedback SaveFeedback(Feedback feedbackToSave) {
		return feedbackRepository.save(feedbackToSave);
	}
	
}