package com.abserver.datasharing.controller;

import com.abserver.datasharing.domain.Company;
import com.abserver.datasharing.domain.Customer;
import com.abserver.datasharing.dto.CompanyDTO;
import com.abserver.datasharing.dto.CustomerDTO;
import com.abserver.datasharing.dto.NewCompanyDTO;
import com.abserver.datasharing.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "companies")
public class CompanyController {

    @Autowired
    private CompanyService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CompanyDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(new CompanyDTO(service.findById(id)));
    }

    @GetMapping()
    public ResponseEntity<List<CompanyDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<CompanyDTO> create(@RequestBody NewCompanyDTO newCompanyDTO){
        CompanyDTO obj = new CompanyDTO(service.create(newCompanyDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody CompanyDTO objDTO){
        service.update(id, objDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
