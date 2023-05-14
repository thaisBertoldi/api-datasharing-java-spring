package com.abserver.datasharing;

import com.abserver.datasharing.domain.Customer;
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

    public static void main(String[] args) {

        SpringApplication.run(DatasharingApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        Customer customer1 = new Customer(null, "Gustavo", "51989469367","gugu@abserver.com.br","01193562032");
        Customer customer2 = new Customer(null, "Neusa", "51989558967","nene@abserver.com.br","011935611555");
        Customer customer3 = new Customer(null, "Betina", "49995569367","bebe@abserver.com.br","01193562011");

        customerRepository.saveAll(Arrays.asList(customer1,customer2,customer3));

    }
}
