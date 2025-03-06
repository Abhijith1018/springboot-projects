package com.example.lab.entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.time.Instant;

@MappedSuperclass
@Getter
@Setter
public abstract class AuditFields {

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

    @PrePersist
    public void prePersist() {
        this.host_ts = Timestamp.from(Instant.now());
        this.local_ts = Timestamp.from(Instant.now());
        this.acpt_ts = Timestamp.from(Instant.now());
        this.acpt_ts_utc_ofst = Timestamp.from(Instant.now());

        // Dummy values; replace with actual user details if available
        this.user_id = "SYSTEM";
        this.ws_id = "DEFAULT_WS";
        this.prgm_id = "CUSTOMER_MGMT";
        this.UUID = java.util.UUID.randomUUID().toString();
    }

    @PreUpdate
    public void preUpdate() {
        this.host_ts = Timestamp.from(Instant.now());
        this.local_ts = Timestamp.from(Instant.now());
        this.acpt_ts = Timestamp.from(Instant.now());
        this.acpt_ts_utc_ofst = Timestamp.from(Instant.now());
    }
}

