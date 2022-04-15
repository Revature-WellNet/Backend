package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
	public Covid19Verification addOrUpdateCovid19Verification(Covid19Verification cv) {
		cvd.save(cv);
		return cv;
	}
	
	public List<Covid19Verification> findAllCovid19Verifications(){
		return cvd.findAll();
	}
	
	public Optional<List<Covid19Verification>> findById(int id) {
		return cvd.findById(id);
	}
	
	
	public boolean deleteCovid19Verification(String userId) {
		Covid19Verification cv = findByUserId(userId).get();
		if(cv!=null) {
			cvd.delete(cv);
		return true;	
		}else {
		return false;
		}
	}
	
	public Optional<Covid19Verification> findByUserId(String userId) {
		return cvd.findByUserId(userId);
	}
	
	
	

}
