package com.pharma.hampi.persistence.crud;


import com.pharma.hampi.persistence.entity.PurchaseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseCrudRepository extends CrudRepository<PurchaseEntity, Integer> {

    //Query methods
    Optional<List<PurchaseEntity>> findByCustomerID(String customerID);


}
