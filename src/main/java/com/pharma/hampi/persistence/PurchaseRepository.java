package com.pharma.hampi.persistence;

import com.pharma.hampi.domain.dto.PurchaseDTO;
import com.pharma.hampi.domain.repository.PurchaseRepositoryInterface;
import com.pharma.hampi.persistence.crud.PurchaseCrudRepository;
import com.pharma.hampi.persistence.entity.ProductEntity;
import com.pharma.hampi.persistence.entity.PurchaseEntity;
import com.pharma.hampi.persistence.entity.PurchaseItemEntity;
import com.pharma.hampi.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements PurchaseRepositoryInterface {

    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Autowired
    private PurchaseMapper mapper;


    @Override
    public List<PurchaseDTO> getPurchases() {
        List<PurchaseEntity> purchases= (List<PurchaseEntity>) purchaseCrudRepository.findAll();
        return mapper.toPurchases(purchases);
    }

    @Override
    public Optional<List<PurchaseDTO>> getPurchasesByCustomer(String customerId) {
        return purchaseCrudRepository.findByCustomerID(customerId)
                .map(customers -> mapper.toPurchases(customers));
    }

    @Override
    public PurchaseDTO save(PurchaseDTO purchase) {
        PurchaseEntity purchaseObj = mapper.toPurchaseEntity(purchase);
        List<PurchaseItemEntity> products = purchaseObj.getProducts(); // Gte product list
        products.forEach(prod -> prod.setPurchase(purchaseObj));
        return mapper.toPurchase(purchaseCrudRepository.save(purchaseObj));
    }
}
