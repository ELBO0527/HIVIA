package com.example.hibia.repository;

import com.example.hibia.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByName(String name);
}
