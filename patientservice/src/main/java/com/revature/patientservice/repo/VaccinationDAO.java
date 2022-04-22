package com.revature.patientservice.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.patientservice.model.Allergy;
import com.revature.patientservice.model.Vaccination;


@Repository
public interface VaccinationDAO extends JpaRepository<Vaccination, Integer>{

	Optional<Vaccination> findByVaccination(String name);
}
