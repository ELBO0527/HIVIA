package com.example.hibia.repository;

import com.example.hibia.domain.Cart;
import com.example.hibia.domain.Item;
import com.example.hibia.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.JpaParameters;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUser(User user);
    Cart findByItem(Item item);
}
