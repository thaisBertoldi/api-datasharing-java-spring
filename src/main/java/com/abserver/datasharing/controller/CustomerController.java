package com.abserver.datasharing.controller;

import com.abserver.datasharing.domain.Customer;
import com.abserver.datasharing.dto.CustomerDTO;
import com.abserver.datasharing.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(new CustomerDTO(service.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(new CustomerDTO(service.createCustomer(customerDTO)));
    }
}
