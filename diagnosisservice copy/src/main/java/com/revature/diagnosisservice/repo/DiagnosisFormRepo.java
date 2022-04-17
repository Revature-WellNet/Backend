package com.revature.diagnosisservice.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.diagnosisservice.model.DiagnosisForm;
import com.revature.diagnosisservice.model.Patient;
import com.revature.diagnosisservice.model.User;

@Repository
public interface DiagnosisFormRepo extends JpaRepository<DiagnosisForm, Integer> {

	@Query("FROM DiagnosisForm d WHERE d.patient = ?1")
	Optional<List<DiagnosisForm>> findByPatient( Patient patient);
	
	@Query("FROM DiagnosisForm d WHERE d.nurse = ?1")
	Optional<List<DiagnosisForm>> findByNurse(User nurse);

	@Query("FROM DiagnosisForm d WHERE d.doctor = ?1")
	Optional<List<DiagnosisForm>> findByDoctor(User doctor);
}