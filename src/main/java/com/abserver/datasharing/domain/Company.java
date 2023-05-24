package com.abserver.datasharing.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;

@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Data
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tradeName;
    private String cnpj;
    private String legalRepresentative;
    private String phone;
    private String email;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
