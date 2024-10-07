package com.dao;

import com.entities.Excursions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


public interface ExcursionsRepository extends JpaRepository<Excursions, Long> {
}
