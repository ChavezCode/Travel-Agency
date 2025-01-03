package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="countries")
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    @JsonProperty("id")
    private Long id;

    @Column(name = "country")
    @JsonProperty("country_name")
    private String country;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date createDate;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date lastUpdate;


//NOT PART OF TABLE

//    @Column(name = "phone")
//    private String phone;
//
//    @Column(name = "postal_code")
//    private String postalCode;
//
//    @Column(name = "division_id")
//    private Long divisionId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private Set<Division> division;

}
