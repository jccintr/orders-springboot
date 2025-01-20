package com.jcsoftware.orders.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jcsoftware.orders.entities.Category;
import com.jcsoftware.orders.entities.Order;
import com.jcsoftware.orders.entities.OrderItem;
import com.jcsoftware.orders.entities.Payment;
import com.jcsoftware.orders.entities.Product;
import com.jcsoftware.orders.entities.User;
import com.jcsoftware.orders.entities.enums.OrderStatus;
import com.jcsoftware.orders.repositories.CategoryRepository;
import com.jcsoftware.orders.repositories.OrderItemRepository;
import com.jcsoftware.orders.repositories.OrderRepository;
import com.jcsoftware.orders.repositories.ProductRepository;
import com.jcsoftware.orders.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
    @Autowired
	private UserRepository userRepository;
    
    @Autowired
	private OrderRepository orderRepository;
    
    @Autowired
   	private OrderItemRepository orderItemRepository;
    
    @Autowired
   	private CategoryRepository categoryRepository;
    
    @Autowired
   	private ProductRepository productRepository;


	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User(null, "Joyce Torres", "joyce@gmail.com", "977777777", "123456");
		User u4 = new User(null, "Daniela Barbosa", "danny@gmail.com", "977777777", "123456");
		User u5 = new User(null, "Graça Oliveira", "gracinha@gmail.com", "977777777", "123456");
		userRepository.saveAll(Arrays.asList(u1,u2,u3,u4,u5));
		Order o1 = new Order(null, Instant.parse("2025-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2025-07-21T03:42:10Z"),OrderStatus.SHIPPED, u2);
		Order o3 = new Order(null, Instant.parse("2025-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, u3);
		Order o4 = new Order(null, Instant.parse("2025-09-10T03:42:10Z"),OrderStatus.CANCELED, u2);
		orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4));
		Category cat1 = new Category(null,"Informática");
		Category cat2 = new Category(null,"Bebidas");
		Category cat3 = new Category(null,"BDSM");
		Category cat4 = new Category(null,"Segurança");
		Category cat5 = new Category(null,"Telefonia");
		Category cat6 = new Category(null,"Novidades");
		Category cat7 = new Category(null,"Em Promoção");
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6,cat7));
		Product p1 = new Product(null, "Mordaça de Bola", "Mordaça de bola em borracha 4 pol na cor vermelha", 20.99, "https:link.com");
		Product p2 = new Product(null, "Cerveja Skol 350ml", "Cerveja Skol pilsen pc 18x350ml", 54.55, "https:link.com");
		Product p3 = new Product(null, "Motorola V3", "Telefone celular Motorola V3 GSM", 1251.50, "https:link.com");
		Product p4 = new Product(null, "HolyTrainer V5", "Dispositivo de castidade HTV5 em resina.", 780.00, "https:link.com");
		Product p5 = new Product(null, "Alarme SeguMax", "Sistema de alarme com 5 sensores,sirene e bateria", 399.00, "https:link.com");
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		p1.getCategories().add(cat3);
		p2.getCategories().add(cat2);
		p3.getCategories().add(cat5);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat4);
		p1.getCategories().add(cat6);
		p4.getCategories().add(cat7);
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 
        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
        
        Payment pay1 = new Payment(null,Instant.parse("2025-06-20T21:53:07Z"),o1);
        o1.setPayment(pay1);
        orderRepository.save(o1);
        
	}
}
