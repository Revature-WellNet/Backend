package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Vaccination;

public interface VaccinationDAO extends JpaRepository<Vaccination, Integer> {

}
