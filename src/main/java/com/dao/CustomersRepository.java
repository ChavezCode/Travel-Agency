package com.dao;

import com.entities.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface CustomersRepository extends JpaRepository<Customers, Long> {
}
