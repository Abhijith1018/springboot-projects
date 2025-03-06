package com.example.lab.dto;


import com.example.lab.entity.CustomerDetails;
import com.example.lab.entity.Customercl;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Data
@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO {
    private String fullName;
    private String email;
    private String mobile;
    private String country;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dob;
    private String status;
    private Long classificationId;


    public CustomerDTO(CustomerDetails customer) {
        this.fullName = customer.getFullName();
        this.email = customer.getEmail();
        this.mobile = customer.getMobile();
        this.country = customer.getCountry();
        this.dob= customer.getDob();
        this.status= customer.getStatus();
        if (customer.getType() != null) {
            this.classificationId = customer.getType().getId(); // Ensure `id` is the primary key in Customercl
        }

    }


}
