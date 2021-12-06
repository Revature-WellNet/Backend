package com.revature.integration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.revature.models.Covid19Verification;
import com.revature.utils.JsonUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.MOCK)
public class Covid19VerificationControllerWebMvcIntegrationTest {

	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mvc;
	
	//These both rely on actual firebase UID entries. If post request tests break,
	//check and make sure that these entries are still in there. If not, replace
	//them with any entry that is inside them.
	
	private static final String testUID1 = "ooApve7PoQP9Lbk5irFdy2D5BeE3";
	private static final String testUID2 = "xQEMPrMTdkMNkKM5eBwr8fAZaJS2";
	private static final Timestamp timestamp = null;
	private static final boolean covid = false;
	
	@Before 
	public void setup() {
		mvc = MockMvcBuilders
				.webAppContextSetup(context)
				.apply(springSecurity())
				.build();
	}
	
	@WithMockUser(value=testUID1)
	@Test
	public void findAllCovid19VerificationTest() throws Exception{
		
		ArrayList<Integer> appropriateStatusCodes = 
				new ArrayList<Integer>(Arrays.asList(200, 204)); 
		MvcResult result = mvc.perform(get("/covid", testUID1)
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		assertTrue(appropriateStatusCodes
				.contains(result.getResponse().getStatus()));	
	}
	
	@WithMockUser(value=testUID1)
	@Test
	public void findCovid19VerificationByIdTest() throws Exception{
		
		ArrayList<Integer> appropriateStatusCodes = 
				new ArrayList<Integer>(Arrays.asList(200, 400));
		
		MvcResult result = mvc.perform(get("/covid/{id}", 1)
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();
				assertTrue(appropriateStatusCodes
				.contains(result.getResponse().getStatus()));
	}
	
	@WithMockUser(value=testUID1)
	@Test
	@Order(1)
	public void addCovid19VerificationTest() throws Exception{
		
		mvc.perform(post("/covid")
				.content(JsonUtils.asJsonString(
						new Covid19Verification(
								testUID1, 
								timestamp, 
								false)))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}
	
	@WithMockUser(value=testUID1)
	@Test
	public void updateCovid19VerificationTest() throws Exception{
		mvc.perform(put("/covid")
				.content(JsonUtils.asJsonString(
						new Covid19Verification(
								testUID1, 
								timestamp, 
								true)))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}
	
	@WithMockUser(value=testUID1)
	@Test
	@Order(2)
	public void deleteCovid19VerificationTest() throws Exception{
		mvc.perform(delete("/covid/{id}", testUID1)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}
	
	@WithMockUser(value=testUID1)
	@Test
	public void findCovid19VerificationByUserId() throws Exception{
		mvc.perform(get("/covid/user/{userId}", testUID1)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
























