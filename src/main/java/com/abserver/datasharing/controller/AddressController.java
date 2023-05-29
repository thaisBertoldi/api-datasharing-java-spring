package com.abserver.datasharing.controller;

import com.abserver.datasharing.domain.Address;
import com.abserver.datasharing.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> create(@Valid @RequestBody Address address) {
        return ResponseEntity.ok(addressService.create(address));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Address> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(addressService.findById(id));
    }
}
