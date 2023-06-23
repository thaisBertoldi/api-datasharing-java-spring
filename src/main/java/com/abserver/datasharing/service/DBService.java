package com.abserver.datasharing.service;

import com.abserver.datasharing.domain.*;
import com.abserver.datasharing.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Service
public class DBService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public void instanciationDataBase() throws ParseException {

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

        Appointment ap1 = new Appointment(null, customer1, comp1, new Date(),sdf.parse("2023-06-03 20:30"), 50.00, "have a haircut");
        comp1.getAppointments().addAll(Arrays.asList(ap1));
        customer1.getAppointments().addAll(Arrays.asList(ap1));

        Employee emp1 = new Employee(null, "Drayton Gaboardi");
        Employee emp2 = new Employee(null, "Fabi Bertoldi");

        employeeRepository.saveAll(Arrays.asList(emp1, emp2));
        addressRepository.saveAll(Arrays.asList(ad1,ad2,ad3,ad4,ad5));
        companyRepository.saveAll(Arrays.asList(comp1, comp2));
        customerRepository.saveAll(Arrays.asList(customer1,customer2,customer3));
        appointmentRepository.saveAll(Arrays.asList(ap1));

    }
}
