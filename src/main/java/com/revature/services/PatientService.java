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

}
