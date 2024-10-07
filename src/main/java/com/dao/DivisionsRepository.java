package com.dao;

import com.entities.Divisions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


public interface DivisionsRepository extends JpaRepository<Divisions, Long> {
}
