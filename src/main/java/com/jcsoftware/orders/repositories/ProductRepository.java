package com.jcsoftware.orders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcsoftware.orders.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
