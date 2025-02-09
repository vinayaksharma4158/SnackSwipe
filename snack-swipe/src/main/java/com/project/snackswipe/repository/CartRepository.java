package com.project.snackswipe.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.snackswipe.model.CartItem;

@Repository
public interface CartRepository extends MongoRepository<CartItem,String>{
	
}
