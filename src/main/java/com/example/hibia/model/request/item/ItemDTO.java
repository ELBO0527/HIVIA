package com.example.hibia.model.request.item;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ItemDTO {

    private String name;
    private String country;
    private String color;
    private String brand;
    private int price;
    private int stars;
    private int stock;
    private int size;
    private LocalDate prodDate;

}
