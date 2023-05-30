package com.abserver.datasharing.service;

import com.abserver.datasharing.domain.Address;
import com.abserver.datasharing.repository.AddressRepository;
import com.abserver.datasharing.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address create(Address address) {
        Address newAddress = new Address(
            null,
            address.getStreet(),
            address.getDistrict(),
            address.getNumber(),
            address.getZipCode(),
            address.getCity(),
            address.getState(),
            address.getCountry()
        );
        return addressRepository.save(newAddress);
    }

    public Address findById(Integer id) {
        Optional<Address> obj = addressRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Object not found! ID: " + id + ", Type: " + Address.class.getName()));
    }

    public void deleteById(Integer id) {
        findById(id);
        addressRepository.deleteById(id);
    }

}
