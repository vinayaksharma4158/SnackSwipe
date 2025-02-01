package com.project.snackswipe.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.snackswipe.model.UserLoginRequest;
import com.project.snackswipe.model.UserSignUp;
import com.project.snackswipe.repository.UserRepository;
import com.project.snackswipe.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;




/**
 * Author : lenovo
 * Date : 31-Jan-2025
 * Time : 2:01:29 pm
*/

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
	public ResponseEntity<String> loginUser(@RequestBody UserLoginRequest userLoginRequest) {

	    // Fetch the result from the service
	    String res = userService.findByPrnOrEmployeeId(userLoginRequest.getPrnOrEmployeeId()
	    		,userLoginRequest.getPassword(),userLoginRequest.getUserType());

	    // Return appropriate response based on result
	    if (res.equals("Success")) {
	        return ResponseEntity.status(HttpStatus.OK).body("Login Successful");
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
	    }
	}

	

}
