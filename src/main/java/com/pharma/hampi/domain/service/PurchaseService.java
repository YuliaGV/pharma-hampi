package com.pharma.hampi.domain.service;



import com.pharma.hampi.domain.dto.PurchaseDTO;
import com.pharma.hampi.domain.repository.PurchaseRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepositoryInterface purchaseRepository;

    public List<PurchaseDTO> getPurchases() {
        return purchaseRepository.getPurchases();
    }

    public Optional<List<PurchaseDTO>> getPurchasesByCustomer(String customerId){
        return purchaseRepository.getPurchasesByCustomer(customerId);
    }

    public PurchaseDTO save(PurchaseDTO purchase){
        return purchaseRepository.save(purchase);
    }


}
