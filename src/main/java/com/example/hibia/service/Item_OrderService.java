package com.example.hibia.service;

import com.example.hibia.repository.Item_OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class Item_OrderService {

    private final Item_OrderRepository itemOrderRepository;
}
