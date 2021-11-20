package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.DiagnosisForm;
import com.revature.models.Patient;
import com.revature.models.User;
import com.revature.repos.DiagnosisFormDAO;
import com.revature.repos.PatientDAO;
import com.revature.repos.UserDAO;

@Service
public class DiagnosisFormService {

	@Autowired
	private DiagnosisFormDAO diagnosisFormDAO;
	@Autowired
	private PatientDAO patientDAO;
	@Autowired
	private UserDAO userDAO;
	
	public DiagnosisForm findDiagnosisFormById(int id) {
		return diagnosisFormDAO.findById(id).get();
	}
	
	public List<DiagnosisForm> findDiagnosisFormByPatient(int patientId) {
		Patient patient = patientDAO.findById(patientId).get();
		
		List<DiagnosisForm> list = diagnosisFormDAO.findByPatient(patient).get();
		return list;
	}
	
	public List<DiagnosisForm> findDiagnosisFormByNurse(String nurseId) {
		User nurse = userDAO.findById(nurseId).get();
		
		List<DiagnosisForm> list = diagnosisFormDAO.findByNurse(nurse).get();
		return list;
	}
	
	public List<DiagnosisForm> findDiagnosisFormByDoctor(String doctorId) {
		User doctor = userDAO.findById(doctorId).get();
		
		List<DiagnosisForm> list = diagnosisFormDAO.findByDoctor(doctor).get();
		return list;
	}


	public Boolean addDiagnosisForm (DiagnosisForm diagnosisForm) {
		try {
			diagnosisFormDAO.save(diagnosisForm);
			return true;
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return false;
		}
	}
	public Boolean updateDiagnosisForm (DiagnosisForm diagnosisForm) {
		try {
			diagnosisFormDAO.save(diagnosisForm);
			return true;
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return false;
		}
	}
	
	public Boolean deleteDiagnosisForm (int  diagnosisFormId) {
		try {
			DiagnosisForm diagnosisForm = findDiagnosisFormById(diagnosisFormId);
			if(diagnosisForm == null) return false;
			diagnosisFormDAO.delete(diagnosisForm);
			return true;
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return false;
		}
	}

	public List<DiagnosisForm> findAllDiagnosis() {
		
		return  diagnosisFormDAO.findAll();
	}
	
	
}
