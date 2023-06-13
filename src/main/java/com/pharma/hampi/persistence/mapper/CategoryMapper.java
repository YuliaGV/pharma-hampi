package com.pharma.hampi.persistence.mapper;

import com.pharma.hampi.domain.dto.CategoryDTO;
import com.pharma.hampi.persistence.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "categoryID", target = "categoryId"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "status", target = "active"),
    })
    CategoryDTO toCategory(CategoryEntity category);
    List<CategoryDTO> toCategories(List<CategoryEntity> categories);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    CategoryEntity toCategoryEntity(CategoryDTO category);



}
