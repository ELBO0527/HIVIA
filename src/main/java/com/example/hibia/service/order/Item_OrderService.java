package com.example.hibia.service.order;

import com.example.hibia.domain.Item_order;
import com.example.hibia.model.response.order.ItemOrderResponse;
import com.example.hibia.repository.order.Item_OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class Item_OrderService {

    private final Item_OrderRepository itemOrderRepository;
    private final ItemOrderResponse itemOrderResponse;


}
