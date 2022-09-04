package com.example.hibia.domain;

import com.example.hibia.domain.common.CommonDateEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id") // 양뱡향 무한참조
@Table(name = "orders")
public class Order extends CommonDateEntity {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

<<<<<<< HEAD
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "item_price")
    private int iprice;

    @Column(name = "total_price")
    private int tprice;

    @Column
    private String require;

    @Column
    private Address address;
=======
    @Column
    private String needs;

    @Column(name = "item_price")
    private int price;

    @Column
    private int deliveryfee;

    @Column(name = "total_price")
    private int totalprice;

    @Column
    private String name;

    @Column
    private String mobile;

    @Column
    private String addr;

    @Column
    private String addrdetail;


    //장바구니
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    //구매자를 나타내기 위해 사용자
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
>>>>>>> 04fee5a6ff01f3142ecb354b999eb509a1ec39e4
}
