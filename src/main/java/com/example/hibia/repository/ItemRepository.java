package com.example.hibia.repository;

import com.example.hibia.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByName(String name);
    List<Item> findItemContainsIgnoreCaseByName(String keyword);
    Page<Item> findByNameContains(String keyword,Pageable pageable);
    //Page<Item> findByItemnameDesc(String name, Pageable pageable);


}