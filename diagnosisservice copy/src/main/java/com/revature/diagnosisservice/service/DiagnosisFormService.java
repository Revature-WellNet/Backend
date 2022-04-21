package com.revature.diagnosisservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.diagnosisservice.model.DiagnosisForm;
import com.revature.diagnosisservice.model.Patient;
import com.revature.diagnosisservice.model.User;
import com.revature.diagnosisservice.repo.DiagnosisFormRepo;

@Service
public class DiagnosisFormService {

	@Autowired
	private DiagnosisFormRepo diagnosisFormRepo;


	public List<DiagnosisForm> findAllDiagnosisForms() {
		return diagnosisFormRepo.findAll();
	}
	
	
	public Optional<DiagnosisForm> findDiagnosisFormById(int id) {
		return diagnosisFormRepo.findById(id);
	}

	
	public Optional<List<DiagnosisForm>> findDiagnosisFormByPatient(Patient patient) {
		return diagnosisFormRepo.findByPatient(patient);
	}
	
	
	public Optional<List<DiagnosisForm>> findDiagnosisFormByNurse(User nurse) {
		return diagnosisFormRepo.findByNurse(nurse);
	}
	
	
	public Optional<List<DiagnosisForm>> findDiagnosisFormByDoctor(User doctor) {
		return diagnosisFormRepo.findByDoctor(doctor);
	}
	
	
	public boolean saveDiagnosisForm(DiagnosisForm diagnosisForm) {
		diagnosisFormRepo.save(diagnosisForm);
		return diagnosisFormRepo.existsById(diagnosisForm.getDiagId());
	}


	public boolean updateDiagnosisForm(DiagnosisForm diagnosisForm) {
		diagnosisFormRepo.save(diagnosisForm);
		return diagnosisFormRepo.existsById(diagnosisForm.getDiagId()); 
	}


	public boolean deleteDiagnosisForm(DiagnosisForm diagnosisForm) {
		diagnosisFormRepo.delete(diagnosisForm);
		return !diagnosisFormRepo.existsById(diagnosisForm.getDiagId());
	}


}