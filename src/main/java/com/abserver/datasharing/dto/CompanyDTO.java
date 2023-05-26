package com.abserver.datasharing.dto;

import com.abserver.datasharing.domain.Address;
import com.abserver.datasharing.domain.Company;
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
    private String tradeName;

    @CNPJ
    private String cnpj;
    private String legalRepresentative;
    private String phone;
    private String email;
    private Address address;

    public CompanyDTO(Company obj) {
        this.id = obj.getId();
        this.tradeName = obj.getTradeName();
        this.cnpj = obj.getCnpj();
        this.legalRepresentative = obj.getLegalRepresentative();
        this.phone = obj.getPhone();
        this.email = obj.getEmail();
        this.address = obj.getAddress();
    }
}
