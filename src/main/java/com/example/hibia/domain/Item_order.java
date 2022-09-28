package com.example.hibia.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class Item_order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemOrder_id")
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
}
