package com.revature.services;

import java.sql.Date;// may have to change to .util 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Allergy;
import com.revature.models.Patient;
import com.revature.models.Vaccination;
import com.revature.repos.AllergyDAO;
import com.revature.repos.PatientDAO;
import com.revature.repos.VaccinationDAO;

@Service
public class PatientService {

	@Autowired
	private PatientDAO patientDAO;
	@Autowired
	private AllergyDAO allergyDAO;
	@Autowired
	private VaccinationDAO vaccinationDAO;

	public List<Patient> findAllPatients(){
		return patientDAO.findAll();
	}
	
	public Patient findPatientById(int id) {
		return patientDAO.findById(id).get();
	}

	public List<Patient> findPatientByName(String firstname) {
		return patientDAO.findByName(firstname).get();
	}

	public List<Patient> findPatientByName(String firstname, String lastname) {
		return patientDAO.findByName(firstname, lastname).get();
	}
	public Patient findPatientByName(String firstname, String lastname, Date dob) {
		return patientDAO.findByName(firstname, lastname,dob).get();
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
	
	public List<Allergy> findAllAllergies(){
		return allergyDAO.findAll();
	}
	
	public List<Vaccination> findAllVaccinations(){
		return vaccinationDAO.findAll();
	}
	
//	public Optional<List<Patient>> findPatientByName(String firstname) {
//		return patientDAO.findByFirstName(firstname);
//	}

//	public Optional<List<Patient>> findPatientByName(String firstname, String lastname) {
//		return patientDAO.findByFirstNameLastName(firstname, lastname);
//	}

}
