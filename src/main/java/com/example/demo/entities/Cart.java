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
@Table(name="carts")
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_id")// matches column name
    @JsonProperty("id") //matches variable name in front end
    private Long cartId;

    @Column(name="package_price", nullable = false)
    @JsonProperty("package_price")
    private BigDecimal packagePrice;

    @Column(name="party_size", nullable = false)
    @JsonProperty("party_size")
    private int partySize;

    @Enumerated(value = EnumType.STRING)
    @Column(name="status")
    @JsonProperty("status")
    private Status status;

    @Column(name="order_tracking_number")
    private String orderTrackingNumber;

    @Column(name="create_date")
    @CreationTimestamp
    private Date createDate;

    @Column(name="last_update")
    @UpdateTimestamp
    private Date lastUpdate;

//    @Column(name = "customer_id")
//    @JsonProperty("customer")
//    private Long customerId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart", fetch = FetchType.LAZY)
    private Set<CartItem> cartItem = new HashSet<>();

// added line 64
    public void add(CartItem item) {
//        this.cartItem.add(item);
        if (item != null) {
            if (cartItem == null) {
                cartItem = new HashSet<>();
            }

            cartItem.add(item);
            item.setCart(this);
        }
    }
}
