package com.example.hibia.repository.order;

import com.example.hibia.domain.Item_order;
import com.example.hibia.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Item_OrderRepository extends JpaRepository<Item_order,Long> {
}
