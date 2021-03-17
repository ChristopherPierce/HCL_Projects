package com.example.SearchingForASpecificUserAndUpdatingTheUserInformation.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.SearchingForASpecificUserAndUpdatingTheUserInformation.exceptions.UserNotFoundException;

@ControllerAdvice
public class UserExceptionController {
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> exception(UserNotFoundException exception) {
		String response = "";
		response += "<h2>User not found...</h2>";
		response += "<a href=\"/\">Return</a>";
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

}
