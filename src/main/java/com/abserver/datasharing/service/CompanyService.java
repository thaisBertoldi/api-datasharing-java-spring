package com.abserver.datasharing.service;

import com.abserver.datasharing.domain.Address;
import com.abserver.datasharing.domain.Company;
import com.abserver.datasharing.dto.CompanyDTO;
import com.abserver.datasharing.dto.NewCompanyDTO;
import com.abserver.datasharing.repository.CompanyRepository;
import com.abserver.datasharing.service.exception.AddressRepeatedException;
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
        List<CompanyDTO> list = findAll();
        for(CompanyDTO obj : list){
            if(obj.getAddress().getId() == objDTO.getAddress()){
                throw new AddressRepeatedException("this address is already in use for Company: "+obj.getTradeName());
            }
        }
        Address address = addressService.findById(objDTO.getAddress());
            Company obj = new Company(null, objDTO.getTradeName(), objDTO.getCnpj(), objDTO.getLegalRepresentative(), objDTO.getPhone(), objDTO.getEmail(), address);
            return repository.save(obj);
    }

    public Company update(Integer id, CompanyDTO objDTO) {
        Company obj = findById(id);
        updateData(objDTO, obj);
        return repository.save(obj);
    }

    private void updateData(CompanyDTO objDTO, Company obj) {
        obj.setEmail(objDTO.getEmail());
        obj.setPhone(objDTO.getPhone());
    }

    public void deleteById(Integer id) {
        Company company = findById(id);
        repository.deleteById(id);
        addressService.deleteById(company.getAddress().getId());
    }

}
