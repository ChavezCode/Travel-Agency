package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="vacations")
@Getter
@Setter
public class Vacations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    @JsonProperty("id")
    private Long vacationId;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date createDate;

    @Column(name = "description")
    @JsonProperty("description")
    private String description;

    @Column(name = "image_url")
    @JsonProperty("image_URL")
    private String imageUrl;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date lastUpdate;

    @Column(name = "travel_fare_price")
    @JsonProperty("travel_price")
    private BigDecimal travelFarePrice;

    @Column(name = "vacation_title")
    @JsonProperty("vacation_title")
    private String vacationTitle;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacations")
    private Set<Excursions> excursions;

}
