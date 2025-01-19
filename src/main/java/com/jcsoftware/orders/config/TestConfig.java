package com.jcsoftware.orders.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jcsoftware.orders.entities.Order;
import com.jcsoftware.orders.entities.User;
import com.jcsoftware.orders.repositories.OrderRepository;
import com.jcsoftware.orders.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
    @Autowired
	private UserRepository userRepository;
    
    @Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User(null, "Joyce Torres", "joyce@gmail.com", "977777777", "123456");
		User u4 = new User(null, "Daniela Barbosa", "danny@gmail.com", "977777777", "123456");
		User u5 = new User(null, "Graça Oliveira", "gracinha@gmail.com", "977777777", "123456");
		userRepository.saveAll(Arrays.asList(u1,u2,u3,u4,u5));
		Order o1 = new Order(null, Instant.parse("2025-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2025-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2025-07-22T15:21:22Z"), u3);
		Order o4 = new Order(null, Instant.parse("2025-09-10T03:42:10Z"), u2);
		orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4));
	}
}
