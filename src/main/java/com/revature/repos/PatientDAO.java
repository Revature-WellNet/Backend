package com.revature.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.models.Patient;

@Repository

public interface PatientDAO extends JpaRepository<Patient, Integer> {
	@Query("SELECT patient FROM Patient WHERE Patient.firstName = ?1")
	Optional<Patient> findByName(String firstname);

	@Query("SELECT patient FROM Patient WHERE Patient.firstName = ?1 and Patient.lastName = ?2")
	Optional<Patient> findByName(String firstname, String lastname);

}
