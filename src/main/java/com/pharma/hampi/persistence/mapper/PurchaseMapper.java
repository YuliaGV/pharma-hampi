package com.pharma.hampi.persistence.mapper;


import com.pharma.hampi.domain.dto.PurchaseDTO;
import com.pharma.hampi.persistence.entity.PurchaseEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {



    @Mappings({
            @Mapping(source = "purchaseID", target = "purchaseId"),
            @Mapping(source = "customerID", target = "customerId"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "paymentMethod", target = "paymentMethod"),
            @Mapping(source = "comment", target = "comment"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "products", target = "items"),


    })
    PurchaseDTO toPurchase(PurchaseEntity purchase);
    List<PurchaseDTO> toPurchases(List<PurchaseEntity> purchases);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "customer", ignore = true),


    })
    PurchaseEntity toPurchaseEntity(PurchaseDTO purchase);


}
