package com.example.hibia.repository;

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
    //에러 분석을 위한 메서드 org.springframework.data.repository.query.QueryCreationException 란 무엇일까?? 어떤 원리로 쿼리를 찾고 작동하는것일까??
    //Cart findByItemnameAndItem(String name, Item item);
}
