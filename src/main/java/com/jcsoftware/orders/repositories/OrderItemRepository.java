package com.jcsoftware.orders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcsoftware.orders.entities.OrderItem;
import com.jcsoftware.orders.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem,OrderItemPK> {

}
