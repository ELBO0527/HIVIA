package com.example.hibia.domain;

import com.example.hibia.domain.common.CommonDateEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
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

    @Column
    private int order_status;

    //구매자를 나타내기 위해 사용자
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
