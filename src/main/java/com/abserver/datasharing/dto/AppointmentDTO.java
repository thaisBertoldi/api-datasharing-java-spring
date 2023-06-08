package com.abserver.datasharing.dto;

import com.abserver.datasharing.domain.Appointment;
import com.abserver.datasharing.domain.Company;
import com.abserver.datasharing.domain.Customer;
import com.abserver.datasharing.repository.CompanyRepository;
import com.abserver.datasharing.repository.CustomerRepository;
import com.abserver.datasharing.service.AppointmentService;
import com.abserver.datasharing.service.CompanyService;
import com.abserver.datasharing.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO implements Serializable {

    private Integer id;
    private Integer customer;
    private Integer company;
    private Date initialSchedule;
    private Date finalSchedule;
    private Double serviceValue;

}
