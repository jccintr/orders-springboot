package com.jcsoftware.orders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jcsoftware.orders.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
