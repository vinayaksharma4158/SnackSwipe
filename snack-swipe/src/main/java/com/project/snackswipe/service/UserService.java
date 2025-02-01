package com.project.snackswipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


import com.project.snackswipe.model.UserSignUp;
import com.project.snackswipe.repository.UserRepository;
import java.util.*;
/**
 * Author : lenovo
 * Date : 31-Jan-2025
 * Time : 1:56:12 pm
*/
@Service
public class UserService {
	
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	
	public UserSignUp saveUser(UserSignUp user)
	{
		return userRepository.save(user);
	}

	public List<UserSignUp> findAllUser()
	{
		return userRepository.findAll();
	}
	
//    public String findByPrnOrEmployeeId(String prnOrEmployeeId,String password,String userType)
//    {
//    return userRepository.findByPrnOrEmployeeIDAndPasswordAndUserType(prnOrEmployeeId, password, userType)
//    		.map(user -> "Login Successfull ")
//    		.orElse("Invalid Credentials. Login Failed. ");
//    }
    
    public String findByPrnOrEmployeeId(String prnOrEmployeeId, String password, String userType) {
        Optional<UserSignUp> user = userRepository.findByPrnOrEmployeeIDAndPasswordAndUserType(prnOrEmployeeId, password, userType);
        return user.isPresent() ? "Success" : "Failure";
    }

}
