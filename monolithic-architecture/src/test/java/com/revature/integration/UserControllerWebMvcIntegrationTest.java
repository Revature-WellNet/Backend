package com.revature.integration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.security.models.AuthUserDTO;
import com.revature.security.models.Credentials;
import com.revature.utils.JsonUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class UserControllerWebMvcIntegrationTest {

	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mvc;
	
	//These both rely on actual firebase UID entries. If post request tests break,
	//check and make sure that these entries are still in there. If not, replace
	//them with any entry that is inside them.
	
	private static final String testUID1 = "ooApve7PoQP9Lbk5irFdy2D5BeE3";
	private static final String testUID2 = "xQEMPrMTdkMNkKM5eBwr8fAZaJS2";
	
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
	public void givenAuthGetUsers() throws Exception
	{
		mvc.perform(get("/user/user").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	@Test
	public void noAuthGetUsers() throws Exception
	{
		mvc.perform(get("/user/user").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isUnauthorized());
	}
	
	@WithMockUser(value=testUID1)
	@Test
	public void givenAuthUpdateProfilePositiveTest() throws Exception
	{	
		AuthUserDTO authUser = new AuthUserDTO();
		authUser.setUid(testUID1);
		Credentials credentials = new Credentials(
			   Credentials.CredentialType.SESSION,
			   null,
			   null,
			   null);
	    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
		   authUser, credentials, null
	    );
	    SecurityContextHolder.getContext().setAuthentication(auth);
		mvc.perform(put("/user/updateprofile")
			.content(JsonUtils.asJsonString(new User(testUID1, "firstname", "lastname", "100docs@gmail.com", new Role(2, "doctor"))))
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated());
	}
	
	@WithMockUser(value=testUID1)
	@Test
	public void givenAuthAttemptUpdateOtherProfileNegativeTest() throws Exception
	{	
		AuthUserDTO authUser = new AuthUserDTO();
		authUser.setUid(testUID1);
		Credentials credentials = new Credentials(
			   Credentials.CredentialType.SESSION,
			   null,
			   null,
			   null);
	    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
		   authUser, credentials, null
	    );
	    SecurityContextHolder.getContext().setAuthentication(auth);
		mvc.perform(put("/user/updateprofile")
			.content(JsonUtils.asJsonString(new User(testUID2, "firstname", "lastname", "email", new Role(2, "doctor"))))
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isBadRequest());
	}
	
	@WithMockUser(value=testUID1)
	@Test
	public void givenAuthGetPatientsByString() throws Exception
	{
		mvc.perform(get("/user/patient/doctor/{inputString}", "1").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated());
	}
	
	@Test
	public void noAuthGetPatientsByString() throws Exception
	{
		mvc.perform(get("/user/patient/doctor/{inputString}", "1").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isUnauthorized());
	}
	
	@WithMockUser(value=testUID1)
	@Test
	public void givenAuthGetUserById() throws Exception
	{
		ArrayList<Integer> appropriateStatusCodes = new ArrayList<Integer>(Arrays.asList(200, 204)); 
		MvcResult result = mvc.perform(get("/user/{id}", testUID2).contentType(MediaType.APPLICATION_JSON))
		.andReturn();
		assertTrue(appropriateStatusCodes.contains(result.getResponse().getStatus()));
	}
	
	@Test
	public void noAuthGetUserById() throws Exception
	{
		mvc.perform(get("/user/{id}", testUID2).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isUnauthorized());
	}
	
	@WithMockUser(value=testUID1)
	@Test
	public void givenAuthGetDoctorPatientMapping() throws Exception
	{
		ArrayList<Integer> appropriateStatusCodes = new ArrayList<Integer>(Arrays.asList(200, 204)); 
		MvcResult result = mvc.perform(get("/user/doctorPatientMap/{firstName}/{lastName}", "firstname", "lastname").contentType(MediaType.APPLICATION_JSON))
		.andReturn();
		assertTrue(appropriateStatusCodes.contains(result.getResponse().getStatus()));
	}
	
	@Test
	public void noAuthGetDoctorPatientMapping() throws Exception
	{
		mvc.perform(get("/user/doctorPatientMap/{firstName}/{lastName}", "firstname", "lastname").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isUnauthorized());
	}
	
	
}
