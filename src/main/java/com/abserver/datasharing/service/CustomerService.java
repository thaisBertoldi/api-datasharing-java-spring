package com.abserver.datasharing.service;

import com.abserver.datasharing.domain.Customer;
import com.abserver.datasharing.dto.CustomerDTO;
import com.abserver.datasharing.repository.CustomerRepository;
import com.abserver.datasharing.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer findById(Integer id) {
        Optional<Customer> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Object not found! ID: " + id + ", Type: " + Customer.class.getName()));
    }

    public List<CustomerDTO> findAll() {
        return repository.findAll().stream().map(CustomerDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public Customer create(CustomerDTO customerDTO) {
        Customer customer = new Customer(null, customerDTO.getName(), customerDTO.getCpf(), customerDTO.getPhone(), customerDTO.getEmail());
        return repository.save(customer);
    }

    public Customer update(Customer newObj) {
        Customer obj = findById(newObj.getId());
        updateData(newObj, obj);
        return repository.save(obj);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    private void updateData(Customer newObj, Customer obj) {
        obj.setName(newObj.getName());
        obj.setEmail(newObj.getEmail());
        obj.setPhone(newObj.getPhone());
    }

    public Customer fromDTO(CustomerDTO objDTO) {
        return new Customer(objDTO.getId(), objDTO.getName(), objDTO.getPhone(), objDTO.getEmail(), null);
    }



}
