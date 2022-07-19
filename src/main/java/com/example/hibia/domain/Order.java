package com.example.hibia.domain;

import com.example.hibia.domain.common.CommonDateEntity;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "orders")
public class Order extends CommonDateEntity {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;


}
