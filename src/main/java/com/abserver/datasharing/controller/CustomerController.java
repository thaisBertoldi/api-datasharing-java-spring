package com.abserver.datasharing.controller;

import com.abserver.datasharing.domain.Customer;
import com.abserver.datasharing.dto.CustomerDTO;
import com.abserver.datasharing.service.CustomerService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
    public ResponseEntity<CustomerDTO> create(@Valid @RequestBody CustomerDTO customerDTO) {
        CustomerDTO obj = new CustomerDTO(service.create(customerDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody CustomerDTO objDTO){
        Customer obj = service.fromDTO(objDTO);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/phone/{id}")
    public ResponseEntity<String> updatePhone(@NonNull @PathVariable("id") Integer id, @Valid @RequestBody Customer obj) {
        Customer customer = service.findById(id);
        customer.setPhone(obj.getPhone());
        customer = service.update(customer);
        return ResponseEntity.noContent().build();
    }

}
