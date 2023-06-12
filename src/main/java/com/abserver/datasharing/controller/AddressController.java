package com.abserver.datasharing.controller;

import com.abserver.datasharing.domain.Address;
import com.abserver.datasharing.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.net.URI;

@RestController
@RequestMapping(value = "addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> create(@Valid @RequestBody Address address) {
        Address obj = addressService.create(address);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Address> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(addressService.findById(id));
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Address obj){
        addressService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Address>> findAll(){
        return ResponseEntity.ok(addressService.findAll());
    }
}
