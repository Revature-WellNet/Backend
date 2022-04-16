package com.revature.diagnosisservice.controller;

import java.time.LocalDateTime;
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

import com.revature.diagnosisservice.model.DiagnosisForm;
import com.revature.diagnosisservice.model.Patient;
import com.revature.diagnosisservice.model.User;
import com.revature.diagnosisservice.service.DiagnosisFormService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/diagnosis")
public class DiagnosisFormController {

	@Autowired
	private DiagnosisFormService diagnosisFormService;

//	@Autowired
//	private RestTemplate restTemplate;

	@GetMapping
	public ResponseEntity<List<DiagnosisForm>> findAllDiagnosisForms() {
		List<DiagnosisForm> all = diagnosisFormService.findAllDiagnosisForms();
//		System.out.println("in diag form GET with: " );
		if (all.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(all);
	}

	@GetMapping("/{diagId}")
	public ResponseEntity<DiagnosisForm> getDiagnosisFormById(@PathVariable("diagId") int diagId) {
		Optional<DiagnosisForm> diag = diagnosisFormService.findDiagnosisFormById(diagId);
		if (diag.isPresent()) {
			return ResponseEntity.ok(diag.get());
		}
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/patientId/{patientId}")

	public ResponseEntity<List<DiagnosisForm>> getDiagnosisFormByPatientId(@PathVariable("patientId") int patientId) {

		//Patient patient = restTemplate.getForObject("http://" + patientId, Patient.class);
		Patient patient = new Patient("dc", "ef", null, 56, 123, null, null, null ,null, null);
		
		Optional<List<DiagnosisForm>> diags = diagnosisFormService.findDiagnosisFormByPatient(patient);
		if (diags != null) {
			return ResponseEntity.ok(diags.get());
		}
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/nurseId/{nurseId}")
	public ResponseEntity<List<DiagnosisForm>> getDiagnosisFormByUserId(@PathVariable("userId")String userId) {
		
		//User user = restTemplate.getForObject("http://" + userId, User.class);
		User user = new User("1", "ab", "bc", "email", null);
		
		Optional<List<DiagnosisForm>> diags = diagnosisFormService.findDiagnosisFormByUser(user);
		if(diags != null) {
			return ResponseEntity.ok(diags.get());
		}
		return ResponseEntity.noContent().build();
	}

//	@GetMapping(value = "/doctorId/{doctorId}")
//	public ResponseEntity<List<DiagnosisForm>> getDiagnosisFormByDoctorId(@PathVariable("doctorId")String doctorId) {
//		Optional<List<DiagnosisForm>> diags = diagnosisFormService.findDiagnosisFormByDoctor(doctorId);
//		if(diags != null) {
//			return ResponseEntity.ok(diags.get());
//		}
//		return ResponseEntity.noContent().build();
//	}
//	
	@PostMapping
	public ResponseEntity<DiagnosisForm> addDiagnosisForm(@RequestBody DiagnosisForm diagnosisForm) {
//		System.out.println("in diag form POST with: " + diagnosisForm);
		if (diagnosisFormService.saveDiagnosisForm(diagnosisForm)) {
			return ResponseEntity.status(201).build();
		} else {
			return ResponseEntity.status(400).build();
		}
	}

	@PutMapping
	public ResponseEntity<DiagnosisForm> updateDiagnosisForm(@RequestBody DiagnosisForm diagnosisForm) {
//		System.out.println("in diag form PUT with: " + diagnosisForm);
		if (diagnosisFormService.updateDiagnosisForm(diagnosisForm)) {
			return ResponseEntity.status(200).build();
		} else {
			return ResponseEntity.status(400).build();
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<DiagnosisForm> deleteDiagnosisForm(@PathVariable("id") int id) {

		if (diagnosisFormService.deleteDiagnosisForm(diagnosisFormService.findDiagnosisFormById(id).get())) {
			return ResponseEntity.status(200).build();
		} // = .ok()
		else {
			return ResponseEntity.status(400).build();
		}

	}

	// Make new patient instead of "Movie movie = restTemplate"
	// At end return Diagnosis form with new patient filled in
	// Can make skeleton of rest api like in movie database

}
