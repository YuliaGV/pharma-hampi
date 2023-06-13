package com.pharma.hampi.persistence.crud;

import com.pharma.hampi.persistence.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<CategoryEntity, Integer> {

}
