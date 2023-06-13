package com.pharma.hampi.domain.service;


import com.pharma.hampi.domain.dto.CustomerDTO;
import com.pharma.hampi.domain.repository.CustomerRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {


    @Autowired
    private CustomerRepositoryInterface customerRepository;


    public List<CustomerDTO> getCategories() {
        return customerRepository.getCustomers();
    }


    public Optional<CustomerDTO> getCustomer(String customerId) {
        return customerRepository.getCustomer(customerId);
    }

    public CustomerDTO save(CustomerDTO customer) {
        return customerRepository.save(customer);
    }




}
