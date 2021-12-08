package com.revature.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Allergy;
import com.revature.models.BloodType;
import com.revature.models.DiagnosisForm;
import com.revature.models.Patient;
import com.revature.models.Sex;
import com.revature.models.User;
import com.revature.models.Vaccination;
import com.revature.repos.AllergyDAO;
import com.revature.repos.BloodTypeDAO;
import com.revature.repos.PatientDAO;
import com.revature.repos.SexDAO;
import com.revature.repos.VaccinationDAO;

@Service
public class PatientService {

    @Autowired
    private PatientDAO patientDAO;
    @Autowired
    private DiagnosisFormService diagnosisFormService;
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

//    public Boolean updatePatient(Patient patient) {
//        try {
//            patientDAO.save(patient);
//            return true;
//        } catch (Exception e) {
//            System.out.println(e.getStackTrace());
//            return false;
//        }
//    }
//
//    public Boolean deletePatient(int patientId) {
//        try {
//            Patient patient = patientDAO.findById(patientId).get();
//
//            if (patient == null)
//                return false;
//            else {
//                //System.out.println("Tao in delete else");
//                // Delete all DigF first
//                List<DiagnosisForm> diagL = diagnosisFormService.findDiagnosisFormByPatient
//                        (patient.getPatientId()).get();
//                for (DiagnosisForm diag : diagL)
//                    diagnosisFormService.deleteDiagnosisForm(diag.getDiagId());
//
//                patientDAO.delete(patient);
//                return true;
//            }
//        } catch (Exception e) {
//            //System.out.println("Tao in delete exception");
//            System.out.println(e.getStackTrace());
//            return false;
//        }
//    }
    
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
        for (Patient p : patientDAO.findAll())
            for( DiagnosisForm df : p.getDiagnosisForms()){
                if(df.isResolutionStatus() == false) {
                    listP.add(p);
                    break;
                    }}

        return listP;
    }


//	public Optional<List<Patient>> findPatientByName(String firstname) {
//		return patientDAO.findByFirstName(firstname);
//	}

//	public Optional<List<Patient>> findPatientByName(String firstname, String lastname) {
//		return patientDAO.findByFirstNameLastName(firstname, lastname);
//	}

}
