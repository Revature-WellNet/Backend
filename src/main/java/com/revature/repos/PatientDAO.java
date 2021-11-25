package com.revature.repos;

import java.sql.Date;// may have to change to .util
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.models.Patient;


@Repository
public interface PatientDAO extends JpaRepository<Patient, Integer> {
	
	
	
	@Query("FROM Patient p WHERE p.firstName = ?1")
	Optional<List<Patient>> findByName(String firstname);

	@Query("FROM Patient p WHERE p.firstName = ?1 and p.lastName = ?2")
	Optional<List<Patient>> findByName(String firstname, String lastname);

	@Query("FROM Patient p WHERE p.firstName = ?1 and p.lastName = ?2 and p.dob = ?3")
	Optional<List<Patient>> findByName(String firstname, String lastname, Date dob);
	
	
//	This allows for search for patients by doctor
	@Query(value = "SELECT p.* FROM DIAGNOSIS_FORM df JOIN USER u ON df.DOCTOR_ID = u.USER_ID JOIN PATIENT p ON df.PATIENT_ID = p.PATIENT_ID WHERE u.USER_ID IN (SELECT u.USER_ID FROM USER WHERE u.FIRSTNAME = ?1 and u.LASTNAME = ?2)", nativeQuery=true)
	Optional<List<Patient>> matchDoctorToUser(String firstname, String lastname);
}