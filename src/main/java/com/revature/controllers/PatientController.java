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

import com.revature.models.Patient;
import com.revature.models.Patient;
import com.revature.services.PatientService;


@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
@RequestMapping(value="/patient")
public class PatientController {
	private PatientService patientService;
	
	@Autowired
	public PatientController(PatientService patientService) {
		this.patientService= patientService;
	}
	
	
	@GetMapping
	public ResponseEntity<List<Patient>> findAllPatient(){
		List<Patient> all = patientService.findAllPatients();
		
		if(all.isEmpty()) {
			return ResponseEntity.noContent().build();
		}	
		return ResponseEntity.ok(all);
	}
	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Patient> getPatient(@PathVariable("id") int id) {
		System.out.println("In get int id.");
		Optional<Patient> patient = patientService.findPatientById(id);
		if(patient.isPresent()) {
			return ResponseEntity.ok(patient.get());
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/firstname/{firstName}")
	public ResponseEntity<List<Patient>> getPatient(@PathVariable("firstname")String firstName){
		System.out.println("In get string firstName.");
		Optional<List<Patient>> list =  patientService.findPatientByName(firstName);
		if(list.isPresent()) {
			return ResponseEntity.ok(list.get());
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/fullname/{firstName}/{lastName}")
	public ResponseEntity<List<Patient>> getPatient(@PathVariable("firstname")String firstName,
			                 @PathVariable("lastname")String lastName) {
		Optional<List<Patient>> list =  patientService.findPatientByName(firstName,lastName);
		if(list.isPresent()) {
			return ResponseEntity.ok(list.get());
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/fullnamedob/{firstName}/{lastName}/{dob}")
	public ResponseEntity<Patient> getPatient(@PathVariable("firstname")String firstName,
			                 @PathVariable("lastname")String lastName,
			                 @PathVariable("dob")Date dob) {
		Optional<Patient> list =  patientService.findPatientByName(firstName,lastName,dob);
		if(list.isPresent()) {
			return ResponseEntity.ok(list.get());
		}
		return ResponseEntity.noContent().build();
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
	

