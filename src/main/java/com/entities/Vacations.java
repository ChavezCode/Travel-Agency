package com.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

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

}
