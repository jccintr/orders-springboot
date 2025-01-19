package com.jcsoftware.orders.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcsoftware.orders.entities.User;
import com.jcsoftware.orders.repositories.UserRepository;

@Service
public class UserService {
	
    @Autowired
	private UserRepository repository;
    
    public List<User> findAll(){
    	
    	return repository.findAll();
    }
    
    public User findById(Long id) {
    	Optional<User> user =  repository.findById(id);
    	return user.get();
    	
    }
}
