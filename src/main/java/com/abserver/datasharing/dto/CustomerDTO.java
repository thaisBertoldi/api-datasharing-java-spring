package com.abserver.datasharing.dto;

import com.abserver.datasharing.domain.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
public class CustomerDTO {

    private Integer id;
    private String name;
    private String phone;
    private String email;
    private String cpf;

    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.phone = customer.getPhone();
        this.email = customer.getEmail();
        this.cpf = customer.getCpf();
    }
}
