package com.abserver.datasharing.service;

import com.abserver.datasharing.domain.Appointment;
import com.abserver.datasharing.domain.Company;
import com.abserver.datasharing.domain.Customer;
import com.abserver.datasharing.domain.enums.Status;
import com.abserver.datasharing.dto.AppointmentDTO;
import com.abserver.datasharing.repository.AppointmentRepository;
import com.abserver.datasharing.repository.CompanyRepository;
import com.abserver.datasharing.repository.CustomerRepository;
import com.abserver.datasharing.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Appointment findById(Integer id) {
        Optional<Appointment> obj = appointmentRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Object not found! ID: " + id + ", Type: " + Appointment.class.getName()));
    }

    public List<Appointment> findAll() {
        checkStatus();
        return appointmentRepository.findAll();
    }

    public Appointment create(AppointmentDTO dto) {
        Appointment obj = transformDtoFromAppointment(dto);

        Company company = companyService.findById(dto.getCompany());
        company.getAppointments().add(obj);
        companyRepository.save(company);

        Customer customer = customerService.findById(dto.getCustomer());
        customer.getAppointments().add(obj);
        customerRepository.save(customer);

        return appointmentRepository.save(obj);
    }

    public Appointment transformDtoFromAppointment(AppointmentDTO dto) {
        Integer idCustomer = dto.getCustomer();
        Integer idCompany = dto.getCompany();
        Customer objCustomer = customerService.findById(idCustomer);
        Customer customer = new Customer(idCustomer, objCustomer.getName(), objCustomer.getPhone(), objCustomer.getEmail(), objCustomer.getCpf(), objCustomer.getAddress());

        Company objCompany = companyService.findById(idCompany);
        Company company = new Company(idCompany, objCompany.getTradeName(), objCompany.getCnpj(), objCompany.getLegalRepresentative(), objCompany.getPhone(), objCompany.getEmail(), objCompany.getAddress());
        return new Appointment(null, customer, company, dto.getInitialSchedule(), dto.getFinalSchedule(), dto.getServiceValue(), dto.getDescription());
    }

    public void checkStatus() {
        List<Appointment> list = appointmentRepository.findAll();
        for (Appointment obj : list) {
            if (obj.getStatus().getCod() == 0) {
                if (obj.getFinalSchedule().before(new Date())) {
                    obj.setStatus(Status.FINISHED);
                    appointmentRepository.save(obj);
                }
            }

        }
    }
}
