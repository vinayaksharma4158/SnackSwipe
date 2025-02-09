package com.project.snackswipe.service;


import org.springframework.stereotype.Service;
import java.util.Optional;

import com.project.snackswipe.exception.UserNotFoundException;
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

    public UserSignUp findByPrnOrEmployeeId( String userType,String prnOrEmployeeId,String name, String password) {
    	Optional<UserSignUp> user = userRepository.findByPrnOrEmployeeIDAndPasswordAndUserType(userType, prnOrEmployeeId, name, password);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException("User Not Found with Given Details");
        }
        }
    
    public String resetPassword(String email, String userType, String prnOrEmployeeId, String newPassword) {
        Optional<UserSignUp> userOptional = userRepository.findByEmailAndUserTypeAndPrnOrEmployeeId(email, userType, prnOrEmployeeId);
        if (userOptional.isPresent()) {
            UserSignUp user = userOptional.get();
            user.setPassword(newPassword); // Hash the password in production
            userRepository.save(user);
            return "Success";
        }
        return "Failure";
    }



    

}
