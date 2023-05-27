package com.abserver.datasharing;

import com.abserver.datasharing.domain.Address;
import com.abserver.datasharing.domain.Company;
import com.abserver.datasharing.domain.Customer;
import com.abserver.datasharing.repository.AddressRepository;
import com.abserver.datasharing.repository.CompanyRepository;
import com.abserver.datasharing.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DatasharingApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public static void main(String[] args) {

        SpringApplication.run(DatasharingApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        Address ad1 = new Address(null, "Baker street", "Mary Lebone", "221b", "91420590", "London", "Biscoito", "England");
        Address ad2 = new Address(null, "Rua Sushi", "Peixinho Dourado", "123", "88888888", "São Paulo", "São Paulo", "Brasil");
        Address ad3 = new Address(null, "Avenida Biscoito", "Enorme Urso", "456", "99999999", "Sidney", "Melancia", "Austrália");
        Address ad4 = new Address(null, "Est. do Limoeiro", "Carvão Azul", "789", "77777777", "Arvoredo", "Santa Catarina", "Brasil");
        Address ad5 = new Address(null, "Utah Avenue", "South Seatle", "2401", "98134", "Seatle", "Washington", "EUA");

        Customer customer1 = new Customer(null, "Gustavo", "51989469367","gugu@abserver.com.br","01193562032", ad2);
        Customer customer2 = new Customer(null, "Neusa", "51989558967","nene@abserver.com.br","011935611555", ad3);
        Customer customer3 = new Customer(null, "Betina", "49995569367","bebe@abserver.com.br","01193562011", ad4);

        Company comp1 = new Company(null, "Mc Donalds", "78.336.743/0001-24","Ray Kroc","49986526369","mcdonals@mcdonalds.com.br",ad1);
        Company comp2 = new Company(null, "Starbucks", "08.652.230/0001-47","Gordon Bowker","49986526369","starbucks@starbucks.com.br", ad5);

        addressRepository.saveAll(Arrays.asList(ad1,ad2,ad3,ad4,ad5));
        companyRepository.saveAll(Arrays.asList(comp1, comp2));

        customerRepository.saveAll(Arrays.asList(customer1,customer2,customer3));

    }
}
