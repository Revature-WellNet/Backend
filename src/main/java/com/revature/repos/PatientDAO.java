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
	
	@Query("FROM Patient p WHERE p.firstName = ?1")
	Optional<List<Patient>> findByName(String firstname);
	
	@Query("FROM Patient p WHERE p.firstName = ?1 and p.lastName = ?2")
	Optional<List<Patient>> findByName(String firstname, String lastname);
	
	@Query("FROM Patient p WHERE p.firstName = ?1 and p.lastName = ?2 and p.dob = ?3")
	Optional<Patient> findByName(String firstname, String lastname, Date dob);
}

