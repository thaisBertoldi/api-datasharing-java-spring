package com.abserver.datasharing.service;

import com.abserver.datasharing.domain.Address;
import com.abserver.datasharing.domain.Company;
import com.abserver.datasharing.dto.CompanyDTO;
import com.abserver.datasharing.dto.NewCompanyDTO;
import com.abserver.datasharing.repository.AddressRepository;
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

    @Autowired
    private AddressService addressService;

    public Company findById(Integer id){
        Optional<Company> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Object not fount ! ID: " + id + " Type: " + Company.class.getName()
        ));
    }

    public List<CompanyDTO> findAll() {
        return repository.findAll().stream().map(CompanyDTO::new).collect(Collectors.toList());
    }

    public Company create(NewCompanyDTO objDTO) {
        Address address = addressService.findById(objDTO.getAddress());
        Company obj = new Company(null, objDTO.getTradeName(), objDTO.getCnpj(), objDTO.getLegalRepresentative(), objDTO.getPhone(), objDTO.getEmail(), address);
        return repository.save(obj);
    }
}
