package com.pharma.hampi.persistence.crud;

import com.pharma.hampi.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {

    //Query methods
    List<ProductEntity> findByCategoryIDOrderByNameAsc(int categoryID);
    Optional<List<ProductEntity>> findByStockQuantityLessThanAndStatus(int stockQuantity, boolean status);



}
