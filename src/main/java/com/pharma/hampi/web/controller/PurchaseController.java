package com.pharma.hampi.web.controller;

import com.pharma.hampi.domain.dto.ProductDTO;
import com.pharma.hampi.domain.dto.PurchaseDTO;
import com.pharma.hampi.domain.service.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    public ResponseEntity<List<PurchaseDTO>> getPurchases(){
        return new ResponseEntity<>(purchaseService.getPurchases(), HttpStatus.OK);
    }


    @GetMapping("/client/{id}")
    public ResponseEntity<List<PurchaseDTO>> getPurchasesByClient (@PathVariable("id") String customerId){
        return purchaseService.getPurchasesByCustomer(customerId)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<PurchaseDTO> save(@RequestBody PurchaseDTO purchase){
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED );
    }

}
