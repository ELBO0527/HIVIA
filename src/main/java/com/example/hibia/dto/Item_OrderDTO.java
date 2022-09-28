package com.example.hibia.dto;

import com.example.hibia.domain.Item;
import com.example.hibia.domain.Order;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

@Data
public class Item_OrderDTO {

    private Item item;
    private Order order;
    private String name;
    private int price;
    private int total;
    private int quantity;
}
