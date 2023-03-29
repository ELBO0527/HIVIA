package com.example.hibia.domain;

import com.example.hibia.domain.common.CommonDateEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders")
public class Order extends CommonDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

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

    @Column
    private int order_status;

    //구매자를 나타내기 위해 사용자
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Order(Long id, String needs, int price, int deliveryfee, int totalprice, String name, String mobile, String addr, String addrdetail, int order_status, User user) {
        this.id = id;
        this.needs = needs;
        this.price = price;
        this.deliveryfee = deliveryfee;
        this.totalprice = totalprice;
        this.name = name;
        this.mobile = mobile;
        this.addr = addr;
        this.addrdetail = addrdetail;
        this.order_status = order_status;
        this.user = user;
    }
}
