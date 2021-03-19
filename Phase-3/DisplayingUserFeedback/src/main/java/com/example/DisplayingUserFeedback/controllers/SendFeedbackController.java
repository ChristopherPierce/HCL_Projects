package com.example.DisplayingUserFeedback.controllers;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.DisplayingUserFeedback.entities.Feedback;

@Controller
public class SendFeedbackController {

	@GetMapping(value = "/send_feedback")
	public String getFeedbackForm(ModelMap model) {
	    Feedback feedback = new Feedback();
	    model.addAttribute("feedback", feedback);
		return "feedback_form";
	}
	
	@PostMapping(value = "/send_feedback")
	public String handleFeedbackSubmission(Feedback feedback, ModelMap model) {
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		String jsonString = new JSONObject()
            .put("user", feedback.getUser())
            .put("rating", Integer.toString(feedback.getRating()))
            .put("comments", feedback.getComments())
            .toString();
		
		HttpEntity<String> request = new HttpEntity<String>(jsonString, headers);
		String restEndpoint = "http://localhost:8090/feedback";
		String response = restTemplate.postForObject(restEndpoint, request, String.class);
		return "redirect:/send_feedback/success";
	}

	@GetMapping(value = "/send_feedback/success")
	public ResponseEntity<Object> feedbackSubmissionSuccess(ModelMap model) {
		String response = "";
		response += "<h2>Your feedback has been received!</h2>";
		response += "<p>Click the link below to return to our home page.</p>";
		response += "<a href=\"/\">Return Home</a>";
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}