package com.example.hibia.repository;

import com.example.hibia.domain.Cart;
import com.example.hibia.domain.Order;
import com.example.hibia.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
