package com.pharma.hampi.persistence.mapper;

import com.pharma.hampi.domain.dto.CustomerDTO;
import com.pharma.hampi.persistence.entity.CustomerEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mappings({
            @Mapping(source = "id", target = "customerId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "phoneNumber", target = "phoneNumber"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "address", target = "address"),
    })
    CustomerDTO toCustomer(CustomerEntity customer);
    List<CustomerDTO> toCustomers (List <CustomerEntity> customers);


    @InheritInverseConfiguration
    @Mapping(target = "purchases", ignore = true)
    CustomerEntity toCustomerEntity(CustomerDTO customer);

}
