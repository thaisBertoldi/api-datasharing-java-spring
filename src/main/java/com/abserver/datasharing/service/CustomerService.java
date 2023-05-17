package com.abserver.datasharing.service;

import com.abserver.datasharing.domain.Customer;
import com.abserver.datasharing.dto.CustomerDTO;
import com.abserver.datasharing.repository.CustomerRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer findById(Integer id){
        Optional<Customer> obj =  repository.findById(id);
        return obj.orElseThrow(()->new RuntimeException("Object not found !"));
    }

    public List<CustomerDTO> findAll(){
        return repository.findAll().stream().map(CustomerDTO::new).collect(Collectors.toList());
    }

    public Customer createCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(null, customerDTO.getName(), customerDTO.getCpf(), customerDTO.getPhone(), customerDTO.getEmail());
        return repository.save(customer);
    }

}
