package com.pharma.hampi.persistence.mapper;


import com.pharma.hampi.domain.ProductDTO;
import com.pharma.hampi.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses={CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "productID", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "categoryID", target = "categoryId"),
            @Mapping(source = "sellingPrice", target = "price"),
            @Mapping(source = "barcode", target = "barcode"),
            @Mapping(source = "stockQuantity", target = "stock"),
            @Mapping(source = "status", target = "active"),
            @Mapping(source = "category", target = "category"),
    })
    ProductDTO toProduct(ProductEntity product);
    List<ProductDTO> toProducts(List<ProductEntity> products);

    @InheritInverseConfiguration
    //@Mapping(target = "barcode", ignore = true) //If I want to ignore an attribute in the mapping
    ProductEntity toProductEntity(ProductDTO product);

}
