package com.dao;

import com.entities.Carts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


public interface CartRepository extends JpaRepository<Carts, Long> {

}
