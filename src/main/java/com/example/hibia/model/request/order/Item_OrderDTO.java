package com.example.hibia.model.request.order;

import com.example.hibia.domain.Item;
import com.example.hibia.domain.Order;
import lombok.Data;

@Data
public class Item_OrderDTO {

    private Item item;
    private Order order;
    private String name;
    private int price;
    private int total;
    private int quantity;
}
