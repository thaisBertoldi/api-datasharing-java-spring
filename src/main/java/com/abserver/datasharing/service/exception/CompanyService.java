package com.abserver.datasharing.service.exception;

import com.abserver.datasharing.domain.Company;
import com.abserver.datasharing.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

}
