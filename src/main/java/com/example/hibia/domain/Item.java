package com.example.hibia.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
public class Item {

    @Id
    @GeneratedValue
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

}
