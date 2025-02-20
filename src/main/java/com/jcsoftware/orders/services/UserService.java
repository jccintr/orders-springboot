package com.jcsoftware.orders.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.jcsoftware.orders.entities.User;
import com.jcsoftware.orders.repositories.UserRepository;
import com.jcsoftware.orders.services.exceptions.IntegrityViolationException;
import com.jcsoftware.orders.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
    @Autowired
	private UserRepository repository;
    
    public List<User> findAll(){
    	
    	return repository.findAll();
    }
    
    public User findById(Long id) {
    	Optional<User> user =  repository.findById(id);
    	return user.orElseThrow(()->new ResourceNotFoundException(id));
    	
    }
    
    public User insert(User newUser) {
    	return repository.save(newUser);
    }
    
    public void delete(Long id) {
    	
    	try {
    		if(repository.existsById(id)) {
    			repository.deleteById(id);	
    		} else {
    			throw(new ResourceNotFoundException(id));
    		}
    			
    	}
    	
    	catch(DataIntegrityViolationException e) {
    		throw(new IntegrityViolationException(id));
    	}
    	 
    }
    
    public User update(Long id,User obj) {
    	
	    try {	
	     User entity = repository.getReferenceById(id);
	     updateData(entity,obj);
	     return repository.save(entity);
	    } 
	    catch (EntityNotFoundException e) {
	    	throw(new ResourceNotFoundException(id));
	    }
    
    }
    
    private void updateData(User entity, User obj) {
    	entity.setName(obj.getName());
    	entity.setEmail(obj.getEmail());
    	entity.setPhone(obj.getPhone());
    	
    }
}
