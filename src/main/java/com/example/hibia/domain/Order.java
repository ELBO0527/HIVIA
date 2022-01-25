package com.example.hibia.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;
}
