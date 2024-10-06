package com.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name="customers")
@Getter
@Setter
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    @JsonProperty("id")
    private Long customerId;

    @Column(name = "address")
    @JsonProperty("address")
    private String address;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "customer_first_name")
    @JsonProperty("firstName")
    private String customerFirstName;

    @Column(name = "customer_last_name")
    @JsonProperty("lastName")
    private String customerLastName;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date lastUpdate;

    @Column(name = "phone")
    private String phone;

    @Column(name = "postal_code")
    @JsonProperty("postal_code")
    private String postalCode;

    @Column(name = "division_id")
    private Long divisionId;


}
