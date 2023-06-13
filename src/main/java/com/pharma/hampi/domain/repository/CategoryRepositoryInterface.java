package com.pharma.hampi.domain.repository;

import com.pharma.hampi.domain.dto.CategoryDTO;


import java.util.List;
import java.util.Optional;

public interface CategoryRepositoryInterface {

    List<CategoryDTO> getCategories();
    Optional<CategoryDTO> getCategory(int productId);
    CategoryDTO save(CategoryDTO category);
    void delete(int categoryId);
}
