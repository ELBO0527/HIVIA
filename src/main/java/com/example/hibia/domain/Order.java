package com.example.hibia.domain;

import com.example.hibia.domain.common.CommonDateEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    //총 가격 구하기
    public int sum(int price, int deliveryfee, int totalprice){
        return totalprice = deliveryfee + price;
    }

    /*
    * 수량 제거
    */
    public int stockRemove(){
        Item item = new Item();
        item.setStock(item.getStock() - cart.getQuantity());
        return 1;
    }
}
