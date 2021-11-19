package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.controllers.CovidVerification;
import com.revature.models.Covid19Verification;
import com.revature.models.Patient;
import com.revature.models.Role;
import com.revature.models.Covid19Verification;
import com.revature.repos.Covid19VerificationDAO;

@Service
public class Covid19VerificationService {
	
	
	private Covid19VerificationDAO cvd;
	
	@Autowired
	public Covid19VerificationService(Covid19VerificationDAO cvd) {
		super();
		this.cvd=cvd;
	}
	
	
	public void addOrUpdateCovid19Verification(Covid19Verification cv) {
		cvd.save(cv);
	}
	
	public List<Covid19Verification> findAllCovid19Verifications(){
		return cvd.findAll();
	}
	
	public Optional<Covid19Verification> findById(int id) {
		return cvd.findById(id);
	}
	
	
	public void deleteCovid19Verification(int id) {
		Covid19Verification cv = findById(id).get();
		if(cv!=null) {
			cvd.delete(cv);
//			return true;		
		}else {
//			return false;
		}
	}
	

	
	
	

}
