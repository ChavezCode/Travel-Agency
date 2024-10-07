package com.dao;

import com.entities.Vacations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


public interface VacationsRepository extends JpaRepository<Vacations, Long> {
}
