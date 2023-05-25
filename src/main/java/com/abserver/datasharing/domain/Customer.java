package com.abserver.datasharing.domain;

import lombok.*;

import javax.persistence.*;

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

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
