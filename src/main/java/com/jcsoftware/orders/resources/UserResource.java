package com.jcsoftware.orders.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcsoftware.orders.entities.User;
import com.jcsoftware.orders.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll(){
		
		User u = new User(1L,"Joyce Torres","joyce@gmail.com","35-3641-10050","gostosa");
        return ResponseEntity.ok().body(u);
        
      //  UserRepository ur;
     //   List<User> users = ur.findAll();
      //  return ResponseEntity.ok().body(users.to);
        
	}
}
