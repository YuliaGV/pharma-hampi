package com.pharma.hampi.persistence.crud;

import com.pharma.hampi.persistence.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerCrudRepository extends CrudRepository<CustomerEntity, String> {

}
