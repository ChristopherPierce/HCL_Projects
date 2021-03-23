package com.example.HandlingUserAuthentication.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.HandlingUserAuthentication.exceptions.EmptyFormFieldException;
import com.example.HandlingUserAuthentication.exceptions.IncorrectPasswordException;
import com.example.HandlingUserAuthentication.exceptions.UserNotFoundException;
import com.example.HandlingUserAuthentication.exceptions.PasswordMismatchException;
import com.example.HandlingUserAuthentication.exceptions.PasswordRequirementsNotMetException;
import com.example.HandlingUserAuthentication.exceptions.UserAlreadyExistsException;

@ControllerAdvice
public class UserExceptionController {
//LOGIN/REGISTRATION EXCEPTIONS:
	@ExceptionHandler(value = EmptyFormFieldException.class)
	public ResponseEntity<Object> exception(EmptyFormFieldException exception) {
		String response = "";
		response += "<h2>One or more fields of the form is missing...</h2>";
		response += "<a href=\"javascript:window.location.href=window.location.href\">Reload Page</a>";
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
//LOGIN EXCEPTIONS:
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> exception(UserNotFoundException exception) {
		String response = "";
		response += "<h2>User does not exist...</h2>";
		response += "<a href=\"/login\">Return to Login</a>";
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = IncorrectPasswordException.class)
	public ResponseEntity<Object> exception(IncorrectPasswordException exception) {
		String response = "";
		response += "<h2>The password you entered is incorrect...</h2>";
		response += "<a href=\"/login\">Return to Login</a>";
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
//REGISTRATION EXCEPTIONS:
	@ExceptionHandler(value = PasswordMismatchException.class)
	public ResponseEntity<Object> exception(PasswordMismatchException exception) {
		String response = "";
		response += "<h2>Your passwords do not match...</h2>";
		response += "<a href=\"/register\">Return to Registration</a>";
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = PasswordRequirementsNotMetException.class)
	public ResponseEntity<Object> exception(PasswordRequirementsNotMetException exception) {
		String response = "";
		response += "<h2>Your password must be at least 8 characters long...</h2>";
		response += "<a href=\"/register\">Return to Registration</a>";
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = UserAlreadyExistsException.class)
	public ResponseEntity<Object> exception(UserAlreadyExistsException exception) {
		String response = "";
		response += "<h2>This email is already registered...</h2>";
		response += "<a href=\"/register\">Return to Registration</a>";
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
