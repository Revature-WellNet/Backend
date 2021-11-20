package com.revature.controllers;

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

import com.revature.models.DiagnosisForm;
import com.revature.services.DiagnosisFormService;

@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
@RequestMapping(value="/diagnosis")
public class DiagnosisFormController {
	
	@Autowired
	private DiagnosisFormService diagnosisFormService;
	
	@GetMapping(value = "/{diagId}")
	public DiagnosisForm getDiagnosisFormById(@PathVariable("diagId")int diagId) {
		return diagnosisFormService.findDiagnosisFormById(diagId);
	}
	
	@GetMapping(value = "/{patientId}")
	public List<DiagnosisForm> getDiagnosisFormByPatientId(@PathVariable("patientId")int patientId) {
		return diagnosisFormService.findDiagnosisFormByPatient(patientId);
	}
	
	@GetMapping(value = "/{nurseId}")
	public List<DiagnosisForm> getDiagnosisFormByNurseId(@PathVariable("nurseId")int nurseId) {
		return diagnosisFormService.findDiagnosisFormByNurse(nurseId);
	}
	
	@GetMapping(value = "/{doctorId}")
	public List<DiagnosisForm> getDiagnosisFormByDoctorId(@PathVariable("doctorId")int doctorId) {
		return diagnosisFormService.findDiagnosisFormByDoctor(doctorId);
	}
	
	@PostMapping
	public  ResponseEntity<DiagnosisForm> addDiagnosisForm(@RequestBody DiagnosisForm diagnosisForm){
		
		if (diagnosisFormService.addDiagnosisForm(diagnosisForm)) {
		return ResponseEntity.status(201).build();}
		
		else {
		return ResponseEntity.status(400).build();}
		
	}
	
	@PutMapping
	public  ResponseEntity<DiagnosisForm> updateDiagnosisForm(@RequestBody DiagnosisForm diagnosisForm){
		
		if (diagnosisFormService.updateDiagnosisForm(diagnosisForm)) {
		return ResponseEntity.status(200).build();}
		
		else {
		return ResponseEntity.status(400).build();}
		
	}
	
	
	@DeleteMapping(value = "/{id}")
	public  ResponseEntity<DiagnosisForm> deleteDiagnosisForm(@PathVariable("id")int id) {
		
		if (diagnosisFormService.deleteDiagnosisForm(id)) {
		return ResponseEntity.status(200).build();}
		else {
		return ResponseEntity.status(400).build();}
		
	}
	
	
}
