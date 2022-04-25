package com.revature.areaservice.integration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.revature.areaservice.model.Role;
import com.revature.areaservice.model.User;
import com.revature.areaservice.utils.JsonUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class AreaControllerWebMvcIntegrationTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	private static final String testUID1 = "ooApve7PoQP9Lbk5irFdy2D5BeE3";
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}

	@WithMockUser()
	@Test
	public void givenAuthGetAreas() throws Exception {
		ArrayList<Integer> appropriateStatusCodes = new ArrayList<Integer>(Arrays.asList(200, 204));
		MvcResult result = mvc.perform(get("/area").contentType(MediaType.APPLICATION_JSON)).andReturn();
		assertTrue(appropriateStatusCodes.contains(result.getResponse().getStatus()));
	}

	@Test
	public void noAuthGetAreas() throws Exception {
		mvc.perform(get("/area").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isUnauthorized());

	}

	@WithMockUser()
	@Test
	public void givenAuthGetAreaById() throws Exception {
		ArrayList<Integer> appropriateStatusCodes = new ArrayList<Integer>(Arrays.asList(200, 204));
		MvcResult result = mvc.perform(get("/area/{id}", 1).contentType(MediaType.APPLICATION_JSON)).andReturn();
		assertTrue(appropriateStatusCodes.contains(result.getResponse().getStatus()));
	}

	@Test
	public void noAuthGetAreaById() throws Exception {
		mvc.perform(get("/area/{id}", 1).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isUnauthorized());

	}

	@WithMockUser()
	@Test
	public void givenAuthGetAreaByName() throws Exception {
		ArrayList<Integer> appropriateStatusCodes = new ArrayList<Integer>(Arrays.asList(200, 204));
		MvcResult result = mvc.perform(get("/area/name/{name}", "emergency").contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		assertTrue(appropriateStatusCodes.contains(result.getResponse().getStatus()));
	}

	@Test
	public void noAuthGetAreaByName() throws Exception {
		mvc.perform(get("/area/name/{name}", "emergency").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isUnauthorized());
	}
	
//	@WithMockUser()
//	@Test
//	public void givenAuthUpdateDoctor() throws Exception {
//		mvc.perform(post("/area/update/{id}", 1)
//				.content(JsonUtils.asJsonString(new User(testUID1, "firstname", "lastname", "email.com", new Role("doctor"))))
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isCreated())
//				.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());		
//	}
}
