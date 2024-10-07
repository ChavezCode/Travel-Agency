package com.dao;

import com.entities.Divisions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface DivisionsRepository extends JpaRepository<Divisions, Long> {
}
