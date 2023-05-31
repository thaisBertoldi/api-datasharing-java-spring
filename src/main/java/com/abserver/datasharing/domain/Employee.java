package com.abserver.datasharing.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Data
public class Employee {

    private Integer id;
    private String name;

}
