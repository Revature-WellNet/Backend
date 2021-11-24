package com.revature.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.models.Patient;
import com.revature.models.User;

public interface UserDAO extends JpaRepository<User, Integer>{
	// TODO String?
	public Optional<User> findByUserId(String id);
	

//	@Query(value = "SELECT p.* FROM DIAGNOSIS_FORM df JOIN USER u ON df.DOCTOR_ID = u.USER_ID JOIN PATIENT p ON df.PATIENT_ID = p.PATIENT_ID WHERE u.USER_ID IN (SELECT u.USER_ID FROM USER WHERE u.FIRSTNAME = ?1 and u.LASTNAME = ?2)", nativeQuery=true)
//	Optional<List<Patient>> matchDoctorToUser(String firstname, String lastname);
	
}
