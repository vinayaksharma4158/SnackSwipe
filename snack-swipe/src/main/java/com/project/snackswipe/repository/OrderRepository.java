package com.project.snackswipe.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.snackswipe.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

	@Query("{ 'prnOrEmployeeId': ?0 }")
	 Optional<Order> findByPrnOrEmployeeIdAndUsedFalse(String prnOrEmployeeId);
	
	@Query("{ 'qrData': ?0 }")
	Order findByQrData(String qrData);

	@Query("{ 'prnOrEmployeeId': ?0 }")
	Optional<Order> findByPrnOrEmployeeIdAndQrUsedFalse(String prnOrEmployeeId);

	@Query("{ 'prnOrEmployeeId': ?0 , 'createdDate' : ?1 }")
	Optional<Order> findByPrnOrEmployeeIdAndCreatedDate(String prnOrEmployeeId, LocalDateTime createdDate);

	@Query("{ '_id': ?0 }")
	 Optional<Order> findByIdAndIsUsedFalse(String id);
}