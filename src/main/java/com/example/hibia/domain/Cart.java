package com.example.hibia.domain;

import com.example.hibia.domain.common.CommonDateEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id") // 양뱡향 무한참조
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

    @Column(name = "sub_total")//장바구니에 담은 아이템 수량
    private int total;

    public Cart setCart(int quantity){
        this.quantity = quantity;
        return this;
    }

    public int soldItem(Item item){
        return item.getStock() - quantity;
    }
}
