package com.abserver.datasharing.dto;

import com.abserver.datasharing.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
