package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="customers")
@Getter
@Setter
public class Customer {

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
    private String firstName;

    @Column(name = "customer_last_name")
    @JsonProperty("lastName")
    private String lastName;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date lastUpdate;

    @Column(name = "phone")
    @JsonProperty("phone")
    private String phone;

    @Column(name = "postal_code")
    @JsonProperty("postal_code")
    private String postalCode;

//    @Column(name = "division_id")
//    private Long divisionId;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Cart> cart;


}
