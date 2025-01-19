package com.jcsoftware.orders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcsoftware.orders.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
