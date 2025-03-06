package com.example.lab.entity;


import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "CUST_CL")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customercl  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CSTCL_ID")
    private Long id;
    @Column(name = "CSTCL_TYP")
    private String type;
    @Column(name = "CSTCL_TYP_VALUE")
    private String typeValue;
    @Column(name = "CSTCL_EFCTV_DATE")
    private Date efctv_date;
    @Column(name = "CSTCL_CRUD_VALUE")
    private char crud_value;
    @Column(name = "CSTCL_USER_ID")
    private String user_id;
    @Column(name = "CSTCL_WS_ID")
    private String ws_id;
    @Column(name = "CSTCL_PRGM_ID")
    private String prgm_id;
    @Column(name = "CSTCL_HOST_TS")
    private Timestamp host_ts;
    @Column(name = "CSTCL_LOCAL_TS")
    private Timestamp local_ts;
    @Column(name = "CSTCL_ACPT_TS")
    private Timestamp acpt_ts;
    @Column(name = "CSTCL_ACPT_TS_UTC_OFST")
    private Timestamp acpt_ts_utc_ofst;
    @Column(name = "CSTCL_UUID")
    private String UUID;


}





