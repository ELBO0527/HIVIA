package com.example.hibia.domain;

import com.example.hibia.domain.common.CommonDateEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item extends CommonDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long id;

    @Column(name = "item_name")
    private String name;

    @Column(name = "manufacture_country")
    private String country;

    @Column
    private String color;

    @Column
    private String brand;

    @Column
    private int price;

    @Column(length = 1)
    private int stars;

    @Column
    private int stock;

    @Column
    private int size;

    @Column
    private LocalDate prodDate;

    @Builder
    public Item(Long id, String name, String country, String color, String brand, int price, int stars, int stock, int size, LocalDate prodDate) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.color = color;
        this.brand = brand;
        this.price = price;
        this.stars = stars;
        this.stock = stock;
        this.size = size;
        this.prodDate = prodDate;
    }

    public void setItem(String name, String country, String color, String brand, int price,
                        int stars, int stock, int size, LocalDate prodDate){
        this.name = name;
        this.country = country;
        this.color = color;
        this.brand = brand;
        this.price = price;
        this.stars = stars;
        this.stock = stock;
        this.size = size;
        this.prodDate = prodDate;
    }

    public void setStock(int stock){
        this.stock = stock;
    }
}
