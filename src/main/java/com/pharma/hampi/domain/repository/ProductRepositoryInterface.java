package com.pharma.hampi.domain.repository;

import com.pharma.hampi.domain.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryInterface {


    List<ProductDTO> getAll();
    Optional<List<ProductDTO>> getByCategory(int categoryId);
    Optional<List<ProductDTO>> getProductsWithLowStock(int minAmount);
    Optional<ProductDTO> getProduct(int productId);
    ProductDTO save(ProductDTO product);
    void delete(int productId);


}


