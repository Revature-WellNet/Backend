package com.revature.patientservice.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.patientservice.model.Allergy;
import com.revature.patientservice.model.BloodType;
import com.revature.patientservice.model.DiagnosisForm;
import com.revature.patientservice.model.DiagnosisFormList;
import com.revature.patientservice.model.Sex;
import com.revature.patientservice.model.User;
import com.revature.patientservice.model.Vaccination;
import com.revature.patientservice.model.Patient;
import com.revature.patientservice.repo.PatientDAO;
import com.revature.patientservice.repo.AllergyDAO;
import com.revature.patientservice.repo.BloodTypeDAO;
import com.revature.patientservice.repo.SexDAO;
import com.revature.patientservice.repo.VaccinationDAO;

@Service
public class PatientService {

    @Autowired
    private PatientDAO patientDAO;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
	private AllergyDAO allergyDAO;
	@Autowired
	private VaccinationDAO vaccinationDAO;
	@Autowired
	private BloodTypeDAO bloodtypeDAO;
	@Autowired
	private SexDAO sexDAO;
	
	


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

    public Optional<List<Patient>> findPatientByName(String firstname, String lastname, Date dob) {
        return patientDAO.findByName(firstname, lastname, dob);
    }

    public Boolean addPatient(Patient patient) {
    	
    	List<Patient> allPatients = this.findAllPatients();    	
    	for(Patient i : allPatients) {
    		
    		if(i.getFirstName().equals(patient.getFirstName()) && 
    			i.getLastName().equals(patient.getLastName()) &&	
    			i.getDob().equals(patient.getDob())) {
    			
    			return false; //Not allowed to have patients with the same First, last and DoB. Comes down to not expecting nurses to memorize unique patient keys
    			
    		}
    	}
    	
        try {
        	System.out.println(patient);
            patientDAO.save(patient);
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
	
	public Boolean addAllergy(Allergy allergy){
		try {
        	
            allergyDAO.save(allergy);
            return true;
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            return false;
        }
	}
	
	public Boolean addVaccine(Vaccination vaccine){
		try {
        	
            vaccinationDAO.save(vaccine);
            return true;
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            return false;
        }
	}
	
	public Boolean deleteAllergy(String allergy) {
        try {
            Allergy deadAllergy = allergyDAO.findByAllergy(allergy).get();

            if (deadAllergy == null)
                return false;
            else {

                allergyDAO.delete(deadAllergy);
                return true;
            }
        } catch (Exception e) {
            
            System.out.println(e.getStackTrace());
            return false;
        }
    }
	
	public Boolean deleteVaccine(String vaccine) {
        try {
            Vaccination deadVaccine = vaccinationDAO.findByVaccination(vaccine).get();

            if (deadVaccine == null)
                return false;
            else {

                vaccinationDAO.delete(deadVaccine);
                return true;
            }
        } catch (Exception e) {
            
            System.out.println(e.getStackTrace());
            return false;
        }
    }
	
	public Optional<BloodType> findBloodType(String name) {
		
		return bloodtypeDAO.findByType(name);
	}
	
	public Optional<Sex> findSex(String name) {
		
		return sexDAO.findBySex(name);
	}
	
	public List<Patient> findPatientByResoved() {
        List<Patient> listP = new ArrayList<>();
        //List<DiagnosisForm> 
        for (Patient p : patientDAO.findAll()) {
        	String url = "http://localhost:8097/patientId/" + p.getPatientId();
        	DiagnosisFormList dFormsList = restTemplate.getForObject(url, DiagnosisFormList.class);
            System.out.println(dFormsList);
        	List<DiagnosisForm> dForms = dFormsList.getDiagnosisForms();
            for( DiagnosisForm df: dForms){
                if(df.isResolutionStatus() == false) {
                    listP.add(p);
                    break;
                }
        	}
        }
        return listP;
    }




}
