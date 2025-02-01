package com.project.snackswipe.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;


import com.project.snackswipe.model.UserSignUp;

/**
 * Author : lenovo
 * Date : 31-Jan-2025
 * Time : 1:54:07 pm
*/
@Repository
public interface UserRepository extends MongoRepository<UserSignUp,String>{
     
	 @Query("{'prnOrEmployeeId': ?0,'password': ?1, 'userType': ?2}")
	Optional<UserSignUp> findByPrnOrEmployeeIDAndPasswordAndUserType(String prnOrEmployeeId,String password,String userType);
}
