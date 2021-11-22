package com.revature.services;

import java.sql.Date;// may have to change to .util 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.DiagnosisForm;
import com.revature.models.Patient;
import com.revature.repos.PatientDAO;

@Service
public class PatientService {

    @Autowired
    private PatientDAO patientDAO;
    @Autowired
    private DiagnosisFormService diagnosisFormService;

    public List<Patient> findAllPatients() {
        return patientDAO.findAll();
    }

    public Optional<Patient> findPatientById(int id) {
        return patientDAO.findById(id);
    }

    public Optional<List<Patient>> findPatientByName(String firstname) {
        return patientDAO.findByName(firstname);
    }

    public Optional<List<Patient>> findPatientByName(String firstname, String lastname) {
        return patientDAO.findByName(firstname, lastname);
    }

    public Optional<Patient> findPatientByName(String firstname, String lastname, Date dob) {
        return patientDAO.findByName(firstname, lastname, dob);
    }

    public Boolean addPatient(Patient patient) {
        try {
            patientDAO.save(patient);
            return true;
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            return false;
        }
    }

    public Boolean updatePatient(Patient patient) {
        try {
            patientDAO.save(patient);
            return true;
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            return false;
        }
    }

    public Boolean deletePatient(int patientId) {
        try {
            Patient patient = patientDAO.findById(patientId).get();

            if (patient == null)
                return false;
            else {
                //System.out.println("Tao in delete else");
                // Delete all DigF first
                List<DiagnosisForm> diagL = diagnosisFormService.findDiagnosisFormByPatient
                        (patient.getPatientId()).get();
                for (DiagnosisForm diag : diagL)
                    diagnosisFormService.deleteDiagnosisForm(diag.getDiagId());

                patientDAO.delete(patient);
                return true;
            }
        } catch (Exception e) {
            //System.out.println("Tao in delete exception");
            System.out.println(e.getStackTrace());
            return false;
        }
    }

//	public Optional<List<Patient>> findPatientByName(String firstname) {
//		return patientDAO.findByFirstName(firstname);
//	}

//	public Optional<List<Patient>> findPatientByName(String firstname, String lastname) {
//		return patientDAO.findByFirstNameLastName(firstname, lastname);
//	}

}
