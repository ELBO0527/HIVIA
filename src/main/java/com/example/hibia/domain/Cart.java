package com.example.hibia.domain;

import com.example.hibia.domain.common.CommonDateEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
public class Cart extends CommonDateEntity {

    @Id
    @GeneratedValue
    @Column(name = "cart_id")
    private Long id;

    @OneToOne//누구의 장바구니인지 구분
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "item_quantity")//장바구니에 담은 아이템 수량
    private int quantity;

    public Cart(User user, Item item, int quantity){
        this.user = user;
        this.item = item;
        this.quantity = quantity;
    }

    public Cart setCart(int quantity){
        this.quantity = quantity;
        return this;
    }
}
