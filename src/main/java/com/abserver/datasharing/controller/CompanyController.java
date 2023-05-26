package com.abserver.datasharing.controller;

import com.abserver.datasharing.domain.Customer;
import com.abserver.datasharing.dto.CompanyDTO;
import com.abserver.datasharing.dto.CustomerDTO;
import com.abserver.datasharing.service.CustomerService;
import com.abserver.datasharing.service.exception.CompanyService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

}
