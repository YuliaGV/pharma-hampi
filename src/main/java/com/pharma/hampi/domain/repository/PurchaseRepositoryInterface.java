package com.pharma.hampi.domain.repository;

import com.pharma.hampi.domain.dto.PurchaseDTO;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepositoryInterface {

    List<PurchaseDTO> getPurchases();
    Optional<List<PurchaseDTO>> getPurchasesByCustomer(String customerId);
    PurchaseDTO save(PurchaseDTO purchase);
}


