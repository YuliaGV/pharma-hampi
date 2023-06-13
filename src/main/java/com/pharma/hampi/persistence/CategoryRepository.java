package com.pharma.hampi.persistence;

import com.pharma.hampi.domain.dto.CategoryDTO;
import com.pharma.hampi.domain.repository.CategoryRepositoryInterface;

import com.pharma.hampi.persistence.crud.CategoryCrudRepository;
import com.pharma.hampi.persistence.entity.CategoryEntity;
import com.pharma.hampi.persistence.mapper.CategoryMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository  implements CategoryRepositoryInterface {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    @Autowired
    private CategoryMapper mapper;


    @Override
    public List<CategoryDTO> getCategories() {
        List <CategoryEntity> categories = (List<CategoryEntity>) categoryCrudRepository.findAll();
        return mapper.toCategories(categories);
    }

    @Override
    public Optional<CategoryDTO> getCategory(int productId) {
        return categoryCrudRepository.findById(productId).map(prod->mapper.toCategory(prod));
    }

    @Override
    public CategoryDTO save(CategoryDTO category) {
        return mapper.toCategory(categoryCrudRepository.save(mapper.toCategoryEntity(category)));
    }

    @Override
    public void delete(int categoryId) {
        categoryCrudRepository.deleteById(categoryId);

    }
}
