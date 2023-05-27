package com.abserver.datasharing.service;

import com.abserver.datasharing.domain.Company;
import com.abserver.datasharing.dto.CompanyDTO;
import com.abserver.datasharing.repository.CompanyRepository;
import com.abserver.datasharing.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    public Company findById(Integer id){
        Optional<Company> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Object not fount ! ID: " + id + " Type: " + Company.class.getName()
        ));
    }

    public List<CompanyDTO> findAll() {
        return repository.findAll().stream().map(CompanyDTO::new).collect(Collectors.toList());
    }

}
