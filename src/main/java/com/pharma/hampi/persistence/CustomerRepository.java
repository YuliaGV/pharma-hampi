package com.pharma.hampi.persistence;

import com.pharma.hampi.domain.dto.CustomerDTO;
import com.pharma.hampi.domain.repository.CustomerRepositoryInterface;
import com.pharma.hampi.persistence.crud.CustomerCrudRepository;
import com.pharma.hampi.persistence.entity.CustomerEntity;
import com.pharma.hampi.persistence.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


 @Repository
public class CustomerRepository implements CustomerRepositoryInterface {


     @Autowired
     private CustomerCrudRepository customerCrudRepository;

     @Autowired
     private CustomerMapper mapper;


    @Override
    public List<CustomerDTO> getCustomers() {
        List <CustomerEntity> customers = (List<CustomerEntity>) customerCrudRepository.findAll();
        return mapper.toCustomers(customers);
    }

    @Override
    public Optional<CustomerDTO> getCustomer(String customerId) {
        Optional<CustomerEntity> customer = customerCrudRepository.findById(customerId);
        return customer.map(cust -> mapper.toCustomer(cust));
    }

    @Override
    public CustomerDTO save(CustomerDTO customer) {
        return mapper.toCustomer(customerCrudRepository.save(mapper.toCustomerEntity(customer)));
    }
}
