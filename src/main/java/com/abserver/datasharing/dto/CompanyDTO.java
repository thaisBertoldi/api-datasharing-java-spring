package com.abserver.datasharing.dto;

import com.abserver.datasharing.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO implements Serializable {

    private Integer id;
    private String tradingName;

    @CNPJ
    private String cnpj;
    private String legalRepresentative;
    private String phone;
    private String email;
    private Address address;

}
