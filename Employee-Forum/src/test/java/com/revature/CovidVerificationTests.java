package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Timestamp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.common.base.Optional;
import com.revature.models.Covid19Verification;
import com.revature.services.Covid19VerificationService;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class CovidVerificationTests {
	
	@Autowired
	private Covid19VerificationService cvs;
	
	Covid19Verification cv = new Covid19Verification(0, "test", new Timestamp(10000), false);
	
	@Test
	@Order(1)
	public void addOrUpdateCovid19VerificationTest() {
		assertEquals(cvs.addOrUpdateCovid19Verification(cv),cv);
		
	}
	
	@Test
	@Order(2)
	public void findAllCovid19VerificationTest() {
		assertNotEquals(cvs.findAllCovid19Verifications().size(),0);
	}
	
	@Test
	@Order(3)
	public void findCovid19VerificationById() {
		assertTrue(cvs.findById(cv.getId()).isPresent());
	}
	
	@Test
	@Order(4)
	public void findCovid19VerificationByUserId() {
		assertTrue(cvs.findByUserId(cv.getUserId()).isPresent());
	}
	
	@AfterAll
	public void deleteCovid19Verification() {
		cvs.deleteCovid19Verification(cv.getUserId());
	}

}
