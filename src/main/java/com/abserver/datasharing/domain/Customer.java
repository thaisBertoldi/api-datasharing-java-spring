package com.abserver.datasharing.domain;

import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Customer {

    private Integer id;
    private String name;
    private String phone;
    private String email;
    private String cpf;

}
