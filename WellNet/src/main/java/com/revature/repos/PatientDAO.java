package com.revature.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.models.Patient;


public interface PatientDAO extends JpaRepository<Patient, Integer> {
	public Optional<List<Patient>> findByFirstName(String firstname);

//	public Optional<List<Patient>> findByFirstNameLastName(String firstname, String lastname);

}
