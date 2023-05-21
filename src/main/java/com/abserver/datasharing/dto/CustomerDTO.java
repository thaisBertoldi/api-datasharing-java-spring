package com.abserver.datasharing.dto;

import com.abserver.datasharing.domain.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class CustomerDTO implements Serializable {

    private Integer id;

    @NotEmpty(message = "Completion is mandatory ! ")
    @Length(min = 3, max = 80, message = "Length must be between 3 and 80 characters")
    private String name;

    @NotEmpty(message = "Completion is mandatory ! ")
    @Length(min = 10, max = 12, message = "Length must be between 8 and 11 characters")
    private String phone;

    @NotEmpty(message = "Completion is mandatory ! ")
    @Length(min = 10, max = 20, message = "Length must be between 10 and 20 characters")
    private String email;

    @NotEmpty(message = "Completion is mandatory ! ")
    @Length(min = 11, max = 11, message = "Length must be 11 characters")
    @CPF
    private String cpf;

    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.phone = customer.getPhone();
        this.email = customer.getEmail();
        this.cpf = customer.getCpf();
    }
}
