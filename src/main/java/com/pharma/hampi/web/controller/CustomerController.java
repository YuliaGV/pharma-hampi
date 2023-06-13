package com.pharma.hampi.web.controller;



import com.pharma.hampi.domain.dto.CategoryDTO;
import com.pharma.hampi.domain.dto.CustomerDTO;
import com.pharma.hampi.domain.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {


    @Autowired
    private CustomerService customerService;


    @GetMapping("/all")
    public ResponseEntity<List<CustomerDTO>> getCategories(){
        return new ResponseEntity<>(customerService.getCategories(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("id") String customerId){
        return customerService.getCustomer(customerId)
                .map(customers-> new ResponseEntity<>(customers, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/save")
    public ResponseEntity<CustomerDTO> save(@RequestBody CustomerDTO customer){
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }


}
