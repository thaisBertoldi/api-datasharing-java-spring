package com.abserver.datasharing.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Appointment> appointments = new ArrayList<>();

    public Company(Integer id, String tradeName, String cnpj, String legalRepresentative, String phone, String email, Address address) {
        this.id = id;
        this.tradeName = tradeName;
        this.cnpj = cnpj;
        this.legalRepresentative = legalRepresentative;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
}
