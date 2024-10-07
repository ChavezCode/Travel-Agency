package com.dao;

import com.entities.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface CountriesRepository extends JpaRepository<Countries, Long> {
}
