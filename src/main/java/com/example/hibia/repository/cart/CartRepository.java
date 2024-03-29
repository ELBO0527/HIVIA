package com.example.hibia.repository.cart;

import com.example.hibia.domain.Cart;
import com.example.hibia.domain.Item;
import com.example.hibia.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.JpaParameters;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUser(User user);
    Cart findByItem(Item item);
    Cart findByItemAndUser(Item item, User user);
}
