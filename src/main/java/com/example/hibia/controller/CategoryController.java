package com.example.hibia.controller;

import com.example.hibia.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "category")
public class CategoryController {

    private final CategoryService categoryService;

}
