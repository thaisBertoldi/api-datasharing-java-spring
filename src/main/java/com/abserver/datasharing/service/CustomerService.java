package com.abserver.datasharing.service;

import com.abserver.datasharing.domain.Customer;
import com.abserver.datasharing.dto.CustomerDTO;
import com.abserver.datasharing.repository.CustomerRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer findById(Integer id){
        Optional<Customer> obj =  repository.findById(id);
        return obj.orElseThrow(()->new RuntimeException("Object not found !"));
    }

}
