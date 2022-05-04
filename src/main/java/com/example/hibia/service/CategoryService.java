package com.example.hibia.service;

import com.example.hibia.domain.Category;
import com.example.hibia.dto.CategoryDTO;
import com.example.hibia.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryDTO createCategoryRoot(){
        Map<Long, List<CategoryDTO>> groupingByParent = categoryRepository.findAll()
                .stream()
                .map(ce -> new CategoryDTO(ce.getId(), ce.getName(), ce.getParentId()))
                .collect(groupingBy(cd -> cd.getParentId()));

        CategoryDTO rootCategoryDto = new CategoryDTO(0l,"ROOT", null);
        addSubCategories(rootCategoryDto, groupingByParent);

        return rootCategoryDto;
    }

    private void addSubCategories(CategoryDTO parent, Map<Long, List<CategoryDTO>> groupingByParentId) {
        List<CategoryDTO> subCategories = groupingByParentId.get(parent.getId());

        if(subCategories == null)
            return;

        parent.setSubCategories(parent.getSubCategories());

        subCategories.stream()
                .forEach(s -> {
                    addSubCategories(s, groupingByParentId);
                });
    }

    private List<Category> findAll(){
        return categoryRepository.findAll();
    }
}
