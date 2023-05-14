package com.abserver.datasharing.controller;

import com.abserver.datasharing.domain.Customer;
import com.abserver.datasharing.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

}
