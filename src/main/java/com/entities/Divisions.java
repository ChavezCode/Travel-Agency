package com.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="division")
@Getter
@Setter
public class Divisions {

    @Column(name = "division")
    @JsonProperty("division_name")
    private String division;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    @JsonProperty("id")
    private Long divisionId;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date createDate;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date lastUpdate;


    @Column(name = "country_id")
    @JsonProperty("country_id")
    private Long countryId;
    public void setCountry(Countries countries) {
        setCountryId(countries.getId());
        this.countries =countries;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false, insertable = false, updatable = false)
    private Countries countries;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "divisions")
    private Set<Customers> customer;
}
