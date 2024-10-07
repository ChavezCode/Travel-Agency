package com.dao;

import com.entities.Vacations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface VacationsRepository extends JpaRepository<Vacations, Long> {
}
