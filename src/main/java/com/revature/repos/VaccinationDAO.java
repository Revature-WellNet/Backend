package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Vaccination;


@Repository
public interface VaccinationDAO extends JpaRepository<Vaccination, Integer>{

}
