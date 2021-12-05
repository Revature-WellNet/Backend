package com.revature.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Allergy;
import com.revature.models.Vaccination;


@Repository
public interface VaccinationDAO extends JpaRepository<Vaccination, Integer>{

	Optional<Vaccination> findByVaccination(String name);
}
