package com.example.lab.dto;

import com.example.lab.entity.CustomerAddress;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class CustomerAddressDTO {
    private Long id;
    private String value;
    private Date efctvDate;
    private char crudValue;
    private Long customerId;
    private Long customerClassId;

    public CustomerAddressDTO(CustomerAddress address) {
        this.id = address.getId();
        this.value = address.getValue();
        this.efctvDate = address.getEfctvDate();
        this.crudValue = address.getCrud_value();
        this.customerId = address.getCustDetails() != null ? address.getCustDetails().getId() : null;
        this.customerClassId = address.getCust_CL() != null ? address.getCust_CL().getId() : null;
    }
}


