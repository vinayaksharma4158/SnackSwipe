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
     
	 @Query("{ 'userType': ?0, 'prnOrEmployeeId': ?1,'name': ?2, 'password': ?3}")
	Optional<UserSignUp> findByPrnOrEmployeeIDAndPasswordAndUserType(String userType,String prnOrEmployeeId,String name,String password);
	 
	 @Query("{ 'prnOrEmployeeId' : ?0 }")
	 Optional<UserSignUp> findByPrnOrEmployeeId(String prnOrEmployeeId);

	 @Query("{ 'email': ?0, 'userType': ?1, 'prnOrEmployeeId': ?2 }")
	 Optional<UserSignUp> findByEmailAndUserTypeAndPrnOrEmployeeId(String email, String userType, String prnOrEmployeeId);

	 
	 
	 
}
