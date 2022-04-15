package com.revature.controllers;

import java.sql.Date;// may have to change to .util
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Allergy;
import com.revature.models.BloodType;
import com.revature.models.Patient;
import com.revature.models.Sex;
import com.revature.models.User;
import com.revature.models.Vaccination;
import com.revature.services.PatientService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/patient")
public class PatientController {


    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatient() {
        List<Patient> all = patientService.findAllPatients();

        if (all.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(all);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable("id") int id) {
        Optional<Patient> patient = patientService.findPatientById(id);
        if (patient.isPresent()) {
            return ResponseEntity.ok(patient.get());
        }

        return ResponseEntity.noContent().build();
    }

//    @GetMapping(value = "/id/{id}")
//    public ResponseEntity<Patient> getPatient(@PathVariable("id") int id) {
//        //System.out.println("In get int id.");
//        Optional<Patient> patient = patientService.findPatientById(id);
//        if (patient.isPresent()) {
//            return ResponseEntity.ok(patient.get());
//        }
//
//        return ResponseEntity.noContent().build();
//    }

    @GetMapping(value = "/firstname/{firstName}")
    public ResponseEntity<List<Patient>> getPatient(@PathVariable("firstName") String firstName) {
        System.out.println("In get string firstName.");
        Optional<List<Patient>> list = patientService.findPatientByName(firstName);
//        System.err.println(list);
        if (list.isPresent()) {
            return ResponseEntity.ok(list.get());
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/fullname/{firstName}/{lastName}")
    public ResponseEntity<List<Patient>> getPatient(@PathVariable("firstName") String firstName,
                                                    @PathVariable("lastName") String lastName) {
        Optional<List<Patient>> list = patientService.findPatientByName(firstName, lastName);
        if (list.isPresent()) {
            return ResponseEntity.ok(list.get());
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/fullnamedob/{firstName}/{lastName}/{dob}")
    public ResponseEntity<List<Patient>> getPatient(@PathVariable("firstName") String firstName,
                                              @PathVariable("lastName") String lastName,
                                              @PathVariable("dob") Date dob) {
        Optional<List<Patient>> list = patientService.findPatientByName(firstName, lastName, dob);
        System.err.println(list);
        if (list.isPresent()) {
            return ResponseEntity.ok(list.get());
        }
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping(value = "/allergies")
	public ResponseEntity<List<Allergy>> getAllAllergies() {
		List<Allergy> all = patientService.findAllAllergies();
		return ResponseEntity.ok(all);
	}
	
	@GetMapping(value = "/vaccinations")
	public ResponseEntity<List<Vaccination>> getAllVaccinations() {
		List<Vaccination> all = patientService.findAllVaccinations();
		
		return ResponseEntity.ok(all);
	}
	
	@GetMapping("/bloodtype/{name}")
	public ResponseEntity<BloodType> findBloodType(@PathVariable("name") String name ){
		Optional<BloodType> optional = patientService.findBloodType(name);
		
		if(optional.isPresent())
		{
			return ResponseEntity.ok(optional.get());
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/sex/{name}")
	public ResponseEntity<Sex> findSex(@PathVariable("name") String name ){
		Optional<Sex> optional = patientService.findSex(name);
		
		if(optional.isPresent())
		{
			return ResponseEntity.ok(optional.get());
		}
		
		return ResponseEntity.noContent().build();
	}
	

    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {

        if (patientService.addPatient(patient)) {
            return ResponseEntity.status(201).build();
        } else {
            return ResponseEntity.status(400).build();
        }

    }

//    @PutMapping
//    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) {
//
//        if (patientService.updatePatient(patient)) {
//            return ResponseEntity.status(200).build();
//        } else {
//            return ResponseEntity.status(400).build();
//        }
//
//    }


//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<Patient> deletePatient(@PathVariable("id") int id) {
//
//        if (patientService.deletePatient(id)) {
//            return ResponseEntity.status(200).build();
//        } else {
//            return ResponseEntity.status(400).build();
//        }
//
//    }
    
    @PostMapping(value = "/allergies")
    public ResponseEntity<Allergy> addAllergy(@RequestBody String allergy) {
    	
    	Allergy allergyObj = new Allergy(allergy, null);
    	
        if (patientService.addAllergy(allergyObj)) {
            return ResponseEntity.status(201).build();
        } else {
            return ResponseEntity.status(400).build();
        }

    }
    
    @PostMapping(value = "/vaccinations")
    public ResponseEntity<Vaccination> addVaccine(@RequestBody String vaccine) {
    	
    	Vaccination vaccineObj = new Vaccination(vaccine, null);

        if (patientService.addVaccine(vaccineObj)) {
            return ResponseEntity.status(201).build();
        } else {
            return ResponseEntity.status(400).build();
        }

    }
    
    @DeleteMapping(value = "allergies/{allergy}")
    public ResponseEntity<Allergy> deleteAllergy(@PathVariable("allergy") String allergy) {
    	
    	System.out.println(allergy);
    	List<Allergy> allAllergies = patientService.findAllAllergies();
    	for(Allergy a : allAllergies) {
    		if(a.getAllergy().equals(allergy)) {
    			
    			if(patientService.deleteAllergy(allergy)) {
    	            return ResponseEntity.status(200).build();
    			}
    			
    		}
    		
    	}
    	
    	return ResponseEntity.status(400).build();


    }
    
    @DeleteMapping(value = "vaccinations/{vaccine}")
    public ResponseEntity<Allergy> deleteVaccine(@PathVariable("vaccine") String vaccine) {
    	
    	List<Vaccination> allVaccinations = patientService.findAllVaccinations();
    	for(Vaccination v : allVaccinations) {
    		if(v.getVaccination().equals(vaccine)) {		
    			
    			if(patientService.deleteVaccine(vaccine)) {
    	            return ResponseEntity.status(200).build();
    			}			
    		}
    		
    	}
    	
    	return ResponseEntity.status(400).build();

    }
    
    @GetMapping(value="/resolved")
    public ResponseEntity<List<Patient>> getAllUnresolvedPatients() {
        List<Patient> all = patientService.findPatientByResoved(); //yep

        if (all.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(all);
    }


}
	

