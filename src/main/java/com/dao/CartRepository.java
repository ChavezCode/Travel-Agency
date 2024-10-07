package com.dao;

import com.entities.Carts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Carts, Long> {

}
