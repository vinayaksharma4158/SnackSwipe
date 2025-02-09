package com.project.snackswipe.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.snackswipe.exception.UserNotFoundException;
import com.project.snackswipe.model.UserLoginRequest;
import com.project.snackswipe.model.UserSignUp;

import com.project.snackswipe.service.UserService;





/**
 * Author : lenovo
 * Date : 31-Jan-2025
 * Time : 2:01:29 pm
*/
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<UserSignUp> registerUser(@RequestBody UserSignUp user)
	{
	UserSignUp savedUser=userService.saveUser(user);
	return ResponseEntity.ok(savedUser);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody UserLoginRequest userLoginRequest) {
	    if (userLoginRequest == null || 
	        userLoginRequest.getPrnOrEmployeeId() == null || 
	        userLoginRequest.getPassword() == null) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body("Missing required fields");
	    }

	    try {
	        UserSignUp user = userService.findByPrnOrEmployeeId(
	                userLoginRequest.getUserType(),
	                userLoginRequest.getPrnOrEmployeeId(),
	                userLoginRequest.getName(),
	                userLoginRequest.getPassword());

	        return ResponseEntity.ok("Login Successful");
	        
	    } catch (UserNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                .body(ex.getMessage());
	    }
	}


	

}
