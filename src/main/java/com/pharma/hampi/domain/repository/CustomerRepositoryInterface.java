package com.pharma.hampi.domain.repository;

import com.pharma.hampi.domain.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerRepositoryInterface {

    List<CustomerDTO> getCustomers();
    Optional<CustomerDTO> getCustomer(String customerId);
    CustomerDTO save(CustomerDTO customer);



}
