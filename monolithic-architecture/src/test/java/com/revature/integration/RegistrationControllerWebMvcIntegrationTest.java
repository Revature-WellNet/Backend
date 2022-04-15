package com.revature.integration;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.utils.JsonUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class RegistrationControllerWebMvcIntegrationTest {

	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mvc;
	
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
	
	//RegistrationController Testing
	
	@Test
	public void publicPostDoctorRegistrationPositiveTest() throws Exception
	{
		mvc.perform(post("/public/registration")
			.content(JsonUtils.asJsonString(new User(testUID1, "firstname", "lastname", "100docs@gmail.com", new Role(2, "doctor"))))
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated())
			.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
	}
	
	@Test
	public void publicPostNurseRegistrationPositiveTest() throws Exception
	{	
		mvc.perform(post("/public/registration")
				.content(JsonUtils.asJsonString(new User(testUID2, "firstname", "lastname", "email", new Role(1, "nurse"))))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());	
	}
	
	@Test
	public void publicPostRegistrationNullIDNegativeTest() throws Exception
	{
		mvc.perform(post("/public/registration")
			.content(JsonUtils.asJsonString(new User(null, "firstname", "lastname", "email", new Role("doctor"))))
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isBadRequest());			
	}
	
	@Test
	public void publicPostRegistrationNullRoleNegativeTest() throws Exception
	{
		mvc.perform(post("/public/registration")
			.content(JsonUtils.asJsonString(new User(testUID1, "firstname", "lastname", "email", null)))
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isBadRequest());			
	}
	
}
