package com.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="cart_items")
@Getter
@Setter
public class CartItems {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_item_id")
    private Long cartItemId;

    @Column(name="create_date")
    @CreationTimestamp
    private Date createDate;

    @Column(name="last_update")
    @UpdateTimestamp
    private Date last_update;

    @Column(name="cart_id")
    private Long cartId;

    @Column(name="vacation_id")
    private Long vacationId;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Carts carts;

    @ManyToMany(mappedBy = "cartItemsSet")
    private Set<Excursions> excursionsSet;

}
