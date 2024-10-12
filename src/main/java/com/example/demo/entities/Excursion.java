package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="excursions")
@Getter
@Setter

public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id", nullable = false, updatable = false)
    @JsonProperty("id")
    private Long excursionId;

    @Column(name = "create_date", nullable = false)
    @CreationTimestamp
    private Date createDate;

    @Column(name = "excursion_price")
    @JsonProperty("excursion_price")
    private BigDecimal excursionPrice;

    @Column(name = "excursion_title")
    @JsonProperty("excursion_title")
    private String excursionTitle;

    @Column(name = "image_url")
    @JsonProperty("image_URL")
    private String imageUrl;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date lastUpdate;
//duplicate Mapping
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "vacation_id")
//    private Long vacationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;


    //added mapped by and private
    @ManyToMany(mappedBy = "excursions")
//    @JoinTable(name = "excursion_cartitem",
//            joinColumns = @JoinColumn(name = "excursion_id", nullable = false),
//            inverseJoinColumns = @JoinColumn(name = "cart_item_id", nullable = false))
    Set<CartItem> cartItems;



}
