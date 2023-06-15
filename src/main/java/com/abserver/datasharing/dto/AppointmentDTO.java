package com.abserver.datasharing.dto;

import com.abserver.datasharing.domain.Company;
import com.abserver.datasharing.domain.Customer;
import com.abserver.datasharing.domain.enums.Status;
import com.abserver.datasharing.repository.CompanyRepository;
import com.abserver.datasharing.repository.CustomerRepository;
import com.abserver.datasharing.service.AppointmentService;
import com.abserver.datasharing.service.CompanyService;
import com.abserver.datasharing.service.CustomerService;
import lombok.*;
import net.bytebuddy.utility.nullability.MaybeNull;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
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
    private Integer status;
    @NotNull
    private String description;

    public AppointmentDTO(Integer id, Integer customer, Integer company, Date initialSchedule, Date finalSchedule, Double serviceValue,String description) {
        this.id = id;
        this.customer = customer;
        this.company = company;
        this.initialSchedule = initialSchedule;
        this.finalSchedule = finalSchedule;
        this.serviceValue = serviceValue;
        this.status = 0;
        this.description = description;
    }

    public Status getStatus() {
        return Status.toEnum(this.status);
    }
}
