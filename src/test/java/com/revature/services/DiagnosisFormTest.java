package com.revature.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.repos.DiagnosisFormDAO;
import com.revature.repos.PatientDAO;
import com.revature.repos.UserDAO;

@ExtendWith({MockitoExtension.class})
public class DiagnosisFormTest {
	
	@InjectMocks
	DiagnosisFormService diagFormService;
	@Mock
	private DiagnosisFormDAO diagFormDAO;
	@Mock
	private PatientDAO patientDAO;
	@Mock
	private UserDAO userDAO;
	
	@BeforeAll
	public void beforeAll() throws Exception {
		MockitoAnnotations.openMocks(this);
	}
}

