package com.pharma.hampi.domain.service;

import com.pharma.hampi.domain.ProductDTO;
import com.pharma.hampi.domain.repository.ProductRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepositoryInterface productRepository;


    public List<ProductDTO> getAll() {
        return productRepository.getAll();
    }

    public Optional<ProductDTO> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public Optional<List<ProductDTO>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public ProductDTO save(ProductDTO product) {
        return productRepository.save(product);
    }

    public boolean delete(int productId) {
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
