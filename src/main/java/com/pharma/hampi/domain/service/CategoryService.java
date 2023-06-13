package com.pharma.hampi.domain.service;


import com.pharma.hampi.domain.dto.CategoryDTO;
import com.pharma.hampi.domain.repository.CategoryRepositoryInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepositoryInterface categoryRepository;

    public List<CategoryDTO> getCategories() {
        return categoryRepository.getCategories();
    }

    public Optional<CategoryDTO> getCategory(int categoryId) {
        return categoryRepository.getCategory(categoryId);
    }

    public CategoryDTO save(CategoryDTO category) {
        return categoryRepository.save(category);
    }

    public boolean delete(int categoryId) {
        return getCategory(categoryId).map(cat -> {
            categoryRepository.delete(categoryId);
            return true;
        }).orElse(false);
    }



}
