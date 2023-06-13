package com.abserver.datasharing.domain;

import com.abserver.datasharing.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Data
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private Date initialSchedule;
    private Date finalSchedule;
    private Double serviceValue;
    private Integer status;

    public Appointment(Integer id, Customer customer, Company company, Date initialSchedule, Date finalSchedule, Double serviceValue) {
        this.id = id;
        this.customer = customer;
        this.company = company;
        this.initialSchedule = initialSchedule;
        this.finalSchedule = finalSchedule;
        this.serviceValue = serviceValue;
        this.status = 0;
    }
    public Status getStatus() {
        return Status.toEnum(this.status);
    }
    public void setStatus(Status status) {
        this.status = status.getCod();
    }
}
