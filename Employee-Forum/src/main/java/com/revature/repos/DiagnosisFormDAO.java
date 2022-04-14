package com.revature.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.models.DiagnosisForm;
import com.revature.models.Patient;
import com.revature.models.User;

@Repository
public interface DiagnosisFormDAO extends JpaRepository<DiagnosisForm, Integer> {

	@Query("FROM DiagnosisForm d WHERE d.patient = ?1")
	Optional<List<DiagnosisForm>> findByPatient( Patient patient);

	@Query("FROM DiagnosisForm d WHERE d.nurse = ?1")
	Optional<List<DiagnosisForm>> findByNurse(User nurse);

	@Query("FROM DiagnosisForm d WHERE d.doctor = ?1")
	Optional<List<DiagnosisForm>> findByDoctor(User doctor);
}