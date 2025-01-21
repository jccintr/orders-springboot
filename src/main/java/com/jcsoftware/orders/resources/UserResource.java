package com.jcsoftware.orders.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcsoftware.orders.entities.User;
import com.jcsoftware.orders.services.UserService;


@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
        List<User> users = service.findAll();
        return ResponseEntity.ok().body(users);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User newUser){
		newUser = service.insert(newUser);
		// return ResponseEntity.ok().body(newUser);
		 return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<User> delete(@PathVariable Long id){
		//User user = service.findById(id);
		service.delete(id);
		//return ResponseEntity.ok().body(user);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value="/{id}")
	public ResponseEntity<User> update(@PathVariable Long id,@RequestBody User obj){
		
		User user = service.update(id, obj);
		return ResponseEntity.ok().body(user);
		
	}
}
