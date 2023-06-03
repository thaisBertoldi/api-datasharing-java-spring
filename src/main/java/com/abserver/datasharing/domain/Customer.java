package com.abserver.datasharing.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String phone;
    private String email;
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Appointment> appointments = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Customer(Integer id, String name, String phone, String email, String cpf, Address address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.cpf = cpf;
        this.address = address;
    }
}
