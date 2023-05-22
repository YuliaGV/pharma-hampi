package com.pharma.hampi.persistence;

import com.pharma.hampi.domain.ProductDTO;
import com.pharma.hampi.domain.repository.ProductRepositoryInterface;
import com.pharma.hampi.persistence.crud.ProductCrudRepository;
import com.pharma.hampi.persistence.entity.ProductEntity;
import com.pharma.hampi.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements ProductRepositoryInterface{

    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<ProductDTO> getAll(){
        List<ProductEntity>products = (List<ProductEntity>) productCrudRepository.findAll();
        return mapper.toProducts(products);
    }

    @Override
    public Optional<List<ProductDTO>> getByCategory(int categoryId){
        List<ProductEntity>products  = productCrudRepository.findByCategoryIDOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProducts(products));
    }

    @Override
    public Optional<List<ProductDTO>> getProductsWithLowStock(int minAmount){
        Optional<List<ProductEntity>>  products =productCrudRepository.findByStockQuantityLessThanAndStatus(minAmount, true);
        return products.map(prods-> mapper.toProducts(prods));
    }

    @Override
    public Optional<ProductDTO> getProduct(int productId){
        return productCrudRepository.findById(productId).map(prod -> mapper.toProduct(prod));
    }


    @Override
    public ProductDTO save(ProductDTO product){
        return mapper.toProduct(productCrudRepository.save(mapper.toProductEntity(product)));
    }

    @Override
    public void delete(int productId){
        productCrudRepository.deleteById(productId);
    }


}
