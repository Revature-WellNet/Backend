package com.revature.controllers;

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

import com.revature.models.DiagnosisForm;
import com.revature.models.User;
import com.revature.services.DiagnosisFormService;

@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
@RequestMapping(value="/diagnosis")
public class DiagnosisFormController {
	
	@Autowired
	private DiagnosisFormService diagnosisFormService;
	
	@GetMapping
	public ResponseEntity<List<DiagnosisForm>> findAllDiagnosisForm(){
		List<DiagnosisForm> all = diagnosisFormService.findAllDiagnosis();
		System.out.println("in diag form GET with: " );
		if(all.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(all);
	}
	
	
	
	@GetMapping(value = "/{diagId}")
	public ResponseEntity<DiagnosisForm> getDiagnosisFormById(@PathVariable("diagId")int diagId) {
		Optional<DiagnosisForm> diag = diagnosisFormService.findDiagnosisFormById(diagId);
		if(diag.isPresent()) {
			return ResponseEntity.ok(diag.get());
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/patientId/{patientId}")
	public ResponseEntity<List<DiagnosisForm>> getDiagnosisFormByPatientId(@PathVariable("patientId")int patientId) {
		Optional<List<DiagnosisForm>> diags = diagnosisFormService.findDiagnosisFormByPatient(patientId);
		if(diags != null) {
			return ResponseEntity.ok(diags.get());
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/nurseId/{nurseId}")
	public ResponseEntity<List<DiagnosisForm>> getDiagnosisFormByNurseId(@PathVariable("nurseId")String nurseId) {
		Optional<List<DiagnosisForm>> diags = diagnosisFormService.findDiagnosisFormByNurse(nurseId);
		if(diags != null) {
			return ResponseEntity.ok(diags.get());
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/doctorId/{doctorId}")
	public ResponseEntity<List<DiagnosisForm>> getDiagnosisFormByDoctorId(@PathVariable("doctorId")String doctorId) {
		Optional<List<DiagnosisForm>> diags = diagnosisFormService.findDiagnosisFormByDoctor(doctorId);
		if(diags != null) {
			return ResponseEntity.ok(diags.get());
		}
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public  ResponseEntity<DiagnosisForm> addDiagnosisForm(@RequestBody DiagnosisForm diagnosisForm){
		System.out.println("in diag form POST with: "+ diagnosisForm);
		if (diagnosisFormService.addDiagnosisForm(diagnosisForm)) {
			return ResponseEntity.status(201).build();
		} else {
			return ResponseEntity.status(400).build();
		}
		
	}
	
	@PutMapping
	public  ResponseEntity<DiagnosisForm> updateDiagnosisForm(@RequestBody DiagnosisForm diagnosisForm){
		System.out.println("in diag form PUT with: "+ diagnosisForm);
		if (diagnosisFormService.updateDiagnosisForm(diagnosisForm)) {
			return ResponseEntity.status(200).build();
		} else {
			return ResponseEntity.status(400).build();
		}
		
	}
	
	
	@DeleteMapping(value = "/{id}")
	public  ResponseEntity<DiagnosisForm> deleteDiagnosisForm(@PathVariable("id")int id) {
		
		if (diagnosisFormService.deleteDiagnosisForm(id)) {
		return ResponseEntity.status(200).build();} // = .ok()
		else {
		return ResponseEntity.status(400).build();}
		
	}
	
	
}
