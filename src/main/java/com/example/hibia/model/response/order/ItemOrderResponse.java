package com.example.hibia.model.response.order;

import com.example.hibia.domain.Item;
import com.example.hibia.domain.Item_order;
import com.example.hibia.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemOrderResponse {
    private Item item;
    private String name;
    private int price;
    private int total;
    private int quantity;

    public ItemOrderResponse(Item_order o) {
        item = o.getItem();
        name = o.getName();
        price = o.getPrice();
        total = o.getTotal();
        quantity = o.getQuantity();
    }

    public static ItemOrderResponse from(Item_order itemOrder){
        return new ItemOrderResponse(
                itemOrder.getItem(),
                itemOrder.getName(),
                itemOrder. getPrice(),
                itemOrder.getTotal(),
                itemOrder.getQuantity());
    }
}
