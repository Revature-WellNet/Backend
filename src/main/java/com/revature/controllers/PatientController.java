package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Patient;
import com.revature.services.PatientService;


@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
@RequestMapping(value="/diagnosis/patient")
public class PatientController {
	private PatientService patientService;
	
	@Autowired
	public PatientController(PatientService patientService) {
		this.patientService= patientService;
	}
	
	@GetMapping(value = "/{id}")
	
	public Patient getPatient(@PathVariable("id")int id) {
		return patientService.findPatientById(id);
	}
	@GetMapping(value = "/{firstName}/{lastName}")
	public Patient getPatient(@PathVariable("firstname")String firstName,
			                 @PathVariable("lastname")String lastName) {
		return patientService.findPatientByName(firstName,lastName);
	}
	@PostMapping
	public  ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
		return ResponseEntity.status(201).build(); 
	}
	
	
	
	

	
	
	
	
	
	
	
}
