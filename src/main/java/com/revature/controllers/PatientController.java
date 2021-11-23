package com.revature.controllers;

import java.sql.Date;// may have to change to .util
import java.util.List;

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
import com.revature.models.Patient;
import com.revature.models.User;
import com.revature.models.Vaccination;
import com.revature.services.PatientService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/diagnosis/patient")
public class PatientController {
	private PatientService patientService;
	
	@Autowired
	public PatientController(PatientService patientService) {
		this.patientService= patientService;
	}
	
	@GetMapping
	public ResponseEntity<List<Patient>> getAllPatient(){
		List<Patient> all = patientService.findAllPatients();
		
		if(all.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(all);
	}
	
	@GetMapping(value = "/{id}")
	public Patient getPatient(@PathVariable("id")int id) {
		return patientService.findPatientById(id);
	}
	@GetMapping(value = "/{firstName}")
	public List<Patient> getPatient(@PathVariable("firstname")String firstName){
		return patientService.findPatientByName(firstName);
	}
	@GetMapping(value = "/{firstName}/{lastName}")
	public List<Patient> getPatient(@PathVariable("firstname")String firstName,
			                 @PathVariable("lastname")String lastName) {
		return patientService.findPatientByName(firstName,lastName);
	}
	@GetMapping(value = "/{firstName}/{lastName}/{dob}")
	public Patient getPatient(@PathVariable("firstname")String firstName,
			                 @PathVariable("lastname")String lastName,
			                 @PathVariable("dob")Date dob) {
		return patientService.findPatientByName(firstName,lastName,dob);
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
	
	@PostMapping
	public  ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
		
		if (patientService.addPatient(patient)) {
		return ResponseEntity.status(201).build();}
		
		else {
		return ResponseEntity.status(400).build();}
		
	}
	
	@PutMapping
	public  ResponseEntity<Patient> updatePatient(@RequestBody Patient patient){
		
		if (patientService.updatePatient(patient)) {
		return ResponseEntity.status(200).build();}
		
		else {
		return ResponseEntity.status(400).build();}
		
	}
	
	
	
	
	
	
	@DeleteMapping(value = "/{id}")
	public  ResponseEntity<Patient> deletePatient(@PathVariable("id")int id) {
		
		if (patientService.deletePatient(id)) {
		return ResponseEntity.status(200).build();}
		else {
		return ResponseEntity.status(400).build();}
		
	}
	
	
	
}
	

