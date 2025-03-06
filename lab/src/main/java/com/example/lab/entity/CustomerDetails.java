package com.example.lab.entity;


import java.sql.Date;
import java.sql.Timestamp;

import com.example.lab.DAO.CustomerClassificationRepository;
import com.example.lab.dto.CustomerDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUST_DETAILS")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDetails{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CSTDET_IDFR")
    @Id
    private Long idfr;
    @Column(name = "CST_ID",unique = true)
    private Long id;
    @Column(name = "CSTDET_FULL_NAME")
    private String fullName;
    @Column(name = "CSTDET_DOB")
    private Date dob;
    @Column(name = "CSTDET_STATUS")
    private String status;


    @Column(name = "CSTDET_MOBILE")
    private String mobile;
    @Column(name = "CSTDET_EMAIL")
    private String email;
    @Column(name = "CSTDET_COUNTRY")
    private String country;
    @Column(name = "CSTDET_EFCTV_DATE")
    private Date efctv_date;
    @Column(name = "CSTDET_CRUD_VALUE")
    private char crud_value;
    @Column(name = "CSTDET_USER_ID")
    private String user_id;
    @Column(name = "CSTDET_WS_ID")
    private String ws_id;
    @Column(name = "CSTDET_PRGM_ID")
    private String prgm_id;
    @Column(name = "CSTDET_HOST_TS")
    private Timestamp host_ts;
    @Column(name = "CSTDET_LOCAL_TS")
    private Timestamp local_ts;
    @Column(name = "CSTDET_ACPT_TS")
    private Timestamp acpt_ts;
    @Column(name = "CSTDET_ACPT_TS_UTC_OFST")
    private Timestamp acpt_ts_utc_ofst;
    @Column(name = "CSTDET_UUID")
    private String UUID;


    @ManyToOne
    @JoinColumn(name = "CSTDET_TYPE")
    private Customercl type;

    public CustomerDetails(CustomerDTO dto, CustomerClassificationRepository classificationRepo) {
        this.fullName = dto.getFullName();

        if (dto.getDob() != null) {
            this.dob = dto.getDob(); // Ensure it's "YYYY-MM-DD"
        }
        this.id = 250001L;
        this.status = dto.getStatus();
        this.mobile = dto.getMobile();
        this.email = dto.getEmail();
        this.efctv_date = new Date(System.currentTimeMillis());
        // Fetching Customer Classification if ID is provided
        if (dto.getClassificationId() != null) {
            this.type = classificationRepo.findById(dto.getClassificationId()).orElse(null);
        }

        this.local_ts = new Timestamp(System.currentTimeMillis());
        this.host_ts = new Timestamp(System.currentTimeMillis());
        this.acpt_ts = new Timestamp(System.currentTimeMillis());
        this.acpt_ts_utc_ofst = new Timestamp(System.currentTimeMillis());
        this.ws_id = "WS001";
        this.prgm_id = "PR102";
        this.user_id = "Abhijith";
        this.UUID = "hhugiehgihvivnhoiwebti16146bvh";


    }

}


