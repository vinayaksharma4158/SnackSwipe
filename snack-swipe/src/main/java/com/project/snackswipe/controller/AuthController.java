package com.project.snackswipe.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.snackswipe.model.ResetPasswordRequest;


import com.project.snackswipe.service.UserService;

@RestController
@RequestMapping("/api")
public class AuthController {


    @Autowired
    private UserService userService;
    
    @PutMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest request) {
    	String result = userService.resetPassword(request.getEmail(), request.getUserType(), request.getPrnOrEmployeeId(), request.getNewPassword());

        if ("Failure".equals(result)) {
            return ResponseEntity.status(404).body("User not found.");
        }

        return ResponseEntity.ok("Password updated successfully.");
    
    }
}


