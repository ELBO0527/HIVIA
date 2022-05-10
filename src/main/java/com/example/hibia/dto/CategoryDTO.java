package com.example.hibia.dto;

import com.example.hibia.domain.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDTO {

    private Long id;
    private String name;
    private Long parentId;
    private List<Category> subCategories;

    public CategoryDTO(Long id,String name,Long parentId){
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }
}
