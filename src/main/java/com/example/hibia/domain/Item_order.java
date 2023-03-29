package com.example.hibia.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item_order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_order_id")
    private Long id;

    @ManyToOne
    private Item item;

    @ManyToOne
    private Order order;

    @Column(name = "item_name")
    private String name;

    @Column(name = "item_price")
    private int price;

    @Column(name = "item_total")
    private int total;

    @Column(name = "order_quantity")
    private int quantity;

    @Builder
    public Item_order(Long id, Item item, Order order, String name, int price, int total, int quantity) {
        this.id = id;
        this.item = item;
        this.order = order;
        this.name = name;
        this.price = price;
        this.total = total;
        this.quantity = quantity;
    }
}
