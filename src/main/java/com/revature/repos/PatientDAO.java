package com.revature.repos;

import java.sql.Date;// may have to change to .util
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.models.Patient;

@Repository
public interface PatientDAO extends JpaRepository<Patient, Integer> {
	
	@Query("SELECT patient FROM Patient WHERE Patient.firstName = ?1")
	Optional<List<Patient>> findByName(String firstname);
	
	@Query("SELECT patient FROM Patient WHERE Patient.firstName = ?1 and Patient.lastName = ?2")
	Optional<List<Patient>> findByName(String firstname, String lastname);
	
	@Query("SELECT patient FROM Patient WHERE Patient.firstName = ?1 and Patient.lastName = ?2 and Patient.dob = ?3")
	Optional<Patient> findByName(String firstname, String lastname, Date dob);
}

