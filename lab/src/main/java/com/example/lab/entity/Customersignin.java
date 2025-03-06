package com.example.lab.entity;


import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

import com.example.lab.dto.CustomerSignInDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUST_SIGNIN")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customersignin extends AuditFields  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CSTSIGN_IDFR")
    private Long id;
    @Column(name = "CSTSIGN_USRNAME")
    private String userName;
    @Column(name = "CSTSIGN_PASSWORD")
    private String password;
    @Column(name = "CSTSIGN_ROLE")
    private String role;
    @Column(name = "CSTSIGN_EFCTV_DATE")
    private Date efctv_date;
    @Column(name = "CSTSIGN_CRUD_VALUE")
    private char crud_value;
    @Column(name = "CSTSIGN_USER_ID")
    private String user_id;
    @Column(name = "CSTSIGN_WS_ID")
    private String ws_id;
    @Column(name = "CSTSIGN_PRGM_ID")
    private String prgm_id;
    @Column(name = "CSTSIGN_HOST_TS")
    private Timestamp host_ts;
    @Column(name = "CSTSIGN_LOCAL_TS")
    private Timestamp local_ts;
    @Column(name = "CSTSIGN_ACPT_TS")
    private Timestamp acpt_ts;
    @Column(name = "CSTSIGN_ACPT_TS_UTC_OFST")
    private Timestamp acpt_ts_utc_ofst;
    @Column(name = "CSTSIGN_UUID")
    private String UUID;


    @ManyToOne
    @JoinColumn(name = "CST_ID")
    private CustomerDetails cust_DETAILS;


    public Customersignin(CustomerSignInDTO dto) {
        this.id = dto.getId();
        this.userName = dto.getUsername();
        this.password = dto.getPassword();
        this.role = dto.getRole();
    }
}

