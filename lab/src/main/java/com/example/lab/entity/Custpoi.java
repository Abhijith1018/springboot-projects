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
@Table(name = "CUST_POI")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Custpoi extends AuditFields  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CSTPOI_IDFR")
    private Long id;
    @Column(name = "CSTPOI_VALUE")
    private String value;
    @Column(name = "CSTPOI_START")
    private Date start;
    @Column(name = "CSTPOI_END")
    private Date end;
    @Column(name = "CSTPOI_EFCTV_DATE")
    private Date efctv_date;
    @Column(name = "CSTPOI_CRUD_VALUE")
    private char crud_value;
    @Column(name = "CSTPOI_USER_ID")
    private String user_id;
    @Column(name = "CSTPOI_WS_ID")
    private String ws_id;
    @Column(name = "CSTPOI_PRGM_ID")
    private String prgm_id;
    @Column(name = "CSTPOI_HOST_TS")
    private Timestamp host_ts;
    @Column(name = "CSTPOI_LOCAL_TS")
    private Timestamp local_ts;
    @Column(name = "CSTPOI_ACPT_TS")
    private Timestamp acpt_ts;
    @Column(name = "CSTPOI_ACPT_TS_UTC_OFST")
    private Timestamp acpt_ts_utc_ofst;
    @Column(name = "CSTPOI_UUID")
    private String UUID;


    @ManyToOne
    @JoinColumn(name = "CST_ID")
    private CustomerDetails cust_DETAILS;
    @ManyToOne
    @JoinColumn(name = "CSTPOI_CLS_ID")
    private Customercl cust_CL;
}

