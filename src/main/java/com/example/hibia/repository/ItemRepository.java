package com.example.hibia.repository;

import com.example.hibia.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByName(String name);
    //Page<Item> findByItemnameDesc(String name, Pageable pageable);
}