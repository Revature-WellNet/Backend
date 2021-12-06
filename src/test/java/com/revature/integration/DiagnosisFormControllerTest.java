package com.revature.integration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.revature.models.DiagnosisForm;
import com.revature.utils.JsonUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class DiagnosisFormControllerTest {

	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mvc;
	
	//These both rely on actual firebase UID entries. If post request tests break,
	//check and make sure that these entries are still in there. If not, replace
	//them with any entry that is inside them.
	
	private static final String testUID1 = "ooApve7PoQP9Lbk5irFdy2D5BeE3";
	private static final String testUID2 = "xQEMPrMTdkMNkKM5eBwr8fAZaJS2";
	
//	int diagId, String diagnosis, String symptoms, String treatment, boolean resolutionStatus, Timestamp checkIn,
//  Timestamp checkOut
	private static final int diagId = 0;
	private static final String diagnosis = "";
	private static final String symptoms = "";
	private static final String treatment = "";
	private static final boolean resolutionStatus = true;
	private static final Timestamp checkIn = null;
	private static final Timestamp checkOut = null;

	
	@Before
	public void setup()
	{
		mvc = MockMvcBuilders
			.webAppContextSetup(context)
			.apply(springSecurity())
			.build();
	}
	
	@WithMockUser(value=testUID1)
	@Test
	public void findAllDianosisFormTest() throws Exception{
		ArrayList<Integer> appropriateStatusCodes = 
				new ArrayList<Integer>(Arrays.asList(200, 204)); 
		MvcResult result = mvc.perform(get("/diagnosis")
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		assertTrue(appropriateStatusCodes
				.contains(result.getResponse()
				.getStatus()));
	}
	
	@WithMockUser(value=testUID1)
	@Test
	public void getDiagnosisFormByIdTest() throws Exception{
		ArrayList<Integer> appropriateStatusCodes = 
				new ArrayList<Integer>(Arrays.asList(200, 204)); 
		MvcResult result = mvc.perform(get("/diagnosis/{diagId}", 1)
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		assertTrue(appropriateStatusCodes
				.contains(result.getResponse()
				.getStatus()));
	}
	
	@WithMockUser(value=testUID1)
	@Test
	public void getDiagnosisFormByPatientIdTest() throws Exception{
		ArrayList<Integer> appropriateStatusCodes = 
				new ArrayList<Integer>(Arrays.asList(200, 204)); 
		MvcResult result = mvc.perform(get("/diagnosis/patientId/{patientId}", 1)
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		assertTrue(appropriateStatusCodes
				.contains(result.getResponse()
				.getStatus()));
	}
	
	@WithMockUser(value=testUID1)
	@Test
	public void getDiagnosisFormByNurseIdTest() throws Exception{
		ArrayList<Integer> appropriateStatusCodes = 
				new ArrayList<Integer>(Arrays.asList(200, 204)); 
		MvcResult result = mvc.perform(get("/diagnosis/nurseId/{nurseId}", 1)
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		assertTrue(appropriateStatusCodes
				.contains(result.getResponse()
				.getStatus()));
	}
	
	@WithMockUser(value=testUID1)
	@Test
	public void getDiagnosisFormByDoctorIdTest() throws Exception{
		ArrayList<Integer> appropriateStatusCodes = 
				new ArrayList<Integer>(Arrays.asList(200, 204)); 
		MvcResult result = mvc.perform(get("/diagnosis/doctorId/{doctorId}", testUID2)
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		assertTrue(appropriateStatusCodes
				.contains(result.getResponse()
				.getStatus()));
	}
	
	@WithMockUser(value=testUID1)
	@Test
	@Order(1)
	public void addDiagnosisFormTest() throws Exception{
		ArrayList<Integer> appropriateStatusCodes = 
				new ArrayList<Integer>(Arrays.asList(201, 400)); 
		MvcResult result = mvc.perform(post("/diagnosis")
				.content(JsonUtils.asJsonString(
						new DiagnosisForm(
								diagId,
								diagnosis,
								symptoms,
								treatment,
								resolutionStatus,
								checkIn,
								checkOut
								)))
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		assertTrue(appropriateStatusCodes
				.contains(result.getResponse()
				.getStatus()));
	}
	
	@WithMockUser(value=testUID1)
	@Test
	public void updateDiagnosisFormTest() throws Exception{
		ArrayList<Integer> appropriateStatusCodes = 
				new ArrayList<Integer>(Arrays.asList(200, 400)); 
		MvcResult result = mvc.perform(put("/diagnosis")
				.content(JsonUtils.asJsonString(
						new DiagnosisForm(
								diagId,
								diagnosis,
								symptoms,
								treatment,
								resolutionStatus,
								checkIn,
								checkOut
								)))
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		assertTrue(appropriateStatusCodes
				.contains(result.getResponse()
				.getStatus()));
	}
	
	@WithMockUser(value=testUID1)
	@Test
	@Order(2)
	public void deleteDiagnosisForm() throws Exception{
		ArrayList<Integer> appropriateStatusCodes = 
				new ArrayList<Integer>(Arrays.asList(200, 400)); 
		MvcResult result = mvc.perform(delete("/diagnosis/{id}", 1)
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		assertTrue(appropriateStatusCodes
				.contains(result.getResponse()
				.getStatus()));
	}
}

































