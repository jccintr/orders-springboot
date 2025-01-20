package com.jcsoftware.orders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcsoftware.orders.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{

}
