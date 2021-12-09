package com.revature.integration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestInstance.Lifecycle;
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

import com.revature.models.Patient;
import com.revature.utils.JsonUtils;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class PatientControllerWebMvcIntegrationTest {
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mvc;
	
	@Before
	public void setup()
	{
		mvc = MockMvcBuilders
			.webAppContextSetup(context)
			.apply(springSecurity())
			.build();
	}
	
	@WithMockUser
	@Test
	@Order(1)
	public void givenAuthGetPatients() throws Exception
	{
		ArrayList<Integer> appropriateStatusCodes = new ArrayList<Integer>(Arrays.asList(200, 204)); 
		MvcResult result = mvc.perform(get("/patient").contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		assertTrue(appropriateStatusCodes.contains(result.getResponse().getStatus()));
	}
	
	@Test
	@Order(1)
	public void noAuthGetPatients() throws Exception
	{
		mvc.perform(get("/patient").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isUnauthorized());
	}
	
	@WithMockUser
	@Test
	@Order(1)
	public void givenAuthGetPatientById() throws Exception
	{
		ArrayList<Integer> appropriateStatusCodes = new ArrayList<Integer>(Arrays.asList(200, 204)); 
		MvcResult result = mvc.perform(get("/patient/{id}", 1).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		assertTrue(appropriateStatusCodes.contains(result.getResponse().getStatus()));
	}
	
	@Test
	@Order(1)
	public void noAuthGetPatientById() throws Exception
	{
		mvc.perform(get("/patient/{id}", 1).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isUnauthorized());
	}
	
	@WithMockUser
	@Test
	@Order(1)
	public void givenAuthGetPatientByFirstName() throws Exception
	{
		ArrayList<Integer> appropriateStatusCodes = new ArrayList<Integer>(Arrays.asList(200, 204)); 
		MvcResult result = mvc.perform(get("/patient/firstname/{firstname}", "firstname").contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		assertTrue(appropriateStatusCodes.contains(result.getResponse().getStatus()));
	}
	
	@Test
	@Order(1)
	public void noAuthGetPatientByFirstName() throws Exception
	{
		mvc.perform(get("/patient/firstname/{firstname}", "firstname").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isUnauthorized());
	}
	
	@WithMockUser
	@Test
	@Order(1)
	public void givenAuthGetPatientByFullName() throws Exception
	{
		ArrayList<Integer> appropriateStatusCodes = new ArrayList<Integer>(Arrays.asList(200, 204)); 
		MvcResult result = mvc.perform(get("/patient/fullname/{firstname}/{lastname}", "firstname", "lastname").contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		assertTrue(appropriateStatusCodes.contains(result.getResponse().getStatus()));
	}
	
	@Test
	@Order(1)
	public void noAuthGetPatientByFullName() throws Exception
	{
		mvc.perform(get("/patient/fullname/{firstname}/{lastname}", "firstname", "lastname").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isUnauthorized());
	}
	
	@WithMockUser
	@Test
	@Order(1)
	public void givenAuthGetPatientByFullNameDOB() throws Exception
	{
		ArrayList<Integer> appropriateStatusCodes = new ArrayList<Integer>(Arrays.asList(200, 204)); 
		MvcResult result = mvc.perform(get("/patient/fullnamedob/{firstname}/{lastname}/{dob}", "firstname", "lastname", new Date(0)).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		System.out.println("response: "  + result.getResponse().getStatus());
		assertTrue(appropriateStatusCodes.contains(result.getResponse().getStatus()));
	}
	
	@Test
	@Order(1)
	public void noAuthGetPatientByFullNameDOB() throws Exception
	{
		mvc.perform(get("/patient/fullnamedob/{firstname}/{lastname}/{dob}", "firstname", "lastname", new Date(0)).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isUnauthorized());
	}
	
	@WithMockUser
	@Test
	@Order(1)
	public void givenAuthGetAllergies() throws Exception
	{
		ArrayList<Integer> appropriateStatusCodes = new ArrayList<Integer>(Arrays.asList(200, 204)); 
		MvcResult result = mvc.perform(get("/patient/allergies").contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		assertTrue(appropriateStatusCodes.contains(result.getResponse().getStatus()));
	}
	
	@Test
	@Order(1)
	public void noAuthGetAllergies() throws Exception
	{
		mvc.perform(get("/patient/allergies").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isUnauthorized());
	}
	
	@WithMockUser
	@Test
	@Order(1)
	public void givenAuthGetVaccinations() throws Exception
	{
		ArrayList<Integer> appropriateStatusCodes = new ArrayList<Integer>(Arrays.asList(200, 204)); 
		MvcResult result = mvc.perform(get("/patient/vaccinations").contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		assertTrue(appropriateStatusCodes.contains(result.getResponse().getStatus()));
	}
	
	@Test
	@Order(1)
	public void noAuthGetVaccinations() throws Exception
	{
		mvc.perform(get("/patient/vaccinations").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isUnauthorized());
	}
	
	@WithMockUser
	@Test
	@Order(1)
	public void givenAuthGetBloodType() throws Exception
	{
		ArrayList<Integer> appropriateStatusCodes = new ArrayList<Integer>(Arrays.asList(200, 204)); 
		MvcResult result = mvc.perform(get("/patient/bloodtype/{blood}", "O").contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		assertTrue(appropriateStatusCodes.contains(result.getResponse().getStatus()));
	}
	
	@Test
	@Order(1)
	public void noAuthGetBloodType() throws Exception
	{
		mvc.perform(get("/patient/bloodtype/{blood}", "O").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isUnauthorized());
	}
	
	@WithMockUser
	@Test
	@Order(1)
	public void givenAuthGetSexType() throws Exception
	{
		ArrayList<Integer> appropriateStatusCodes = new ArrayList<Integer>(Arrays.asList(200, 204)); 
		MvcResult result = mvc.perform(get("/patient/sex/{sex}", "M").contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		assertTrue(appropriateStatusCodes.contains(result.getResponse().getStatus()));
	}
	
	@Test
	@Order(1)
	public void noAuthGetSexType() throws Exception
	{
		mvc.perform(get("/patient/sex/{sex}", "M").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isUnauthorized());
	}
	
	@WithMockUser
	@Test
	@Order(2)
	public void givenAuthPostPatientPositiveTest() throws Exception
	{
		mvc.perform(post("/patient")
			.content(JsonUtils.asJsonString(new Patient("first", "last", new Date(0), 0, 0, null, null, null, null, null)))
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated());
	}
	
	@Test
	@Order(2)
	public void noAuthPostPatient() throws Exception
	{
		mvc.perform(post("/patient")
			.content(JsonUtils.asJsonString(new Patient("first", "last", new Date(0), 0, 0, null, null, null, null, null)))
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isUnauthorized());
	}
	
	@WithMockUser
	@Test
	@Order(2)
	public void givenAuthPutPatient() throws Exception
	{
		ArrayList<Integer> appropriateStatusCodes = new ArrayList<Integer>(Arrays.asList(200, 400)); 
		MvcResult result = mvc.perform(put("/patient")
			.content(JsonUtils.asJsonString(new Patient(99, "first", "last", new Date(0), 0, 0, null, null, null, null, null)))
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andReturn();
		assertTrue(appropriateStatusCodes.contains(result.getResponse().getStatus()));
	}
	
	@Test
	@Order(2)
	public void noAuthPutPatient() throws Exception
	{
		mvc.perform(put("/patient")
				.content(JsonUtils.asJsonString(new Patient(99, "first", "last", new Date(0), 0, 0, null, null, null, null, null)))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isUnauthorized());
	}
	
	@WithMockUser
	@Test
	@Order(3)
	public void givenAuthDeletePatient() throws Exception
	{
		ArrayList<Integer> appropriateStatusCodes = new ArrayList<Integer>(Arrays.asList(200, 400)); 
		MvcResult result = mvc.perform(delete("/patient/{id}", 99)
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andReturn();
		assertTrue(appropriateStatusCodes.contains(result.getResponse().getStatus()));
	}
	
	@Test
	@Order(3)
	public void noAuthDeletePatient() throws Exception
	{
		mvc.perform(delete("/patient/{id}", 99)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isUnauthorized());
	}
	
	@WithMockUser
	@Test
	@Order(2)
	public void givenAuthAddAllergy() throws Exception
	{
		ArrayList<Integer> appropriateStatusCodes = new ArrayList<Integer>(Arrays.asList(201, 400)); 
		MvcResult result = mvc.perform(post("/patient/allergies")
				.content("integration-allergy")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		assertTrue(appropriateStatusCodes.contains(result.getResponse().getStatus()));
	}
	
	@Test
	@Order(2)
	public void noAuthAddAllergy() throws Exception
	{
		mvc.perform(post("/patient/allergies")
			.content("integration-allergy")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isUnauthorized());
	}
	
	@WithMockUser
	@Test
	@Order(2)
	public void givenAuthAddVaccine() throws Exception
	{
		ArrayList<Integer> appropriateStatusCodes = new ArrayList<Integer>(Arrays.asList(201, 400)); 
		MvcResult result = mvc.perform(post("/patient/vaccinations")
			.content("integration-vaccine")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andReturn();
		assertTrue(appropriateStatusCodes.contains(result.getResponse().getStatus()));
	}
	
	@Test
	@Order(2)
	public void noAuthAddVaccine() throws Exception
	{
		mvc.perform(post("/patient/vaccinations")
			.content("integration-vaccine")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isUnauthorized());
	}
	
	@WithMockUser
	@Test
	@Order(3)
	public void givenAuthDeleteAllergy() throws Exception
	{
		ArrayList<Integer> appropriateStatusCodes = new ArrayList<Integer>(Arrays.asList(200, 400)); 
		MvcResult result = mvc.perform(delete("/patient/allergies/{allergy}", "integration-allergy")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andReturn();
		assertTrue(appropriateStatusCodes.contains(result.getResponse().getStatus()));
	}
	
	@Test
	@Order(3)
	public void noAuthDeleteAllergy() throws Exception
	{
		mvc.perform(delete("/patient/allergies/{allergy}", "integration-allergy")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isUnauthorized());
	}
	
	@WithMockUser
	@Test
	@Order(3)
	public void givenAuthDeleteVaccine() throws Exception
	{
		ArrayList<Integer> appropriateStatusCodes = new ArrayList<Integer>(Arrays.asList(200, 400)); 
		MvcResult result = mvc.perform(delete("/patient/vaccinations/{vaccine}", "integration-vaccine")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andReturn();
		assertTrue(appropriateStatusCodes.contains(result.getResponse().getStatus()));
	}
	
	@Test
	@Order(3)
	public void noAuthDeleteVaccine() throws Exception
	{
		mvc.perform(post("/patient/vaccinations/{vaccine}", "integration-vaccine")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isUnauthorized());
	}
	
}
