package com.abserver.datasharing.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Data
public class Appointment {

    private Integer id;
    private Customer customer;
    private Date initialSchedule;
    private Date finalSchedule;
    private Double serviceValue;

}
