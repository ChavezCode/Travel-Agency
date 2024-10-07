package com.dao;

import com.entities.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


public interface CartItemsRepository extends JpaRepository <CartItems, Long> {

}
