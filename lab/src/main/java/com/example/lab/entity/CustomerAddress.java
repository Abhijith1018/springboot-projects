package com.example.lab.entity;



import java.sql.Timestamp;
import java.sql.Date;

import com.example.lab.dto.CustomerAddressDTO;
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
@Table(name = "CUST_ADDRESS")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerAddress extends AuditFields  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CSTADD_IDFR")
    private Long id;

    @Column(name = "CSTADD_VALUE")
    private String value;

    @Column(name = "CSTADD_EFCTV_DATE")
    private Date efctvDate;

    @Column(name = "CSTADD_CRUD_VALUE")
    private char crud_value;
    @Column(name = "CSTADD_USER_ID")
    private String user_id;
    @Column(name = "CSTADD_WS_ID")
    private String ws_id;
    @Column(name = "CSTADD_PRGM_ID")
    private String prgm_id;
    @Column(name = "CSTADD_HOST_TS")
    private Timestamp host_ts;
    @Column(name = "CSTADD_LOCAL_TS")
    private Timestamp local_ts;
    @Column(name = "CSTADD_ACPT_TS")
    private Timestamp acpt_ts;
    @Column(name = "CSTADD_ACPT_TS_UTC_OFST")
    private Timestamp acpt_ts_utc_ofst;
    @Column(name = "CSTADD_UUID")
    private String UUID;


    @ManyToOne
    @JoinColumn(name = "CST_ID")
    private CustomerDetails custDetails;
    @ManyToOne
    @JoinColumn(name = "CSTADD_CLS_ID")
    private Customercl cust_CL;


    public CustomerAddress(CustomerAddressDTO dto) {
        this.id = dto.getId();
        this.value = dto.getValue();
        this.efctvDate = dto.getEfctvDate();
        this.crud_value = dto.getCrudValue();

    }
    @PrePersist
    protected void onCreate() {
        if (this.efctvDate == null) {
            this.efctvDate = new Date(System.currentTimeMillis()); // Default to current date
        }
    }


}

