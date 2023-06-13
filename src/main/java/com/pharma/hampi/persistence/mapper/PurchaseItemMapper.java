package com.pharma.hampi.persistence.mapper;
import com.pharma.hampi.domain.dto.PurschaseItemDTO;
import com.pharma.hampi.persistence.entity.PurchaseItemEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.productID", target = "productId"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "status", target = "active"),


    })
    PurschaseItemDTO toPurchaseItem(PurchaseItemEntity purchaseItem);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "id.purchaseID", ignore = true)


    })
    PurchaseItemEntity toPurchaseItemEntity(PurschaseItemDTO purchaseItem);


}
