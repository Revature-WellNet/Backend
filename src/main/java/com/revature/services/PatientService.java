package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Patient;
import com.revature.repos.PatientDAO;

@Service
public class PatientService {

	@Autowired
	private PatientDAO patientDAO;

	public Patient findPatientById(int id) {
		return patientDAO.findById(id).get();
	}

	public Patient findPatientByName(String firstname) {
		return patientDAO.findByName(firstname).get();
	}

	public Patient findPatientByName(String firstname, String lastname) {
		return patientDAO.findByName(firstname, lastname).get();
	}
	
	public Boolean addPatient (Patient patient) {
		try {
			patientDAO.save(patient);
			return true;
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return false;
		}
	}
	public Boolean updatePatient (Patient patient) {
		try {
			patientDAO.save(patient);
			return true;
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return false;
		}
	}
	
	public Boolean deletePatient (int  patientId) {
		try {
			Patient patient = findPatientById(patientId);
			if(patient == null) return false;
			patientDAO.delete(patient);
			return true;
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return false;
		}
	}
	

}
