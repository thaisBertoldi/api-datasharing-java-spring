package com.abserver.datasharing.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Entity
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private String district;
    private String number;
    private String zipCode;
    private String city;
    private String state;
    private String country;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Company company;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Customer customer;

    public Address(Integer id, String street, String district, String number, String zipCode, String city, String state, String country) {
        this.id = id;
        this.street = street;
        this.district = district;
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.country = country;
    }
}
