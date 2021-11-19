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

import com.revature.models.Avenger;
import com.revature.models.Covid19Verification;
import com.revature.models.Home;
import com.revature.models.User;
import com.revature.services.Covid19VerificationService;


@CrossOrigin
@RestController
@RequestMapping("/covid")
public class Covid19VerificationController {
	
	@Autowired
	private Covid19VerificationService cvs;

	@Autowired
	public Covid19VerificationController(Covid19VerificationService cvs) {
		super();
		this.cvs = cvs;
	}
	
	
	@GetMapping
	public ResponseEntity<List<Covid19Verification>> findAllCovid19Verification(){
		List<Covid19Verification> all = cvs.findAllCovid19Verifications();
		
		if(all.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(all);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Covid19Verification>> findCovid19VerificationById(@PathVariable("id") int id){
		Optional<Covid19Verification> cv = cvs.findById(id);
		return ResponseEntity.status(200).body(cv);
	}
	
	@PostMapping
	public ResponseEntity<Covid19Verification> addCovid19Verification(@RequestBody Covid19Verification cv) {
		cvs.addOrUpdateCovid19Verification(cv);
		return ResponseEntity.status(201).build();
	}
	
	@PutMapping
	public ResponseEntity<Covid19Verification> updateCovid19Verification(@RequestBody Covid19Verification cv) {
		cvs.addOrUpdateCovid19Verification(cv);
		return ResponseEntity.status(201).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Covid19Verification> deleteCovid19Verification(@PathVariable("id") int id) {
		cvs.deleteCovid19Verification(id);
		return ResponseEntity.status(201).build();
	}
	
	
	
	
	

}
