package com.example.hibia.model.response.order;

import com.example.hibia.domain.Item;
import com.example.hibia.domain.Item_order;
import com.example.hibia.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemOrderResponse {
    private Item item;
    private String name;
    private int price;
    private int total;
    private int quantity;


}
