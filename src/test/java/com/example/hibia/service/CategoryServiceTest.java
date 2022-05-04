package com.example.hibia.service;

import com.example.hibia.domain.Category;
import com.example.hibia.dto.CategoryDTO;
import com.example.hibia.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

     @Test
         public void hello(){
             //given
         List<Category> categoryList = createCategoryList();
         given(categoryRepository.findAll())
                 .willReturn(categoryList);

             //when
         CategoryDTO categoryDTO = categoryService.createCategoryRoot();
             //then
        verify(categoryRepository, atLeastOnce()).findAll();
            //root


     }

    private List<Category> createCategoryList() {
         return null;
    }
}